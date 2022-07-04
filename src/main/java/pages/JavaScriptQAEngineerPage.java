package pages;

import org.openqa.selenium.WebDriver;

public class JavaScriptQAEngineerPage extends AnyPageAbs<JavaScriptQAEngineerPage> {

  public JavaScriptQAEngineerPage(WebDriver driver) {
    super(driver);
  }

  public String getPageTitle() {
    return driver.getTitle();
  }


}
