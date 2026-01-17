package com.butteredapples.ptw.contents.utils;

import net.minecraft.util.StringIdentifiable;
import net.minecraft.util.math.Direction;

public enum RakeBlockEnum implements StringIdentifiable {
    NORTH("north"),
    SOUTH("south"),
    EAST("east"),
    WEST("west"),
    NORTHEAST("northeast"),
    NORTHWEST("northwest"),
    SOUTHEAST("southeast"),
    SOUTHWEST("southwest"),
    CENTRE("centre");

    private final String name;

    private RakeBlockEnum(String name){
        this.name = name;
    }

    public static RakeBlockEnum fromDirection(Direction dir) {
        return switch (dir) {
            case SOUTH -> SOUTH;
            case EAST  -> EAST;
            case WEST  -> WEST;
            default -> NORTH;
        };
    }


    public String toString() {
        return this.name;
    }

    @Override
    public String asString() {
        return this.name;
    }
}
