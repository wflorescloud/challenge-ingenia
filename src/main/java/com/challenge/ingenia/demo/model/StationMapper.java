package com.challenge.ingenia.demo.model;

public class StationMapper {
    public static StationDto toDto(StationJpa station) {
        if (station == null) {
            return null;
        }

        StationDto dto = new StationDto();
        dto.setStationId(station.getId());
        dto.setName(station.getName());
        return dto;
    }
}