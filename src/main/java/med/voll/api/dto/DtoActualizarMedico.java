package med.voll.api.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;
import med.voll.api.model.Especialidad;

public record DtoActualizarMedico(

        String nombre,
        @Pattern(regexp = "^[0-9]{10,13}$")
        String telefono,
        @Valid
        DtoDireccion direccion
    )
{
}
