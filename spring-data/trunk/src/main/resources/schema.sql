drop table if exists hobbie;
drop table if exists persona;
drop table if exists pais;
drop table if exists usuario;


create table pais(
    id bigint identity primary key,
    nombre varchar(100) not null
);

create table persona(
    id bigint identity primary key,
    nombre varchar(100) not null,
    apellido varchar(100) not null,
    fecha_nacimiento datetime,
    pais_id bigint
);

create table hobbie (
    id bigint identity primary key,
    descripcion varchar(100) not null,
    persona_id bigint not null
);

create table usuario(
    id bigint identity primary key,
    nombre varchar(100) not null,
    apellido varchar(100) not null,
    nombre_usuario varchar(20) not null
);

alter table persona add constraint fk_persona_pais foreign key(pais_id) references pais(id);
alter table hobbie add constraint fk_hobbie_persona foreign key(persona_id) references persona(id);


insert into pais (id, nombre) values (1, 'Argentina');
insert into pais (id, nombre) values (2, 'Brasil');
insert into pais (id, nombre) values (3, 'Chile');
insert into pais (id, nombre) values (4, 'Uruguay');

insert into persona (id, nombre, apellido, pais_id) values (1, 'Kilgore', 'Trout', 1);
insert into persona (id, nombre, apellido, pais_id) values (2, 'Billy', 'Pilgrim', 2);
insert into persona (id, nombre, apellido, pais_id) values (3, 'Dorian', 'Gray', 3);

insert into hobbie (id, descripcion, persona_id) values (10, 'magic', 1);
insert into hobbie (id, descripcion, persona_id) values (11, 'escritor', 1);
insert into hobbie (id, descripcion, persona_id) values (20, 'peliculas', 2);
insert into hobbie (id, descripcion, persona_id) values (30, 'deportes varios', 3);

insert into usuario (id, nombre, apellido, nombre_usuario) values (1, 'Jose', 'Perez', 'jperez');
insert into usuario (id, nombre, apellido, nombre_usuario) values (2, 'Raul', 'Gonzalez', 'rgonzalez');
insert into usuario (id, nombre, apellido, nombre_usuario) values (3, 'Juan', 'Garcia', 'jgarcia');