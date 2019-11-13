package com.adventofcode.year2018.day1.part2;

import static org.testng.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TimeTravelDeviceTest {


    @DataProvider(name = "exampleInput")
    public static Object[][] exampleInput() {
        return new Object[][]{
                {Arrays.asList(1, -1), 0},
                {Arrays.asList(3, 3, 4, -2, -4, 3, 3, 4, -2, -4, 3, 3, 4, -2, -4), 10},
                {Arrays.asList(-6, 3, 8, 5, -6, -6, 3, 8, 5, -6, -6, 3, 8, 5, -6), 5},
                {Arrays.asList(+7, +7, -2, -7, -4, +7, +7, -2, -7, -4, +7, +7, -2, -7, -4), 14}

        };
    }

    @Test(dataProvider = "exampleInput")
    public void shouldFindRepeatingFrequencyInList(List<Integer> input, int expected) {
        TimeTravelDevice sut = new TimeTravelDevice();
        int actual = sut.processInputOnce(input);
        assertEquals(actual, expected);
    }
}