package med.voll.api.controller;

import lombok.RequiredArgsConstructor;
import med.voll.api.model.Usuario;
import med.voll.api.service.TokenService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import med.voll.api.dto.request.DtoAutenticacionUsuario;

@RestController
@RequestMapping("/login")
@RequiredArgsConstructor
public class AutenticacionController {

    private final AuthenticationManager authenticationManager;

    private final TokenService tokenService;
    @PostMapping
    public ResponseEntity<Object> login(@RequestBody DtoAutenticacionUsuario dtoAutenticacionUsuario) {

        Authentication authToken = new UsernamePasswordAuthenticationToken(dtoAutenticacionUsuario.login(), dtoAutenticacionUsuario.password());

        var usuarioAutenticado = authenticationManager.authenticate(authToken);

        var jwtToken = tokenService.generarToken((Usuario) usuarioAutenticado.getPrincipal());

        return ResponseEntity.ok().body(jwtToken);
    }

}
