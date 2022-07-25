package order;

import dto.GetOrderRs;
import dto.PostOrderRs;
import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GetOrderTest extends OrderBaseTest {
  //проверяем, что если заказ существует то приходит успешный ответ с корректными данными
  @Test
  public void getOrder() {

    ValidatableResponse response = orderApi.getOrder("/2");

    PostOrderRs orderRs = response.extract().body().as(PostOrderRs.class);
    Assertions.assertAll(() -> {
      Assertions.assertEquals(orderRs.getId(), 2);
      Assertions.assertEquals(orderRs.getStatus(), "placed");
      Assertions.assertEquals(orderRs.isComplete(), true);
    });
  }

  //проверяем, что если заказ не существует то приходит ошибка с корректными данными
  @Test
  public void getOrderWithError() {

    ValidatableResponse response = orderApi.getOrderWithError("/1");

    GetOrderRs orderRs = response.extract().body().as(GetOrderRs.class);
    Assertions.assertAll(() -> {
      Assertions.assertEquals(orderRs.getCode(), 1);
      Assertions.assertEquals(orderRs.getType(), "error");
      Assertions.assertEquals(orderRs.getMessage(), "Order not found");
    });
  }
}
