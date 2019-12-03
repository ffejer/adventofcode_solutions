package com.adventofcode.year2018.day3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OverlappingBruteForce {
    private static String REGEXP = "#([0-9]+)\\W@\\W([0-9]+),([0-9]+):\\W([0-9]+)x([0-9]+)";
    private static Pattern pattern = Pattern.compile(REGEXP);

    public static void main(String[] args) {
        OverlappingBruteForce overlapping = new OverlappingBruteForce();
        try (Stream<String> stream = Files.lines(Paths.get("./src/main/resources/2018/day/3/input"))) {
            overlapping.doCalculation(stream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void doCalculation(Stream<String> stream) {
        List<Claim> collect = stream.map(s -> new Claim(pattern.matcher(s))).collect(Collectors.toList());
        Map<Point, Integer> overlapping = new HashMap<>();
        for(Claim claim : collect) {
            Set<Point> points = claim.getPoints();
            for(Point point : points) {
                if(overlapping.containsKey(point)) {
                    // todo
                }
            }
        }
        return;
    }

    class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    class Claim {
        int id;
        int x, y, dx, dy;

        public Claim(Matcher matcher) {
            matcher.find();
            this.id = Integer.parseInt(matcher.group(1));
            this.x = Integer.parseInt(matcher.group(2));
            this.y = Integer.parseInt(matcher.group(3));
            this.dx = Integer.parseInt(matcher.group(4));
            this.dy = Integer.parseInt(matcher.group(5));
        }

        Set<Point> getPoints(){
            Set<Point> result = new HashSet<>();
            int x2 = this.x + this.dx;
            int y2 = this.y + this.dy;
            for(int i = this.x; i < x2; i++) {
                for (int j = this.y; j < y2; j++) {
                    result.add(new Point(i,j));
                }
            }
            return result;
        }
    }
}
