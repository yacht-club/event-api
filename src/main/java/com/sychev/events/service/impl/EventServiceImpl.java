package com.sychev.events.service.impl;

import com.sychev.events.converter.ModelConverter;
import com.sychev.events.exception.NotFoundEventException;
import com.sychev.events.model.request.AddEventRequest;
import com.sychev.events.model.response.EventInfo;
import com.sychev.events.repository.EventRepository;
import com.sychev.events.service.EventService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class EventServiceImpl implements EventService {
    private static final Logger logger = LoggerFactory.getLogger(EventServiceImpl.class);

    private final EventRepository repository;

    @Autowired
    public EventServiceImpl(EventRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<EventInfo> getAllEvents() {
        return repository.findAll().stream()
                .map(ModelConverter::convert)
                .collect(Collectors.toList());
    }

    @Override
    public EventInfo getEvent(UUID eventUid) {
        return ModelConverter.convert(repository.findByEventUid(eventUid).orElseThrow(() -> {
            logger.info("Not found event with uid: " + eventUid);
            return new NotFoundEventException("Not found event with uid: " + eventUid);
        }));
    }

    @Override
    public UUID addEvent(AddEventRequest request) {
        return repository.save(ModelConverter.convert(request)).getEventUid();
    }
}
