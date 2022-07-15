package otuss.pages;

import com.google.inject.Inject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import otuss.support.GuiceScoped;

import java.util.List;
import java.util.stream.Collectors;

public class CursesForPreparing extends AnyPageAbs<CursesForPreparing> {

  private String curses = "//*[@class='lessons']/a";
  private List<WebElement> cursesList = guiceScoped.driver.findElements(By.xpath(curses));
  private By courseTitle = By.xpath(".//div[contains(@class, 'lessons__new-item-title')]");
  private By coursePrice = By.xpath(".//div[@class='lessons__new-item-price']");

  @Inject
  public CursesForPreparing(GuiceScoped guiceScoped) {
    super(guiceScoped);
  }


  public void showMax() {
    List<String> cursesMaxPrise = cursesList.stream()
        .map(price -> price.findElement(coursePrice).getText().replace(" ₽", ""))
        .map(Integer::parseInt)
        .sorted((s1, s2) -> s2 - s1)
        .limit(1)
        .map(String::valueOf)
        .collect(Collectors.toList());

    List<WebElement> cursesWithMaxPrise = cursesList.stream()
        .filter(curse -> curse.findElement(coursePrice).getText().equals(cursesMaxPrise.get(0).concat(" ₽")))
        .collect(Collectors.toList());

    String name = cursesWithMaxPrise.get(0).findElement(courseTitle).getText();
    String price = cursesWithMaxPrise.get(0).findElement(coursePrice).getText();

    System.out.println("Самый дорогой курс это: " + name + " его цена: " + price);
  }

  public void showMin() {
    List<String> cursesMinPrise = cursesList.stream()
        .map(price -> price.findElement(coursePrice).getText().replace(" ₽", ""))
        .map(Integer::parseInt)
        .sorted()
        .limit(1)
        .map(String::valueOf)
        .collect(Collectors.toList());

    List<WebElement> cursesWithMinPrise = cursesList.stream()
        .filter(curse -> curse.findElement(coursePrice).getText().equals(cursesMinPrise.get(0).concat(" ₽")))
        .collect(Collectors.toList());

    String name = cursesWithMinPrise.get(0).findElement(courseTitle).getText();
    String price = cursesWithMinPrise.get(0).findElement(coursePrice).getText();

    System.out.println("Самый дешевый курс это: " + name + " его цена: " + price);
  }

}
