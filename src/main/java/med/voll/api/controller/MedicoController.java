package med.voll.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import med.voll.api.dto.DtoActualizarMedico;
import med.voll.api.dto.DtoListarMedicos;
import med.voll.api.dto.DtoRegistroMedico;
import med.voll.api.service.implent.MedicoService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/medicos")
@RequiredArgsConstructor
public class MedicoController {

    private final MedicoService medicoService;

    @PostMapping
    public void registrarMedico(@RequestBody @Valid DtoRegistroMedico dtoRegistroMedico) {
        medicoService.registrarMedico(dtoRegistroMedico);
    }

    @GetMapping
    public Page<DtoListarMedicos> listarMedicos(@PageableDefault(size = 5, sort = "nombre") Pageable paginacion) {
        return medicoService.listarMedicos(paginacion);
    }

    @GetMapping("/{id}")
    public DtoListarMedicos buscarMedico(@PathVariable Long id) {
        return medicoService.buscarMedico(id);
    }

    @PutMapping("/{id}")
    @Transactional
    public void actualizarMedico(@PathVariable Long id, @RequestBody @Valid DtoActualizarMedico dtoActualizarMedico) {
        medicoService.actualizarMedico(id, dtoActualizarMedico);
    }

    @DeleteMapping("/{id}")
    public void eliminarMedico(@PathVariable Long id) {
        medicoService.eliminarMedico(id);
    }

    @PutMapping("/{id}/eliminar")
    @Transactional
    public void eliminarMedicoLogico(@PathVariable Long id) {
        medicoService.eliminarMedicoLogico(id);
    }

    @GetMapping("/buscar")
    public Page<DtoListarMedicos> buscarMedicoPorActivo(@PageableDefault(size = 5, sort = "nombre") Pageable paginacion) {
        return medicoService.buscarMedicoPorActivo(paginacion);
    }
}
