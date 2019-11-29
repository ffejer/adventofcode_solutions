package com.adventofcode.year2018.day3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Overlapping {
    private static String REGEXP = "#([0-9]+)\\W@\\W([0-9]+),([0-9]+):\\W([0-9]+)x([0-9]+)";
    private static Pattern pattern = Pattern.compile(REGEXP);

    public static void main(String[] args) {
        Overlapping overlapping = new Overlapping();
        try (Stream<String> stream = Files.lines(Paths.get("./src/main/resources/2018/day/3/input"))) {
            overlapping.doWork(stream);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }



    void doWork(Stream<String> stream) {
        List<Claim> collect = stream.map(s -> new Claim(pattern.matcher(s))).collect(Collectors.toList());
        return;
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

        public int getId() {
            return id;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public int getDx() {
            return dx;
        }

        public int getDy() {
            return dy;
        }
    }
}
