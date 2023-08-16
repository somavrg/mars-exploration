package com.codecool.marsexploration.data;

import com.codecool.marsexploration.TerrainType;

import java.util.Random;

public class ShapeGenerator {
    private void generateShape(int size,int offsetX,int offsetY) {
        Random random = new Random();
        if (size > config.getMapWidth()) {
            throw new IllegalArgumentException("Size cannot be greater than map side");
        }

        for (int y = offsetY; y < size+offsetY; y++) {
            for (int x = offsetX; x < size+offsetX; x++) {
                if (random.nextInt(100) > 30) {
                    map.put(new Coordinate(x, y), new TerrainType("Mountain", '^'));
                }
            }
        }
    }
}
