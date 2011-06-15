
insert into alumnos (id, nombre,apellido,email) values(1,'Jose','Perez','jose@perez.com');
insert into alumnos (id, nombre,apellido,email) values(2,'Juan','Lopez','juan@lopez.com');
insert into alumnos (id, nombre,apellido,email) values(3,'Carlos','Antonio','carlos@antonio.com');
insert into alumnos (id, nombre,apellido,email) values(4,'Roberto','Carlos','roberto@carlos.com');
insert into alumnos (id, nombre,apellido,email) values(5,'Martin','Palermo','martin@palermo.com');
insert into alumnos (id, nombre,apellido,email) values(6,'Patita','Minervino','patita@minervino.com');
insert into alumnos (id, nombre,apellido,email) values(7,'Carlos','Alonso','carlos@alonso.com');
insert into alumnos (id, nombre,apellido,email) values(8,'Jorge','Corona','jorge@corona.com');


insert into cursos (id, titulo,materia_id) values(1,'Matematica basica',1);
insert into cursos (id, titulo,materia_id) values(2,'Objetos',2);
insert into cursos (id, titulo,materia_id) values(3,'Java',2);


insert into materias (id, nombre) values(1,'Matematica');
insert into materias (id, nombre) values(2,'Programacion java');


insert into alumno_curso (id_alumno,id_curso) values(1,1);
insert into alumno_curso (id_alumno,id_curso) values(1,2);
insert into alumno_curso (id_alumno,id_curso) values(1,3);

insert into alumno_curso (id_alumno,id_curso) values(2,1);
insert into alumno_curso (id_alumno,id_curso) values(2,2);

insert into alumno_curso (id_alumno,id_curso) values(5,1);
insert into alumno_curso (id_alumno,id_curso) values(5,2);

insert into alumno_curso (id_alumno,id_curso) values(7,2);

insert into alumno_curso (id_alumno,id_curso) values(8,1);
insert into alumno_curso (id_alumno,id_curso) values(8,2);
insert into alumno_curso (id_alumno,id_curso) values(8,3);

insert into curso_materia (id_curso,id_materia) values(1,1);
insert into curso_materia (id_curso,id_materia) values(2,2);





