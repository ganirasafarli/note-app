package noteappp.entity;

import lombok.experimental.Accessors;
import noteappp.enumeration.UserStatusActivity;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Accessors(chain = true)
@Document(collection = "users")
public class User implements Serializable {
    @Id
    private String id;
    private String name;
    private String surname;
    private String password;
    private String email;
    private UserStatusActivity status;
    @Field("created_time")
    private LocalDateTime createdAt;
    @Field("updated_time")
    private LocalDateTime updateAt;
}
