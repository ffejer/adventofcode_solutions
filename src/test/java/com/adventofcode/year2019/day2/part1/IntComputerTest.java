package com.adventofcode.year2019.day2.part1;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class IntComputerTest {

    @DataProvider(name = "exampleInput")
    public static Object[][] exampleInput() {
        return new Object[][]{
                {Arrays.asList(1, 0, 0, 0, 99)},
                {Arrays.asList(2, 3, 0, 3, 99)}
        };
    }


    @Test(dataProvider = "exampleInput")
    public void testName(List<Integer> input) {
        Integer actual = IntComputer.doCalc(input);
        assertEquals(actual, Integer.valueOf(2));
    }


}