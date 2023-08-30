package med.voll.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import med.voll.api.dto.request.DtoAgendarConsulta;
import med.voll.api.model.Consulta;
import med.voll.api.service.ConsultaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("consultas")
@RequiredArgsConstructor
public class ConsultaController {

    private final ConsultaService consultaService;

    @PostMapping
    @Transactional
    public ResponseEntity consultaAgendar(@RequestBody @Valid DtoAgendarConsulta dtoAgendarConsulta){

        return new ResponseEntity(consultaService.agendarConsulta(dtoAgendarConsulta), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity consultarConsultas(){

        return new ResponseEntity(consultaService.listarConsultas(), HttpStatus.OK);
    }

}
