package com.adventofcode.year2019.day1.part2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class RocketFuelEquation {

    private static final float DIVIDENT = 3.0f;

    public static void main(String[] args) {
        try (Stream<String> stream = Files.lines(Paths.get("./src/main/resources/2019/day/1/input"))) {
            int sum = stream.map(x -> {
                int grandTotal = 0;
                int mass = Integer.parseInt(x);

                for (; ; ) {
                    float divided = mass / DIVIDENT;
                    mass = ((int) divided) - 2;
                    if (mass <= 0) {
                        break;
                    }
                    grandTotal += mass;
                }

                return grandTotal;
            }).reduce(0, Integer::sum);
            System.out.println(sum);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
