package enums;

public enum Posts {
  POSTID1("sunt aut facere repellat provident occaecati excepturi optio reprehenderit\n" +
      "quia et suscipit\n" +
      "suscipit recusandae consequuntur expedita et cum\n" +
      "reprehenderit molestiae ut ut quas totam\n" +
      "nostrum rerum est autem sunt rem eveniet architecto\n" +
      "post id: 1\n" +
      "user id: 1", "sunt aut facere repellat provident occaecati excepturi optio reprehenderit");

  private String text;
  private String title;

  Posts(String text, String title) {

    this.text = text;
    this.title = title;
  }

  public String getText() {
    return text;
  }
  public String getTitle() {
    return title;
  }
}
