package otuss.enums;

public enum CurseBlocks {
  PopularCurses("Популярные курсы"),
  SpecializationCurses("Специализации");

  private String name;

  CurseBlocks(String name) {
    this.name = name;

  }

  public String getName() {
    return name;
  }

}
