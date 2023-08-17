package com.codecool.marsexploration.map;

import com.codecool.marsexploration.configuration.Configuration;
import com.codecool.marsexploration.data.Coordinate;
import com.codecool.marsexploration.data.Resource;
import com.codecool.marsexploration.data.TerrainType;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class MarsMap {
    private final Map<Coordinate, TerrainType> map;
    private final Configuration configuration;
    private final Random random;


    public MarsMap (Map<Coordinate, TerrainType> map, Configuration configuration, Random random) {
        this.map = map;
        this.configuration = configuration;
        this.random = random;
    }

    public Map<Coordinate, TerrainType> getMap(){
        return new HashMap<>(map);
    }

    public void placer(Resource resource) {
        for (int y = 0; y < configuration.getMapWidth(); y++) {
            for (int x = 0; x < configuration.getMapWidth(); x++) {
                Coordinate coordinate = new Coordinate(x, y);

                if(isNeighbourPreferredType(coordinate, resource.preferredNeighbour()) && random.nextInt(100) > 30) {
                    map.put(coordinate, resource.terrainType());
                }
            }
        }

    }

    private boolean isNeighbourPreferredType(Coordinate coordinate, TerrainType terrainType) {
        int xCoordinate = coordinate.x();
        int yCoordinate = coordinate.y();

        if (isVoid(coordinate)) return false;

        for (int x = xCoordinate - 1; x < xCoordinate + 1; x++) {
            for (int y = yCoordinate - 1; y < yCoordinate + 1; y++) {
                var mapTile = map.get(new Coordinate(x, y));

                if (mapTile == null || (x == xCoordinate && y == yCoordinate)) {
                    continue;
                }
                if (mapTile.equals(terrainType)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isVoid (Coordinate coordinate) {
        if (!map.get(coordinate).equals(new TerrainType("Void", ' '))) {
            return true;
        }
        return false;
    }
}
