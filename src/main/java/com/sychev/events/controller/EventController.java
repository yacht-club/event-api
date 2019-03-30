package com.sychev.events.controller;

import com.sychev.events.model.request.AddEventRequest;
import com.sychev.events.model.response.EventInfo;
import com.sychev.events.service.EventService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/api/events", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class EventController {

    private static final Logger logger = LoggerFactory.getLogger(EventController.class);
    private final EventService eventService;

    @Autowired
    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping
    public ResponseEntity<List<EventInfo>> getAllEvents() {
        logger.debug("Getting all events");

        return ResponseEntity.ok(eventService.getAllEvents());
    }

    @GetMapping("/{eventUid}")
    public ResponseEntity<EventInfo> getEvent(@PathVariable UUID eventUid) {
        logger.debug("Getting event with uid: {} ", eventUid);

        return ResponseEntity.ok(eventService.getEvent(eventUid));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<UUID> addEvent(@RequestBody @Valid AddEventRequest request) {
        logger.debug("Adding event with name: {}", request.getName());

        return ResponseEntity.ok(eventService.addEvent(request));
    }

}
