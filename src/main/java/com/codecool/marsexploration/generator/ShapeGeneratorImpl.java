package com.codecool.marsexploration.generator;

import com.codecool.marsexploration.configuration.Configuration;
import com.codecool.marsexploration.data.Coordinate;
import com.codecool.marsexploration.data.Shape;
import com.codecool.marsexploration.data.TerrainType;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class ShapeGeneratorImpl implements ShapeGenerator {
    public static final int MAX_CHANCE = 100;
    public static final int CHANCE = 30;
    private final Random random;
    private final Configuration configuration;

    public ShapeGeneratorImpl(Random random, Configuration configuration) {
        this.random = random;
        this.configuration = configuration;
    }

    @Override
    public Shape generateShape(int size, TerrainType terrainType) {
        Map<Coordinate, TerrainType> shapeMap = new HashMap<>();


        if (size > configuration.getMapWidth()) {
            throw new IllegalArgumentException("Size cannot be greater than map side");
        }

        for (int y = 0; y < size; y++) {
            for (int x = 0; x < size; x++) {
                if (random.nextInt(MAX_CHANCE) > CHANCE) {
                    shapeMap.put(new Coordinate(x, y), terrainType);
                }
            }
        }
        return new Shape(size, shapeMap);
    }
}
