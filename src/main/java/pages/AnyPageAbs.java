package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class AnyPageAbs<T> {

  public final WebDriver driver;


  public AnyPageAbs(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);
  }

}

