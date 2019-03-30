package com.sychev.events.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.Instant;

public class AddTaskRequest {

    @NotBlank
    @ApiModelProperty(example = "Name")
    private String name;

    @NotBlank
    @ApiModelProperty(example = "Description")
    private String description;

    @NotNull
    private Instant deadlineTime;

    @NotNull
    private String responsiblePrsUid;

    @NotNull
    private String partnerUid;

    public AddTaskRequest(
            @JsonProperty("name") String name,
            @JsonProperty("description") String description,
            @JsonProperty("deadlineTime") Instant deadlineTime,
            @JsonProperty("responsiblePrsUid") String responsiblePrsUid,
            @JsonProperty("partnerUid") String partnerUid) {
        this.name = name;
        this.description = description;
        this.deadlineTime = deadlineTime;
        this.responsiblePrsUid = responsiblePrsUid;
        this.partnerUid = partnerUid;
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

    public String getResponsiblePrsUid() {
        return responsiblePrsUid;
    }

    public String getPartnerUid() {
        return partnerUid;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
