package github.io.ecommerce.infraestructure.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.List;

@Service
public class JWTService {

    private Key key;

    public void init() {
        this.key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
    }

    public String generateToken(String username, List<String> roles, String clientId) {
        Date now = new Date();
        Date expirationDate = new Date(now.getTime() + 3600000);

        return Jwts.builder()
                .setSubject(username)
                .setIssuer("ecommerce-api")
                .setAudience(clientId)
                .setIssuedAt(now)
                .setExpiration(expirationDate)
                .claim("roles", roles)
                .signWith(key)
                .compact();
    }
}
