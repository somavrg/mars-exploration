package com.codecool.marsexploration.generator;

import com.codecool.marsexploration.configuration.Configuration;
import com.codecool.marsexploration.data.Shape;
import com.codecool.marsexploration.data.TerrainType;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ShapeGeneratorImplTest {

    @Nested
    class GenerateShapeThrowsException {

        @Test
        void whenSizeGreaterThanMapWidth() {
            int mapSize = 3;
            int generateSize = mapSize + 1;
            Configuration mockConfiguration = mock(Configuration.class);
            Random mockRandom = mock(Random.class);
            TerrainType mockTerrainType = mock(TerrainType.class);
            ShapeGenerator shapeGenerator = new ShapeGeneratorImpl(mockRandom, mockConfiguration);
            when(mockConfiguration.getMapWidth()).thenReturn(mapSize);


            assertThrows(IllegalArgumentException.class,
                    () -> shapeGenerator.generateShape(generateSize, mockTerrainType));
        }

        @Test
        void withCorrectMessage() {
            String correctMessage = "Size cannot be greater than map side";
            int mapSize = 3;
            int generateSize = mapSize + 1;
            Configuration mockConfiguration = mock(Configuration.class);
            Random mockRandom = mock(Random.class);
            TerrainType mockTerrainType = mock(TerrainType.class);
            when(mockConfiguration.getMapWidth()).thenReturn(mapSize);
            ShapeGenerator shapeGenerator = new ShapeGeneratorImpl(mockRandom, mockConfiguration);

            IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                    () -> shapeGenerator.generateShape(generateSize, mockTerrainType));

            assertTrue(exception.getMessage().contains(correctMessage));
        }
    }

    @Nested
    class GenerateShapeCreatesShape {
        @Test
        void whenRandomIsAlwaysBiggerThanChance() {
            int mapSize = 25;
            Configuration mockConfiguration = mock(Configuration.class);
            Random mockRandom = mock(Random.class);
            TerrainType mockTerrainType = mock(TerrainType.class);
            int chance = 100;
            when(mockConfiguration.getMapWidth()).thenReturn(mapSize);
            ShapeGenerator shapeGenerator = new ShapeGeneratorImpl(mockRandom, mockConfiguration);
            when(mockRandom.nextInt(chance)).thenReturn(chance);
            Shape shape = shapeGenerator.generateShape(mapSize, mockTerrainType);

            for (int y = 0; y < mapSize; y++) {
                for (int x = 0; x < mapSize; x++) {
                    assertEquals(shape.getTerrainType(x, y), mockTerrainType);
                }
            }


        }
    }
}
