package otuss.steps.pages;

import com.google.inject.Inject;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Когда;
import otuss.pages.MainPage;

public class MainPageSteps {

  @Inject
  public MainPage mainPage;

  @Когда("Открываем главную страницу")
  public void openMainPage() {
    mainPage.openSite();
  }

  @И("Выбираем курс в блоке {string} с названием {string}")
  public void selectCurse(String curseBlock, String curseTitle) {
    mainPage.selectCurse(curseBlock, curseTitle);
  }
}
