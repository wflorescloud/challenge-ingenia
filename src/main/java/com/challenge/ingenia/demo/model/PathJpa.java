package com.challenge.ingenia.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "paths")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class PathJpa {
    @Id
    private Long id;
    private Integer cost;

    @ManyToOne
    @JoinColumn(name = "source_id", referencedColumnName = "id")
    @JsonBackReference
    private StationJpa sourceStation;

    @ManyToOne
    @JoinColumn(name = "destination_id", referencedColumnName = "id")
    @JsonBackReference
    private StationJpa destinationStation;

    // Getters y Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public StationJpa getSourceStation() {
        return sourceStation;
    }

    public void setSourceStation(StationJpa sourceStation) {
        this.sourceStation = sourceStation;
    }

    public StationJpa getDestinationStation() {
        return destinationStation;
    }

    public void setDestinationStation(StationJpa destinationStation) {
        this.destinationStation = destinationStation;
    }
}

