CREATE SCHEMA UnoAMuchos AUTHORIZATION DBA;

CREATE TABLE UnoAMuchos.Persona (
    personaId                    INTEGER IDENTITY not null PRIMARY KEY,
    personaNombre           VARCHAR(255) not null
);


CREATE TABLE UnoAMuchos.Apodo (
    apodoId               INTEGER IDENTITY not null PRIMARY KEY,
    personaId             INTEGER not null,
    apodoDescripcion           VARCHAR(255) not null
);
ALTER TABLE UnoAMuchos.Apodo
ADD CONSTRAINT FK_Apodo_Persona FOREIGN KEY (personaId)
REFERENCES UnoAMuchos.Persona (personaId)
ON UPDATE NO ACTION ON DELETE NO ACTION