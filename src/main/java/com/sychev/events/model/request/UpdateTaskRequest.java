package com.sychev.events.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sychev.events.model.TaskEnum;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.validation.constraints.NotNull;
import java.util.UUID;

public class UpdateTaskRequest {

    @NotNull
    private UUID taskUid;

    @NotNull
    private TaskEnum status;

    public UpdateTaskRequest(
            @JsonProperty("taskUid") UUID taskUid,
            @JsonProperty("status") TaskEnum status) {
        this.taskUid = taskUid;
        this.status = status;
    }

    public UUID getTaskUid() {
        return taskUid;
    }

    public TaskEnum getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
