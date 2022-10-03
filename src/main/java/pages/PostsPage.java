package pages;

import com.codeborne.selenide.Condition;
import enums.Posts;

import static com.codeborne.selenide.Selenide.$;

public class PostsPage extends BasePage<PostsPage>{

  public void checkPostsPageIsOpened() {
    $(String.format(selectorTemplate, Posts.POSTID1.getText())).shouldBe(Condition.visible);
  }

  public void openPost(Posts post) {
    $(String.format(selectorTemplate, post.getText())).click();
  }

}
