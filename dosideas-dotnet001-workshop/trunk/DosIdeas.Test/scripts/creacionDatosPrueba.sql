


create table hibernate_unique_key (
	next_hi INT
);

insert into hibernate_unique_key values ( 5 );


drop table if exists Paises;
CREATE TABLE Paises
( Id INTEGER NOT NULL CONSTRAINT PK_Paises PRIMARY KEY ,
  Nombre TEXT );

INSERT INTO Paises(Nombre) VALUES ('Argentina');
INSERT INTO Paises(Nombre) VALUES ('Colombia');
INSERT INTO Paises(Nombre) VALUES ('Venezuela');
INSERT INTO Paises(Nombre) VALUES ('Peru');
