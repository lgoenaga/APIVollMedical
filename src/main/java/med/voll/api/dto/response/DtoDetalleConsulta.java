package med.voll.api.dto.response;


import java.time.LocalDateTime;

public record DtoDetalleConsulta(

        String paciente,
        String medico,
        LocalDateTime fecha
    )
{
}
