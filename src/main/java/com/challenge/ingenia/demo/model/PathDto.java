package com.challenge.ingenia.demo.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(description = "Details about a path")
public class PathDto {

    @Schema( example = "1", description = "id the path"  )
    private Long pathId;
    @Schema( example = "2", description = "id the source station"  )
    private Long sourceId;
    @Schema( example = "10", description = "id the destination station"  )
    private Long destinationId;
    @Schema( example = "100", description = "cost of journey"  )
    private Double cost;

    public Long getPathId() {
        return pathId;
    }

    public Long getSourceId() {
        return sourceId;
    }

    public Long getDestinationId() {
        return destinationId;
    }

    public Double getCost() {
        return cost;
    }
}
