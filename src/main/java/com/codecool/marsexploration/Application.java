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

        int VISUALIZER_MAP_WIDTH = 32;
        String filePath = "C:/Users/thehi/Documents/CODECOOL/PROJECTS/OOP/mars-exploration-visuals/";

        Configuration configuration = new Configuration(filePath,VISUALIZER_MAP_WIDTH);

        Resource waterResource = new Resource(new TerrainType("Water", '~'), new TerrainType("Pit", '#'));
        Resource mineralResource = new Resource(new TerrainType("Mineral", '%'), new TerrainType("Mountain", '^'));

        ShapeGenerator shapeGenerator = new ShapeGeneratorImpl(random, configuration);
        MapGenerator mapGenerator = new MapGenerator(random, configuration, shapeGenerator);
        MapPrinter mapPrinter = new MapPrinter(configuration);
        MarsExploration marsExploration = new MarsExploration(mapPrinter, mapGenerator, configuration, random);

        marsExploration.addResource(waterResource);
        marsExploration.addResource(mineralResource);

        marsExploration.explore();
        marsExploration.explore();
        marsExploration.explore();
        marsExploration.explore();

    }
}
