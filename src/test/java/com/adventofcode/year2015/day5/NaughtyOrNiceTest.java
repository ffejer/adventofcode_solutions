package com.adventofcode.year2015.day5;

import com.sun.corba.se.impl.naming.cosnaming.NamingUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;

import static org.testng.Assert.*;

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