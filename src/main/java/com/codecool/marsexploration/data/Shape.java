package com.codecool.marsexploration.data;

import java.util.Map;

public class Shape {
    private final int size;
    private final Map<Coordinate, TerrainType> shape;

    public Shape(int size, Map<Coordinate, TerrainType> shape) {
        this.size = size;
        this.shape = shape;
    }

    public int getSize() {
        return size;
    }

    public TerrainType getTerrainType(int x, int y) {
        return shape.get(new Coordinate(x, y));
    }
}
