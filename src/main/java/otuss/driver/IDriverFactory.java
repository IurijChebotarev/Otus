package otuss.driver;

import otuss.exceptions.DriverTypeNotSupported;
import org.openqa.selenium.WebDriver;

public interface IDriverFactory {
  WebDriver getDriver() throws DriverTypeNotSupported;
}
