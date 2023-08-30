package med.voll.api.validations;

import jakarta.validation.ValidationException;
import lombok.RequiredArgsConstructor;
import med.voll.api.dto.request.DtoAgendarConsulta;
import med.voll.api.interfaces.ConsultaRepository;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class HorarioAtencion {

    private final ConsultaRepository consultaRepository;

    public void validar(DtoAgendarConsulta dtoAgendarConsulta) {

        var domingo = DayOfWeek.SUNDAY.equals(dtoAgendarConsulta.fecha().getDayOfWeek());

        var hora = dtoAgendarConsulta.fecha().getHour();

        var pacienteconconsulta = consultaRepository.existsByPacienteIdAndFechaBetween(dtoAgendarConsulta.idPaciente(), dtoAgendarConsulta.fecha().withHour(7), dtoAgendarConsulta.fecha().withHour(18));

        var diferencia = Duration.between(LocalDateTime.now(), dtoAgendarConsulta.fecha()).toMinutes()<30;

        if (domingo) {
            throw new ValidationException("No se puede agendar consultas los domingos");
        }

        if (hora < 7 || hora > 19) {
            throw new ValidationException("No se puede agendar consultas fuera del horario de atención");
        }

        if (diferencia) {
            throw new ValidationException("No se puede agendar consultas con menos de 30 minutos de anticipación");
        }

        if (pacienteconconsulta) {
            throw new ValidationException("No se puede agendar, el paciente ya tiene una consulta agendada en este día");
        }
    }
}
