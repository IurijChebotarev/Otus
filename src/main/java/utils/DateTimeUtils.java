package utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeUtils {

  public static final DateTimeFormatter DD_MMM = DateTimeFormatter.ofPattern("DD MMM");

  public static LocalDateTime dateToFormat_DD_MMM(String dateTime) {
    return stringToDateTime(dateTime, DD_MMM);
  }

  private static LocalDateTime stringToDateTime(String text, DateTimeFormatter formatter) {
    return LocalDateTime.parse(text, formatter);
  }
}
