package com.sychev.events.converter;

import com.sychev.events.model.entity.CommunicationHistoryEntity;
import com.sychev.events.model.entity.EventEntity;
import com.sychev.events.model.entity.RelEventPartnersEntity;
import com.sychev.events.model.entity.TaskEntity;
import com.sychev.events.model.request.AddEventRequest;
import com.sychev.events.model.request.AddHistoryRequest;
import com.sychev.events.model.request.AddTaskRequest;
import com.sychev.events.model.request.LinkEventWithPartnerRequest;
import com.sychev.events.model.response.CommunicationHistoryInfo;
import com.sychev.events.model.response.EventInfo;
import com.sychev.events.model.response.TaskInfo;

import java.util.UUID;

public class ModelConverter {

    public static EventInfo convert(EventEntity entity) {
        return new EventInfo(
                entity.getEventUid(),
                entity.getName(),
                entity.getDescription(),
                entity.getDateFromMillis(),
                entity.getDateTillMillis(),
                entity.getTimeFromMillis(),
                entity.getTimeTillMillis(),
                entity.getPlace());
    }

    public static TaskInfo convert(TaskEntity entity) {
        return new TaskInfo(
                entity.getTaskUid(),
                entity.getName(),
                entity.getDescription(),
                entity.getPrsExtId(),
                entity.getPartnerExtId(),
                entity.getDeadlineTime(),
                entity.getEvent().getEventUid(),
                entity.getStatus()
                );
    }

    public static EventEntity convert(AddEventRequest request) {
        return new EventEntity()
                .setName(request.getName())
                .setDateFromMillis(request.getDateFromMillis())
                .setDateTillMillis(request.getDateTillMillis())
                .setDescription(request.getDescription())
                .setPlace(request.getPlace())
                .setTimeFromMillis(request.getTimeFromMillis())
                .setTimeTillMillis(request.getTimeTillMillis());
    }

    public static TaskEntity convert(AddTaskRequest request) {
        return new TaskEntity()
                .setName(request.getName())
                .setDescription(request.getDescription())
                .setPartnerExtId(request.getPartnerExtId())
                .setPrsExtId(request.getPrsExtId())
                .setDeadlineTime(request.getDeadlineTime());

    }

    public static RelEventPartnersEntity convert(LinkEventWithPartnerRequest request, EventEntity eventEntity) {
        return new RelEventPartnersEntity()
                .setPartnerUid(UUID.fromString(request.getPartnerExtId()))
                .setEvent(eventEntity);
    }

    public static CommunicationHistoryEntity convert(AddHistoryRequest request, EventEntity event) {
        return new CommunicationHistoryEntity()
                .setChannel(request.getChannel())
                .setComment(request.getComment())
                .setEvent(event)
                .setPartnerExtId(UUID.fromString(request.getPartnerExtId()));
    }

    public static CommunicationHistoryInfo convert(CommunicationHistoryEntity commHistory) {
        return new CommunicationHistoryInfo(
                commHistory.getEvent(),
                commHistory.getPartnerExtId(),
                commHistory.getChannel(),
                commHistory.getComment()
        );
    }
}
