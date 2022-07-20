package dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class PostOrderRq {
  private int petId;
  private int quantity;
  private Long id;
  private String shipDate;
  private boolean complete;
  private String status;

}