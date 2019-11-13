package com.adventofcode.year2018.day1.part2;

import static org.testng.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.testng.annotations.Test;

public class FrequencyTest {

    @Test
    public void shouldFindRepeatingFrequencyInList() {
        List<Integer> integerList = Arrays.asList(3, 3, 4, -2, -4);
        int i = Frequency.doCalc(integerList);
        assertEquals(i, 10);
    }
}