package com.adventofcode.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractProblemSolution {

  private static final Logger logger = LoggerFactory.getLogger(AbstractProblemSolution.class);

  protected Stream<String> getInputLines(String filePath) {
    try (Stream<String> stream = Files.lines(Paths.get(filePath))) {
      return stream;
    } catch (
        IOException e) {
      logger.error("Error while reading file {}", filePath, e);
    }
    return Stream.empty();
  }

  protected String readFile(String pathname) {

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

  protected List<String> readStreamFromFile(String pathname) {
    try (Stream<String> stream = Files.lines(Paths.get(pathname))) {
      return stream.collect(Collectors.toList());
    } catch (Exception e) {
      System.out.println("Something went wrong. " + e.getMessage());
    }
    return null;
  }

}
