drop table if exists users;
drop table if exists authorities;


create table users(
      username varchar(50) not null primary key,
      password varchar(50) not null,
      enabled numeric(1) not null
);

create table authorities (
      username varchar(50) not null,
      authority varchar(50) not null
);


insert into users (username, password, enabled) values ('bart', '123', 1);
insert into users (username, password, enabled) values ('edna', '123', 1);
insert into users (username, password, enabled) values ('skinner', '123', 1);
insert into users (username, password, enabled) values ('willy', '123', 1);

insert into authorities (username, authority) values ('bart', 'ALUMNO');
insert into authorities (username, authority) values ('edna', 'PROFESOR');
insert into authorities (username, authority) values ('skinner', 'PROFESOR');
insert into authorities (username, authority) values ('skinner', 'ALUMNO');
insert into authorities (username, authority) values ('willy', 'ENCARGADO');

