package otuss.steps.components;

import com.google.inject.Inject;
import io.cucumber.java.ru.И;
import otuss.components.HeaderMenuComponent;

public class HeaderMenuSteps {

  @Inject
  public HeaderMenuComponent headerMenuComponent;

  @И("Открываем дропдаун меню {string}")
  public void openDropDownMenu(String dropDownMenu) {
    headerMenuComponent.moveToMenuItem(dropDownMenu);
  }

  @И("Выбираем значение {string}")
  public void selectItemFromDropDownMenu(String dropDownMenuItem) {
    headerMenuComponent.clickCourseItem(dropDownMenuItem);
  }
}
