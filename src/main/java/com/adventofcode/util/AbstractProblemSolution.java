package com.adventofcode.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public abstract class AbstractProblemSolution {

    protected static List<String> getInputLines(String filePath) {
        List<String> input = Collections.emptyList();

        try (Stream<String> stream = Files.lines(Paths.get(filePath))) {
            input = stream.collect(Collectors.toList());
        } catch (
                IOException e) {
            e.printStackTrace();
        }
        return input;
    }

    protected static String readFile(String pathname) {

        String text = "";

        try (
                FileInputStream fis = new FileInputStream(new File(pathname))
        ) {
            File file = new File(pathname);
            byte[] data = new byte[(int) file.length()];
            System.out.println(fis.read(data));
            text = new String(data, "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return text;
    }

    protected static List<String> readStreamFromFile(String pathname) {
        try (Stream<String> stream = Files.lines(Paths.get(pathname))) {
            return stream.collect(Collectors.toList());
        } catch (Exception e) {
            System.out.println("Something went wrong. " + e.getMessage());
        }
        return null;
    }

}
