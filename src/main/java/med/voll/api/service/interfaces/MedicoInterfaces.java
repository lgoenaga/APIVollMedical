package med.voll.api.service.interfaces;

import jakarta.validation.constraints.NotNull;
import med.voll.api.dto.DtoActualizarMedico;
import med.voll.api.dto.DtoListarMedicos;
import med.voll.api.dto.DtoRegistroMedico;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MedicoInterfaces {

    void registrarMedico(DtoRegistroMedico dtoRegistroMedico);
    void eliminarMedico(Long id);
    DtoListarMedicos buscarMedico(Long id);
    Page<DtoListarMedicos> listarMedicos(Pageable paginacion);
    void actualizarMedico(@NotNull Long id, DtoActualizarMedico dtoActualizarMedico);
    void eliminarMedicoLogico(Long id);
    Page<DtoListarMedicos> buscarMedicoPorActivo(Pageable paginacion);
}
