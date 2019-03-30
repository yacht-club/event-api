package com.sychev.events.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sychev.events.model.ChannelEnum;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.validation.constraints.NotNull;
import java.time.Instant;
import java.util.UUID;

public class AddHistoryRequest {

    @NotNull
    private UUID eventUid;

    @NotNull
    private String partnerExtId;

    @NotNull
    private ChannelEnum channel;

    private String comment;

    public AddHistoryRequest(
            @JsonProperty("partnerExtId") String partnerExtId,
            @JsonProperty("eventUid") UUID eventUid,
            @JsonProperty("channel") ChannelEnum channel,
            @JsonProperty("comment") String comment) {
        this.partnerExtId = partnerExtId;
        this.eventUid = eventUid;
        this.channel = channel;
        this.comment = comment;
    }

    public String getPartnerExtId() {
        return partnerExtId;
    }

    public ChannelEnum getChannel() {
        return channel;
    }

    public String getComment() {
        return comment;
    }

    public UUID getEventUid() {
        return eventUid;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
