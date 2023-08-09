package med.voll.api.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DtoRegistroPaciente(

        @NotBlank
        String nombre,
        @NotBlank
        @Email
        String email,
        @NotBlank
        @Pattern(regexp = "^[0-9]{10,13}$")
        String telefono,
        @NotBlank
        @Pattern(regexp = "^[0-9]{6,12}$")
        String documentoIdentidad,
        @NotNull
        @Valid
        DtoDireccion direccion,

       String codigoPostal,
       String provincia
) {
}
