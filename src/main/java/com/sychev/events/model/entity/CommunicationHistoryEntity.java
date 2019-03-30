package com.sychev.events.model.entity;

import com.sychev.events.model.ChannelEnum;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "communication_history", schema = "eventum")
public class CommunicationHistoryEntity {

    private Integer id;
    private EventEntity event;
    private UUID partnerExtId;
    private ChannelEnum channel;
    private String comment;

    public CommunicationHistoryEntity() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @ManyToOne
    @JoinColumn(name = "event_id", nullable = false)
    public EventEntity getEvent() {
        return event;
    }

    public CommunicationHistoryEntity setEvent(EventEntity event) {
        this.event = event;
        return this;
    }

    @Column(name = "partner_ext_id", nullable = false)
    public UUID getPartnerExtId() {
        return partnerExtId;
    }

    public CommunicationHistoryEntity setPartnerExtId(UUID partnerExtId) {
        this.partnerExtId = partnerExtId;
        return this;
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "channel", nullable = false)
    public ChannelEnum getChannel() {
        return channel;
    }

    public CommunicationHistoryEntity setChannel(ChannelEnum channel) {
        this.channel = channel;
        return this;
    }

    @Column(name = "comment")
    public String getComment() {
        return comment;
    }

    public CommunicationHistoryEntity setComment(String comment) {
        this.comment = comment;
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
