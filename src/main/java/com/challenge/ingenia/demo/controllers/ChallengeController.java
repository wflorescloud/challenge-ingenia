package com.challenge.ingenia.demo.controllers;


import com.challenge.ingenia.demo.commons.Utils;
import com.challenge.ingenia.demo.model.*;
import com.challenge.ingenia.demo.services.ChallengeService;
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

import java.util.Collections;
import java.util.List;


@Tag(name = "Journeys")
@RestController
@RequestMapping("/journeys")
public class ChallengeController {

    public static final Logger LOGGER = LoggerFactory.getLogger(ChallengeController.class);

    private final ChallengeService challengeService;

    public ChallengeController(ChallengeService challengeService) {
        this.challengeService = challengeService;
    }

    @Operation(summary = "Get paths for source id and destination id")
    @GetMapping("/paths/{sourceId}/{destinationId}")
    public ResponseEntity<ChallengePathResponse> getPath(@Parameter(description = "source id", example = "12") @PathVariable(required = true) Long sourceId,
                                                         @Parameter(description = "destination id", example = "8") @PathVariable(required = true) Long destinationId) {
        ChallengePathResponse challengePathResponse = new ChallengePathResponse();
        List<PathJpa> paths = challengeService.getBySourceAndDestination(sourceId, destinationId);
        challengePathResponse.setStatus("OK");
        challengePathResponse.setPaths(Utils.converterPathToDto(paths));
        return new ResponseEntity<>(challengePathResponse, HttpStatus.OK);
    }

    @Operation(summary = "Get all paths")
    @GetMapping("/paths")
    public ResponseEntity<ChallengePathResponse> getPaths() {
        ChallengePathResponse challengePathResponse = new ChallengePathResponse();
        List<PathJpa> paths = challengeService.getAllPaths();
        challengePathResponse.setStatus("OK");
        challengePathResponse.setPaths(Utils.converterPathToDto(paths));
        return new ResponseEntity<>(challengePathResponse, HttpStatus.OK);
    }

    @Operation(summary = "Get all stations")
    @GetMapping("/stations")
    public ResponseEntity<ChallengeStationResponse> getStations() {
        ChallengeStationResponse challengeStationResponse = new ChallengeStationResponse();
        List<StationJpa> stations = challengeService.getAllStations();
        challengeStationResponse.setStatus("OK");
        challengeStationResponse.setStations(Utils.converterStationToDto(stations));
        return new ResponseEntity<>(challengeStationResponse, HttpStatus.OK);
    }

    @Operation(summary = "Post station",
            description = "Create a new station",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "station object to be created",
                    required = true,
                    content = @Content(schema = @Schema(implementation = StationDto.class))),
            responses = {
                    @ApiResponse(responseCode = "200", description = "Successfully created path"),
                    @ApiResponse(responseCode = "400", description = "Invalid input data")
            })
    @PostMapping("/stations")
    public ResponseEntity<ChallengeStationResponse> postStation(@RequestBody StationDto body) {
        ChallengeStationResponse challengeStationResponse = new ChallengeStationResponse();
        StationJpa stationJpa = challengeService.saveStation(body);
        challengeStationResponse.setStatus("OK");
        challengeStationResponse.setStations(Utils.converterStationToDto(Collections.singletonList(stationJpa)));
        return new ResponseEntity<>(challengeStationResponse, HttpStatus.OK);
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
    public ResponseEntity<ChallengePathResponse> postPath(@RequestBody PathDto body) {
        ChallengePathResponse challengePathResponse = new ChallengePathResponse();
        LOGGER.info("postPath");
        return new ResponseEntity<>(challengePathResponse, HttpStatus.OK);

    }


}
