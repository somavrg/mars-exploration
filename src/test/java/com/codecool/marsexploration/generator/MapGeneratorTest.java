package com.codecool.marsexploration.generator;

import com.codecool.marsexploration.configuration.Configuration;
import com.codecool.marsexploration.data.Coordinate;
import com.codecool.marsexploration.data.TerrainType;
import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class MapGeneratorTest {

    @Test
    void generateGenerates() {
        Map<Coordinate, TerrainType> map;
        int mapSize = 6;
        String filePath = "fakeFilePath";
        Configuration configuration = new Configuration(filePath, mapSize);
        Random mockedRandom = mock(Random.class);
        ShapeGenerator shapeGenerator = new ShapeGeneratorImpl(mockedRandom, configuration);
        MapGenerator mapGenerator = new MapGenerator(mockedRandom, configuration, shapeGenerator);
        map = mapGenerator.generate();
        for (int y = 0; y < mapSize; y++) {
            for (int x = 0; x < mapSize; x++) {
                Coordinate coordinate = new Coordinate(x, y);
                assertNotNull(map.get(coordinate));
            }
        }
    }
}