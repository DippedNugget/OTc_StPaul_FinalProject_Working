package OTC.StPaul.Final.Project.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class concessions {
  private int concessions_id;
  private String full_name;
  private double price;
  private int quantity;
}
