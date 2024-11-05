package com.adventofcode;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class Util {

  private static final Logger logger = LoggerFactory.getLogger(Util.class);

  private Util() {
  }

  public static List<String> getInputLines(String filePath) {
    try (Stream<String> stream = Files.lines(Paths.get(filePath))) {
      return stream.toList();
    } catch (
        IOException e) {
      logger.error("Error while reading file {}", filePath, e);
    }
    return List.of();
  }

  public static String readFile(String pathname) {
    return String.join("\n", getInputLines(pathname));
  }
}
