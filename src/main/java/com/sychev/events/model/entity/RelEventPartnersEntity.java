package com.sychev.events.model.entity;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "rel_event_partners", schema = "eventum")
public class RelEventPartnersEntity {

    private Integer id;
    private EventEntity event;
    private UUID partnerUid;

    public RelEventPartnersEntity() {
    }

    @Id
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @ManyToOne
    @JoinColumn(name = "event_id")
    public EventEntity getEvent() {
        return event;
    }

    public RelEventPartnersEntity setEvent(EventEntity event) {
        this.event = event;
        return this;
    }

    @Column(name = "partner_ext_id", nullable = false)
    public UUID getPartnerUid() {
        return partnerUid;
    }

    public RelEventPartnersEntity setPartnerUid(UUID partnerUid) {
        this.partnerUid = partnerUid;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public boolean equals(Object o) {
        return EqualsBuilder.reflectionEquals(this, o, false);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }
}
