package com.sychev.events.model.response;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.sychev.events.model.ChannelEnum;
import com.sychev.events.model.entity.EventEntity;

import java.util.UUID;

public class EventPartnerInfo {

    private UUID partnerUid;

    public EventPartnerInfo(
            UUID partnerUid) {
        this.partnerUid = partnerUid;
    }

    @JsonGetter("partnerUid")
    public UUID getPartnerUid() {
        return partnerUid;
    }

}
