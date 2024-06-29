package com.challenge.ingenia.demo.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.OneToMany;
import java.util.List;

@Entity
@Table(name = "stations")
public class StationJpa {
    @Id
    private Long id;
    private String name;

    @OneToMany(mappedBy = "sourceStation")
    @JsonManagedReference
    private List<PathJpa> sourcePaths;

    @OneToMany(mappedBy = "destinationStation")
    @JsonManagedReference
    private List<PathJpa> destinationPaths;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<PathJpa> getSourcePaths() {
        return sourcePaths;
    }

    public void setSourcePaths(List<PathJpa> sourcePaths) {
        this.sourcePaths = sourcePaths;
    }

    public List<PathJpa> getDestinationPaths() {
        return destinationPaths;
    }

    public void setDestinationPaths(List<PathJpa> destinationPaths) {
        this.destinationPaths = destinationPaths;
    }
}

