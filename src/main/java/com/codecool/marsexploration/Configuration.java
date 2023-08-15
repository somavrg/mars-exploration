package com.codecool.marsexploration;

import java.util.*;

/**
 *
 * Configuration class for map generator
 */
public class Configuration {
    private final String outputFilePath;
    private final int mapWidth;
    private final Set<TerrainType> terrainTypes;

    public Configuration(String outputFilePath, int mapWidth) {
        this.outputFilePath = outputFilePath;
        this.mapWidth = mapWidth;
        this.terrainTypes = new HashSet<>();
    }
}
