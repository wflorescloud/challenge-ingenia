package com.challenge.ingenia.demo.repositories;

import com.challenge.ingenia.demo.model.PathJpa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PathJpaRepository extends JpaRepository<PathJpa, Long> {
    List<PathJpa> findByCost(Integer cost);
}
