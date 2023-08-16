package com.codecool.marsexploration.generator;

import com.codecool.marsexploration.configuration.Configuration;
import com.codecool.marsexploration.data.Coordinate;
import com.codecool.marsexploration.data.TerrainType;

import java.util.HashMap;
import java.util.Map;

public class MapGenerator {
    private final Configuration config;
    private final ShapeGenerator shapeGenerator;

    public MapGenerator(Configuration config, ShapeGenerator shapeGenerator) {
        this.config = config;
        this.shapeGenerator = shapeGenerator;
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
