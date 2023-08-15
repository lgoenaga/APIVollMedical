package med.voll.api.controller;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import med.voll.api.dto.request.DtoAgendarConsulta;
import med.voll.api.dto.response.DtoDetalleConsulta;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("consultas")
@RequiredArgsConstructor
public class ConsultaController {

    @PostMapping
    @Transactional
    public ResponseEntity consultaAgendar(@RequestBody DtoAgendarConsulta dtoAgendarConsulta) {
        DtoDetalleConsulta dtoDetalleConsulta = new DtoDetalleConsulta(dtoAgendarConsulta);
        return ResponseEntity.created(null).body(dtoDetalleConsulta.toString());
    }
}
