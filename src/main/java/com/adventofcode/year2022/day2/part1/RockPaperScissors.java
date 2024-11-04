package com.adventofcode.year2022.day2.part1;

import com.adventofcode.util.AbstractProblemSolution;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RockPaperScissors extends AbstractProblemSolution {

  private static final Logger logger = LoggerFactory.getLogger(RockPaperScissors.class);

  public static void main(String[] args) {
    new RockPaperScissors().solve();
  }

  enum Stone {
    ROCK(1), PAPER(2), SCISSOR(3);
    final int value;

    Stone(int value) {
      this.value = value;
    }
  }


  private void solve() {
    var input = getInputLines("./src/main/resources/input/2022/2/input");
    var solution = input.stream().map(s -> {
      String[] choices = s.split(" ");
      var opponent = getStone(choices[0]);
      var self = getStone(choices[1]);
      var score = evaluateRound(opponent, self);
      return score + self.value;
    }).mapToInt(Integer::intValue).sum();
    logger.info("Solution {}", solution);
  }

  private int evaluateRound(Stone opponent, Stone self) {
    if (opponent.equals(self)) {
      return 3;
    }
    if ((Stone.ROCK.equals(self) && Stone.SCISSOR.equals(opponent)) || (Stone.PAPER.equals(self)
        && Stone.ROCK.equals(opponent)) || (Stone.SCISSOR.equals(self) && Stone.PAPER.equals(
        opponent))) {
      return 6;
    }
    return 0;
  }

  private Stone getStone(String choice) {
    switch (choice) {
      case "A", "X" -> {
        return Stone.ROCK;
      }
      case "B", "Y" -> {
        return Stone.PAPER;
      }
      case "C", "Z" -> {
        return Stone.SCISSOR;
      }
      default -> throw new IllegalStateException("Unexpected value: " + choice);
    }
  }
}
