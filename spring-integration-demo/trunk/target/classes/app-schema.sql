drop table if exists mensajes;

create table mensajes (
    id bigint identity primary key, 
    texto varchar(100),
    formato varchar(10),
    estado int
);



