package enums;

public enum PagesTitles {
  JavaScriptQAEngineer("Автоматизация тестирования на JavaScript. Курс по написанию автотестов на JS");

  private String pagesTitles;

  public final String pagesTitles() {
    return pagesTitles;
  }

  PagesTitles(String pagesTitles) {
    this.pagesTitles = pagesTitles;
  }
}
