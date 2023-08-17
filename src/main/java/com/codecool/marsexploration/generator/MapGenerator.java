package com.codecool.marsexploration.generator;

import com.codecool.marsexploration.configuration.Configuration;
import com.codecool.marsexploration.data.Coordinate;
import com.codecool.marsexploration.data.Resource;
import com.codecool.marsexploration.data.Shape;
import com.codecool.marsexploration.data.TerrainType;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class MapGenerator {
    private final Random random;
    private final Configuration configuration;
    private final ShapeGenerator shapeGenerator;

    public MapGenerator(Random random, Configuration configuration, ShapeGenerator shapeGenerator) {
        this.configuration = configuration;
        this.shapeGenerator = shapeGenerator;
        this.random = random;
    }

    public Map<Coordinate, TerrainType> generate() {
        Map<Coordinate, TerrainType> map = new HashMap<>();


        int shapeSize = 5;
        Shape mountain1 = shapeGenerator.generateShape(shapeSize, new TerrainType("Mountain", '^'));
        Shape mountain2 = shapeGenerator.generateShape(shapeSize, new TerrainType("Mountain", '^'));
        Shape mountain3 = shapeGenerator.generateShape(shapeSize, new TerrainType("Mountain", '^'));

        Shape pit1 = shapeGenerator.generateShape(shapeSize, new TerrainType("Pit", '#'));
        Shape pit2 = shapeGenerator.generateShape(shapeSize, new TerrainType("Pit", '#'));
        Shape pit3 = shapeGenerator.generateShape(shapeSize, new TerrainType("Pit", '#'));

        generatePlainMap(map);

        placeShapeOnMap(map, mountain1);
        placeShapeOnMap(map, mountain2);
        placeShapeOnMap(map, mountain3);

        placeShapeOnMap(map, pit1);
        placeShapeOnMap(map, pit2);
        placeShapeOnMap(map, pit3);

        return map;
    }

    private void generatePlainMap(Map<Coordinate, TerrainType> map) {
        for (int y = 0; y < configuration.getMapWidth(); y++) {
            for (int x = 0; x < configuration.getMapWidth(); x++) {
                map.put(new Coordinate(x, y), new TerrainType("Void", ' '));
            }
        }
    }

    private void placeShapeOnMap(
            Map<Coordinate, TerrainType> map,
            Shape shape) {
        int maxOffset = configuration.getMapWidth() - shape.getSize();
        int offsetX = random.nextInt(maxOffset);
        int offsetY = random.nextInt(maxOffset);

        for (int y = 0; y < configuration.getMapWidth(); y++) {
            for (int x = 0; x < configuration.getMapWidth(); x++) {
                TerrainType terrainElement = shape.getTerrainType(x, y);
                if (terrainElement != null) {
                    map.put(new Coordinate(x + offsetX, y + offsetY), terrainElement);
                }
            }
        }
    }
}
