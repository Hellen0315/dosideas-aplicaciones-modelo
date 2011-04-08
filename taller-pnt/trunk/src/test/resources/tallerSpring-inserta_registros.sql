
insert into alumnos (id, nombre,apellido,email) values(1,'Jose','Perez','jose@perez.com');
insert into alumnos (id, nombre,apellido,email) values(2,'Juan','Lopez','juan@lopez.com');

insert into cursos (id, titulo,materia_id) values(1,'Matematica basica',2);
insert into cursos (id, titulo,materia_id) values(2,'Objetos',2);

insert into materias (id, nombre) values(1,'Matematica');
insert into materias (id, nombre) values(2,'Programacion java');

insert into alumno_curso (id_alumno,id_curso) values(1,1);
insert into alumno_curso (id_alumno,id_curso) values(1,2);
insert into alumno_curso (id_alumno,id_curso) values(2,1);
insert into alumno_curso (id_alumno,id_curso) values(2,2);

insert into curso_materia (id_curso,id_materia) values(1,1);
insert into curso_materia (id_curso,id_materia) values(2,2);





