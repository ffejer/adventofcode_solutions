package com.adventofcode.year2018.day1.part2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * https://adventofcode.com/2018/day/1#part2
 */
public class TimeTravelDevice {

    private Set<Integer> valuesSeen = new HashSet<>();
    private int frequency = 0;

    TimeTravelDevice() {
        valuesSeen.add(0);
    }

    public static void main(String[] args) {
        try(Stream<String> stream = Files.lines(Paths.get("./src/main/resources/2018/day/1/input"))) {
            List<Integer> input = stream.map(Integer::valueOf).collect(Collectors.toList());
            Integer result = null;
            TimeTravelDevice device = new TimeTravelDevice();
            do {
                result = device.processInputOnce(input);
            } while (result == null);
            System.out.println(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    Integer processInputOnce(List<Integer> integerList) {
        for(int adjustment : integerList) {
            frequency += adjustment;
            if(valuesSeen.contains(frequency)) {
                return frequency;
            } else {
                valuesSeen.add(frequency);
            }
        }
        return null;
    }
}
