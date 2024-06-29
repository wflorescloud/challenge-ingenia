package com.challenge.ingenia.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;



@Schema(description = "Details about a path")
public class PathDto {

    @Schema( example = "1", description = "id the path"  )
    private Long pathId;
    @Schema( example = "2", description = "id the source station"  )
    @JsonProperty("source")
    private StationDto sourceStation;

    @Schema( example = "10", description = "id the destination station"  )
    @JsonProperty("destination")
    private StationDto destinationStation;
    @Schema( example = "100", description = "cost of journey"  )
    private Double cost;

    public Long getPathId() {
        return pathId;
    }

    public void setPathId(Long pathId) {
        this.pathId = pathId;
    }

    public StationDto getSourceStation() {
        return sourceStation;
    }

    public void setSourceStation(StationDto sourceStation) {
        this.sourceStation = sourceStation;
    }

    public StationDto getDestinationStation() {
        return destinationStation;
    }

    public void setDestinationStation(StationDto destinationStation) {
        this.destinationStation = destinationStation;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }
}
