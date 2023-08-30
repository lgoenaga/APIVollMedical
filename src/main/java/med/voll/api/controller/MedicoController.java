package med.voll.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import med.voll.api.dto.request.DtoActualizarMedico;
import med.voll.api.dto.request.DtoRegistroMedico;
import med.voll.api.dto.response.DtoListarMedicos;
import med.voll.api.dto.response.DtoResponseMedico;
import med.voll.api.service.MedicoService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Objects;

@RestController
@RequestMapping("/medicos")
@RequiredArgsConstructor
public class MedicoController {

    private final MedicoService medicoService;

    @PostMapping
    public ResponseEntity<DtoRegistroMedico> registrarMedico(@RequestBody @Valid DtoRegistroMedico dtoRegistroMedico) {
       ResponseEntity<DtoResponseMedico> dtoResponseMedico = medicoService.registrarMedico(dtoRegistroMedico);

       URI uri = dtoResponseMedico.getHeaders().getLocation();

       return ResponseEntity.created(Objects.requireNonNull(uri)).body(dtoRegistroMedico);
    }

    @GetMapping
    public ResponseEntity <Page<DtoListarMedicos>> listarMedicos(@PageableDefault(sort = "nombre") Pageable paginacion) {
        return ResponseEntity.ok(medicoService.listarMedicos(paginacion));
    }

    @GetMapping("/{id}")
    public DtoListarMedicos buscarMedico(@PathVariable Long id) {
        return medicoService.buscarMedico(id);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<Object> actualizarMedico(@PathVariable Long id, @RequestBody @Valid DtoActualizarMedico dtoActualizarMedico) {
        medicoService.actualizarMedico(id, dtoActualizarMedico);

        return new ResponseEntity<> (dtoActualizarMedico, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void eliminarMedico(@PathVariable Long id) {
        medicoService.eliminarMedico(id);
    }

    @PutMapping("/{id}/eliminar")
    @Transactional
    public ResponseEntity<Object> eliminarMedicoLogico(@PathVariable Long id) {

        medicoService.eliminarMedicoLogico(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/buscar")
    public Page<DtoListarMedicos> buscarMedicoPorActivo(@PageableDefault(size = 5, sort = "nombre") Pageable paginacion) {
        return medicoService.buscarMedicoPorActivo(paginacion);
    }

}
