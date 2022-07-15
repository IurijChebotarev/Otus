package otuss.components;

import com.google.inject.Inject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import otuss.annotations.Component;
import otuss.enums.MenuItemData;
import otuss.pages.CursesForPreparing;
import otuss.support.GuiceScoped;

@Component("//*[contains(@class, 'header2-menu_main')]")
public class HeaderMenuComponent extends AnyComponentAbs<HeaderMenuComponent> {

  private String menuItemLocator = "//*[contains(@class, 'header2-menu__item_dropdown')][.//*[contains(@class, 'header2-menu__item')][text()='%s']]";
  private String menuItemDropdownListLocator = menuItemLocator + "//*[@class='header2-menu__dropdown']";

  @Inject
  public HeaderMenuComponent(GuiceScoped guiceScoped) {
    super(guiceScoped);
  }

  public HeaderMenuComponent moveToMenuItem(String dropDownMenu) {
    WebElement menuItemElement = guiceScoped.driver.findElement(By.xpath(String.format(menuItemLocator, dropDownMenu)));
    actions.moveToElement(menuItemElement).build().perform();

    return this;
  }

  public CursesForPreparing clickCourseItem(String dropDownMenuItem) {
    String baseCourseTypeLocator = menuItemDropdownListLocator + "[.//a[@title='%s']]";
    WebElement baseCourseElement = guiceScoped.driver.findElement(By.xpath(String.format(baseCourseTypeLocator, MenuItemData.Courses.getName(), dropDownMenuItem)));
    actions.moveToElement(baseCourseElement).build().perform();
    baseCourseElement.findElement(By.xpath(String.format(".//a[@title='%s']", dropDownMenuItem))).click();

    return new CursesForPreparing(guiceScoped);
  }
}

