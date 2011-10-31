CREATE SCHEMA Base AUTHORIZATION DBA;

CREATE TABLE Base.Dummy (
    dummyId                    INTEGER IDENTITY not null PRIMARY KEY,
    dummyDescripcion           VARCHAR(255) not null
);
