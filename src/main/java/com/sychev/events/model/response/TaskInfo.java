package com.sychev.events.model.response;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.sychev.events.model.TaskEnum;
import com.sychev.events.model.entity.EventEntity;

import java.time.Instant;
import java.util.UUID;

public class TaskInfo {

    private UUID taskUid;
    private String name;
    private String description;
    private String prsExtId;
    private Instant deadlineTime;
    private EventEntity event;
    private String partnerExtId;
    private TaskEnum status;

    public TaskInfo(
            UUID taskUid,
            String name,
            String description,
            String prsExtId,
            String partnerExtId,
            Instant deadlineTime,
            EventEntity event,
            TaskEnum status) {
        this.taskUid = taskUid;
        this.name = name;
        this.description = description;
        this.prsExtId = prsExtId;
        this.partnerExtId = partnerExtId;
        this.deadlineTime = deadlineTime;
        this.event = event;
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

    @JsonGetter("event")
    public EventEntity getEvent() {
        return event;
    }

    @JsonGetter("status")
    public TaskEnum getStatus() {
        return status;
    }
}
