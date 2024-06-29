package com.challenge.ingenia.demo.services;

import com.challenge.ingenia.demo.model.PathJpa;
import com.challenge.ingenia.demo.model.PathSimpleDto;
import com.challenge.ingenia.demo.model.StationDto;
import com.challenge.ingenia.demo.model.StationJpa;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ChallengeService {

    List<StationJpa> getAllStations() ;

    List<PathJpa> getAllPaths();

    List<PathJpa> getBySourceAndDestination(long sourceId, long destinationId);

    StationJpa saveStation(StationDto stationDto);

    PathJpa savePath(PathSimpleDto pathSimpleDto);
}
