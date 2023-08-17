package com.codecool.marsexploration;

import com.codecool.marsexploration.configuration.Configuration;
import com.codecool.marsexploration.data.Resource;
import com.codecool.marsexploration.data.TerrainType;
import com.codecool.marsexploration.generator.ShapeGenerator;
import com.codecool.marsexploration.generator.MapGenerator;
import com.codecool.marsexploration.generator.ShapeGeneratorImpl;
import com.codecool.marsexploration.map.MapPrinter;
import com.codecool.marsexploration.map.MarsMap;

import java.util.Random;

public class Application {
    public static void main(String[] args) {
        Random random = new Random();
        String filePath = "src/main/resources/testmap.txt";
        Configuration configuration = new Configuration(filePath,25);
        ShapeGenerator shapeGenerator = new ShapeGeneratorImpl(random, configuration);
        MapGenerator mapGenerator = new MapGenerator(random, configuration, shapeGenerator);
        var map = mapGenerator.generate();
        MarsMap marsMap = new MarsMap(map, configuration, random);
        MapPrinter mapPrinter = new MapPrinter(configuration);
        MarsExploration marsExploration = new MarsExploration(mapPrinter,marsMap);
        Resource waterResource = new Resource(new TerrainType("Water", '~'), new TerrainType("Pit", '#'));
        Resource mineralResource = new Resource(new TerrainType("Mineral", '%'), new TerrainType("Mountain", '^'));
        marsExploration.addResource(waterResource);
        marsExploration.addResource(mineralResource);

        marsExploration.explore();


    }
}
