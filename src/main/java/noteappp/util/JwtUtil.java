package noteappp.util;

import io.jsonwebtoken.Claims;
import noteappp.dto.UserDTO;
import noteappp.entity.AuthenticationRequest;
import noteappp.entity.UserRegister;

import java.util.Date;
import java.util.Map;

public interface JwtUtil {
    String generateToken(UserRegister userDTO);

    String doGenerateToken(Map<String, Object> claims, String username);

    boolean validateToken(String token);

    boolean isTokenExpired(String token);

    Date getExpirationDateFromToken(String token);

    String getUserIdFromToken(String token);

    String getUsernameFromToken(String token);

    Claims getAllClaimsFromToken(String token);

    void init();
}
