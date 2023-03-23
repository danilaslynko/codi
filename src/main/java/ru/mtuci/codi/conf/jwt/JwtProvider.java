package ru.mtuci.codi.conf.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ru.mtuci.codi.exception.CodiValidationException;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

@Component
@Log
public class JwtProvider {

    @Value("$(jwt.secret)")
    private String jwtSecret;

    public String generateToken(String login) {
        Date date = Date.from(LocalDate.now().plusDays(15).atStartOfDay(ZoneId.systemDefault()).toInstant());
        return Jwts.builder()
                .setSubject(login)
                .setExpiration(date)
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .compact();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token);
            return true;
        } catch (ExpiredJwtException expEx) {
            log.severe("Token expired");
            throw new CodiValidationException(expEx.getMessage());
        } catch (UnsupportedJwtException unsEx) {
            log.severe("Unsupported jwt");
            throw new CodiValidationException(unsEx.getMessage());
        } catch (MalformedJwtException mjEx) {
            log.severe("Malformed jwt");
            throw new CodiValidationException(mjEx.getMessage());
        } catch (SignatureException sEx) {
            log.severe("Invalid signature");
            throw new CodiValidationException(sEx.getMessage());
        } catch (Exception e) {
            log.severe("invalid token");
            throw new CodiValidationException(e.getMessage());
        }
    }

    public String getLoginFromToken(String token) {
        Claims claims = Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody();
        return claims.getSubject();
    }
}
