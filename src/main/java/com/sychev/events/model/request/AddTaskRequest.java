package com.sychev.events.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.validation.constraints.NotNull;
import java.time.Instant;
import java.util.UUID;

public class AddTaskRequest {

    @NotNull
    private String name;

    @NotNull
    private String description;

    @NotNull
    private Instant deadlineTime;

    @NotNull
    private String prsExtId;

    private String partnerExtId;

    private UUID eventUid;

    public AddTaskRequest(
            @JsonProperty("name") String name,
            @JsonProperty("description") String description,
            @JsonProperty("deadlineTime") Instant deadlineTime,
            @JsonProperty("prsExtId") String prsExtId,
            @JsonProperty("partnerExtId") String partnerExtId,
            @JsonProperty("eventUid") UUID eventUid) {
        this.name = name;
        this.description = description;
        this.deadlineTime = deadlineTime;
        this.prsExtId = prsExtId;
        this.partnerExtId = partnerExtId;
        this.eventUid = eventUid;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Instant getDeadlineTime() {
        return deadlineTime;
    }

    public String getPrsExtId() {
        return prsExtId;
    }

    public String getPartnerExtId() {
        return partnerExtId;
    }

    public UUID getEventUid() {
        return eventUid;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
