package pages;

import com.codeborne.selenide.Selenide;
import enums.Tabs;

import static com.codeborne.selenide.Selenide.$;

public class MainPage extends BasePage<MainPage> {

  public MainPage open() {
    Selenide.open();

    return this;
  }

  public void clickOnTab (Tabs tab) {
    String selectorTemplate = "[content-desc='%s']";
    $(String.format(selectorTemplate, tab.getName())).click();
  }

}
