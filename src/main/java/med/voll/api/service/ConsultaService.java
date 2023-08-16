package med.voll.api.service;

import lombok.RequiredArgsConstructor;
import med.voll.api.dto.request.DtoAgendarConsulta;
import med.voll.api.exceptions.ValidacionIntegridad;
import med.voll.api.interfaces.ConsultaRepository;
import med.voll.api.interfaces.MedicoRepository;
import med.voll.api.interfaces.PacienteRepository;
import med.voll.api.model.Consulta;
import med.voll.api.model.Medico;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ConsultaService {

    private final ConsultaRepository consultaRepository;
    private final MedicoRepository medicoRepository;
    private final PacienteRepository pacienteRepository;

    public void agendarConsulta(DtoAgendarConsulta dtoAgendarConsulta){

        var paciente = pacienteRepository.getReferenceById(dtoAgendarConsulta.idPaciente());

        if(paciente == null){
            throw new ValidacionIntegridad("Paciente no encontrado");
        }

        if (paciente.getActivo() == false){
            throw new ValidacionIntegridad("Paciente inactivo");
        }

        var medico = seleccionarMedico(dtoAgendarConsulta);


        var consulta = new Consulta(null,medico, paciente, dtoAgendarConsulta.fecha());

        consultaRepository.save(consulta);

    }

    private Medico seleccionarMedico(DtoAgendarConsulta dtoAgendarConsulta){

        if (dtoAgendarConsulta.idMedico()!=null){
            var medico = medicoRepository.getReferenceById(dtoAgendarConsulta.idMedico());
            if(medico == null){
                throw new ValidacionIntegridad("Medico no encontrado");
            }
            if (medico.getActivo() == false){
                throw new ValidacionIntegridad("Medico inactivo");
            }
            return medico;
        }

        var medicos = medicoRepository.findAll().stream().filter(m -> m.getActivo()).toList();

        var medico = medicos.stream().filter(m -> m.getEspecialidad().equals(dtoAgendarConsulta.especialidad())).findFirst().orElse(null);
        if(medico == null){
            throw new ValidacionIntegridad("No hay medicos disponibles para la especialidad seleccionada");
        }

        var asignado = consultaRepository.findAll().stream().filter(c -> c.getMedico().equals(medico)).toList().stream().filter(c -> c.getFecha().equals(dtoAgendarConsulta.fecha())).findFirst().orElse(null);

        if(asignado != null){
            throw new ValidacionIntegridad("Medico no disponible para la fecha seleccionada");
        }

        return medico;
    }

}
