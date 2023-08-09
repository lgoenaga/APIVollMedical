package med.voll.api.service.implent;

import lombok.RequiredArgsConstructor;
import med.voll.api.dto.DtoListarPacientes;
import med.voll.api.dto.DtoRegistroPaciente;
import med.voll.api.interfaces.PacienteRepository;
import med.voll.api.model.Paciente;
import med.voll.api.service.interfaces.PacienteInterfaces;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PacienteService implements PacienteInterfaces {

    private final PacienteRepository pacienteRepository;

    public void registrarPaciente(DtoRegistroPaciente dtoRegistroPaciente) {
        pacienteRepository.save(new Paciente(dtoRegistroPaciente));
    }

    public Page<DtoListarPacientes> listarPacientes(Pageable paginacion) {
        return pacienteRepository.findAll(paginacion).map(DtoListarPacientes::new);
    }

    public void actualizarPaciente() {
        // TODO implement here
    }

    public void eliminarPaciente() {
        // TODO implement here
    }

    public void buscarPaciente() {
        // TODO implement here
    }
}
