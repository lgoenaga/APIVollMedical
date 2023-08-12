package med.voll.api.service;

import lombok.RequiredArgsConstructor;
import med.voll.api.dto.response.DtoListarPacientes;
import med.voll.api.dto.request.DtoRegistroPaciente;
import med.voll.api.interfaces.PacienteRepository;
import med.voll.api.model.Paciente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PacienteService {

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
