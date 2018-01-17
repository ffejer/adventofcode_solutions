package com.adventofcode.year2015.day1.part2;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static com.adventofcode.year2015.day1.part2.FloorMadness.Direction.DOWN;
import static com.adventofcode.year2015.day1.part2.FloorMadness.Direction.UP;

public class FloorMadnessTest {

    @Test
    public void testInput() {
        List<FloorMadness.Direction> directions = Arrays.asList(UP, DOWN, DOWN);
        Integer actualResult = new FloorMadness().calculate(directions);

        Assert.assertEquals((int) actualResult, 3);
    }
}