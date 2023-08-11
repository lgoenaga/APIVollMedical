package med.voll.api.interfaces;

import med.voll.api.model.Medico;
import med.voll.api.service.interfaces.MedicoInterfaces;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicoRepository extends JpaRepository<Medico, Long>, MedicoInterfaces {
    Page<Medico> findByActivoTrue(Pageable paginacion);
}
