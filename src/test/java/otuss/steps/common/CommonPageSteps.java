package otuss.steps.common;

import com.google.inject.Inject;
import io.cucumber.java.ru.Пусть;
import otuss.driver.DriverFactory;
import otuss.enums.BrowserData;
import otuss.support.GuiceScoped;

import java.util.Locale;

public class CommonPageSteps {
  @Inject
  private DriverFactory driverFactory;
  @Inject
  private GuiceScoped guiceScoped;

  @Пусть("Я открываю браузер {string}")
  public void initBrowser(String browserName) {
    BrowserData browserData = BrowserData.valueOf(browserName.toUpperCase(Locale.ROOT));
    guiceScoped.browserName = browserData;
    guiceScoped.driver = driverFactory.getDriver();
  }
}
