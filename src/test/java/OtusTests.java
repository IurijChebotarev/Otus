import annotations.Driver;
import enums.CursesTitles;
import enums.PagesTitles;
import extensions.UIExtension;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import pages.MainPage;

@ExtendWith(UIExtension.class)
public class OtusTests {

  @Driver
  public WebDriver driver;

  @Test
  public void showCourseWithQATest() {
    MainPage mainPage = new MainPage(driver);
    mainPage.openSite();
    mainPage.showQACurses(CursesTitles.PopularCurses.getName());
    mainPage.showQACurses(CursesTitles.SpecializationCurses.getName());
  }

  @Test
  public void showCursesDatesTest() {
    MainPage mainPage = new MainPage(driver);
    mainPage.openSite();
    mainPage.showDates(CursesTitles.PopularCurses.getName());
  }

  @Test
  public void moveAndClickWithActionsTest() {
    MainPage mainPage = new MainPage(driver);
    mainPage.openSite();
    mainPage.openPage(mainPage.getJavaScriptQAEngineerCourse());
    Assertions.assertEquals(driver.getTitle(), PagesTitles.JavaScriptQAEngineer.getName());

  }

  @Test
  public void showHighlightingOnClickTest() {
    MainPage mainPage = new MainPage(driver);
    mainPage.openSite();
    mainPage.getLogo().click();
  }
}




