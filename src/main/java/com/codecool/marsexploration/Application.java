package com.codecool.marsexploration;

import java.util.Map;
import java.util.Random;

public class Application {
    public static void main(String[] args) {
        Random random = new Random();
        System.out.println(random.nextInt(42));


        String filePath = "src/main/resources/testmap.txt";
        Configuration configuration = new Configuration(filePath,25);
        MapGenerator mapGenerator = new MapGenerator(configuration);
        var map = mapGenerator.generate();
        MapPrinter mapPrinter = new MapPrinter(configuration,map);
        mapPrinter.print();


    }
}
