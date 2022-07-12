package otuss.steps.pages;

import com.google.inject.Inject;
import io.cucumber.java.ru.Тогда;
import otuss.pages.LessonPage;

public class LessonPageSteps {

  @Inject
  public LessonPage lessonPage;

  @Тогда("Страница урока {string} открыта")
  public void lessonPageShouldBeOpened(String lessonName) {
    lessonPage.pageTitleShouldBeSameAs(lessonName);
  }
}
