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
public class GetOrderRs{
  private Integer code;
  private String type;
  private String message;
}
