package com.sychev.events.model.response;

import com.fasterxml.jackson.annotation.JsonGetter;

import java.time.Instant;
import java.util.UUID;

public class EventInfo {

    private UUID eventUid;
    private String name;
    private String description;
    private Instant dateFromMillis;
    private Instant dateTillMillis;
    private Instant timeFromMillis;
    private Instant timeTillMillis;
    private String place;

    public EventInfo(
            UUID eventUid,
            String name,
            String description,
            Instant dateFromMillis,
            Instant dateTillMillis,
            Instant timeFromMillis,
            Instant timeTillMillis,
            String place) {
        this.eventUid = eventUid;
        this.name = name;
        this.description = description;
        this.dateFromMillis = dateFromMillis;
        this.dateTillMillis = dateTillMillis;
        this.timeFromMillis = timeFromMillis;
        this.timeTillMillis = timeTillMillis;
        this.place = place;
    }

    @JsonGetter("eventUid")
    public UUID getEventUid() {
        return eventUid;
    }

    @JsonGetter("name")
    public String getName() {
        return name;
    }

    @JsonGetter("description")
    public String getDescription() {
        return description;
    }

    @JsonGetter("dateFromMillis")
    public Instant getDateFromMillis() {
        return dateFromMillis;
    }

    @JsonGetter("dateTillMillis")
    public Instant getDateTillMillis() {
        return dateTillMillis;
    }

    @JsonGetter("timeFromMillis")
    public Instant getTimeFromMillis() {
        return timeFromMillis;
    }

    @JsonGetter("timeTillMillis")
    public Instant getTimeTillMillis() {
        return timeTillMillis;
    }

    @JsonGetter("place")
    public String getPlace() {
        return place;
    }
}
