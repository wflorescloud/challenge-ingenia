package com.challenge.ingenia.demo.services;

import com.challenge.ingenia.demo.commons.BusinessMessages;
import com.challenge.ingenia.demo.exceptions.ResourceNotFoundException;
import com.challenge.ingenia.demo.model.*;
import com.challenge.ingenia.demo.repositories.PathJpaRepository;
import com.challenge.ingenia.demo.repositories.StationJpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChallengeServiceImpl implements ChallengeService {

    private final StationJpaRepository stationJpaRepository;
    private final PathJpaRepository pathJpaRepository;

    public ChallengeServiceImpl(StationJpaRepository stationJpaRepository, PathJpaRepository pathJpaRepository) {
        this.stationJpaRepository = stationJpaRepository;
        this.pathJpaRepository = pathJpaRepository;
    }


    @Override
    public List<StationJpa> getAllStations() {
        return stationJpaRepository.findAll();
    }

    @Override
    public List<PathJpa> getAllPaths() {
        return pathJpaRepository.findAll();
    }

    @Override
    public List<PathJpa> getBySourceAndDestination(long sourceId, long destinationId) {
        return pathJpaRepository.findBySourceStationIdAndDestinationStationId(sourceId, destinationId)
                .filter(paths -> !paths.isEmpty())
                .orElseThrow(() -> new ResourceNotFoundException(BusinessMessages.CodeService.CODE_PATH_0100.getMessage(),
                        BusinessMessages.CodeService.CODE_PATH_0100.name()));
    }

    @Override
    public StationJpa saveStation(StationDto stationDto) {
        return stationJpaRepository.save(StationMapper.toJpa(stationDto));
    }

    @Override
    public PathJpa savePath(PathSimpleDto pathSimpleDto) {
        Optional<StationJpa> sourceStation = stationJpaRepository.findById(pathSimpleDto.getSourceId());
        if(sourceStation.isEmpty()) throw new ResourceNotFoundException(BusinessMessages.CodeService.CODE_STATION_0100.getMessage(),BusinessMessages.CodeService.CODE_STATION_0100.name());

        Optional<StationJpa> destinationStation = stationJpaRepository.findById(pathSimpleDto.getDestinationId());
        if(destinationStation.isEmpty()) throw new ResourceNotFoundException(BusinessMessages.CodeService.CODE_STATION_0200.getMessage(),BusinessMessages.CodeService.CODE_STATION_0200.name());

        PathJpa pathJpa = new PathJpa();
        pathJpa.setId(pathSimpleDto.getPathId());
        pathJpa.setCost(pathSimpleDto.getCost().intValue());
        pathJpa.setSourceStation(sourceStation.get());
        pathJpa.setDestinationStation(destinationStation.get());

        return pathJpaRepository.save(pathJpa);
    }
}
