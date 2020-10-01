package com.adventofcode.year2019.day10.part1;

import com.adventofcode.model.Pair;
import com.adventofcode.util.AbstractProblemSolution;
import com.adventofcode.util.Asteroid;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.lang.String.format;

public class Observatory extends AbstractProblemSolution {

    Set<Asteroid> asteroids = new HashSet<>();
    Set<Pair<Asteroid, Asteroid>> visiblePairs;
    Set<Pair<Asteroid, Asteroid>> notVisiblePairs;

    public static void main(String[] args) {
        new Observatory().solve("./src/main/resources/2019/day/10/input1");
//        Asteroid a = new Asteroid(1, 2);
//        Asteroid b = new Asteroid(1, 2);
//        System.out.println(a.equals(b));
    }

    private void solve(String pathname) {
        initInput(pathname);

        for (Asteroid a : asteroids) {
            for (Asteroid b : asteroids) {
                checkPair(a, b);
            }
        }
    }

    private void checkPair(Asteroid a, Asteroid b) {
        if(a.equals(b)) return;

        int dx = a.getX() - b.getX();
        int dy = a.getY() - b.getY();

        int absDx = Math.abs(dx);
        int absDy = Math.abs(dy);
        BigInteger bigInteger1 = BigInteger.valueOf(absDx);
        BigInteger bigInteger2 = BigInteger.valueOf(absDy);
        BigInteger gcd = bigInteger1.gcd(bigInteger2);
        System.out.println(format("|dx| = %d, |dy| = %d, gcd = %d", absDx, absDy, gcd));

    }

    private void initInput(String pathname) {
        List<String> input = readStreamFromFile(pathname);
        int i = 0;
        int j = 0;
        for (String s : input) {
            for (char a : s.toCharArray()) {
                if (a == '#') asteroids.add(new Asteroid(i, j));
                j++;
            }
            i++;
            j = 0;
        }
    }
}
