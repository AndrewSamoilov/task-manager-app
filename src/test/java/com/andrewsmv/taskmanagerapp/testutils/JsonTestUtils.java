package com.andrewsmv.taskmanagerapp.testutils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import lombok.experimental.UtilityClass;

@UtilityClass
public class JsonTestUtils {

  public static String getJsonString(String fileName) {
    ClassLoader classLoader = JsonTestUtils.class.getClassLoader();
    try (InputStream inputStream = classLoader.getResourceAsStream("data/" + fileName)) {
      if (inputStream == null) {
        throw new IllegalArgumentException("File not found: " + fileName);
      }
      return new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);
    } catch (IOException e) {
      e.printStackTrace();
    }
    return "";
  }
}