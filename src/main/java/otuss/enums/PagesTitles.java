package otuss.enums;

public enum PagesTitles {
  JavaScriptQAEngineer("Автоматизация тестирования на JavaScript. Курс по написанию автотестов на JS");

  private String name;

  PagesTitles(String name) {
    this.name = name;

  }

  public String getName() {
    return name;
  }
}
