package med.voll.api.service.implent;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import med.voll.api.dto.DtoActualizarMedico;
import med.voll.api.dto.DtoListarMedicos;
import med.voll.api.dto.DtoRegistroMedico;
import med.voll.api.interfaces.MedicoRepository;
import med.voll.api.model.Medico;
import med.voll.api.service.interfaces.MedicoInterfaces;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MedicoService implements MedicoInterfaces {

    private final MedicoRepository medicoRepository;

    public void registrarMedico(DtoRegistroMedico dtoRegistroMedico) {

        medicoRepository.save(new Medico(dtoRegistroMedico));
    }

    public void eliminarMedico(Long id) {

        medicoRepository.deleteById(id);
    }

    public DtoListarMedicos buscarMedico(Long id) {

        return new DtoListarMedicos(medicoRepository.findById(id).orElse(null));
    }

    public Page<DtoListarMedicos> listarMedicos(Pageable paginacion) {

        return medicoRepository.findAll(paginacion).map(DtoListarMedicos::new);
    }

    public void actualizarMedico(@NotNull Long id, DtoActualizarMedico dtoActualizarMedico) {

            Medico medico = medicoRepository.getReferenceById(id);
            if (medico != null) {
                if (dtoActualizarMedico.nombre() != null)
                medico.setNombre(dtoActualizarMedico.nombre());
                if (dtoActualizarMedico.telefono() != null)
                medico.setTelefono(dtoActualizarMedico.telefono());
                if (dtoActualizarMedico.direccion() != null)
                medico.setDireccion(dtoActualizarMedico.direccion());

            }
    }

    public void eliminarMedicoLogico(Long id) {

            Medico medico = medicoRepository.getReferenceById(id);
            if (medico != null) {
                medico.setActivo(false);
            }
    }

    public Page<DtoListarMedicos> buscarMedicoPorActivo(Pageable paginacion) {

            return medicoRepository.findByActivoTrue(paginacion).map(DtoListarMedicos::new);
    }
}
