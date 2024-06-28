package com.challenge.ingenia.demo.repositories;

import com.challenge.ingenia.demo.model.StationJpa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StationJpaRepository extends JpaRepository<StationJpa, Long> {

    List<StationJpa> findByName(String name);

}
