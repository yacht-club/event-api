package com.sychev.events.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.Instant;
import java.util.UUID;

public class AddEventRequest {

    @NotBlank
    @ApiModelProperty(example = "Name")
    private String name;

    @NotBlank
    @ApiModelProperty(example = "Description")
    private String description;

    @NotNull
    private Instant dateFromMillis;

    @NotNull
    private Instant dateTillMillis;

    @NotNull
    private Instant timeFromMillis;

    @NotNull
    private Instant timeTillMillis;

    @NotBlank
    @ApiModelProperty(example = "Place")
    private String place;

    @NotNull
    private UUID ownerUid;

    public AddEventRequest(
            @JsonProperty("name") String name,
            @JsonProperty("description") String description,
            @JsonProperty("dateFromMillis") Instant dateFromMillis,
            @JsonProperty("dateTillMillis") Instant dateTillMillis,
            @JsonProperty("timeFromMillis") Instant timeFromMillis,
            @JsonProperty("timeTillMillis") Instant timeTillMillis,
            @JsonProperty("place") String place,
            @JsonProperty("ownerUid") UUID ownerUid) {
        this.name = name;
        this.description = description;
        this.dateFromMillis = dateFromMillis;
        this.dateTillMillis = dateTillMillis;
        this.timeFromMillis = timeFromMillis;
        this.timeTillMillis = timeTillMillis;
        this.place = place;
        this.ownerUid = ownerUid;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Instant getDateFromMillis() {
        return dateFromMillis;
    }

    public Instant getDateTillMillis() {
        return dateTillMillis;
    }

    public Instant getTimeFromMillis() {
        return timeFromMillis;
    }

    public Instant getTimeTillMillis() {
        return timeTillMillis;
    }

    public String getPlace() {
        return place;
    }

    public UUID getOwnerUid() {
        return ownerUid;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
