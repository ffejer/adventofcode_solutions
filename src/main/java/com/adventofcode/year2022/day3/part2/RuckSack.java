package com.adventofcode.year2022.day3.part2;

import com.adventofcode.util.AbstractProblemSolution;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.apache.commons.collections4.SetUtils;
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
    for (int i = 0; i < input.size(); i += 3) {
      List<String> threeLineBatch = input.subList(i, Math.min(i + 3, input.size()));
      char common = findCommon(threeLineBatch);
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

  private char findCommon(List<String> batch) {
    Set<Character> first = batch.get(0).chars()
        .mapToObj(c -> (char) c)
        .collect(Collectors.toSet());

    Set<Character> second = batch.get(1).chars()
        .mapToObj(c -> (char) c)
        .collect(Collectors.toSet());

    Set<Character> third = batch.get(2).chars()
        .mapToObj(c -> (char) c)
        .collect(Collectors.toSet());

    Set<Character> intersection = SetUtils.intersection(first, second).toSet();
    Set<Character> result = SetUtils.intersection(intersection, third).toSet();
    if (result.size() == 1) {
      return result.iterator().next();
    } else {
      throw new IllegalStateException(
          "Couldn't find common character in the triplet: " + batch);
    }
  }
}