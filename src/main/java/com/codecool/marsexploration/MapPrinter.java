package com.codecool.marsexploration;

import com.codecool.marsexploration.data.Coordinate;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.stream.Collectors;

public class MapPrinter {
    public void print(String filePath, int mapSize, Map<Coordinate, TerrainType> virtualMap) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
            for (int y = 0; y < mapSize; y++) {
                StringBuilder stringBuilder = new StringBuilder();
                for (int x = 0; x < mapSize; x++) {
                    Coordinate coordinate = new Coordinate(x, y);
                    stringBuilder.append(virtualMap.get(coordinate).symbol());
                }
                writer.write(stringBuilder.toString());
                writer.newLine();
            }

            writer.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
