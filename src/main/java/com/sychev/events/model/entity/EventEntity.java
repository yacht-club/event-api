package com.sychev.events.model.entity;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;
import java.time.Instant;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "events", schema = "eventum")
public class EventEntity {
    private Integer id;
    private UUID eventUid = UUID.randomUUID();
    private String name;
    private String description;
    private Instant dateFromMillis;
    private Instant dateTillMillis;
    private Instant timeFromMillis;
    private Instant timeTillMillis;
    private String place;
    private UUID ownerUid;

    public EventEntity() {
    }

    @Id
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "name", nullable = false)
    public String getName() {
        return name;
    }

    public EventEntity setName(String name) {
        this.name = name;
        return this;
    }

    @Column(name = "description", nullable = false)
    public String getDescription() {
        return description;
    }

    public EventEntity setDescription(String description) {
        this.description = description;
        return this;
    }

    @Column(name = "date_from", nullable = false)
    public Instant getDateFromMillis() {
        return dateFromMillis;
    }

    public EventEntity setDateFromMillis(Instant dateFromMillis) {
        this.dateFromMillis = dateFromMillis;
        return this;
    }

    @Column(name = "date_till", nullable = false)
    public Instant getDateTillMillis() {
        return dateTillMillis;
    }

    public EventEntity setDateTillMillis(Instant dateTillMillis) {
        this.dateTillMillis = dateTillMillis;
        return this;
    }

    @Column(name = "time_from", nullable = false)
    public Instant getTimeFromMillis() {
        return timeFromMillis;
    }

    public EventEntity setTimeFromMillis(Instant timeFromMillis) {
        this.timeFromMillis = timeFromMillis;
        return this;
    }

    @Column(name = "time_till", nullable = false)
    public Instant getTimeTillMillis() {
        return timeTillMillis;
    }

    public EventEntity setTimeTillMillis(Instant timeTillMillis) {
        this.timeTillMillis = timeTillMillis;
        return this;
    }

    @Column(name = "place", length = 50, nullable = false)
    public String getPlace() {
        return place;
    }

    public EventEntity setPlace(String place) {
        this.place = place;
        return this;
    }

    @Column(name = "owner_external_id", nullable = false)
    public UUID getOwnerUid() {
        return ownerUid;
    }

    public EventEntity setOwnerUid(UUID ownerUid) {
        this.ownerUid = ownerUid;
        return this;
    }

    @Column(name = "event_uid", nullable = false)
    public UUID getEventUid() {
        return eventUid;
    }

    public EventEntity setEventUid(UUID eventUid) {
        this.eventUid = eventUid;
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
