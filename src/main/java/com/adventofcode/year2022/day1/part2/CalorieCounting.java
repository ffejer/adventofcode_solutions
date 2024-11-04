package com.adventofcode.year2022.day1.part2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.apache.commons.lang3.StringUtils;

public class CalorieCounting {

  public static void main(String[] args) throws IOException {
    try (Stream<String> stream = Files.lines(Paths.get("./src/main/resources/2022/1/input"))) {
      var listofcalories = stream.collect(Collectors.toList());
      var elfCalories = new ArrayList<Integer>();
      int currentCalories = 0;
      for (var calories : listofcalories) {
        if (StringUtils.isNotBlank(calories)) {
          currentCalories += Integer.parseInt(calories);
        } else {
          elfCalories.add(currentCalories);
          currentCalories = 0;
        }
      }
      var top3 = elfCalories.stream().sorted(Comparator.reverseOrder())
          .limit(3)
          .collect(Collectors.toList());
      int solution = top3.stream()
          .mapToInt(Integer::intValue).sum();
      System.out.println(solution);
    }
  }
}
