package enums;

public enum CursesTitles {
  PopularCurses("Популярные курсы"),
  SpecializationCurses("Специализации");

  private String name;

  CursesTitles(String name) {
    this.name = name;

  }

  public String getName() {
    return name;
  }

}
