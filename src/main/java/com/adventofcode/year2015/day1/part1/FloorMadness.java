package com.adventofcode.year2015.day1.part1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FloorMadness {

    enum Direction {
        UP, DOWN
    }

    public static void main(String[] args) throws IOException {
        System.out.println(new FloorMadness().calculate(convertInput()));
    }

    Integer calculate(List<Direction> directions) {
        int result = 0;

        for(Direction direction : directions)
            if(Direction.UP.equals(direction))
                result++;
            else if (Direction.DOWN.equals(direction))
                result--;

        return result;
    }

    static List<Direction> convertInput() throws IOException {
        Path path = Paths.get("./src/main/resources/2015/day1/input.txt");
        byte[] data = Files.readAllBytes(path);
        String text = new String(data, "UTF-8");

        List<Direction> input = new ArrayList<>();

        for(int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);

            switch(c) {
                case '(':
                    input.add(Direction.UP);
                    break;
                case ')':
                    input.add(Direction.DOWN);
                    break;
            }
        }

        return input;

    }

}
