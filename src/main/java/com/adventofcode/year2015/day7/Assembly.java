package com.adventofcode.year2015.day7;

import java.util.HashMap;
import java.util.Map;

public class Assembly {

    enum GateType { NOT, AND, OR, LSHIFT, RSHIFT }

    Map<String, BuildingBlock> register = new HashMap<>();

    abstract class BuildingBlock {
        abstract char getOutPut();
    }

    class Wire {
        String id;

    }

    class Gate {

    }

    public static void main(String[] args) {

    }
}
