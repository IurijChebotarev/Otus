package otuss.steps.pages;

import com.google.inject.Inject;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Тогда;
import otuss.pages.CursesForPreparing;

public class CursesForPreparingSteps {

  @Inject
  public CursesForPreparing cursesForPreparing;

  @Тогда("Показываем название и цену самого дорогого курса")
  public void showNameAndMaxPrice() {
    cursesForPreparing.showMax();
  }

  @И("Показываем название и цену самого дешевого курса")
  public void showNameAndMinPrice() {
    cursesForPreparing.showMin();
  }
}
