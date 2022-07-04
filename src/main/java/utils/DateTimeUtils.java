package utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeUtils {

  public static final DateTimeFormatter D_MMM = DateTimeFormatter.ofPattern("D MMMM");

  public static LocalDateTime stringToFormat_D_MMM(String dateTime) {
    return stringToDateTime(dateTime, D_MMM);
  }

  private static LocalDateTime stringToDateTime(String text, DateTimeFormatter formatter) {
    return LocalDateTime.parse(text, formatter);
  }
}
