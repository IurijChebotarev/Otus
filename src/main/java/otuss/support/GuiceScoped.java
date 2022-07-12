package otuss.support;

import com.google.inject.AbstractModule;
import io.cucumber.guice.ScenarioScoped;
import org.openqa.selenium.WebDriver;
import otuss.enums.BrowserData;

@ScenarioScoped
public class GuiceScoped extends AbstractModule {

  public BrowserData browserName;
  public WebDriver driver;
}
