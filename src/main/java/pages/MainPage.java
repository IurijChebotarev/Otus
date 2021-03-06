package pages;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class MainPage {

  private final String site = StringUtils.stripEnd(System.getProperty("webdriver.base.url"), "/");
  private WebDriver driver;
  private String curses = "//*[contains(@class, 'container-lessons')]//*[contains(text(), '%s')]/following-sibling::div[@class='lessons']/a";
  @FindBy(xpath = "//div[@class='lessons']/a[@href='/lessons/qajs/']")
  private WebElement javaScriptQAEngineerCourse;
  @FindBy(xpath = "//div[@class='header2__logo']")
  private WebElement logo;

  public MainPage(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);
  }

  public WebElement getLogo() {
    return logo;
  }

  public WebElement getJavaScriptQAEngineerCourse() {
    return javaScriptQAEngineerCourse;
  }

  public void openSite() {
    driver.get(site);
    driver.manage().window().maximize();
  }

  public JavaScriptQAEngineerPage openPage(WebElement element) {
    Actions actions = new Actions(driver);
    actions
        .moveToElement(element)
        .click()
        .build().perform();
    return new JavaScriptQAEngineerPage(driver);
  }

  public void showQACurses(String title) {
    List<WebElement> cursesList = driver.findElements(By.xpath(String.format(curses, title)));
    By courseTitle = By.xpath(".//div[contains(@class, 'lessons__new-item-title')]");
    List<String> cursesResult = cursesList.stream()
        .map(element -> element.findElement(courseTitle).getText())
        .filter(element -> element.contains("QA"))
        .collect(Collectors.toList());
    System.out.println("?? ?????? ???????? ?????????? ?????????? ?????? QA :" + cursesResult);
  }

  public void showDates(String title) {
    List<WebElement> cursesList = driver.findElements(By.xpath(String.format(curses, title)));
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

    System.out.println("?????????? ?????????????? ???????? ??????????: " + format.format(farestDate));
  }

  void showEarliestDate(List<Date> dates, DateFormat format) {
    Date earliestDate = dates.stream()
        .reduce(dates.get(0), (a, b) -> a.getTime() < b.getTime() ? a : b);

    System.out.println("?????????? ???????????? ???????? ??????????: " + format.format(earliestDate));
  }


}