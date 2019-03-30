package com.sychev.events.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.validation.constraints.NotNull;
import java.util.UUID;

public class LinkEventWithPartnerRequest {

    @NotNull
    private UUID eventUid;

    @NotNull
    private String partnerExtId;

    public LinkEventWithPartnerRequest(
            @JsonProperty("eventUid") UUID eventUid,
            @JsonProperty("partnerExtId") String partnerExtId) {
        this.eventUid = eventUid;
        this.partnerExtId = partnerExtId;
    }

    public UUID getEventUid() {
        return eventUid;
    }

    public String getPartnerExtId() {
        return partnerExtId;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
