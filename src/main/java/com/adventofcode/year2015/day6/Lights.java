package com.adventofcode.year2015.day6;

import com.adventofcode.util.AbstractProblemSolution;

import java.util.List;

public class Lights extends AbstractProblemSolution {

    boolean[][] switchPanel;

    enum Change { ON, OFF, TOGGLE }

    class SwitchChange {
        int x1, y1, x2, y2;
        Change change;

        public SwitchChange(int x1, int y1, int x2, int y2, Change change) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
            this.change = change;
        }
    }

    public static void main(String[] args) {
        List<SwitchChange> input = convertInput(readFile("./src/main/resources/2015/day1/input.txt"));


        new Lights().solve(input);

    }

    void solve(List<Lights.SwitchChange> input) {

    }

    private static List<SwitchChange> convertInput(String s) {



        return null;
    }

}
