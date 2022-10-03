package pages;

import com.codeborne.selenide.Condition;
import enums.Users;

import static com.codeborne.selenide.Selenide.$;

public class UsersPage extends BasePage<UsersPage>{

  public void checkUsersPageIsOpened() {
    $(String.format(selectorTemplate, Users.USER1.getInfo())).shouldBe(Condition.visible);
  }

  public void openUser(Users user) {
    $(String.format(selectorTemplate, user.getInfo())).click();
  }

}
