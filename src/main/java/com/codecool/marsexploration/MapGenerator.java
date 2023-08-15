package com.codecool.marsexploration;

import com.codecool.marsexploration.data.Coordinate;

import java.util.HashMap;
import java.util.Map;

public class MapGenerator {
    private final Configuration config;

    public MapGenerator(Configuration config) {
        this.config = config;
    }

    public Map<Coordinate, TerrainType> generate() {
        Map<Coordinate, TerrainType> virtualMap = new HashMap<>();
        for (int y = 0; y < config.getMapWidth(); y++) {
            for (int x = 0; x < config.getMapWidth(); x++) {
                virtualMap.put(new Coordinate(x, y), new TerrainType("Void", '~'));
            }
        }
        return virtualMap;
    }
}
