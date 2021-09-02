package OTC.StPaul.Final.Project.entity;

import java.util.List;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import org.hibernate.validator.constraints.Length;
import lombok.Data;

@Data
public class transactionRequest {
 
  @Positive
  @Min(1)
  @Max(6)
  private int customer_idFK;
  
  @Positive
  @Min(1)
  @Max(6)
  private int store_idFK;
  
  private List<@NotNull @Length(max = 30) 
  @Pattern(regexp = "[\\w\\s]*") String> movies;
  
  private List<@NotNull @Length(max = 30) 
  @Pattern(regexp = "[\\w\\s]*") String> concessions;
  
} // last bracket
