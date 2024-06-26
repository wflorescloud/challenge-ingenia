package com.challenge.ingenia.demo.controllers;


import com.challenge.ingenia.demo.model.ChallengeResponse;
import com.challenge.ingenia.demo.model.Path;
import com.challenge.ingenia.demo.model.Station;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/journeys")
public class ChallengeController {

    public static final Logger LOGGER = LoggerFactory.getLogger(ChallengeController.class);

    @GetMapping("/paths/{sourceId}/{destinationId}")
    public ResponseEntity<ChallengeResponse> getPath(@PathVariable(required = false) String sourceId,
                                                     @PathVariable(required = false) String destinationId) {
        ChallengeResponse challengeResponse = new ChallengeResponse();
        LOGGER.info("source id {} ",sourceId);
        LOGGER.info("destination id {}",destinationId);
        return new ResponseEntity<>(challengeResponse, HttpStatus.OK);
    }

    @PostMapping("/stations")
    public ResponseEntity<ChallengeResponse> postStation(@RequestBody Station body) {
        ChallengeResponse challengeResponse = new ChallengeResponse();
        LOGGER.info("postStation");
        return new ResponseEntity<>(challengeResponse, HttpStatus.OK);
    }

    @PostMapping("/paths")
    public ResponseEntity<ChallengeResponse> postPath(@RequestBody Path body) {
        ChallengeResponse challengeResponse = new ChallengeResponse();
        LOGGER.info("postPath");
        return new ResponseEntity<>(challengeResponse, HttpStatus.OK);
    }


}
