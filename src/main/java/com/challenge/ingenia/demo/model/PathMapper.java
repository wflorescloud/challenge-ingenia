package com.challenge.ingenia.demo.model;

public class PathMapper {
    public static PathDto toDto(PathJpa path) {
        if (path == null) {
            return null;
        }

        PathDto dto = new PathDto();
        dto.setPathId(path.getId());
        dto.setCost(path.getCost().doubleValue());
        dto.setSourceStation(StationMapper.toDto(path.getSourceStation()));
        dto.setDestinationStation(StationMapper.toDto(path.getDestinationStation()));
        return dto;
    }


}
