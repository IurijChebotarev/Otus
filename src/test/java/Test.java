import annotations.Driver;
import extensions.UIExtension;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

@ExtendWith(UIExtension.class)
public class Test {

  @Driver
  public WebDriver driver;

  private By pupularCurses = By.xpath("//*[contains(@class, 'container-lessons')]//*[contains(text(), 'Популярные курсы')]/following-sibling::div[@class='lessons'][1]/a");
  private By specializationCurses = By.xpath("//*[contains(@class, 'container-lessons')]//*[contains(text(), 'Специализации')]/following-sibling::div[@class='lessons']/a");
  private By courseTitle = By.xpath(".//div[contains(@class, 'lessons__new-item-title')]");
  private By courseStartDate = By.xpath(".//div[contains(@class, 'lessons__new-item-start')]");

  @org.junit.jupiter.api.Test
  void showCourseWithQA() {
    driver.get("http://otus.ru");
    driver.manage().window().maximize();
    List<WebElement> pupularCursesList = driver.findElements(pupularCurses);
    List<WebElement> specializationCursesList = driver.findElements(specializationCurses);

//    List<String> pupularCursesResult = pupularCursesList.stream()
//        .map(element -> element.findElement(courseTitle).getText())
//        .filter(element -> element.contains("QA"))
//        .collect(Collectors.toList());
//    System.out.println("We have such courses with QA :" + pupularCursesResult);
//
//    List<String> specializationCursesResult = specializationCursesList.stream()
//        .map(element -> element.findElement(courseTitle).getText())
//        .filter(element -> element.contains("QA"))
//        .collect(Collectors.toList());
//    System.out.println("We have such courses with QA :" + specializationCursesResult);

    List<String> pupularCursesResult = pupularCursesList.stream()
        .reduce((a, b) -> {a.findElement(courseStartDate).getText().compareTo(b.findElement(courseStartDate).getText())
          return a;
        })
        .collect(Collectors.toList());
    System.out.println("We have such courses with QA :" + pupularCursesResult);


  }


}
