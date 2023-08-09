package med.voll.api.dto;

import jakarta.validation.constraints.NotBlank;

public record DtoDireccion(

        @NotBlank
        String calle,
        @NotBlank
        String distrito,
        @NotBlank
        String ciudad,
        String numero,
        String complemento
)
{
}
