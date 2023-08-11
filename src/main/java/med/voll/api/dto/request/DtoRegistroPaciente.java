package med.voll.api.dto.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DtoRegistroPaciente(

        @NotBlank(message = "Nombre es obligatorio")
        String nombre,
        @NotBlank(message = "Email es obligatorio")
        @Email(message = "Formato de email es inválido")
        String email,
        @NotBlank(message = "Telefono es obligatorio")
        @Pattern(regexp = "^[0-9]{10,13}$")
        String telefono,
        @NotBlank(message = "Documento es obligatorio")
        @Pattern(regexp = "^[0-9]{6,12}$")
        String documentoIdentidad,
        @NotNull(message = "Direccion es obligatorio")
        @Valid
        DtoDireccion direccion,

       String codigoPostal,
       String provincia
) {
}
