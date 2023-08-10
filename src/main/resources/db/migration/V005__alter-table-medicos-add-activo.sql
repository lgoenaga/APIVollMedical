use vollmed_api;
alter table medicos add activo BOOLEAN DEFAULT TRUE;
update medicos set activo = TRUE;