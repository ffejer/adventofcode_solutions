package com.adventofcode.year2018.day1.part1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Frequency {

    public static void main(String[] args) {
        try (Stream<String> stream = Files.lines(Paths.get("./src/main/resources/2018/day/1/input"))) {
            int sum = stream.map(Integer::new).mapToInt(Integer::intValue).sum();
            System.out.println(sum);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
