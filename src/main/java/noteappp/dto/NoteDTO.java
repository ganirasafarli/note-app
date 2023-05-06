package noteappp.dto;

import lombok.Data;
import lombok.experimental.Accessors;
import noteappp.entity.UserLike;

@Data
@Accessors(chain = true)
public class NoteDTO {
    private String id;
    private String content;
    private UserLike like;
}
