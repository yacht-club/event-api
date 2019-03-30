package com.sychev.events.model.response;

import com.fasterxml.jackson.annotation.JsonGetter;

import java.time.Instant;
import java.util.UUID;

public class TaskInfo {

    private UUID taskUid;
    private String name;
    private String description;
    private Instant timeTillMillis;
    private String prsExtId;
    private String partnerExtId;

    public TaskInfo(
            UUID taskUid,
            String name,
            String description,
            Instant timeTillMillis,
            String prsExtId,
            String partnerExtId) {
        this.taskUid = taskUid;
        this.name = name;
        this.description = description;
        this.timeTillMillis = timeTillMillis;
        this.prsExtId = prsExtId;
        this.partnerExtId = partnerExtId;
    }

    @JsonGetter("taskUid")
    public UUID getEventUid() {
        return taskUid;
    }

    @JsonGetter("name")
    public String getName() {
        return name;
    }

    @JsonGetter("description")
    public String getDescription() {
        return description;
    }

    @JsonGetter("timeTillMillis")
    public Instant getTimeTillMillis() {
        return timeTillMillis;
    }

    @JsonGetter("prsExtId")
    public String getPrsExtId() {
        return prsExtId;
    }

    @JsonGetter("partnerExtId")
    public String getPartnerExtId() {
        return partnerExtId;
    }
}
