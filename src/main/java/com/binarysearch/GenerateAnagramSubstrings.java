package com.binarysearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    Map<String, ArrayList<String>> strings = generateAndCountSubstrings(s);
    List<String> result = new ArrayList<>();
    for (List<String> l : strings.values()) {
      if (l.size() > 1) {
        result.addAll(l);
      }
    }
    String[] retval = result.toArray(new String[0]);
    Arrays.sort(retval);
    return retval;
  }

  private Map<String, ArrayList<String>> generateAndCountSubstrings(String s) {
    Map<String, ArrayList<String>> result = new HashMap<>();
    for (int length = 1; length < s.length(); length++) {
      for (int start = 0; start < s.length() - length + 1; start++) {
        String substring = s.substring(start, start + length);
        char[] chars = substring.toCharArray();
        String substr = String.valueOf(chars);
        Arrays.sort(chars);
        String key = String.valueOf(chars);
        ArrayList<String> list = result.getOrDefault(key, new ArrayList<>());
        list.add(substr);
        result.putIfAbsent(key, list);
      }
    }
    return result;
  }
}
