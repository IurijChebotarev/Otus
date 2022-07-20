package order.postorder;

import dto.PostOrderRq;
import dto.PostOrderRs;
import io.restassured.response.ValidatableResponse;
import order.OrderBaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PostOrderTest extends OrderBaseTest {

  @Test
  public void checkCompleteOrder() {
    PostOrderRq order = PostOrderRq.builder()
        .id(1L)
        .petId(0)
        .quantity(0)
        .shipDate("2022-07-20T17:45:54.919Z")
        .status("placed")
        .complete(true)
        .build();

    ValidatableResponse response = orderApi.createOrder(order)
        .statusCode(200);

    PostOrderRs orderRs = response.extract().body().as(PostOrderRs.class);
    Assertions.assertAll(() -> {
      Assertions.assertEquals(orderRs.getId(),order.getId());
      Assertions.assertNotEquals(orderRs.getShipDate(), order.getShipDate());
    });
  }

  @Test
  public void checkIncompleteOrder() {
    PostOrderRq order = PostOrderRq.builder()
        .build();

    ValidatableResponse response = orderApi.createOrder(order)
        .statusCode(200);

    PostOrderRs orderRs = response.extract().body().as(PostOrderRs.class);
    Assertions.assertAll(() -> {
      Assertions.assertNotEquals(orderRs.getId(),order.getId());
    });
  }
}