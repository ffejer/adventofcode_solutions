package com.adventofcode.year2018.day2.part1;

import static java.util.stream.Collectors.toMap;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class BoxCheckSum {

  public static void main(String[] args) {
    try (Stream<String> stream = Files.lines(Paths.get("./src/main/resources/2018/day/2/input"))) {
      List<Integer> collect = stream.map(BoxCheckSum::calculateChecksumStream)
          .collect(Collectors.toList());
      int checksum2 = 0, checksum3 = 0;
      for (int stringChecksum : collect) {
          if (stringChecksum == 2) {
              checksum2++;
          } else if (stringChecksum == 3) {
              checksum3++;
          } else if (stringChecksum == 5) {
              checksum2++;
              checksum3++;
          }
      }
      System.out.println(checksum2 * checksum3);
    } catch (IOException e) {
      e.printStackTrace();
    }

  }

  static int calculateChecksumStream(String input) {
    Map<Character, Integer> frequency = input.chars().boxed()
        .collect(toMap(k -> Character.valueOf((char) k.intValue()),
            v -> 1,
            Integer::sum));
    System.out.println(frequency);
    long count2 = frequency.entrySet().stream().filter(e -> e.getValue() == 2).limit(1).count();
    long count3 = frequency.entrySet().stream().filter(e -> e.getValue() == 3).limit(1).count();
    System.out.println(String.format("%d : %d", count2, count3));

    int result = 0;
      if (count2 == 1L) {
          result += 2;
      }
      if (count3 == 1L) {
          result += 3;
      }

    return result;
  }

}
