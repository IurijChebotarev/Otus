import annotations.Driver;
import enums.CursesTitles;
import enums.PagesTitles;
import extensions.UIExtension;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import pages.MainPage;

import java.text.ParseException;

@ExtendWith(UIExtension.class)
public class OtusTests {

  @Driver
  public WebDriver driver;

  @Test
  public void showCourseWithQATest() {
    MainPage mainPage = new MainPage(driver);
    mainPage.openSite();
    mainPage.showQACurses(CursesTitles.PopularCurses.getName(), "QA");
    mainPage.showQACurses(CursesTitles.SpecializationCurses.getName(), "QA");
  }

  @Test
  public void showCursesDatesTest() throws ParseException {
    MainPage mainPage = new MainPage(driver);
    mainPage.openSite();
    mainPage.showDates(CursesTitles.PopularCurses.getName());
  }

  @Test
  public void moveAndClickWithActionsTest() {
    MainPage mainPage = new MainPage(driver);
    mainPage.openSite();
    mainPage.openDSPage(PagesTitles.DS.getUrlSuffix());
    Assertions.assertEquals(driver.getTitle(), PagesTitles.DS.getName());

  }

  @Test
  public void showHighlightingOnClickTest() {
    MainPage mainPage = new MainPage(driver);
    mainPage.openSite();
    mainPage.clickOnLogo();
  }
}




