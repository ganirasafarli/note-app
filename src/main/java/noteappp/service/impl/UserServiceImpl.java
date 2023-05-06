package noteappp.service.impl;

import lombok.RequiredArgsConstructor;
import noteappp.entity.UserRegister;
import noteappp.entity.User;
import noteappp.exception.NotFoundException;
import noteappp.repository.UserAuthRepo;
import noteappp.repository.UserRepo;
import noteappp.service.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService, UserDetailsService {
    private final UserAuthRepo userAuthRepo;
    private final UserRepo userRepo;

    @Override
    public User save(User user) {
        return userRepo.save(user);
    }

    @Override
    public User findById(String id) {
        Optional<User> user = userRepo.findById(id);
        return user.orElseThrow(() -> new NotFoundException("User not found"));
    }

    @Transactional
    @Override
    public User updateById(String id, User userRequest) {
        User user = findById(id).setName(userRequest.getName()).setSurname(userRequest.getSurname()).setEmail(userRequest.getEmail()).setStatus(userRequest.getStatus());
        return userRepo.save(user);
    }

    @Override
    public void deleteById(String id) {
        User user = findById(id);
        userRepo.delete(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserRegister userRegister = userAuthRepo.findByUsername(username);
        if (userRegister == null) return null;
        String name = userRegister.getUsername();
        String password = userRegister.getPassword();
        return null;
    }
}