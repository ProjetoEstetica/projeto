create database profissionais;
use profissionais;

create table cadastro_profissionais(
	id int not null auto_increment primary key,
	nome_completo varchar(300),
    apelido varchar(100),
	celular char(13),
	aniversario varchar(50), 
    cep varchar(50),
	rua varchar(300),
	numero int,
	comp varchar(100),
	bairro varchar(300),
	cidade varchar(100),
	estado char(3)
);


