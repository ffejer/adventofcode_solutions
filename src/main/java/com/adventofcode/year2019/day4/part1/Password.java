package com.adventofcode.year2019.day4.part1;

public class Password {

  public static void main(String[] args) {
    int solution = solve(372304, 847060);
    System.out.println(solution);
  }

  private static int solve(int from, int to) {
    int result = 0;
    for (int i = from; i <= to; i++) {
      String number = Integer.toString(i);
      if (twoAdjacent(number) && monotoneIncreases(number)) {
        result++;
      }
    }
    return result;
  }

  static boolean twoAdjacent(String number) {
    char[] chars = number.toCharArray();
    for (int i = 0; i < chars.length - 1; i++) {
      if (chars[i] == chars[i + 1]) {
        return true;
      }
    }
    return false;
  }

  static boolean monotoneIncreases(String number) {
    char[] chars = number.toCharArray();
    for (int i = 0; i < chars.length - 1; i++) {
      if (chars[i] > chars[i + 1]) {
        return false;
      }
    }
    return true;
  }
}
