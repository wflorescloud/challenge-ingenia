package com.challenge.ingenia.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Details about a station")
public class StationDto {

    @Schema(example = "1", description = "ID of the station")
    @JsonProperty("stationId")
    private Long stationId;

    @Schema(example = "Barcelona", description = "Name of the station")
    @JsonProperty("name")
    private String name;

    public Long getStationId() {
        return stationId;
    }

    public void setStationId(Long stationId) {
        this.stationId = stationId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

