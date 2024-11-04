package com.adventofcode.year2022.day4.part1;

import com.adventofcode.Util;
import java.text.MessageFormat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CampCleanup {

  private static final Logger logger = LoggerFactory.getLogger(CampCleanup.class);

  public static void main(String[] args) {
    new CampCleanup().solve();
  }

  private void solve() {
    var input = Util.getInputLines("./src/main/resources/input/2022/4/input");
    int solution = 0;
    for (String line : input) {
      String[] assignments = line.split(",");
      String[] team1 = assignments[0].split("-");
      String[] team2 = assignments[1].split("-");
      if (fullOverlap(Integer.parseInt(team1[0]), Integer.parseInt(team1[1]),
          Integer.parseInt(team2[0]), Integer.parseInt(team2[1]))) {
        solution++;
      }
    }
    logger.info(String.valueOf(solution));
  }

  boolean fullOverlap(int teamAFrom, int teamATo, int teamBFrom, int teamBTo) {
    if (!(teamAFrom <= teamATo && teamBFrom <= teamBTo)) {
      throw new IllegalStateException(
          MessageFormat.format("Sections [{0}, {1}] & [{2}, {3}]", teamAFrom, teamATo,
              teamBFrom, teamBTo));
    }
    return (teamAFrom >= teamBFrom && teamATo <= teamBTo)
        || (teamBFrom >= teamAFrom && teamBTo <= teamATo);
  }

}
