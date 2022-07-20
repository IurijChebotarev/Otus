package dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@Data
@Builder
@AllArgsConstructor
@JsonSerialize
@NoArgsConstructor
public class PostOrderRs {
  private int petId;
  private int quantity;
  private Long id;
  private String shipDate;
  private boolean complete;
  private String status;

}
