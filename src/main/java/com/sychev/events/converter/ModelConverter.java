package com.sychev.events.converter;


import com.sychev.events.model.entity.EventEntity;
import com.sychev.events.model.entity.RelEventPartnersEntity;
import com.sychev.events.model.entity.TaskEntity;
import com.sychev.events.model.request.AddEventRequest;
import com.sychev.events.model.request.AddTaskRequest;
import com.sychev.events.model.request.LinkEventWithPartnerRequest;
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
                entity.getPlace(),
                entity.getOwnerExtId()
        );
    }

    public static TaskInfo convert(TaskEntity entity) {
        return new TaskInfo(
                entity.getTaskUid(),
                entity.getName(),
                entity.getDescription(),
                entity.getDeadlineTime(),
                entity.getResponsiblePrsUid(),
                entity.getPartnerExtId()
        );
    }

    public static EventEntity convert(AddEventRequest request) {
        return new EventEntity()
                .setName(request.getName())
                .setDateFromMillis(request.getDateFromMillis())
                .setDateTillMillis(request.getDateTillMillis())
                .setDescription(request.getDescription())
                .setPlace(request.getPlace())
                .setOwnerExtId(request.getOwnerExtId())
                .setTimeFromMillis(request.getTimeFromMillis())
                .setTimeTillMillis(request.getTimeTillMillis());

    }

    public static TaskEntity convert(AddTaskRequest request) {
        return new TaskEntity()
                .setName(request.getName())
                .setDescription(request.getDescription())
                .setPartnerExtId(request.getPartnerExtId())
                .setResponsiblePrsUid(request.getPrsExtId())
                .setDeadlineTime(request.getDeadlineTime());

    }

    public static RelEventPartnersEntity convert(LinkEventWithPartnerRequest request, EventEntity eventEntity) {

        return new RelEventPartnersEntity()
                .setPartnerUid(UUID.fromString(request.getPartnerExtId()))
                .setEvent(eventEntity);
    }
}
