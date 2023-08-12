package med.voll.api.service;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import med.voll.api.dto.request.DtoActualizarMedico;
import med.voll.api.dto.response.DtoListarMedicos;
import med.voll.api.dto.request.DtoRegistroMedico;
import med.voll.api.dto.response.DtoResponseMedico;
import med.voll.api.interfaces.MedicoRepository;
import med.voll.api.model.Medico;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class MedicoService {

    private final MedicoRepository medicoRepository;

    public ResponseEntity<DtoResponseMedico> registrarMedico(DtoRegistroMedico dtoRegistroMedico) {

        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.newInstance();
        Medico medico = medicoRepository.save(new Medico(dtoRegistroMedico));

        DtoResponseMedico dtoResponseMedico = new DtoResponseMedico(
                medico.getId(),
                medico.getNombre(),
                medico.getEmail(),
                medico.getDocumento(),
                medico.getTelefono(),
                medico.getDireccion()
        );

        @NotNull
        URI uri = uriComponentsBuilder.path("/medicos/{id}").buildAndExpand(medico.getId()).toUri();

        return ResponseEntity.created(uri).body(dtoResponseMedico);




    }

    public void eliminarMedico(Long id) {

        medicoRepository.deleteById(id);
    }

    public DtoListarMedicos buscarMedico(@NotNull Long id) {

        return new DtoListarMedicos(Objects.requireNonNull(medicoRepository.findById(id).orElse(null)));
    }

    public Page<DtoListarMedicos> listarMedicos(Pageable paginacion) {

        return medicoRepository.findAll(paginacion).map(DtoListarMedicos::new);
    }

    public void actualizarMedico(@NotNull Long id, DtoActualizarMedico dtoActualizarMedico) {

        Medico medico = medicoRepository.getReferenceById(id);

        if (dtoActualizarMedico.nombre() != null)
            medico.setNombre(dtoActualizarMedico.nombre());
        if (dtoActualizarMedico.telefono() != null)
            medico.setTelefono(dtoActualizarMedico.telefono());
        if (dtoActualizarMedico.direccion() != null)
            medico.setDireccion(dtoActualizarMedico.direccion());


    }

    public void eliminarMedicoLogico(@NotNull Long id) {

            Medico medico = medicoRepository.getReferenceById(id);
                medico.setActivo(false);
    }

    public Page<DtoListarMedicos> buscarMedicoPorActivo(Pageable paginacion) {

            return medicoRepository.findByActivoTrue(paginacion).map(DtoListarMedicos::new);
    }
}
