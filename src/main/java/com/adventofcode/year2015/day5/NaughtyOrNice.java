package com.adventofcode.year2015.day5;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NaughtyOrNice {

    private final Pattern atLeastThreeVowels;
    private final Pattern dupeChars;
    private final Pattern noDisallowedStrings;

    NaughtyOrNice() {
        this.dupeChars = Pattern.compile("(.)\1/g");
        this.atLeastThreeVowels = Pattern.compile("([aeiou].*){3,}");
        this.noDisallowedStrings = Pattern.compile("(ab|cd|pq|xy)");
    }

    public static void main(String[] args) {
        System.out.println(new NaughtyOrNice().calculate(convertInput()));
    }

    long calculate(List<String> strings) {

        dupeChars.matcher("dmrtgdkaimrrwmej").matches();


        long count = strings.stream().filter(s ->
                /*atLeastThreeVowels.matcher(s).matches() &&*/ dupeChars.matcher(s).matches() /*&& !noDisallowedStrings.matcher(s)*/
                        /*.matches()*/
        ).count();

        return count;
    }

    static List<String> convertInput() {

        List<String> lines = new ArrayList<>();

        String fileName = "./src/main/resources/2015/day5/part1/input.txt";

        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            lines = stream.collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return lines;
    }

}
