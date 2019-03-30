package com.sychev.events.model.entity;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "events", schema = "events")
public class EventEntity {
    private Integer id;
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

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "description", nullable = false)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "date_from", nullable = false)
    public Instant getDateFromMillis() {
        return dateFromMillis;
    }

    public void setDateFromMillis(Instant dateFromMillis) {
        this.dateFromMillis = dateFromMillis;
    }

    @Column(name = "date_till", nullable = false)
    public Instant getDateTillMillis() {
        return dateTillMillis;
    }

    public void setDateTillMillis(Instant dateTillMillis) {
        this.dateTillMillis = dateTillMillis;
    }

    @Column(name = "time_from", nullable = false)
    public Instant getTimeFromMillis() {
        return timeFromMillis;
    }

    public void setTimeFromMillis(Instant timeFromMillis) {
        this.timeFromMillis = timeFromMillis;
    }

    @Column(name = "time_till", nullable = false)
    public Instant getTimeTillMillis() {
        return timeTillMillis;
    }

    public void setTimeTillMillis(Instant timeTillMillis) {
        this.timeTillMillis = timeTillMillis;
    }

    @Column(name = "place", length = 50, nullable = false)
    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    @Column(name = "owner_uid", nullable = false)
    public UUID getOwnerUid() {
        return ownerUid;
    }

    public void setOwnerUid(UUID ownerUid) {
        this.ownerUid = ownerUid;
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
