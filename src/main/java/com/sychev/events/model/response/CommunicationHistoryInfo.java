package com.sychev.events.model.response;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.sychev.events.model.ChannelEnum;
import com.sychev.events.model.entity.EventEntity;

import java.util.UUID;

public class CommunicationHistoryInfo {

    private EventEntity event;
    private UUID partnerExtId;
    private ChannelEnum channel;
    private String comment;

    public CommunicationHistoryInfo(
            EventEntity event,
            UUID partnerExtId,
            ChannelEnum channel,
            String comment) {
        this.event = event;
        this.partnerExtId = partnerExtId;
        this.channel = channel;
        this.comment = comment;
    }

    @JsonGetter("event")
    public EventEntity getEvent() {
        return event;
    }

    @JsonGetter("partnerExtId")
    public UUID getPartnerExtId() {
        return partnerExtId;
    }

    @JsonGetter("channel")
    public ChannelEnum getChannel() {
        return channel;
    }

    @JsonGetter("comment")
    public String getComment() {
        return comment;
    }

}
