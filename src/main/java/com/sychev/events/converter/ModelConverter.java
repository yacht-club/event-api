package com.sychev.events.converter;


import com.sychev.events.model.entity.EventEntity;
import com.sychev.events.model.request.AddEventRequest;
import com.sychev.events.model.response.EventInfo;

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
                entity.getOwnerUid()
        );
    }

    public static EventEntity convert(AddEventRequest request) {
        return new EventEntity()
                .setName(request.getName())
                .setDateFromMillis(request.getDateFromMillis())
                .setDateTillMillis(request.getDateTillMillis())
                .setDescription(request.getDescription())
                .setPlace(request.getPlace())
                .setOwnerUid(request.getOwnerUid())
                .setTimeFromMillis(request.getTimeFromMillis())
                .setTimeTillMillis(request.getTimeTillMillis());

    }
}
