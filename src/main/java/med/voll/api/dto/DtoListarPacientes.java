package med.voll.api.dto;

import med.voll.api.model.Paciente;

public record DtoListarPacientes(
        String nombre,
        String email,
        String telefono,
        String documentoIdentidad

    )
{
    public DtoListarPacientes(Paciente paciente) {
        this(
                paciente.getNombre(),
                paciente.getEmail(),
                paciente.getTelefono(),
                paciente.getDocumentoIdentidad()
        );
    }
}
