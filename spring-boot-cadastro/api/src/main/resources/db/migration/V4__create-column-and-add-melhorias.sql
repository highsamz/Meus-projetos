alter table medicos add status tinyint;
alter table pacientes add status tinyint;

update medicos set status = 1;
update pacientes set status = 1;

alter table pacientes
modify complemento varchar(100);

alter table pacientes
modify uf char(2) not null;

alter table pacientes
modify cidade varchar(100) not null;