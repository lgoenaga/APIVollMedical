use vollmed_api;
alter table pacientes add activo BOOLEAN DEFAULT TRUE;
update pacientes set activo = TRUE;