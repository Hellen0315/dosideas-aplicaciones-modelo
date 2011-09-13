
Drop Table If Exists hibernate_unique_key;
Create Table hibernate_unique_key (next_hi INT);

Drop Table If Exists Paises;
Create Table Paises (Id Integer NOT NULL Constraint PK_Paises Primary Key, Nombre Text );
