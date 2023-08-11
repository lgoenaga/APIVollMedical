package med.voll.api.dto.response;

import med.voll.api.model.Medico;

public record DtoListarMedicos(

        Long id,
        String nombre,
        String especialidad,
        String documento,
        String email

    )
{
    public DtoListarMedicos(Medico medico) {
        this(
                medico.getId(),
                medico.getNombre(),
                medico.getEspecialidad().toString(),
                medico.getDocumento(),
                medico.getEmail()
        );
    }
}
