package com.sychev.events.model.entity;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "tasks", schema = "events")
public class TaskEntity {
    private Integer id;
    private UUID taskUid = UUID.randomUUID();
    private String name;
    private String description;
    private UUID responsiblePrsUid;
    private UUID partnerUid;

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

    @Column(name = "task_uid", nullable = false)
    public UUID getTaskUid() {
        return taskUid;
    }

    public void setTaskUid(UUID taskUid) {
        this.taskUid = taskUid;
    }

    @Column(name = "responsible_prs_id", nullable = false)
    public UUID getResponsiblePrsUid() {
        return responsiblePrsUid;
    }

    public void setResponsiblePrsUid(UUID responsiblePrsUid) {
        this.responsiblePrsUid = responsiblePrsUid;
    }

    @Column(name = "partner_uid", nullable = false)
    public UUID getPartnerUid() {
        return partnerUid;
    }

    public void setPartnerUid(UUID partnerUid) {
        this.partnerUid = partnerUid;
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
