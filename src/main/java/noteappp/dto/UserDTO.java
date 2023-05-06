package noteappp.dto;

import lombok.Data;
import lombok.experimental.Accessors;
import noteappp.enumeration.UserStatusActivity;

@Data
@Accessors(chain = true)
public class UserDTO {
    private String id;
    private String name;
    private String surname;
    private String email;
    private UserStatusActivity status;
}
