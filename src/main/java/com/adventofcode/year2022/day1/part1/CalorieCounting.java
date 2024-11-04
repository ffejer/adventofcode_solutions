package com.adventofcode.year2022.day1.part1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.apache.commons.lang3.StringUtils;

public class CalorieCounting {

  public static void main(String[] args) throws IOException {
    try (Stream<String> stream = Files.lines(Paths.get("./src/main/resources/2022/1/input1"))) {
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

      Optional<Integer> max = elfCalories.stream().max(Integer::compareTo);
      System.out.println(max.get());
    }
  }
}
