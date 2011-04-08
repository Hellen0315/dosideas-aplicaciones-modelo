

create table alumnos (id bigint IDENTITY PRIMARY KEY , nombre varchar(100), apellido varchar(100), email varchar(30), telefono varchar(20) );
create table cursos (id bigint IDENTITY PRIMARY KEY, titulo varchar(100), materia_id bigint);
create table materias (id bigint IDENTITY PRIMARY KEY, nombre varchar(100));


create table alumno_curso (id_alumno bigint , id_curso bigint);
CREATE UNIQUE INDEX alumno_curso_uk on alumno_curso(id_alumno,id_curso);
ALTER TABLE alumno_curso ADD FOREIGN KEY (id_alumno) REFERENCES alumnos(id);
ALTER TABLE alumno_curso ADD FOREIGN KEY (id_curso) REFERENCES cursos(id);

create table curso_materia (id_curso bigint , id_materia bigint);
CREATE UNIQUE INDEX curso_materia_uk on curso_materia(id_curso,id_materia);
ALTER TABLE curso_materia ADD FOREIGN KEY (id_curso) REFERENCES cursos(id);
ALTER TABLE curso_materia ADD FOREIGN KEY (id_materia) REFERENCES materias(id);





