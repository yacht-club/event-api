package com.sychev.events.service.impl;

import com.sychev.events.converter.ModelConverter;
import com.sychev.events.exception.NotFoundEventException;
import com.sychev.events.model.entity.EventEntity;
import com.sychev.events.model.request.AddEventRequest;
import com.sychev.events.model.request.AddHistoryRequest;
import com.sychev.events.model.request.LinkEventWithPartnerRequest;
import com.sychev.events.model.response.CommunicationHistoryInfo;
import com.sychev.events.model.response.EventInfo;
import com.sychev.events.model.response.EventPartnerInfo;
import com.sychev.events.repository.CommunicationHistoryRepository;
import com.sychev.events.repository.EventRepository;
import com.sychev.events.repository.RelEventPartnersRepository;
import com.sychev.events.service.EventService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class EventServiceImpl implements EventService {
    private static final Logger logger = LoggerFactory.getLogger(EventServiceImpl.class);

    private final EventRepository eventRepository;
    private final RelEventPartnersRepository relRepository;
    private final CommunicationHistoryRepository historyRepository;

    @Autowired
    public EventServiceImpl(
            EventRepository repository,
            RelEventPartnersRepository relRepository,
            CommunicationHistoryRepository historyRepository) {
        this.eventRepository = repository;
        this.relRepository = relRepository;
        this.historyRepository = historyRepository;
    }

    @Override
    public List<EventInfo> getAllEvents(String name) {
        if (name != null) {
            return getByName(name);
        }
        return eventRepository.findAll().stream()
                .filter(event -> event.getDateFromMillis().isAfter(Instant.now()))
                .map(ModelConverter::convert)
                .sorted(Comparator.comparing(EventInfo::getDateFromMillis))
                .collect(Collectors.toList());
    }

    private List<EventInfo> getByName(String name) {
        return eventRepository.findAll().stream()
                .filter(eventEntity -> eventEntity.getName().contains(name))
                .filter(event -> event.getDateFromMillis().isAfter(Instant.now()))
                .map(ModelConverter::convert)
                .sorted(Comparator.comparing(EventInfo::getDateFromMillis))
                .collect(Collectors.toList());
    }

    @Override
    public List<EventInfo> getAllArchiveEvents(String name) {
        if (name != null) {
            return getArchiveEventsByName(name);
        }
        return eventRepository.findAll().stream()
                .filter(event -> event.getDateFromMillis().isBefore(Instant.now()))
                .map(ModelConverter::convert)
                .sorted()
                .collect(Collectors.toList());
    }

    private List<EventInfo> getArchiveEventsByName(String name) {
        return eventRepository.findAll().stream()
                .filter(eventEntity -> eventEntity.getName().contains(name))
                .map(ModelConverter::convert)
                .sorted()
                .collect(Collectors.toList());
    }

    @Override
    public EventInfo getEvent(UUID eventUid) {
        return ModelConverter.convert(eventRepository.findByEventUid(eventUid).orElseThrow(() -> {
            logger.info("Not found event with uid: " + eventUid);
            return new NotFoundEventException("Not found event with uid: " + eventUid);
        }));
    }

    @Override
    public UUID addEvent(AddEventRequest request) {
        return eventRepository.save(ModelConverter.convert(request)).getEventUid();
    }

    @Override
    public void linkEventWithPartner(LinkEventWithPartnerRequest request) {
        EventEntity event = eventRepository.findByEventUid(request.getEventUid()).orElseThrow(() -> {
            logger.info("Not found event with uid: " + request.getEventUid());
            return new NotFoundEventException("Not found event with uid: " + request.getEventUid());
        });

        relRepository.save(ModelConverter.convert(request, event));
    }

    @Override
    public List<EventPartnerInfo> getPartnersByEvent(UUID eventUid) {
        EventEntity event = eventRepository.findByEventUid(eventUid).orElseThrow(() -> {
            logger.info("Not found event with uid: " + eventUid);
            return new NotFoundEventException("Not found event with uid: " + eventUid);
        });

        return relRepository.findAllByEvent(event).stream()
                .map(ModelConverter::convert)
                .collect(Collectors.toList());
    }

    @Override
    public void addHistory(AddHistoryRequest request) {
        EventEntity event = eventRepository.findByEventUid(request.getEventUid()).orElseThrow(() -> {
            logger.info("Not found event with uid: " + request.getEventUid());
            return new NotFoundEventException("Not found event with uid: " + request.getEventUid());
        });

        historyRepository.save(ModelConverter.convert(request, event));
    }

    @Override
    public List<CommunicationHistoryInfo> getAllHistoriesByEventUid(UUID eventUid) {
        EventEntity event = eventRepository.findByEventUid(eventUid).orElseThrow(() -> {
            logger.info("Not found event with uid: " + eventUid);
            return new NotFoundEventException("Not found event with uid: " + eventUid);
        });

        return historyRepository.findAllByEvent(event)
                .stream()
                .map(ModelConverter::convert)
                .collect(Collectors.toList());
    }
}
