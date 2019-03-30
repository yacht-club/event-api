package com.sychev.events.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.validation.constraints.NotNull;
import java.util.UUID;

public class LinkTaskWithPartnerRequest {

    @NotNull
    private UUID taskUid;

    @NotNull
    private String partnerExtId;

    public LinkTaskWithPartnerRequest(
            @JsonProperty("taskUid") UUID taskUid,
            @JsonProperty("partnerExtId") String partnerExtId) {
        this.taskUid = taskUid;
        this.partnerExtId = partnerExtId;
    }

    public UUID getTaskUid() {
        return taskUid;
    }

    public String getPartnerExtId() {
        return partnerExtId;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
