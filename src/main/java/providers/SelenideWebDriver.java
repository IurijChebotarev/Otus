package providers;

import com.codeborne.selenide.WebDriverProvider;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AutomationName;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;

import javax.annotation.Nonnull;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class SelenideWebDriver implements WebDriverProvider {

  @Nonnull
  @Override
  public WebDriver createDriver(@Nonnull Capabilities capabilities) {
    File app = downloadApk();

    UiAutomator2Options options = new UiAutomator2Options();
    options.merge(capabilities);
    options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);
    options.setPlatformName("Android");
    options.setDeviceName("emulator-5554");
    options.setPlatformVersion("13");
    options.setApp(app.getAbsolutePath());

    try {
      return new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), options);
    } catch (MalformedURLException e) {
      throw new RuntimeException(e);
    }
  }

  private File downloadApk() {
    File apk = new File("build/app-java-pro-v2.apk");
    if (!apk.exists()) {
      throw new AssertionError("Failed to download apk");
    }
    return apk;
  }
}
