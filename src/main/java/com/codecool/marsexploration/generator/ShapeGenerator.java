package com.codecool.marsexploration.generator;

import com.codecool.marsexploration.data.Coordinate;
import com.codecool.marsexploration.data.TerrainType;

import java.util.Map;

public interface ShapeGenerator {
    Map<Coordinate, TerrainType> generateShape(int size, TerrainType terrainType);
}
