package med.voll.api.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.model.Especialidad;

public record DtoRegistroMedico(
        @NotBlank
        String nombre,
        @NotBlank
        @Email
        String email,
        @NotBlank
        @Pattern(regexp = "^[0-9]{6,12}$")
        String documento,
        @NotBlank
        @Pattern(regexp = "^[0-9]{10,13}$")
        String telefono,
        @NotNull
        Especialidad especialidad,
        @NotNull
        @Valid
        DtoDireccion direccion
    )
{
}
