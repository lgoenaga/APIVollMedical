package med.voll.api.dto;

import med.voll.api.model.Medico;

public record DtoListarMedicos(

        String nombre,
        String especialidad,
        String documento,
        String email

    )
{
    public DtoListarMedicos(Medico medico) {
        this(
                medico.getNombre(),
                medico.getEspecialidad().toString(),
                medico.getDocumento(),
                medico.getEmail()
        );
    }
}
