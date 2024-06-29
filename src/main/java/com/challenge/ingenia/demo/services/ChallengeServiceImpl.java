package com.challenge.ingenia.demo.services;

import com.challenge.ingenia.demo.model.PathJpa;
import com.challenge.ingenia.demo.model.StationJpa;
import com.challenge.ingenia.demo.repositories.PathJpaRepository;
import com.challenge.ingenia.demo.repositories.StationJpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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

}
