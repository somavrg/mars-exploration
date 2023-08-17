package com.codecool.marsexploration.generator;

import com.codecool.marsexploration.configuration.Configuration;
import com.codecool.marsexploration.data.Coordinate;
import com.codecool.marsexploration.data.TerrainType;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class MapGeneratorTest {

    @Test
    void generateGenerates() {
        Map<Coordinate, TerrainType> map = new HashMap<>();
        Configuration mockedConfiguration =mock(Configuration.class);
        Random mockedRandom = mock(Random.class);
        ShapeGenerator mockShapeGenerator = mock(ShapeGenerator.class);
        MapGenerator mapGenerator = new MapGenerator(mockedRandom,mockedConfiguration,mockShapeGenerator);
        when(mockedConfiguration.getMapWidth()).thenReturn(2);

        mapGenerator.generate();

    }
}