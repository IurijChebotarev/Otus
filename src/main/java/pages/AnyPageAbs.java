package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public abstract class AnyPageAbs<T> {

  protected final WebDriver driver;


  public AnyPageAbs(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);
  }

  public T openPage(WebElement element) {
    Actions actions = new Actions(driver);
    actions
        .moveToElement(element)
        .click()
        .build().perform();
    return (T) (driver);
  }

}

