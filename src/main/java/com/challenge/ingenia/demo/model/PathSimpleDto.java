package com.challenge.ingenia.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Details about a path")
public class PathSimpleDto {

    @Schema( example = "1", description = "id the path"  )
    private Long pathId;
    @Schema( example = "2", description = "id the source station"  )
    @JsonProperty("sourceId")
    private Long sourceId;
    @Schema( example = "10", description = "id the destination station"  )
    @JsonProperty("destinationId")
    private Long destinationId;
    @Schema( example = "100", description = "cost of journey"  )
    private Double cost;


    public Long getPathId() {
        return pathId;
    }

    public void setPathId(Long pathId) {
        this.pathId = pathId;
    }

    public Long getSourceId() {
        return sourceId;
    }

    public void setSourceId(Long sourceId) {
        this.sourceId = sourceId;
    }

    public Long getDestinationId() {
        return destinationId;
    }

    public void setDestinationId(Long destinationId) {
        this.destinationId = destinationId;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }
}
