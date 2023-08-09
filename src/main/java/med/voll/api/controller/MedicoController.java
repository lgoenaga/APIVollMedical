package med.voll.api.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
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


}
