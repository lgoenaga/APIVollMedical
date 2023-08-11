package med.voll.api.dto.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;

public record DtoActualizarMedico(

        String nombre,
        @Pattern(regexp = "^[0-9]{10,13}$")
        String telefono,
        @Valid
        DtoDireccion direccion
    )
{
}
