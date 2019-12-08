package com.adventofcode.year2019.day2.part2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class IntComputer {

    public static void main(String[] args) {
        List<String> input = Collections.emptyList();

        try (Stream<String> stream = Files.lines(Paths.get("./src/main/resources/2019/day/2/input"))) {
            input = stream.collect(Collectors.toList());
        } catch (
                IOException e) {
            e.printStackTrace();
        }
        List<Integer> initialList = convertInput(input);

        outer: for(int i = 0; i < 100; i++) {
            for(int j = 0; j < 100; j++) {
                List<Integer> intList = new ArrayList<>(initialList);
                adjustComputer(intList, i, j);
                Integer integer = doCalc(intList);
                if(integer == 19690720) {
                    System.out.println(String.format("result %d %d", i, j));
                    break outer;
                }
            }
        }
    }

    static Integer doCalc(List<Integer> input) {
        int size = input.size();

        for(int position = 0; position < size; position += 4) {
            int opcode = input.get(position);
            if(position == size - 1) {
                break;
            }
            int index1 = input.get(position + 1);
            int index2 = input.get(position + 2);
            int destination = input.get(position + 3);
            if(opcode == 1) {
                input.set(destination, input.get(index1) + input.get(index2));
            } else if (opcode == 2) {
                input.set(destination, input.get(index1) * input.get(index2));
            } else if (opcode == 99) {
                break;
            } else{
                throw new IllegalStateException();
            }
        }

        return input.get(0);
    }

    private static void adjustComputer(List<Integer> intList, int i, int j) {
        intList.set(1, i);
        intList.set(2, j);
    }

    private static List<Integer> convertInput(List<String> input) {
        List<Integer> result = new ArrayList<>();
        for (String string : input) {
            List<String> strings = Arrays.asList(string.split("\\s*,\\s*"));
            result.addAll(strings.stream().map(Integer::valueOf).collect(Collectors.toList()));
        }
        return result;
    }

}
