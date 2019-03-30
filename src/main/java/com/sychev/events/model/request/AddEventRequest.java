package com.sychev.events.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.validation.constraints.NotNull;
import java.time.Instant;

public class AddEventRequest {

    @NotNull
    private String name;

    @NotNull
    private String description;

    @NotNull
    private Instant dateFromMillis;

    @NotNull
    private Instant dateTillMillis;
    
    private Instant timeFromMillis;

    private Instant timeTillMillis;

    @NotNull
    private String place;

    public AddEventRequest(
            @JsonProperty("name") String name,
            @JsonProperty("description") String description,
            @JsonProperty("dateFromMillis") Instant dateFromMillis,
            @JsonProperty("dateTillMillis") Instant dateTillMillis,
            @JsonProperty("timeFromMillis") Instant timeFromMillis,
            @JsonProperty("timeTillMillis") Instant timeTillMillis,
            @JsonProperty("place") String place) {
        this.name = name;
        this.description = description;
        this.dateFromMillis = dateFromMillis;
        this.dateTillMillis = dateTillMillis;
        this.timeFromMillis = timeFromMillis;
        this.timeTillMillis = timeTillMillis;
        this.place = place;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Instant getDateFromMillis() {
        return dateFromMillis;
    }

    public Instant getDateTillMillis() {
        return dateTillMillis;
    }

    public Instant getTimeFromMillis() {
        return timeFromMillis;
    }

    public Instant getTimeTillMillis() {
        return timeTillMillis;
    }

    public String getPlace() {
        return place;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
