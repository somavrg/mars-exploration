package com.codecool.marsexploration.map;

import com.codecool.marsexploration.configuration.Configuration;
import com.codecool.marsexploration.data.Coordinate;
import com.codecool.marsexploration.data.TerrainType;

import java.util.HashMap;
import java.util.Map;

public class MapGenerator {
    private final Configuration config;

    public MapGenerator(Configuration config) {
        this.config = config;
    }

    public Map<Coordinate, TerrainType> generate() {
        Map<Coordinate, TerrainType> map = new HashMap<>();
        generatePlainMap(map);

        return map;
    }

    private void generatePlainMap(Map<Coordinate, TerrainType> map) {
        for (int y = 0; y < config.getMapWidth(); y++) {
            for (int x = 0; x < config.getMapWidth(); x++) {
                map.put(new Coordinate(x, y), new TerrainType("Void", ' '));
            }
        }
    }
}
