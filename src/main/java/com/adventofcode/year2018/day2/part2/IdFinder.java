package com.adventofcode.year2018.day2.part2;

import com.adventofcode.year2018.day2.part1.BoxCheckSum;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class IdFinder {

    private static boolean isMatching(String a, String b) {
        int count = 0;
        for (int i = 0; i < a.length() && count < 2; i++) {
            if(a.charAt(i) != b.charAt(i)) {
                count++;
            }
        }
        return count < 2;
    }

    public static void main(String[] args) {
        try(Stream<String> stream = Files.lines(Paths.get("./src/main/resources/2018/day/2/input"))) {
            docalc(stream);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void docalc(Stream<String> stream) {
        List<String> collect = stream.collect(Collectors.toList());
        for (int i = 0; i < collect.size(); i++) {
            for (int j = 0; j < collect.size(); j++) {
                if(i == j) continue;
                String a = collect.get(i);
                String b = collect.get(j);
                if(isMatching(a, b)) {
                    System.out.println("result: " + a + " " + b);
                    return;
                }
            }
        }
    }

}
