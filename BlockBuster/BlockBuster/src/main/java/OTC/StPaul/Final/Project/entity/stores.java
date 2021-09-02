package OTC.StPaul.Final.Project.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class stores {
  private int store_idPK;
  private String address;
  private String phone;
  
}
