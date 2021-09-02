package OTC.StPaul.Final.Project.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class customers {
  private int customer_idPK;
  private String first_name;
  private String last_name;
  private String address;
  private String phone;

}
