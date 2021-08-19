package OTC.StPaul.Final.Project.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class user_validation {
    private Long validation_id;
    private Long emp_idFK;
    private String emp_username;
    private String emp_validator;
    private Boolean ENABLED;

}
