package com.adventofcode.year2015.day3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class SantaClause {

    enum Direction {
        NORTH( 0,  1), //
        SOUTH( 0, -1), //
        EAST ( 1,  0), //
        WEST (-1,  0); //

        int deltaX;
        int deltaY;

        Direction(int dx, int dy) {
            this.deltaX = dx;
            this.deltaY = dy;
        }
    }

    class Location {
        private final int x, y;

        Location(int x, int y) {
            this.x = x;
            this.y = y;
        }

        int getX() {
            return x;
        }

        int getY() {
            return y;
        }

        @Override public String toString() {
            return "Location{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }

        @Override public boolean equals(Object o) {
            if (this == o)
                return true;
            if (o == null || getClass() != o.getClass())
                return false;
            Location location = (Location) o;
            return getX() == location.getX() &&
                    getY() == location.getY();
        }

        @Override public int hashCode() {

            return Objects.hash(getX(), getY());
        }
    }

    public static void main(String[] args) throws IOException {
        System.out.println(new SantaClause().calculate(convertInput()));
    }

    static List<Direction> convertInput() throws IOException {
        Path path = Paths.get("./input.txt");
        byte[] data = Files.readAllBytes(path);
        String text = new String(data, "UTF-8");

        List<Direction> input = new ArrayList<>();

        for(int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);

            switch(c) {
                case '<':
                    input.add(Direction.WEST);
                    break;
                case '>':
                    input.add(Direction.EAST);
                    break;
                case 'v':
                    input.add(Direction.SOUTH);
                    break;
                case '^':
                    input.add(Direction.NORTH);
                    break;
            }
        }

        return input;

    }

    protected int calculate(List<Direction> input) {

        Set<Location> touchedHouses = new HashSet<>();

        int numOfInstruction = 0;

        int x = 0;
        int y = 0;

        int roboX = 0;
        int roboY = 0;

        touchedHouses.add(new Location(x,y));

        for(Direction direction : input) {
            if(numOfInstruction%2 == 0) {
                x += direction.deltaX;
                y += direction.deltaY;
                touchedHouses.add(new Location(x, y));
            } else {
                roboX += direction.deltaX;
                roboY += direction.deltaY;
                touchedHouses.add(new Location(roboX, roboY));
            }
            numOfInstruction++;
        }

        return touchedHouses.size();
    }
}
