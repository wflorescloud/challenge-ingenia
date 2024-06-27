package com.challenge.ingenia.demo.controllers;


import com.challenge.ingenia.demo.model.ChallengeResponse;
import com.challenge.ingenia.demo.model.PathDto;
import com.challenge.ingenia.demo.model.StationDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Journeys")
@RestController
@RequestMapping("/journeys")
public class ChallengeController {

    public static final Logger LOGGER = LoggerFactory.getLogger(ChallengeController.class);

    @Operation(summary = "Get paths for source id and destination id")
    @GetMapping("/paths/{sourceId}/{destinationId}")
    public ResponseEntity<ChallengeResponse> getPath(@Parameter(description = "source id", example = "12") @PathVariable(required = false) String sourceId,
                                                     @Parameter(description = "destination id", example = "8") @PathVariable(required = false) String destinationId) {
        ChallengeResponse challengeResponse = new ChallengeResponse();
        LOGGER.info("source id {} ",sourceId);
        LOGGER.info("destination id {}",destinationId);
        return new ResponseEntity<>(challengeResponse, HttpStatus.OK);
    }


    @Operation(summary = "Post station",
            description = "Create a new station",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Station object to be created",
                    required = true,
                    content = @Content(schema = @Schema(implementation = StationDto.class))),
            responses = {
                    @ApiResponse(responseCode = "200", description = "Successfully created station"),
                    @ApiResponse(responseCode = "400", description = "Invalid input data")
            })
    @PostMapping("/stations")
    public ResponseEntity<ChallengeResponse> postStation(@RequestBody StationDto body) {
        ChallengeResponse challengeResponse = new ChallengeResponse();
        LOGGER.info("postStation");
        return new ResponseEntity<>(challengeResponse, HttpStatus.OK);
    }


    @Operation(summary = "Post path",
            description = "Create a new path",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Path object to be created",
                    required = true,
                    content = @Content(schema = @Schema(implementation = PathDto.class))),
            responses = {
                    @ApiResponse(responseCode = "200", description = "Successfully created path"),
                    @ApiResponse(responseCode = "400", description = "Invalid input data")
            })
    @PostMapping("/paths")
    public ResponseEntity<ChallengeResponse> postPath(@RequestBody PathDto body) {
        ChallengeResponse challengeResponse = new ChallengeResponse();
        LOGGER.info("postPath");
        return new ResponseEntity<>(challengeResponse, HttpStatus.OK);

    }


}
