package com.sychev.events.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.validation.constraints.NotNull;
import java.util.UUID;

public class AddTaskRequest {

    @NotNull
    private String name;

    @NotNull
    private String description;

    @NotNull
    private long deadlineTime;

    @NotNull
    private String prsExtId;

    @NotNull
    private String email;

    private String partnerExtId;

    private UUID eventUid;

    public AddTaskRequest(
            @JsonProperty("name") String name,
            @JsonProperty("description") String description,
            @JsonProperty("deadlineTime") long deadlineTime,
            @JsonProperty("prsExtId") String prsExtId,
            @JsonProperty("email") String email,
            @JsonProperty("partnerExtId") String partnerExtId,
            @JsonProperty("eventUid") UUID eventUid) {
        this.name = name;
        this.description = description;
        this.deadlineTime = deadlineTime;
        this.prsExtId = prsExtId;
        this.email = email;
        this.partnerExtId = partnerExtId;
        this.eventUid = eventUid;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public long getDeadlineTime() {
        return deadlineTime;
    }

    public String getPrsExtId() {
        return prsExtId;
    }

    public String getEmail() {
        return email;
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
