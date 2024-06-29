package com.challenge.ingenia.demo.model;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

@Schema(description = "Response object for stations endpoints")
public class ChallengeStationResponse {

    @Schema(example = "Success", description = "Status of the response")
    private String status;

    @Schema(example = "Stations", description = "list of stations")
    private List<StationDto> paths;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<StationDto> getPaths() {
        return paths;
    }

    public void setPaths(List<StationDto> paths) {
        this.paths = paths;
    }
}
