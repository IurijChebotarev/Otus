import pages.MainPage;
import annotations.Driver;
import extensions.UIExtension;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


@ExtendWith(UIExtension.class)
public class Test {

  @Driver
  public WebDriver driver;
  MainPage mainPage = new MainPage(driver);
  private By courseTitle = By.xpath(".//div[contains(@class, 'lessons__new-item-title')]");
  private By courseStartDate = By.xpath(".//div[contains(@class, 'lessons__new-item-start')]");

  @org.junit.jupiter.api.Test
  void showCourseWithQA() {
    MainPage mainPage = new MainPage(driver);
    mainPage.openSite();
    List<String> pupularCursesResult = mainPage.getPupularCursesList().stream()
        .map(element -> element.findElement((By) mainPage.getCursesTitle()).getText())
        .filter(element -> element.contains("QA"))
        .collect(Collectors.toList());
    System.out.println("У нас есть такие курсы для QA :" + pupularCursesResult);

    List<String> specializationCursesResult = mainPage.getSpecializationCursesList().stream()
        .map(element -> element.findElement((By) mainPage.getCursesTitle()).getText())
        .filter(element -> element.contains("QA"))
        .collect(Collectors.toList());
    System.out.println("У нас есть такие курсы для QA :" + specializationCursesResult);
  }
  @org.junit.jupiter.api.Test
  void showCursesDates() {
    MainPage mainPage = new MainPage(driver);
    mainPage.openSite();
    Date date = null;
    String dateString;
    List<Date> dates = new ArrayList<>();
    DateFormat formatter = new SimpleDateFormat("d MMMM");

    for (WebElement element : mainPage.getPupularCursesList()) {
      dateString = element.findElement((By) mainPage.getCursesStartDate()).getText();
      try {
        date = formatter.parse(dateString.substring(2));
      } catch (ParseException e) {
        e.printStackTrace();
      }
      dates.add(date);
    }
    System.out.println(dates);
    showFarestDate(dates, formatter);
    showEarliestDate(dates, formatter);
  }

  void showFarestDate(List<Date> dates, DateFormat format) {
    Date farestDate = dates.stream()
        .reduce(dates.get(0), (a, b) -> {
          return a.getTime() > b.getTime() ? a : b;
        });

    System.out.println("Самый поздний курс будет: " + format.format(farestDate));
  }

  void showEarliestDate(List<Date> dates, DateFormat format) {
    Date earliestDate = dates.stream()
        .reduce(dates.get(0), (a, b) -> {
          return a.getTime() < b.getTime() ? a : b;
        });

    System.out.println("Самый ранний курс будет: " + format.format(earliestDate));
  }

  @org.junit.jupiter.api.Test
  void moveAndClickWithActions() {
    MainPage mainPage = new MainPage(driver);
    mainPage.openSite();
    Actions actions = new Actions(driver);
    actions
        .moveToElement(mainPage.getJavaScriptQAEngineerCourse(), 10, 50)
        .click()
        .build().perform();


  }
}




