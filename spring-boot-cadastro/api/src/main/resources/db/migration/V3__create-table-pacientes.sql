create table pacientes(
    id bigint not null auto_increment,
    nome varchar(100) not null,
    email varchar(100) not null unique,
    documento varchar(6) not null unique,
    telefone varchar(100) not null,
    rua varchar(100) not null,
    numero varchar(100) not null,
    cep varchar(9) not null,
    cidade varchar(100),
    uf varchar(20),
    complemento char(2) not null,
    primary key(id)
);