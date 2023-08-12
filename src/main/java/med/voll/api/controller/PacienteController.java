package med.voll.api.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import med.voll.api.dto.response.DtoListarPacientes;
import med.voll.api.dto.request.DtoRegistroPaciente;
import med.voll.api.service.PacienteService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("pacientes")
@RequiredArgsConstructor
public class PacienteController {

    private final PacienteService pacienteService;

    @PostMapping
    public void registrar(@RequestBody @Valid DtoRegistroPaciente dtoRegistroPaciente) {
        pacienteService.registrarPaciente(dtoRegistroPaciente);
    }

    @GetMapping
    public Page<DtoListarPacientes> listar(@PageableDefault(size = 5, sort = "nombre",direction = Sort.Direction.DESC) Pageable paginacion) {

        return pacienteService.listarPacientes(paginacion);
    }
}