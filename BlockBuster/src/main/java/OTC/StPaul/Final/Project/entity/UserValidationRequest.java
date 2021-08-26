package OTC.StPaul.Final.Project.entity;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Length;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserValidationRequest {
  
  @NotNull
  private Long emp_idFK;
  
  @NotNull
  @Length(max = 30)
  @Pattern(regexp = "[\\w\\s]*")
  private String emp_username;
  
  @NotNull
  @Length(max = 30)
  @Pattern(regexp = "[\\w\\s]*")
  private String emp_validator;
}
