package med.voll.api.dto.request;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import med.voll.api.model.Consulta;
import med.voll.api.model.Especialidad;

import java.time.LocalDateTime;

public record DtoAgendarConsulta(

        Long id,
        @NotNull(message = "Paciente es obligatorio")
        Long idPaciente,
        Long idMedico,
        @NotNull(message = "Fecha es obligatorio")
        @Future(message = "La fecha debe ser futura")
        LocalDateTime fecha,
        Especialidad especialidad
) {

}
