package enums;

public enum Users {
  USER1("Bret\n" +
      "Leanne Graham\n" +
      "Sincere@april.biz\n" +
      "hildegard.org", "User Leanne Graham");

  private String info;
  private String title;

  Users(String info, String title) {

    this.info = info;
    this.title = title;
  }

  public String getInfo() {
    return info;
  }

  public String getTitle() {
    return title;
  }
}
