package noteappp.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import noteappp.dto.UserDTO;
import noteappp.entity.AuthenticationRequest;
import noteappp.entity.AuthenticationResponse;
import noteappp.entity.UserRegister;
import noteappp.repository.UserAuthRepo;
import noteappp.util.impl.JwtUtilsImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/user")
public class UserAuthController {
    private final UserAuthRepo userRepo;
    private final JwtUtilsImpl jwtUtils;

    @PostMapping("/subs")
    public ResponseEntity<?> subscribe(@RequestBody AuthenticationRequest request) {
        String userName = request.getUserName();
        String password = request.getPassword();
        UserRegister userRegister = new UserRegister();
        userRegister.setUsername(userName);
        userRegister.setPassword(password);
        try {
            userRepo.save(userRegister);
        } catch (Exception ex) {
            return ResponseEntity.ok(new AuthenticationResponse("Error during client subscription." + userName));
        }
        return ResponseEntity.ok(new AuthenticationResponse("Subscribed successfully.  " + userName));
    }

    @PostMapping("/auth")
    public ResponseEntity<String> authenticate(@RequestBody AuthenticationRequest request) {
        String userName = request.getUserName();
        String password = request.getPassword();
        UserRegister user = userRepo.findByUsernameAndPassword(userName, password);
        if (user != null) {
            String token = jwtUtils.generateToken(user);
            if (jwtUtils.validateToken(token)) {
                return ResponseEntity.ok(token);
            }
        }
        return null;
    }
}
