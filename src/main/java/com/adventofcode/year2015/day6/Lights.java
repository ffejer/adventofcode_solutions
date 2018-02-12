package com.adventofcode.year2015.day6;

import com.adventofcode.util.AbstractProblemSolution;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.adventofcode.year2015.day6.Lights.Change.*;

public class Lights extends AbstractProblemSolution {

    static String  pattern     = "^(turn on|turn off|toggle)\\s([0-9]*\\d),([0-9]*\\d)\\sthrough\\s([0-9]*\\d),([0-9]*\\d)";
    static Pattern instruction = Pattern.compile(pattern, Pattern.MULTILINE | Pattern.UNIX_LINES);

    boolean[][] switchPanel;

    public int getSolution() {

        int count = 0;

        for (int i = 0; i < switchPanel.length; i++) {
            for (int j = 0; j < switchPanel[i].length; j++) {
                if (switchPanel[i][j]) {
                    count++;
                }
            }
        }

        return count;
    }

    enum Change {ON, OFF, TOGGLE}

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

    Lights() {
        switchPanel = new boolean[1000][1000];
    }

    public static void main(String[] args) {
        Lights lights = new Lights();
        List<SwitchChange> input = lights.convertInput(readFile("./src/main/resources/2015/day6/part1/input.txt"));
        lights.solve(input);

        System.out.println(lights.getSolution());
    }

    void solve(List<Lights.SwitchChange> input) {
        for (SwitchChange instruction : input) {
            applyInstruction(instruction);
        }
    }

    private void applyInstruction(SwitchChange instruction) {
        for (int tempx = instruction.x1; tempx <= instruction.x2; tempx++)
            for (int tempy = instruction.y1; tempy <= instruction.y2; tempy++) {
                if (instruction.change.equals(ON))
                    switchPanel[tempx][tempy] = true;
                else if (instruction.change.equals(OFF))
                    switchPanel[tempx][tempy] = false;
                else if (instruction.change.equals(TOGGLE))
                    switchPanel[tempx][tempy] = !switchPanel[tempx][tempy];
            }
    }

    private List<SwitchChange> convertInput(String s) {

        List<SwitchChange> input = new ArrayList<>();

        Matcher matcher = instruction.matcher(s);

        while (matcher.find()) {
            MatchResult matchResult = matcher.toMatchResult();
            input.add(extractSwitchChange(
                    matchResult.group(1),
                    matchResult.group(2),
                    matchResult.group(3),
                    matchResult.group(4),
                    matchResult.group(5)
            ));
        }

        return input;
    }

    private SwitchChange extractSwitchChange(//
            String flipString,//
            String x1String,//
            String y1String,//
            String x2String,//
            String y2String//
    ) {

        Change flip = null;
        int x1, x2, y1, y2;
        x1 = x2 = y1 = y2 = 0;

        try {
            switch (flipString) {
                case "turn on":
                    flip = ON;
                    break;
                case "turn off":
                    flip = OFF;
                    break;
                case "toggle":
                    flip = Change.TOGGLE;
                    break;
                default:
                    flip = null;
                    break;
            }

            x1 = Integer.parseInt(x1String);
            y1 = Integer.parseInt(y1String);
            x2 = Integer.parseInt(x2String);
            y2 = Integer.parseInt(y2String);

        } catch (Exception ex) {
            //            System.out.println("matcher: " + matcher);
        }

        return new SwitchChange(x1, y1, x2, y2, flip);
    }

}
