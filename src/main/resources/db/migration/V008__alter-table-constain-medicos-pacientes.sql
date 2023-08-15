use vollmed_api;
ALTER TABLE consultas
    ADD CONSTRAINT fk_consultas_paciente_id
        FOREIGN KEY (paciente_id) references pacientes(id);

ALTER TABLE consultas
    ADD CONSTRAINT fk_consultas_medico_id
        FOREIGN KEY (medico_id) references medicos(id);