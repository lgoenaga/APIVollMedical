package med.voll.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import med.voll.api.dto.request.DtoActualizarPaciente;
import med.voll.api.dto.response.DtoListarPacientes;
import med.voll.api.dto.request.DtoRegistroPaciente;
import med.voll.api.service.PacienteService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("pacientes")
@RequiredArgsConstructor
public class PacienteController {

    private final PacienteService pacienteService;

    @PostMapping
    public ResponseEntity<DtoRegistroPaciente> registrar(@RequestBody @Valid DtoRegistroPaciente dtoRegistroPaciente) {
        pacienteService.registrarPaciente(dtoRegistroPaciente);

        URI uri = URI.create("/pacientes");

        return ResponseEntity.created(uri).body(dtoRegistroPaciente);
    }

    @GetMapping
    public ResponseEntity<Page<DtoListarPacientes>> listar(@PageableDefault(size = 5, sort = "nombre",direction = Sort.Direction.DESC) Pageable paginacion) {
        return ResponseEntity.ok(pacienteService.listarPacientes(paginacion));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DtoListarPacientes> buscar(@PathVariable Long id) {
        return ResponseEntity.ok(pacienteService.buscarPaciente(id));
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<DtoActualizarPaciente> actualizar(@PathVariable Long id, @RequestBody @Valid DtoActualizarPaciente dtoActualizarPaciente) {
        pacienteService.actualizarPaciente(id, dtoActualizarPaciente);
        return ResponseEntity.ok(dtoActualizarPaciente);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        pacienteService.eliminarPaciente(id);
        return ResponseEntity.noContent().build();
    }

}