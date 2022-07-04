package pages;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MainPage {

  private WebDriver driver;
  private final String site = StringUtils.stripEnd(System.getProperty("webdriver.base.url"), "/");

  @FindBy(xpath = "//*[contains(@class, 'container-lessons')]//*[contains(text(), 'Популярные курсы')]/following-sibling::div[@class='lessons'][1]/a")
  private List<WebElement> pupularCursesList;
  @FindBy(xpath = "//*[contains(@class, 'container-lessons')]//*[contains(text(), 'Специализации')]/following-sibling::div[@class='lessons']/a")
  private List<WebElement> specializationCursesList;
  @FindBy(css = "img[alt='JavaScript QA Engineer foreground']")
  private WebElement javaScriptQAEngineerCourse;

  public WebElement getJavaScriptQAEngineerCourse() {
    javaScriptQAEngineerCourse.findElement(By.xpath(".//div[contains(@class, 'lessons__new-item-start')]"));
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

  public JavaScriptQAEngineerPage openPage(WebElement element) {
    Actions actions = new Actions(driver);
    actions
        .moveToElement(element)
        .click()
        .build().perform();
    return new JavaScriptQAEngineerPage(driver);
  }

}