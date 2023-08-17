package com.codecool.marsexploration;

import com.codecool.marsexploration.configuration.Configuration;
import com.codecool.marsexploration.data.Resource;
import com.codecool.marsexploration.generator.MapGenerator;
import com.codecool.marsexploration.map.MapPrinter;
import com.codecool.marsexploration.map.MarsMap;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MarsExploration {
    private final MapPrinter mapPrinter;
    private final List<Resource> resources;
    private final MapGenerator mapGenerator;
    private final Configuration configuration;
    private final Random random;

    public MarsExploration(MapPrinter mapPrinter,
                           MapGenerator mapGenerator,
                           Configuration configuration,
                           Random random) {
        this.mapPrinter = mapPrinter;
        this.resources = new ArrayList<>();
        this.mapGenerator = mapGenerator;
        this.configuration = configuration;
        this.random = random;
    }

    public void addResource(Resource resource) {
        this.resources.add(resource);
    }

    public MarsMap generateMarsMap() {
        return new MarsMap(mapGenerator.generate(), configuration, random);
    }

    public void explore() {
        MarsMap marsMap = new MarsMap(mapGenerator.generate(), configuration, random);
        resources.forEach(marsMap::placer);
        mapPrinter.print(marsMap);
    }

    ;
}
