package com.adventofcode.year2019.day1.part1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class RocketFuelEquation {

    private static final float DIVIDENT = 3.0f;

    public static void main(String[] args) {
        try(Stream<String> stream = Files.lines(Paths.get("./src/main/resources/2019/day/1/input"))) {
            int sum = stream.map(x -> {
                float divided = Integer.parseInt(x) / DIVIDENT;
                return ((int) divided) - 2;
            }).reduce(0, Integer::sum);
            System.out.println(sum);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
