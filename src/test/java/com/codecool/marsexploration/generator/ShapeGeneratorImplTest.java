package com.codecool.marsexploration.generator;

import com.codecool.marsexploration.configuration.Configuration;
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

}
