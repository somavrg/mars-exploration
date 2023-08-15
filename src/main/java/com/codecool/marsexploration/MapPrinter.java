package com.codecool.marsexploration;

import com.codecool.marsexploration.data.Coordinate;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class MapPrinter {
    public void print(String filePath, Map<Coordinate, TerrainType> virtualMap) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
            StringBuilder stringBuilder = new StringBuilder();


            writer.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
