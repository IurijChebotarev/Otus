package otuss.components;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import otuss.support.GuiceScoped;

public class AnyComponentAbs<T> {
  protected GuiceScoped guiceScoped;
  protected Actions actions;

  public AnyComponentAbs(GuiceScoped guiceScoped) {
    this.guiceScoped = guiceScoped;
    PageFactory.initElements(guiceScoped.driver, this);
    actions = new Actions(guiceScoped.driver);
  }

}
