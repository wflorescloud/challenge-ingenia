package com.challenge.ingenia.demo.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(description = "Response object for challenge endpoints")
public class ChallengeResponse {

    @Schema(example = "Success", description = "Status of the response")
    private String status;

}
