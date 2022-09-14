package enums;

public enum PagesTitles {
  DS("Профессия DS", "prof-ds");

  private String name;
  private String urlSuffix;

  PagesTitles(String name, String urlSuffix) {
    this.name = name;
    this.urlSuffix = urlSuffix;

  }

  public String getName() {
    return name;
  }
  public String getUrlSuffix() {
    return urlSuffix;
  }
}
