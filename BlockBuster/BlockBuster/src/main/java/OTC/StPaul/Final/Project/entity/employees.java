package OTC.StPaul.Final.Project.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class employees {
    private Long employee_idPK;
    private String first_name;
    private String last_name;
    private String address;
    private String phone;
    private Long store_idFK;
}
