package med.voll.api.interfaces;

import med.voll.api.model.Paciente;
import med.voll.api.service.interfaces.PacienteInterfaces;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long>, PacienteInterfaces {
}
