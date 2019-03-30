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
@Table(name = "tasks", schema = "eventum")
public class TaskEntity {
    private Integer id;
    private UUID taskUid = UUID.randomUUID();
    private String name;
    private String description;
    private String responsiblePrsUid;
    private Instant deadlineTime;
    private String partnerExtId;

    public TaskEntity() {
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

    public TaskEntity setName(String name) {
        this.name = name;
        return this;
    }

    @Column(name = "description", nullable = false)
    public String getDescription() {
        return description;
    }

    public TaskEntity setDescription(String description) {
        this.description = description;
        return this;
    }

    @Column(name = "task_uid", nullable = false)
    public UUID getTaskUid() {
        return taskUid;
    }

    public TaskEntity setTaskUid(UUID taskUid) {
        this.taskUid = taskUid;
        return this;
    }

    @Column(name = "prs_ext_id", nullable = false)
    public String getResponsiblePrsUid() {
        return responsiblePrsUid;
    }

    public TaskEntity setResponsiblePrsUid(String responsiblePrsUid) {
        this.responsiblePrsUid = responsiblePrsUid;
        return this;
    }

    @Column(name = "deadline_time", nullable = false)
    public Instant getDeadlineTime() {
        return deadlineTime;
    }

    public TaskEntity setDeadlineTime(Instant deadlineTime) {
        this.deadlineTime = deadlineTime;
        return this;
    }

    @Column(name = "partner_ext_id", nullable = false)
    public String getPartnerExtId() {
        return partnerExtId;
    }

    public TaskEntity setPartnerExtId(String partnerExtId) {
        this.partnerExtId = partnerExtId;
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
