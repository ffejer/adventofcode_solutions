package com.adventofcode.year2022.day6.part1;

import com.adventofcode.Util;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TuningTrouble {

  private static final Logger logger = LoggerFactory.getLogger(TuningTrouble.class);

  public static void main(String[] args) {
    new TuningTrouble().solve();
  }

  private void solve() {
    var input = Util.getInputLines("./src/main/resources/input/2022/6/input").get(0);

    for (int i = 4; i <= input.length(); i++) {
      String substring = input.substring(i - 4, i);
      if (substring.chars().boxed().collect(Collectors.toSet()).size() == 4) {
        logger.info("Tuning trouble at {}", substring);
        logger.info("Tuning trouble at {}", i);
        return;
      }
    }
  }
}
