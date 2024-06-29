package com.challenge.ingenia.demo.commons;

import com.challenge.ingenia.demo.model.*;

import java.util.List;

public  class Utils
{
    Utils() {
    }

    public static List<PathDto> converterPathToDto(List<PathJpa> paths) {
        return paths.stream().map(PathMapper::toDto).toList();
    }

    public static List<StationDto> converterStationToDto(List<StationJpa> stations) {
        return stations.stream().map(StationMapper::toDto).toList();
    }



}
