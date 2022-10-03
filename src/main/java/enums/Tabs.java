package enums;

public enum Tabs {
  POSTS("Посты\n" + "Tab 2 of 2"),
  USERS("Пользователи\n" + "Tab 1 of 2");

  private String name;

  Tabs(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }
}
