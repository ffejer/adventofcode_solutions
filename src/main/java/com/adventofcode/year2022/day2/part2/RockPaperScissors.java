package com.adventofcode.year2022.day2.part2;

import com.adventofcode.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RockPaperScissors {

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

  enum Outcome {
    WIN(6), LOSE(0), DRAW(3);
    int score;

    Outcome(int score) {
      this.score = score;
    }
  }

  private void solve() {
    var input = Util.getInputLines("./src/main/resources/input/2022/2/input");
    var solution = input.stream().map(s -> {
      String[] choices = s.split(" ");
      var opponent = getStone(choices[0]);
      var outcome = getOutcome(choices[1]);
      var myStone = calculateMyStone(opponent, outcome);
      return outcome.score + myStone.value;
    }).mapToInt(Integer::intValue).sum();
    logger.info("Solution {}", solution);
  }

  private Stone calculateMyStone(Stone opponent, Outcome outcome) {
    if (Outcome.DRAW.equals(outcome)) {
      return opponent;
    }

    if (Outcome.WIN.equals(outcome)) {
      if (Stone.ROCK.equals(opponent)) {
        return Stone.PAPER;
      }
      if (Stone.PAPER.equals(opponent)) {
        return Stone.SCISSOR;
      }
      if (Stone.SCISSOR.equals(opponent)) {
        return Stone.ROCK;
      }
    }

    if (Outcome.LOSE.equals(outcome)) {
      if (Stone.ROCK.equals(opponent)) {
        return Stone.SCISSOR;
      }
      if (Stone.PAPER.equals(opponent)) {
        return Stone.ROCK;
      }
      if (Stone.SCISSOR.equals(opponent)) {
        return Stone.PAPER;
      }
    }

    throw new IllegalArgumentException();
  }

  private Outcome getOutcome(String choice) {
    switch (choice) {
      case "X" -> {
        return Outcome.LOSE;
      }
      case "Y" -> {
        return Outcome.DRAW;
      }
      case "Z" -> {
        return Outcome.WIN;
      }
      default -> throw new IllegalStateException("Unexpected value: " + choice);
    }
  }

  private Stone getStone(String choice) {
    switch (choice) {
      case "A" -> {
        return Stone.ROCK;
      }
      case "B" -> {
        return Stone.PAPER;
      }
      case "C" -> {
        return Stone.SCISSOR;
      }
      default -> throw new IllegalStateException("Unexpected value: " + choice);
    }
  }
}
