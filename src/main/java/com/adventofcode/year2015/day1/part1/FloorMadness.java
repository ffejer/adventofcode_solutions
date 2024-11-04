package com.adventofcode.year2015.day1.part1;

import com.adventofcode.Util;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FloorMadness {

  enum Direction {
    UP, DOWN
  }

  public static void main(String[] args) throws IOException {
    new FloorMadness().solveProblem();
  }

  Integer solveProblem() throws IOException {
    int result = 0;
    for (Direction direction : convertInput()) {
      if (Direction.UP.equals(direction)) {
        result++;
      } else if (Direction.DOWN.equals(direction)) {
        result--;
      }
    }
    return result;
  }

  List<Direction> convertInput() throws IOException {
    String text = Util.readFile("./src/main/resources/2015/day1/input");

    List<Direction> input = new ArrayList<>();

    for (int i = 0; i < text.length(); i++) {
      char c = text.charAt(i);

      switch (c) {
        case '(':
          input.add(Direction.UP);
          break;
        case ')':
          input.add(Direction.DOWN);
          break;
      }
    }

    return input;

  }

}
