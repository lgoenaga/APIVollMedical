package med.voll.api.dto.request;

import jakarta.validation.constraints.NotBlank;

public record DtoDireccion(

        @NotBlank(message = "La calle no puede estar vacía")
        String calle,
        @NotBlank(message = "El distrito no puede estar vacío")
        String distrito,
        @NotBlank(message = "La ciudad no puede estar vacía")
        String ciudad,
        String numero,
        String complemento
)
{
}
