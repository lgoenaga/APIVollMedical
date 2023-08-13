package med.voll.api.service;

import lombok.RequiredArgsConstructor;
import med.voll.api.dto.request.DtoActualizarPaciente;
import med.voll.api.dto.request.DtoRegistroPaciente;
import med.voll.api.dto.response.DtoListarPacientes;
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

    public DtoListarPacientes buscarPaciente(Long id) {
        return pacienteRepository.findById(id).map(DtoListarPacientes::new).orElseThrow();
    }

public void actualizarPaciente(Long id, DtoActualizarPaciente dtoActualizarPaciente) {
        Paciente paciente = pacienteRepository.findById(id).orElseThrow();
        if (dtoActualizarPaciente.nombre() != null) {
            paciente.setNombre(dtoActualizarPaciente.nombre());
        }
        if (dtoActualizarPaciente.telefono() != null) {
            paciente.setTelefono(dtoActualizarPaciente.telefono());
        }
        if (dtoActualizarPaciente.direccion() != null) {
            paciente.setDireccion(dtoActualizarPaciente.direccion());
        }
        if (dtoActualizarPaciente.codigoPostal() != null) {
            paciente.setCodigoPostal(dtoActualizarPaciente.codigoPostal());
        }
        if (dtoActualizarPaciente.provincia() != null) {
            paciente.setProvincia(dtoActualizarPaciente.provincia());
        }
    }

    public void eliminarPaciente(Long id) {
        pacienteRepository.deleteById(id);
    }
}
