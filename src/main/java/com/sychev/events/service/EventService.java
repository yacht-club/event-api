package com.sychev.events.service;

import com.sychev.events.model.request.AddEventRequest;
import com.sychev.events.model.request.AddHistoryRequest;
import com.sychev.events.model.request.LinkEventWithPartnerRequest;
import com.sychev.events.model.response.CommunicationHistoryInfo;
import com.sychev.events.model.response.EventInfo;
import com.sychev.events.model.response.EventPartnerInfo;

import java.util.List;
import java.util.UUID;

public interface EventService {

    List<EventInfo> getAllEvents(String name);

    List<EventInfo> getAllArchiveEvents(String name);

    EventInfo getEvent(UUID eventUid);

    UUID addEvent(AddEventRequest request);

    void addHistory(AddHistoryRequest request);

    List<CommunicationHistoryInfo> getAllHistoriesByEventUid(UUID eventUid);

    void linkEventWithPartner(LinkEventWithPartnerRequest request);

    List<EventPartnerInfo> getPartnersByEvent(UUID eventUid);
}
