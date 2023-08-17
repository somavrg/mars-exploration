package com.codecool.marsexploration;

import com.codecool.marsexploration.data.Resource;
import com.codecool.marsexploration.map.MapPrinter;
import com.codecool.marsexploration.map.MarsMap;

import java.util.ArrayList;
import java.util.List;

public class MarsExploration {
    private final MapPrinter mapPrinter;
    private final MarsMap marsMap;
    private final List<Resource> resources;

    public MarsExploration(MapPrinter mapPrinter, MarsMap marsMap) {
        this.mapPrinter = mapPrinter;
        this.marsMap = marsMap;
        this.resources = new ArrayList<>();
    }
    public void addResource(Resource resource){
        this.resources.add(resource);
    }

    public void explore(){
        resources.forEach(marsMap::placer);
        mapPrinter.print(marsMap);
    };
}
