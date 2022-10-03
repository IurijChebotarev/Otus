package pages;

import com.codeborne.selenide.Condition;
import enums.Users;

import static com.codeborne.selenide.Selenide.$;

public class UserPage extends BasePage<UserPage> {

  public void checkUserTitle(Users user) {
    $(String.format(selectorTemplate, user.getTitle())).shouldBe(Condition.visible);
  }
}
