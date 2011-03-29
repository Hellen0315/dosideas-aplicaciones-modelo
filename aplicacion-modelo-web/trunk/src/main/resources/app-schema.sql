drop table personas if exists;

create table personas (
    id bigint identity PRIMARY KEY, 
    nombre varchar(100), 
    apellido varchar(100), 
    email varchar(50) not null
);