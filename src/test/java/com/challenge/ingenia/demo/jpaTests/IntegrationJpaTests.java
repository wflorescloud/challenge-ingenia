package com.challenge.ingenia.demo.jpaTests;

import com.challenge.ingenia.demo.model.PathJpa;
import com.challenge.ingenia.demo.model.StationJpa;
import com.challenge.ingenia.demo.repositories.PathJpaRepository;
import com.challenge.ingenia.demo.repositories.StationJpaRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

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

    @BeforeEach
    public void setUp() {
        testStation = new StationJpa();
        testStation.setId(5L);
        testStation.setName("Station tests");
        stationJpaRepository.save(testStation);

        testPath = new PathJpa();
        testPath.setId(5L);
        testPath.setCost(23);
        testPath.setSourceId(4L);
        testPath.setDestinationId(2L);
        pathJpaRepository.save(testPath);
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
        assertEquals(testPath.getSourceId(), savedPath.getSourceId());
        assertEquals(testPath.getDestinationId(), savedPath.getDestinationId());
        assertEquals(testPath.getCost(), savedPath.getCost());
    }



}


