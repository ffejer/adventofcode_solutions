package com.adventofcode.year2022.day5.part2;

import com.adventofcode.Util;
import java.text.MessageFormat;
import java.util.List;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SupplyStacks {

  private static final Logger logger = LoggerFactory.getLogger(SupplyStacks.class);

  public static void main(String[] args) {
    new SupplyStacks().solve();
  }

  record Instruction(int amount, int source, int target) {

  }

  private void solve() {
    Stack<Character>[] stacks = getStacks();
    List<Instruction> instructions = getInstructions();

    executeInstructions(stacks, instructions);

    StringBuilder sb = new StringBuilder(9);
    for (int i = 0; i < 9; i++) {
      sb.append(stacks[i].pop());
    }

    logger.info(sb.toString());
  }

  private void executeInstructions(Stack<Character>[] stacks, List<Instruction> instructions) {
    for (Instruction inst : instructions) {
      if (inst.source > 9 || inst.target > 9) {
        throw new IllegalArgumentException(MessageFormat.format("Invalid instruction {0}", inst));
      }

      Stack<Character> source = stacks[inst.source - 1];
      Stack<Character> target = stacks[inst.target - 1];
      Stack<Character> stackAux = new Stack<>();

      for (int i = 0; i < inst.amount(); i++) {
        stackAux.push(source.pop());
      }

      while (!stackAux.isEmpty()) {
        target.push(stackAux.pop());
      }
    }
  }

  private List<Instruction> getInstructions() {
    var lines = Util.getInputLines("./src/main/resources/input/2022/5/input");
    Pattern pattern = Pattern.compile("move (\\d+) from (\\d+) to (\\d+)");
    return lines.subList(10, lines.size()).stream().map(text -> {
      try {
        Matcher matcher = pattern.matcher(text);
        if (matcher.matches()) {
          return new Instruction(Integer.parseInt(matcher.group(1)),
              Integer.parseInt(matcher.group(2)),
              Integer.parseInt(matcher.group(3)));
        }
      } catch (IllegalStateException e) {
        logger.error(MessageFormat.format("Input does not match pattern: {0}", text), e);
      }
      return null;
    }).toList();
  }

  private static Stack<Character>[] getStacks() {
    var input = Util.getInputLines("./src/main/resources/input/2022/5/input");
    var stacksString = input.stream().limit(8).toList();

    Stack<Character>[] stacksAux = new Stack[9];
    for (int i = 0; i < stacksAux.length; i++) {
      stacksAux[i] = new Stack<>();
    }

    for (String s : stacksString) {
      for (int i = 0; i < 9; i++) {
        char item = s.charAt(1 + i * 4);
        if (' ' != item) {
          stacksAux[i].push(item);
        }
      }
    }

    Stack<Character>[] stacks = new Stack[9];
    for (int i = 0; i < stacks.length; i++) {
      stacks[i] = new Stack<>();
    }

    for (int i = 0; i < 9; i++) {
      var currentAuxStack = stacksAux[i];
      while (!currentAuxStack.empty()) {
        stacks[i].push(currentAuxStack.pop());
      }
    }

    return stacks;
  }
}
