package med.voll.api.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import med.voll.api.model.Usuario;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.auth0.jwt.exceptions.JWTVerificationException;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    @Value("${api.security.jwt.secret}")
    private String secret;

    public String generarToken(Usuario usuario){

        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.create()
                    .withIssuer("voll med")
                    .withSubject(usuario.getLogin())
                    .withClaim("id", usuario.getId())
                    .withExpiresAt(getExpirationTime())
                    .sign(algorithm);
        } catch (JWTCreationException exception){
            throw new RuntimeException("Error al generar el token");
        }
    }

    public String getSubject(String token){
        if (token==null)
            throw new RuntimeException("Error al verificar el token");

        DecodedJWT decodedJWT;
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            JWTVerifier verifier = JWT.require(algorithm)
                    .withIssuer("voll med")
                    .build();

            decodedJWT = verifier.verify(token);
        } catch (JWTVerificationException exception){
            throw new RuntimeException("Error al verificar el token");
        }

        if (decodedJWT.getSubject()==null)
            throw new RuntimeException("Error al verificar el token");

        return decodedJWT.getSubject();
    }
    private Instant getExpirationTime(){
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-05:00"));
    }
}
