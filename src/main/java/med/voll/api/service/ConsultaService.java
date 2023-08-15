package med.voll.api.service;

import lombok.RequiredArgsConstructor;
import med.voll.api.dto.request.DtoAgendarConsulta;
import org.springframework.stereotype.Service;
import med.voll.api.interfaces.ConsultaRepository;

@Service
@RequiredArgsConstructor
public class ConsultaService {

    private final ConsultaRepository consultaRepository;

    public void agendarConsulta(DtoAgendarConsulta dtoAgendarConsulta) {



    }

}
