drop table users;
drop table authorities;


create table users(
      username varchar(50) not null primary key,
      password varchar(50) not null,
      enabled numeric(1) not null
);

create table authorities (
      username varchar(50) not null,
      authority varchar(50) not null
);


insert into users (username, password, enabled) values ('zim', '123', 1);
insert into users (username, password, enabled) values ('dib', '123', 1);

insert into authorities (username, authority) values ('zim', 'USER');
insert into authorities (username, authority) values ('zim', 'ADMIN');
insert into authorities (username, authority) values ('dib', 'USER');
