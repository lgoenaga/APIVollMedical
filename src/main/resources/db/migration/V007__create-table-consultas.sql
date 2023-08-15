create table IF NOT EXISTS consultas (
    id bigint not null auto_increment,
    paciente_id bigint not null,
    medico_id bigint not null,
    fecha datetime not null,
    primary key (id)
);