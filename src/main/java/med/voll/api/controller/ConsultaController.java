package med.voll.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import med.voll.api.dto.request.DtoAgendarConsulta;
import med.voll.api.dto.response.DtoDetalleConsulta;
import med.voll.api.service.ConsultaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("consultas")
@RequiredArgsConstructor
public class ConsultaController {

    private final ConsultaService consultaService;

    @PostMapping
    @Transactional
    public ResponseEntity consultaAgendar(@RequestBody @Valid DtoAgendarConsulta dtoAgendarConsulta) throws Exception{
        consultaService.agendarConsulta(dtoAgendarConsulta);
        return ResponseEntity.created(null).body(new DtoDetalleConsulta(dtoAgendarConsulta));
    }
}
