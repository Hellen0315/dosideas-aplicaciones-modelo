drop table if exists personas;
drop table if exists curso_materia;
drop table if exists materias;
drop table if exists alumno_curso;
drop table if exists cursos;
drop table if exists alumnos;

create table personas (
    id bigint identity PRIMARY KEY, 
    nombre varchar(100), 
    apellido varchar(100), 
    email varchar(50) not null
);

create table alumnos (
    id bigint identity primary key, 
    nombre varchar(100), 
    apellido varchar(100), 
    email varchar(30), 
    telefono varchar(20) 
);

create table cursos (
    id bigint identity primary key, 
    titulo varchar(100), 
    materia_id bigint
);

create table materias (
    id bigint identity primary key, 
    nombre varchar(100)
);

create table alumno_curso (
    id_alumno bigint , 
    id_curso bigint
);

create table curso_materia (
    id_curso bigint , 
    id_materia bigint
);


create unique index alumno_curso_uk on alumno_curso(id_alumno,id_curso);
alter table alumno_curso add foreign key (id_alumno) references alumnos(id);
alter table alumno_curso add foreign key (id_curso) references cursos(id);

create unique index curso_materia_uk on curso_materia(id_curso,id_materia);
alter table curso_materia add foreign key (id_curso) references cursos(id);
alter table curso_materia add foreign key (id_materia) references materias(id);

