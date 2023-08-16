package com.codecool.marsexploration;

import com.codecool.marsexploration.data.Coordinate;

import javax.swing.plaf.basic.BasicDesktopIconUI;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class MapGenerator {
    private final Configuration config;
    private final Map<Coordinate, TerrainType> map;

    public MapGenerator(Configuration config) {
        this.config = config;
        this.map = new HashMap<>();
    }

    public Map<Coordinate, TerrainType> generate() {
        generatePlainMap();
        generateShape(6,5,10);
        return this.map;
    }

    private void generatePlainMap() {
        for (int y = 0; y < config.getMapWidth(); y++) {
            for (int x = 0; x < config.getMapWidth(); x++) {
                map.put(new Coordinate(x, y), new TerrainType("Void", '~'));
            }
        }
    }
}
