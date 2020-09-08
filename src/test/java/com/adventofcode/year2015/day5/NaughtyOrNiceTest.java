package com.adventofcode.year2015.day5;

import org.testng.Assert;

import java.util.Arrays;

public class NaughtyOrNiceTest {

    //    @Test
    public void should_shouldFindDupeCharsInString() throws Exception {
        // given
        NaughtyOrNice naughtyOrNice = new NaughtyOrNice();

        // when
        long result = naughtyOrNice.calculate(Arrays.asList("dmrtgdkaimrrwmej"));

        // then
        Assert.assertEquals(1, result);
    }
}