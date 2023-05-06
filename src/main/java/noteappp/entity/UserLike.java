package noteappp.entity;

import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class UserLike {
    private int likes;
    Set<User> users = new HashSet<>();
}
