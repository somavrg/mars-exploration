package com.codecool.marsexploration.map;

import com.codecool.marsexploration.configuration.Configuration;
import com.codecool.marsexploration.data.Coordinate;
import com.codecool.marsexploration.data.TerrainType;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class MapPrinter {
    private final Configuration configuration;

    public MapPrinter(Configuration configuration) {
        this.configuration = configuration;
    }

    public void print(MarsMap marsMap) {
        String filePath = this.configuration.getOutputFilePath();
        int mapSize = this.configuration.getMapWidth();
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
            for (int y = 0; y < mapSize; y++) {
                StringBuilder stringBuilder = new StringBuilder();
                for (int x = 0; x < mapSize; x++) {
                    Coordinate coordinate = new Coordinate(x, y);
                    stringBuilder.append(marsMap.getTerrainTypeSymbolFromCoordinate(coordinate));
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
