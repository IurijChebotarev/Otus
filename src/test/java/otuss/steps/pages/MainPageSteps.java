package otuss.steps.pages;

import com.google.inject.Inject;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import otuss.pages.MainPage;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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

  @Тогда("Показываем курс из блока {string} который стартует раньше или в день {string}")
  public void showDatesAndTitles(String curseBlock, String myDate) {
    DateFormat formatter = new SimpleDateFormat("d MMMM");
    Date date = null;
    try {
      date = formatter.parse(myDate);
    } catch (ParseException e) {
      e.printStackTrace();
    }
    mainPage.showDatesAndTitles(curseBlock, date, formatter);
  }
}
