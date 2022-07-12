package otuss.pages;

import com.google.inject.Inject;
import org.assertj.core.api.Assertions;
import otuss.annotations.Url;
import otuss.annotations.UrlTemplate;
import otuss.support.GuiceScoped;

@Url(
    @UrlTemplate(name = "lessons", template = "/lessons/{1}")
)

public class LessonPage extends AnyPageAbs<LessonPage> {

  @Inject
  public LessonPage(GuiceScoped guiceScoped) {
    super(guiceScoped);
  }

  public LessonPage pageTitleShouldBeSameAs(String pageName) {
    Assertions.assertThat(guiceScoped.driver.getTitle())
        .as("Page title should be {}", pageName)
        .isEqualTo(pageName);

    return this;
  }


}
