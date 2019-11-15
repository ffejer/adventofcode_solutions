package com.adventofcode.year2018.day2.part1;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class BoxCheckSumTest {
    @DataProvider(name = "exampleInput")
    public static Object[][] exampleInput() {
        return new Object[][]{
                {"abcdef", 0},
                {"bababc", 5},
                {"abbcde", 2},
                {"abcccd", 3},
                {"aabcdd", 2},
                {"abcdee", 2},
                {"ababab", 3}
        };
    }


    @Test(dataProvider = "exampleInput")
    public void testName(String input, int expected) {
        int actual = BoxCheckSum.calculateChecksumStream(input);
        assertEquals(actual, expected);
    }
}