package com.adventofcode.year2015.day2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

public class WrappingPaper {

    class Present {

        private final int surfaceArea;
        private final int smallestSide;
        private final int bow;
        private final int ribbon;

        Present(int l, int w, int h) {
            int lw = l * w;
            int wh = w * h;
            int hl = h * l;

            int sideLW = l + w + l + w;
            int sideWH = w + h + w + h;
            int sideHL = h + l + h + l;

            int tempSmallestPerimeter;

            tempSmallestPerimeter = sideLW;

            if (sideWH < tempSmallestPerimeter)
                tempSmallestPerimeter = sideWH;
            if (sideHL < tempSmallestPerimeter)
                tempSmallestPerimeter = sideHL;

            this.ribbon = tempSmallestPerimeter;
            this.bow = l * w * h;
            this.surfaceArea = (2 * lw) + (2 * wh) + (2 * hl);

            int tempSmallestSide;

            tempSmallestSide = lw;

            if (wh < tempSmallestSide)
                tempSmallestSide = wh;
            if (hl < tempSmallestSide)
                tempSmallestSide = hl;

            this.smallestSide = tempSmallestSide;
        }

        int ribbonNeeded() {
            return this.bow + this.ribbon;
        }

        int paperNeeded() {
            return smallestSide + surfaceArea;
        }
    }

    public static void main(String[] args) {
        new WrappingPaper().convertInput();
    }

    List<Present> convertInput() {

        String fileName = "./src/main/resources/2015/day2/part1/input.txt";

        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

            Stream<Present> presentStream = stream
                    .map(present -> present.split("x"))
                    .map(dimensions -> new Present(Integer.valueOf(dimensions[0]), Integer.valueOf(dimensions[1]),
                            Integer.valueOf(dimensions[2])));

            int ribbon = presentStream.mapToInt(Present::ribbonNeeded).sum();

            System.out.println(ribbon);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;

    }

}
