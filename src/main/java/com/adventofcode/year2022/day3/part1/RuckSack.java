package com.adventofcode.year2022.day3.part1;

import com.adventofcode.util.AbstractProblemSolution;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RuckSack extends AbstractProblemSolution {

  private static final Logger logger = LoggerFactory.getLogger(RuckSack.class);
  private static final int LOWERCASE_A = 'a';
  private static final int CAPITAL_A = 'A';
  public static final int LOW_PRIO_ADJUSTMENT = 1;
  public static final int HIGHT_PRIO_ADJUSTMENT = 27;

  public static void main(String[] args) {
    new RuckSack().solve();
  }

  private void solve() {
    var input = getInputLines("./src/main/resources/input/2022/3/input");
    int solution = 0;
    for (String line : input) {
      int totalLength = line.length();
      int halfLine = totalLength / 2;
      var firstHalf = line.substring(0, halfLine);
      var secondHalf = line.substring(halfLine, totalLength);
      char common = findCommon(firstHalf, secondHalf);
      solution += findPrio(common);
    }
    logger.info(String.valueOf(solution));
  }

  int findPrio(char common) {
    if (common >= 'a' && common <= 'z') {
      return common - LOWERCASE_A + LOW_PRIO_ADJUSTMENT;
    }
    if (common >= 'A' && common <= 'Z') {
      return common - CAPITAL_A + HIGHT_PRIO_ADJUSTMENT;
    }
    throw new IllegalStateException("Unknown priority found: " + common);
  }

  private char findCommon(String firstHalf, String secondHalf) {
    for (char c1 : firstHalf.toCharArray()) {
      for (char c2 : secondHalf.toCharArray()) {
        if (c1 == c2) {
          return c1;
        }
      }
    }
    throw new IllegalStateException(
        "No common item found between " + firstHalf + " and " + secondHalf);
  }
}