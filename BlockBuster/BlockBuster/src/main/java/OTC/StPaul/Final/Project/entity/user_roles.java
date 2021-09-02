package OTC.StPaul.Final.Project.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class user_roles {
    private Long role_id;
    private String emp_username;
    private String user_role;

} // last bracket
