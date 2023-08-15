package med.voll.api.dto.response;

import med.voll.api.dto.request.DtoAgendarConsulta;

public record DtoDetalleConsulta(

        DtoAgendarConsulta dtoAgendarConsulta) {

    @Override
    public String toString() {
        return "Detalle Consulta{" +
                "\n\t\t\t\t\t\t\t\t\t\tPaciente: " + dtoAgendarConsulta.idPaciente() +
                "\n\t\t\t\t\t\t\t\t\t\tMedico: " + dtoAgendarConsulta.idMedico() +
                "\n\t\t\t\t\t\t\t\t\t\tFecha: " + dtoAgendarConsulta.fecha() +
                "\n\t\t\t\t\t\t\t\t"+'}';
    }

}
