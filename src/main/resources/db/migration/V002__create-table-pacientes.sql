use vollmed_api;
create table pacientes(

                          id int not null auto_increment,
                          nombre varchar(100) not null,
                          email varchar(100) not null unique,
                          documento_identidad varchar(20) not null unique,
                          telefono varchar(13) not null,
                          calle varchar(50) not null,
                          distrito varchar(50) not null,
                          complemento varchar(50),
                          numero varchar(13),
                          ciudad varchar(50) not null,
                          primary key (id)

)