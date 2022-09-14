package pages;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class MainPage extends AnyPageAbs<MainPage> {

  private final String site = StringUtils.stripEnd(System.getProperty("webdriver.base.url"), "/");
  private String curses = "//*[contains(@class, 'container-lessons')]//*[contains(text(), '%s')]/following-sibling::div[@class='lessons']/a";
  @FindBy(xpath = "//div[@class='header2__logo']")
  private WebElement logo;

  public MainPage(WebDriver driver) {
    super(driver);
  }

  public void clickOnLogo() {
    logo.click();

  }

  public WebElement getDSCourse(String courseName) {
    WebElement baseCourceElement = driver.findElement(By.xpath("//div[@class='lessons']"));
    return baseCourceElement.findElement(By.xpath(String.format("./a[@href='/lessons/%s/']", courseName)));
  }

  public void openSite() {
    driver.get(site);
    driver.manage().window().maximize();
  }

  public void openDSPage(String courseName) {
    openPage(getDSCourse(courseName));
  }

  public void showQACurses(String title, String filterMeaning) {
    List<WebElement> cursesList = driver.findElements(By.xpath(String.format(curses, title)));
    By courseTitle = By.xpath(".//div[contains(@class, 'lessons__new-item-title')]");
    List<String> cursesResult = cursesList.stream()
        .map(element -> element.findElement(courseTitle).getText())
        .filter(element -> element.contains(filterMeaning))
        .collect(Collectors.toList());
    System.out.println("У нас есть такие курсы для QA :" + cursesResult);
  }

  public void showDates(String title) throws ParseException {
    List<WebElement> cursesList = driver.findElements(By.xpath(String.format(curses, title)));
    By courseStartDate = By.xpath(".//div[contains(@class, 'lessons__new-item-start')]");
    Date date;
    String dateString;
    List<Date> dates = new ArrayList<>();
    DateFormat formatter = new SimpleDateFormat("d MMMM");
    //    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d MMMM");
    //    DateTimeFormatter formatter = new DateTimeFormatterBuilder().parseCaseInsensitive()
    //        .append(DateTimeFormatter.ofPattern("d MMMM")).toFormatter();
    //    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d MMMM")
    //        .withLocale(new Locale("ru"));
    for (WebElement element : cursesList) {
      dateString = element.findElement(courseStartDate).getText().trim();
      date = formatter.parse(dateString.substring(2));
      //      date = LocalDate.parse(dateString.substring(2), formatter);
      dates.add(date);
    }
    showFarestDate(dates, formatter);
    //    showEarliestDate(dates, formatter);
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


}