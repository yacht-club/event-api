package com.sychev.events.controller;

import com.sychev.events.model.request.AddHistoryRequest;
import com.sychev.events.model.response.CommunicationHistoryInfo;
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
@RequestMapping(path = "/api/history", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class CommHistoryController {

    private static final Logger logger = LoggerFactory.getLogger(CommHistoryController.class);
    private final EventService eventService;

    @Autowired
    public CommHistoryController(EventService eventService) {
        this.eventService = eventService;
    }


    @GetMapping("/{eventUid}")
    public ResponseEntity<List<CommunicationHistoryInfo>> getHistoriesByEvent(@PathVariable UUID eventUid) {
        logger.debug("Getting histories by event with uid: {} ", eventUid);

        return ResponseEntity.ok(eventService.getAllHistoriesByEventUid(eventUid));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Void> addEvent(@RequestBody @Valid AddHistoryRequest request) {
        logger.debug("Adding communication history");

        eventService.addHistory(request);
        return ResponseEntity.ok().build();
    }

}
