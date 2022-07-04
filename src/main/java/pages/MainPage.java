package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MainPage {

  private WebDriver driver;
  private final String site = "https://otus.ru";

  @FindBy(xpath = "//*[contains(@class, 'container-lessons')]//*[contains(text(), 'Популярные курсы')]/following-sibling::div[@class='lessons'][1]/a")
  private List<WebElement> pupularCursesList;
  @FindBy(xpath = "//*[contains(@class, 'container-lessons')]//*[contains(text(), 'Специализации')]/following-sibling::div[@class='lessons']/a")
  private List<WebElement> specializationCursesList;
  @FindBy(css = "img[alt='JavaScript QA Engineer foreground']")
  private WebElement javaScriptQAEngineerCourse;
  @FindBy(xpath = ".//div[contains(@class, 'lessons__new-item-title')]")
  private WebElement cursesTitle;
  @FindBy(xpath = ".//div[contains(@class, 'lessons__new-item-start')]")
  private WebElement cursesStartDate;

  public WebElement getCursesTitle() {
    return cursesTitle;
  }

  public WebElement getCursesStartDate() {
    return cursesStartDate;
  }

  public WebElement getJavaScriptQAEngineerCourse() {
    return javaScriptQAEngineerCourse;
  }

  public List<WebElement> getPupularCursesList() {
    return pupularCursesList;
  }

  public List<WebElement> getSpecializationCursesList() {
    return specializationCursesList;
  }

  public MainPage(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);
  }

  public void openSite() {
    driver.get(site);
    driver.manage().window().maximize();
  }
}