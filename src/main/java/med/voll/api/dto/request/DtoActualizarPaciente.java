package med.voll.api.dto.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DtoActualizarPaciente(

        String nombre,
        @Pattern(regexp = "^[0-9]{10,13}$")
        String telefono,
        @Valid
        DtoDireccion direccion,
       String codigoPostal,
       String provincia
) {
}
