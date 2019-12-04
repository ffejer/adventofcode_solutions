package com.adventofcode.year2018.day3;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;

class Claim {
    int id;
    int lx, ly, rx, ry, dx, dy;

    Claim(Matcher matcher) {
        matcher.find();
        this.id = Integer.parseInt(matcher.group(1));
        this.lx = Integer.parseInt(matcher.group(2));
        this.ly = Integer.parseInt(matcher.group(3));
        this.dx = Integer.parseInt(matcher.group(4));
        this.dy = Integer.parseInt(matcher.group(5));
        this.rx = lx + dx;
        this.ry = ly + dy;
    }

    Set<Point> getOverlap(Claim o) {
        boolean right = isRight(o);
        boolean left = isLeft(o);
        boolean upper = isUpper(o);
        boolean lower = isLower(o);

        if (right) {
            if (upper) {
                return getPoints(o.lx, o.ly, rx, ry);
            } else if (lower) {
                return getPoints(o.lx, ly, o.rx, ry);
            }
        } else if (left) {
            if(upper) {
                return getPoints(lx, o.ly, o.rx, ry);
            } else if (lower) {
                return getPoints(lx, ly, o.rx, o.ly);
            }
        }

        return Collections.emptySet();
    }

    boolean isRight(Claim o) {
        return lx < o.lx && o.lx < rx && rx < o.rx;
    }

    boolean isLeft(Claim o) {
        return o.lx < lx && lx < o.rx && o.rx < rx;
    }

    boolean isUpper(Claim o) {
        return ly < o.ly && o.ly < ry && ry < o.ry;
    }

    boolean isLower(Claim o) {
        return o.ly < ly && ly < o.ry && o.ry < ry;
    }


    Set<Point> getPoints() {
        return getPoints(this.lx, this.ly, rx, ry);
    }

    private Set<Point> getPoints(int lx, int ly, int rx, int ry) {
        Set<Point> result = new HashSet<>();
        for (int i = lx; i < rx; i++) {
            for (int j = ly; j < ry; j++) {
                result.add(new Point(i, j));
            }
        }
        return result;
    }
}
