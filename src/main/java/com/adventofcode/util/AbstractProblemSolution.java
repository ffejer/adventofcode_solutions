package com.adventofcode.util;

import java.io.File;
import java.io.FileInputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public abstract class AbstractProblemSolution {

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

    protected static Stream<String> readStreamFromFile(String pathname) {
        try(Stream<String> stream = Files.lines(Paths.get(pathname))) {
            return stream;
        } catch(Exception e) {
            System.out.println("Something went wrong. " + e.getMessage());
        }
        return null;
    }


}
