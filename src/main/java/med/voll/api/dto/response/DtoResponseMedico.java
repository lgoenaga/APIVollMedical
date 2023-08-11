package med.voll.api.dto.response;

import med.voll.api.model.Direccion;

public record DtoResponseMedico(

        Long id,
        String nombre,
        String email,
        String documento,
        String telefono,
        Direccion direccion
    )
{
}
