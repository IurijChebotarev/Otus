package otuss.enums;

public enum MenuItemData {
  Courses("Курсы");

  private String name;

  MenuItemData(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }
}
