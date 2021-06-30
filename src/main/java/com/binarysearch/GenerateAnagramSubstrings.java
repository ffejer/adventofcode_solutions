package com.binarysearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * You are given a lowercase alphabet string s. Return all substrings in s where there is another
 * substring in s at a different location that is an anagram. Return the list sorted in
 * lexicographic order.
 *
 * Constraints 1 ≤ n ≤ 100 where n is the length of s
 */
public class GenerateAnagramSubstrings {

  public static void main(String[] args) {
    String[] input = new GenerateAnagramSubstrings().solve("aaabcda");
    System.out.println(Arrays.toString(input));
  }

  public String[] solve(String s) {
    ArrayList<String> strings = generateSubstrings(s);
    ArrayList<String> result = new ArrayList<>();
    System.out.println(strings);
    List<HashMap<Integer, Integer>> sums =
        strings.stream().map(this::sumchars).collect(Collectors.toList());

    for (int i = 0; i < strings.size() - 1; i++) {
      for (int j = i + 1; j < strings.size(); j++) {
        if (sums.get(i).equals(sums.get(j))) {
          result.add(strings.get(i));
          result.add(strings.get(j));
        }
      }
    }
    String[] returnValue = result.toArray(new String[0]);
    Arrays.sort(returnValue);
    return returnValue;
  }

  private HashMap<Integer, Integer> sumchars(String s) {
    HashMap<Integer, Integer> result = new HashMap<>();
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (result.containsKey((int) c)) {
        Integer integer = result.get((int) c);
        integer++;
        result.put((int) c, integer);
      } else {
        result.put((int) c, 1);
      }
    }
    return result;
  }

  private ArrayList<String> generateSubstrings(String s) {
    ArrayList<String> result = new ArrayList<>();
    for (int length = 1; length < s.length(); length++) {
      for (int start = 0; start < s.length() - length + 1; start++) {
        result.add(s.substring(start, start + length));
      }
    }
    return result;
  }
}
