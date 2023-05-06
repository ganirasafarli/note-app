package noteappp.service;

import noteappp.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    User save(User user);

    User findById(String id);

    User updateById(String id, User user);

    void deleteById(String id);
}
