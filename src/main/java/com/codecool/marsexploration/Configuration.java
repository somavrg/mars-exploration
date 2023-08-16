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

    public String getOutputFilePath() {
        return outputFilePath;
    }

    public int getMapWidth() {
        return mapWidth;
    }

    public Set<TerrainType> getTerrainTypes() {
        return new HashSet<>(terrainTypes);
    }

    public void addTerrainType(TerrainType terrainType) {
        terrainTypes.add(terrainType);
    }
}
