package com.adventofcode.year2018.day1.part2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Frequency {

    public static void main(String[] args) {
        try(Stream<String> stream = Files.lines(Paths.get("./src/main/resources/2018/day1/input.txt"))) {
            List<Integer> integerList = stream.map(Integer::valueOf).collect(Collectors.toList());
            System.out.println(doCalc(integerList));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static int doCalc(List<Integer> integerList) {
        Set<Integer> valuesSeen = new HashSet<>();
        int frequency = 0;
        valuesSeen.add(0);
        for(Integer i : integerList) {
            frequency += i;
            if(valuesSeen.contains(frequency)) {
                return frequency;
            } else {
                valuesSeen.add(frequency);
            }
        }

        throw new IllegalStateException("No frequencies were seen twice.");
    }
}
