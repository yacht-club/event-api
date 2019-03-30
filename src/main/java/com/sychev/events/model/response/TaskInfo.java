package com.sychev.events.model.response;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.sychev.events.model.TaskEnum;

import java.time.Instant;
import java.util.UUID;

public class TaskInfo {

    private UUID taskUid;
    private String name;
    private String description;
    private String prsExtId;
    private Instant deadlineTime;
    private UUID eventUid;
    private String partnerExtId;
    private TaskEnum status;

    public TaskInfo(
            UUID taskUid,
            String name,
            String description,
            String prsExtId,
            String partnerExtId,
            Instant deadlineTime,
            UUID eventUid,
            TaskEnum status) {
        this.taskUid = taskUid;
        this.name = name;
        this.description = description;
        this.prsExtId = prsExtId;
        this.partnerExtId = partnerExtId;
        this.deadlineTime = deadlineTime;
        this.eventUid = eventUid;
        this.status = status;
    }

    @JsonGetter("taskUid")
    public UUID getTaskUid() {
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

    @JsonGetter("prsExtId")
    public String getPrsExtId() {
        return prsExtId;
    }

    @JsonGetter("partnerExtId")
    public String getPartnerExtId() {
        return partnerExtId;
    }

    @JsonGetter("deadlineTime")
    public Instant getDeadlineTime() {
        return deadlineTime;
    }

    @JsonGetter("eventUid")
    public UUID getEventUid() {
        return eventUid;
    }

    @JsonGetter("status")
    public TaskEnum getStatus() {
        return status;
    }
}
