package med.voll.api.model;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.*;
import med.voll.api.dto.request.DtoDireccion;
import med.voll.api.dto.request.DtoRegistroPaciente;

import java.io.Serializable;

@Table(name = "pacientes")
@Entity(name = "Paciente")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Paciente implements Serializable {

    private static final long serialVersionUID = 1L;

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
    Boolean activo = true;

    public Paciente(DtoRegistroPaciente dtoRegistroPaciente) {
        this.nombre = dtoRegistroPaciente.nombre();
        this.email = dtoRegistroPaciente.email();
        this.telefono = dtoRegistroPaciente.telefono();
        this.documentoIdentidad = dtoRegistroPaciente.documentoIdentidad();
        this.direccion = new Direccion(dtoRegistroPaciente.direccion());
        this.codigoPostal = dtoRegistroPaciente.codigoPostal();
        this.provincia = dtoRegistroPaciente.provincia();
        this.activo = true;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setDireccion(@Valid DtoDireccion direccion) {
           this.direccion = new Direccion(direccion);
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", nombre='" + nombre +
                ", email='" + email +
                ", telefono='" + telefono +
                ", documentoIdentidad='" + documentoIdentidad +
                '}';
    }
}
