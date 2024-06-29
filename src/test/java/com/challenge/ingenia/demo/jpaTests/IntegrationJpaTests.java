package com.challenge.ingenia.demo.jpaTests;

import com.challenge.ingenia.demo.commons.BusinessMessages;
import com.challenge.ingenia.demo.exceptions.ResourceNotFoundException;
import com.challenge.ingenia.demo.model.PathJpa;
import com.challenge.ingenia.demo.model.StationDto;
import com.challenge.ingenia.demo.model.StationJpa;
import com.challenge.ingenia.demo.repositories.PathJpaRepository;
import com.challenge.ingenia.demo.repositories.StationJpaRepository;
import com.challenge.ingenia.demo.services.ChallengeService;
import com.challenge.ingenia.demo.services.ChallengeServiceImpl;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@EnableJpaRepositories(basePackages = "com.challenge.ingenia.demo.repositories")
@ComponentScan(basePackages = "com.challenge.ingenia.demo")
class IntegrationJpaTests {

    @Autowired
    private StationJpaRepository stationJpaRepository;
    private StationJpa testStation;

    @Autowired
    private PathJpaRepository pathJpaRepository;
    private PathJpa testPath;

    private ChallengeService challengeService;

    @BeforeEach
    public void setUp() {
        testStation = new StationJpa();
        testStation.setId(5L);
        testStation.setName("Station tests");
        stationJpaRepository.save(testStation);

        testPath = new PathJpa();
        testPath.setId(5L);
        testPath.setCost(23);
        StationJpa stationSource = stationJpaRepository.findById(4L)
                .orElseThrow(() -> new EntityNotFoundException("Station with id 4 not found"));

        testPath.setSourceStation(stationSource);
        StationJpa stationDestination = stationJpaRepository.findById(2L)
                .orElseThrow(() -> new EntityNotFoundException("Station with id 4 not found"));
        testPath.setDestinationStation(stationDestination);
        pathJpaRepository.save(testPath);

        challengeService = new ChallengeServiceImpl(stationJpaRepository,pathJpaRepository);
    }

    @AfterEach
    public void tearDown() {
        stationJpaRepository.delete(testStation);
        pathJpaRepository.delete(testPath);
    }

    @Test
    void test_givenStation_whenSaved_thenCanBeFoundById() {
        StationJpa savedStation = stationJpaRepository.findById(testStation.getId()).orElse(null);
        assertNotNull(savedStation);
        assertEquals(testStation.getId(), savedStation.getId());
        assertEquals(testStation.getName(), savedStation.getName());
    }

    @Test
    void test_givenPath_whenSaved_thenCanBeFoundById() {
        PathJpa savedPath = pathJpaRepository.findById(testPath.getId()).orElse(null);
        assertNotNull(savedPath);
        assertEquals(testPath.getId(), savedPath.getId());
        assertEquals(testPath.getSourceStation(), savedPath.getSourceStation());
        assertEquals(testPath.getDestinationStation(), savedPath.getDestinationStation());
        assertEquals(testPath.getCost(), savedPath.getCost());
    }

    @Test
    void test_whenCallGetServiceForStations_thenGetListStations() {
        List<StationJpa> stations = challengeService.getAllStations();
        assertEquals("Barcelona", stations.get(0).getName());
        assertEquals("Paris", stations.get(1).getName());
        assertEquals("Berlin", stations.get(2).getName());
        assertEquals("Roma", stations.get(3).getName());
    }

    @Test
    void test_whenCallGetServiceForPaths_thenGetListStations() {
        List<PathJpa> paths = challengeService.getAllPaths();
        assertEquals(1L, paths.get(0).getId());
        assertEquals(50, paths.get(0).getCost());
        assertEquals(1L, paths.get(0).getSourceStation().getId());
        assertEquals(2L, paths.get(0).getDestinationStation().getId());

        assertEquals(2L, paths.get(1).getId());
        assertEquals(100, paths.get(1).getCost());
        assertEquals(1L, paths.get(1).getSourceStation().getId());
        assertEquals(3L, paths.get(1).getDestinationStation().getId());

        assertEquals(3L, paths.get(2).getId());
        assertEquals(60, paths.get(2).getCost());
        assertEquals(1L, paths.get(2).getSourceStation().getId());
        assertEquals(4L, paths.get(2).getDestinationStation().getId());

        assertEquals(4L, paths.get(3).getId());
        assertEquals(20, paths.get(3).getCost());
        assertEquals(4L, paths.get(3).getSourceStation().getId());
        assertEquals(3L, paths.get(3).getDestinationStation().getId());

    }

    @Test
    void test_whenCallGetServiceForPathID_thenGetPath() {
        List<PathJpa> path = challengeService.getBySourceAndDestination(1L, 2L);
        assertEquals(1L, path.get(0).getId());
        assertEquals(50, path.get(0).getCost());
        assertEquals(1L, path.get(0).getSourceStation().getId());
        assertEquals(2L, path.get(0).getDestinationStation().getId());
    }

    @Test
    void test_whenCallGetServiceForNonExistentPath_thenThrowResourceNotFoundException() {
        ResourceNotFoundException exception = assertThrows(
                ResourceNotFoundException.class,
                () -> challengeService.getBySourceAndDestination(99L, 99L)
        );
        assertEquals(BusinessMessages.CodeService.CODE_PATH_0100.getMessage(), exception.getMessage());
        assertEquals(BusinessMessages.CodeService.CODE_PATH_0100.name(), exception.getAppCode());
    }

    @Test
    void test_whenCallPostServiceForStation_thenSaveStation() {
        StationDto stationDto = new StationDto();
        stationDto.setStationId(5L);
        stationDto.setName("Londres");
        StationJpa stationJpa= challengeService.saveStation(stationDto);
        assertEquals(5L, stationJpa.getId());
        assertEquals("Londres", stationJpa.getName());

    }

}


