package med.voll.api.interfaces;

import med.voll.api.model.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface ConsultaRepository extends JpaRepository<Consulta, Long> {

    Boolean existsByPacienteIdAndFechaBetween(Long aLong, LocalDateTime localDateTime, LocalDateTime localDateTime1);
}
