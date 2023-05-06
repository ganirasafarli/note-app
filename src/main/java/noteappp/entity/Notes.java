package noteappp.entity;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Accessors(chain = true)
@Document(collection = "note")
public class Notes implements Serializable {
    @Id
    private String id;
    private String content;
    private UserLike like;
    @Field("created_time")
    private LocalDateTime createdAt;
    @Field("updated_time")
    private LocalDateTime updateAt;
}
