package com.sychev.events.model.response;

import com.fasterxml.jackson.annotation.JsonGetter;

import java.time.Instant;
import java.util.UUID;

public class TaskInfo {

    private UUID taskUid;
    private String name;
    private String description;
    private Instant timeTillMillis;
    private String responsiblePrsUid;
    private String partnerUid;

    public TaskInfo(
            UUID taskUid,
            String name,
            String description,
            Instant timeTillMillis,
            String responsiblePrsUid,
            String partnerUid) {
        this.taskUid = taskUid;
        this.name = name;
        this.description = description;
        this.timeTillMillis = timeTillMillis;
        this.responsiblePrsUid = responsiblePrsUid;
        this.partnerUid = partnerUid;
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

    @JsonGetter("responsible_prs_uid")
    public String responsiblePrsUid() {
        return responsiblePrsUid;
    }

    @JsonGetter("partner_uid")
    public String partnerUid() {
        return partnerUid;
    }
}
