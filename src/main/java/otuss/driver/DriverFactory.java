package otuss.driver;

import com.google.inject.Inject;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import otuss.driver.impl.ChromeWebDriver;
import otuss.driver.impl.FireFoxWebDriver;
import otuss.driver.impl.OperaWebDriver;
import otuss.exceptions.DriverTypeNotSupported;
import otuss.support.GuiceScoped;

public class DriverFactory implements IDriverFactory {

  public GuiceScoped guiceScoped;

  @Inject
  public DriverFactory(GuiceScoped guiceScoped) {
    this.guiceScoped = guiceScoped;
  }

  @Override
  public EventFiringWebDriver getDriver() {
    switch (guiceScoped.browserName) {
      case CHROME: {
        return new EventFiringWebDriver(new ChromeWebDriver().newDriver());
      }
      case OPERA: {
        return new EventFiringWebDriver(new OperaWebDriver().newDriver());
      }
      case FIREFOX: {
        return new EventFiringWebDriver(new FireFoxWebDriver().newDriver());
      }
      default:
        try {
          throw new DriverTypeNotSupported(guiceScoped.browserName.getName());
        } catch (DriverTypeNotSupported ex) {
          ex.printStackTrace();
          return null;
        }
    }
  }
}
