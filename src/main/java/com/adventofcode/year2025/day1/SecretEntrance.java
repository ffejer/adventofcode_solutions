package com.adventofcode.year2025.day1;

import com.adventofcode.Util;

public class SecretEntrance {

  private void solve() {
    var input = Util.getInputLines("./src/main/resources/input/2025/1/input");
    int zerohit = 0;
    int pointer = 50;
    for (String line : input) {
      var direction = line.substring(0, 1);
      var notches = Integer.parseInt(line.substring(1));
      if (direction.equals("L")) {
        pointer -= notches;
      } else if (direction.equals("R")) {
        pointer += notches;
      }
      pointer %= 100;
      if (pointer == 0) {
        zerohit++;
      }
    }
    System.out.println(zerohit);
  }

  public static void main(String[] args) {
    new SecretEntrance().solve();
  }
}
