package com.sychev.events.service;

import com.sychev.events.model.request.AddEventRequest;
import com.sychev.events.model.response.EventInfo;

import java.util.List;
import java.util.UUID;

public interface EventService {

    List<EventInfo> getAllEvents();

    EventInfo getEvent(UUID eventUid);

    UUID addEvent(AddEventRequest request);
}
