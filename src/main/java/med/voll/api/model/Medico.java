package med.voll.api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.dto.DtoRegistroMedico;

@Table(name = "medicos")
@Entity(name = "Medico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String email;
    private String documento;
    private String telefono;

    @Enumerated(EnumType.STRING)
    private Especialidad especialidad;
    @Embedded
    private Direccion direccion;

    public Medico(DtoRegistroMedico dtoRegistroMedico) {
        this.nombre = dtoRegistroMedico.nombre();
        this.email = dtoRegistroMedico.email();
        this.documento = dtoRegistroMedico.documento();
        this.telefono = dtoRegistroMedico.telefono();
        this.especialidad = dtoRegistroMedico.especialidad();
        this.direccion = new Direccion(dtoRegistroMedico.direccion());
    }
}
