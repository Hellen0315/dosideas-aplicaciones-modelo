create table PAIS (
    id_pais numeric(8) primary key,
    nombre varchar(50)
);

create table PROVINCIA (
    id_provincia numeric(8) primary key,
    id_pais numeric(8),
    nombre varchar(50)
);