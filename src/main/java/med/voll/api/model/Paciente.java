package med.voll.api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.dto.DtoRegistroPaciente;

@Table(name = "pacientes")
@Entity(name = "Paciente")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    String nombre;
    String email;
    String telefono;
    String documentoIdentidad;
    @Embedded
    Direccion direccion;

    String codigoPostal;
    String provincia;

    public Paciente(DtoRegistroPaciente dtoRegistroPaciente) {
        this.nombre = dtoRegistroPaciente.nombre();
        this.email = dtoRegistroPaciente.email();
        this.telefono = dtoRegistroPaciente.telefono();
        this.documentoIdentidad = dtoRegistroPaciente.documentoIdentidad();
        this.direccion = new Direccion(dtoRegistroPaciente.direccion());
        this.codigoPostal = dtoRegistroPaciente.codigoPostal();
        this.provincia = dtoRegistroPaciente.provincia();
    }
}
