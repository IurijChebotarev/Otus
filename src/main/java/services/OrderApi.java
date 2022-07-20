package services;

import dto.PostOrderRq;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;


public class OrderApi {
  public static final String BASE_URL = "https://petstore.swagger.io/v2";
  public static final String ORDER = "/store/order";
  private RequestSpecification rspec;

  public OrderApi() {
    rspec = io.restassured.RestAssured.given()
        .baseUri(BASE_URL)
        .contentType(ContentType.JSON);
  }

  public ValidatableResponse createOrder(PostOrderRq order) {
    return io.restassured.RestAssured.given(rspec)
        .basePath(ORDER)
        .body(order)
        .log().all()
        .when()
        .post()
        .then()
        .log().all();
  }
}

