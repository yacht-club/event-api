package com.sychev.events.model.entity;

import com.sychev.events.model.TaskEnum;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;
import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "tasks", schema = "eventum")
public class TaskEntity {
    private Integer id;
    private UUID taskUid = UUID.randomUUID();
    private String name;
    private String description;
    private String prsExtId;
    private Instant deadlineTime;
    private EventEntity event;
    private String partnerExtId;
    private TaskEnum status = TaskEnum.CREATED;

    public TaskEntity() {
    }

    @Id
    @Column(name = "id", nullable = false)
    @SequenceGenerator(
            schema = "eventum", name = "eventum.tasks_id_seq",
            sequenceName = "eventum.tasks_id_seq", allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "eventum.tasks_id_seq")
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
    public String getPrsExtId() {
        return prsExtId;
    }

    public TaskEntity setPrsExtId(String prsExtId) {
        this.prsExtId = prsExtId;
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

    @Column(name = "partner_ext_id")
    public String getPartnerExtId() {
        return partnerExtId;
    }

    public TaskEntity setPartnerExtId(String partnerExtId) {
        this.partnerExtId = partnerExtId;
        return this;
    }

    @ManyToOne
    @JoinColumn(name = "event_id")
    public EventEntity getEvent() {
        return event;
    }

    public TaskEntity setEvent(EventEntity event) {
        this.event = event;
        return this;
    }

    @Enumerated(value = EnumType.STRING)
    @Column(name = "status")
    public TaskEnum getStatus() {
        return status;
    }

    public TaskEntity setStatus(TaskEnum status) {
        this.status = status;
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

    public TaskEntity copy(TaskEntity entity) {
        this.name = entity.name;
        this.deadlineTime = entity.deadlineTime;
        this.description = entity.description;
        this.event = entity.event;
        this.partnerExtId = entity.partnerExtId;
        this.prsExtId = entity.prsExtId;
        this.status = entity.status;
        this.taskUid = entity.taskUid;
        return this;
    }
}
