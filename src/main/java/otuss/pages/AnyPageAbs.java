package otuss.pages;

import org.openqa.selenium.support.PageFactory;
import otuss.annotations.PagePath;
import otuss.annotations.Url;
import otuss.annotations.UrlTemplate;
import otuss.exceptions.DataUrlNotValid;
import otuss.exceptions.UrlTemplateNotValid;
import otuss.support.GuiceScoped;

public abstract class AnyPageAbs<T> {

  public AnyPageAbs(GuiceScoped guiceScoped) {
    this.guiceScoped = guiceScoped;
    PageFactory.initElements(guiceScoped.driver, this);
  }

  protected GuiceScoped guiceScoped;

  private String getPath() {
    Class<?> clazz = this.getClass();
    if(clazz.isAnnotationPresent(PagePath.class)) {
      PagePath pagePath = clazz.getAnnotation(PagePath.class);
      return pagePath.value().replaceAll("/+$", "");
    }

    return "";
  }

  private String getPageUrlTemplate(String name) throws UrlTemplateNotValid {
    Class<?> clazz = this.getClass();
    if(clazz.isAnnotationPresent(Url.class)) {
      Url urlTemplates = clazz.getAnnotation(Url.class);
      UrlTemplate[] templates = urlTemplates.value();
      for(UrlTemplate urlTemplate: templates) {
        if(urlTemplate.name().equals(name)) {
          return urlTemplate.template();
        }
      }
      throw new UrlTemplateNotValid();
    }
    return "";
  }

  public T open(String name, String... values) throws Exception {
    if(values.length == 0) {
      throw new DataUrlNotValid();
    }
    String template = this.getPageUrlTemplate(name);
    String pathFromTemplate = "";
    for(int i =0; i < values.length; i++) {
      pathFromTemplate = template.replace(String.format("{%s}", i + 1), values[i]);
    }

    String hostname = System.getProperty("base.url");
    hostname = hostname.replaceAll("/+$", "");

    if(!this.getPath().isEmpty()) {
      guiceScoped.driver.get(hostname + this.getPath() + "/" + pathFromTemplate);
    } else {
      guiceScoped.driver.get(hostname + "/" + pathFromTemplate);
    }

    return (T)this;
  }

}

