import enums.Posts;
import enums.Tabs;
import enums.Users;
import extensions.AppiumExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import pages.*;

@ExtendWith(AppiumExtension.class)
public class AppiumTests {

  private MainPage mainPage = new MainPage();
  private PostsPage postsPage = new PostsPage();
  private PostPage postPage = new PostPage();
  private UsersPage usersPage = new UsersPage();
  private UserPage userPage = new UserPage();

  @Test
  public void checkPosts() {
    mainPage.open()
        .clickOnTab(Tabs.POSTS);
    postsPage.checkPostsPageIsOpened();
  }

  @Test
  public void checkPostsId() {
    mainPage.open()
        .clickOnTab(Tabs.POSTS);
    postsPage.openPost(Posts.POSTID1);
    postPage.checkPostTitle(Posts.POSTID1);
  }

  @Test
  public void checkUsersId() {
    mainPage.open()
        .clickOnTab(Tabs.USERS);
    usersPage.openUser(Users.USER1);
    userPage.checkUserTitle(Users.USER1);
  }

}