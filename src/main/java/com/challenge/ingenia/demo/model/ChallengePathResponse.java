package com.challenge.ingenia.demo.model;

import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;


@Schema(description = "Response object for paths endpoints")
public class ChallengePathResponse {

    @Schema(example = "Success", description = "Status of the response")
    private String status;

    @Schema(example = "Paths", description = "list of paths")
    private List<PathDto> paths;


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<PathDto> getPaths() {
        return paths;
    }

    public void setPaths(List<PathDto> paths) {
        this.paths = paths;
    }
}
