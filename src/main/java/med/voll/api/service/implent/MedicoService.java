package med.voll.api.service.implent;

import lombok.RequiredArgsConstructor;
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

    public void actualizarMedico() {
        // TODO implement here
    }

    public void eliminarMedico() {
        // TODO implement here
    }

    public void buscarMedico() {
        // TODO implement here
    }

    public Page<DtoListarMedicos> listarMedicos(Pageable paginacion) {

        return medicoRepository.findAll(paginacion).map(DtoListarMedicos::new);
    }

}
