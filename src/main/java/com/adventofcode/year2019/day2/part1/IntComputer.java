package com.adventofcode.year2019.day2.part1;

import com.adventofcode.util.AbstractProblemSolution;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class IntComputer extends AbstractProblemSolution {

  public static void main(String[] args) {
    new IntComputer().solveProblem();
  }

  void solveProblem() {
    List<String> input = getInputLines("./src/main/resources/2019/day/2/input");
    List<Integer> intList = convertInput(input);
    adjustComputer(intList);

    System.out.println(doCalc(intList));
  }

  Integer doCalc(List<Integer> input) {
    int size = input.size();

    for (int position = 0; position < size; position += 4) {
      System.out.println(position);
      int opcode = input.get(position);

      if (position == size - 1) {
        break;
      }

      int index1 = input.get(position + 1);
      int index2 = input.get(position + 2);
      int destination = input.get(position + 3);
      Integer value1 = input.get(index1);
      Integer value2 = input.get(index2);
      if (opcode == 1) {
        input.set(destination, value1 + value2);
      } else if (opcode == 2) {
        input.set(destination, value1 * value2);
      } else if (opcode == 99) {
        break;
      } else {
        throw new IllegalStateException();
      }
    }

    return input.get(0);
  }

  private void adjustComputer(List<Integer> intList) {
    intList.set(1, 12);
    intList.set(2, 2);
  }

  private List<Integer> convertInput(List<String> input) {
    List<Integer> result = new ArrayList<>();
    for (String string : input) {
      List<String> strings = Arrays.asList(string.split("\\s*,\\s*"));
      result.addAll(strings.stream().map(Integer::valueOf).collect(Collectors.toList()));
    }
    return result;
  }

}
