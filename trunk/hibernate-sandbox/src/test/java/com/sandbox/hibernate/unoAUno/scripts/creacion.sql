CREATE SCHEMA UnoAUno AUTHORIZATION DBA;

CREATE TABLE UnoAUno.Cuerpo (
    cuerpoId               INTEGER IDENTITY not null PRIMARY KEY,
    cuerpoDescripcion       VARCHAR(255) not null
);


CREATE TABLE UnoAUno.Corazon (
    corazonId               INTEGER IDENTITY not null PRIMARY KEY,
    cuerpoId                INTEGER not null,
    corazonDescripcion      VARCHAR(255) not null
);
ALTER TABLE UnoAUno.Corazon
ADD CONSTRAINT FK_Corazon_Cuerpo FOREIGN KEY (cuerpoId)
REFERENCES UnoAUno.Cuerpo (cuerpoId)
ON UPDATE NO ACTION ON DELETE NO ACTION