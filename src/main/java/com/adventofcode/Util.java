package com.adventofcode;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
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

    String text = "";

    try (
        FileInputStream fis = new FileInputStream(new File(pathname))
    ) {
      File file = new File(pathname);
      byte[] data = new byte[(int) file.length()];
      System.out.println(fis.read(data));
      text = new String(data, "UTF-8");
    } catch (Exception e) {
      logger.error("Error while reading file {}", pathname, e);
    }

    return text;
  }
}
