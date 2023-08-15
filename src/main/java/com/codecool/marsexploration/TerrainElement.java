package com.codecool.marsexploration;

public abstract class TerrainElement {
    private final String name;
    private final char symbol;

    public TerrainElement(String name, char symbol) {
        this.name = name;
        this.symbol = symbol;
    }
}
