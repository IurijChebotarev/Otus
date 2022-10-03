package pages;

import com.codeborne.selenide.Condition;
import enums.Posts;

import static com.codeborne.selenide.Selenide.$;

public class PostPage extends BasePage<PostPage> {

  public void checkPostTitle(Posts post) {
    $(String.format(selectorTemplate, post.getTitle())).shouldBe(Condition.visible);
  }
}
