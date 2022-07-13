package otuss.pages;

import com.google.inject.Inject;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import otuss.support.GuiceScoped;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

public class MainPage extends AnyPageAbs<MainPage> {

  private final String site = StringUtils.stripEnd(System.getProperty("webdriver.base.url"), "/");
  private String curses = "//*[contains(@class, 'container-lessons')]//*[contains(text(), '%s')]/following-sibling::div[@class='lessons']/a";
  @FindBy(xpath = "//div[@class='lessons']/a[@href='/lessons/qajs/']")
  private WebElement javaScriptQAEngineerCourse;
  @FindBy(xpath = "//div[@class='header2__logo']")
  private WebElement logo;

  @Inject
  public MainPage(GuiceScoped guiceScoped) {
    super(guiceScoped);
  }

  public WebElement getLogo() {
    return logo;
  }

  public WebElement getJavaScriptQAEngineerCourse() {
    return javaScriptQAEngineerCourse;
  }

  public void openSite() {
    guiceScoped.driver.get(site);
    guiceScoped.driver.manage().window().maximize();
  }

  public JavaScriptQAEngineerPage openPage(WebElement element) {
    Actions actions = new Actions(guiceScoped.driver);
    actions
        .moveToElement(element)
        .click()
        .build().perform();
    return new JavaScriptQAEngineerPage(guiceScoped);
  }


  public void showQACurses(String title) {
    List<WebElement> cursesList = guiceScoped.driver.findElements(By.xpath(String.format(curses, title)));
    By courseTitle = By.xpath(".//div[contains(@class, 'lessons__new-item-title')]");
    List<String> cursesResult = cursesList.stream()
        .map(element -> element.findElement(courseTitle).getText())
        .filter(element -> element.contains("QA"))
        .collect(Collectors.toList());
    System.out.println("У нас есть такие курсы для QA :" + cursesResult);
  }

  public void selectCurse(String curseBlockTitle, String title) {
    WebElement cursesList = guiceScoped.driver.findElement(By.xpath(String.format(curses, curseBlockTitle)));
    cursesList.findElement(By.xpath(String.format("//div[contains(text(), '%s')]", title))).click();
  }


  public void showDates(String title) {
    List<WebElement> cursesList = guiceScoped.driver.findElements(By.xpath(String.format(curses, title)));
    By courseStartDate = By.xpath(".//div[contains(@class, 'lessons__new-item-start')]");
    Date date = null;
    String dateString;
    List<Date> dates = new ArrayList<>();
    DateFormat formatter = new SimpleDateFormat("d MMMM");

    for (WebElement element : cursesList) {
      dateString = element.findElement(courseStartDate).getText();
      try {
        date = formatter.parse(dateString.substring(2));
      } catch (ParseException e) {
        e.printStackTrace();
      }
      dates.add(date);
    }
    showFarestDate(dates, formatter);
    showEarliestDate(dates, formatter);
  }

  void showFarestDate(List<Date> dates, DateFormat format) {
    Date farestDate = dates.stream()
        .reduce(dates.get(0), (a, b) -> a.getTime() > b.getTime() ? a : b);

    System.out.println("Самый поздний курс будет: " + format.format(farestDate));
  }

  void showEarliestDate(List<Date> dates, DateFormat format) {
    Date earliestDate = dates.stream()
        .reduce(dates.get(0), (a, b) -> a.getTime() < b.getTime() ? a : b);

    System.out.println("Самый ранний курс будет: " + format.format(earliestDate));
  }

  public void showDatesAndTitles(String title, Date myDate, DateFormat formatter) {
    List<WebElement> cursesList = guiceScoped.driver.findElements(By.xpath(String.format(curses, title)));
    By courseStartDate = By.xpath(".//div[contains(@class, 'lessons__new-item-start')]");
    By courseTitle = By.xpath(".//div[contains(@class, 'lessons__new-item-title')]");
    Date date = null;
    String dateString;
    String titleString;
    Map<String, Date> titlesAndDates = new HashMap<>();

    for (WebElement element : cursesList) {
      dateString = element.findElement(courseStartDate).getText();
      titleString = element.findElement(courseTitle).getText();
      try {
        date = formatter.parse(dateString.substring(2));
      } catch (ParseException e) {
        e.printStackTrace();
      }
      titlesAndDates.put(titleString, date);
    }
    showTitleAndDate(titlesAndDates, myDate, formatter);
  }

  void showTitleAndDate(Map<String, Date> titlesAndDates, Date myDate, DateFormat formatter) {
    titlesAndDates.forEach((curseTitle, curseDate) -> {
          if (curseDate.getTime() == myDate.getTime() || curseDate.getTime() > myDate.getTime()) {
            System.out.println(curseTitle + " : " + formatter.format(curseDate));
          }
        }
    );
  }
}