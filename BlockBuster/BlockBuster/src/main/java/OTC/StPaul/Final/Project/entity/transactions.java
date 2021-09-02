package OTC.StPaul.Final.Project.entity;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class transactions {
  private int transaction_id;
  private customers customer;
  private stores store;
  private List<movies> movies_rented;
  private List<concessions> concessions_purchased;
  private Double total;
  
  @JsonIgnore
  public int getTransaction_id() {
    return transaction_id;
  }

} // last bracket
