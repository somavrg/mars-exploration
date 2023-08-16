package com.codecool.marsexploration;

import com.codecool.marsexploration.configuration.Configuration;
import com.codecool.marsexploration.generator.ShapeGenerator;
import com.codecool.marsexploration.generator.MapGenerator;
import com.codecool.marsexploration.generator.ShapeGeneratorImpl;
import com.codecool.marsexploration.map.MapPrinter;

import java.util.Random;

public class Application {
    public static void main(String[] args) {
        Random random = new Random();
        String filePath = "src/main/resources/testmap.txt";

        Configuration configuration = new Configuration(filePath,25);
        ShapeGenerator shapeGenerator = new ShapeGeneratorImpl(random, configuration);

        MapGenerator mapGenerator = new MapGenerator(random, configuration, shapeGenerator);

        var map = mapGenerator.generate();

        MapPrinter mapPrinter = new MapPrinter(configuration, map);
        mapPrinter.print();



    }
}
