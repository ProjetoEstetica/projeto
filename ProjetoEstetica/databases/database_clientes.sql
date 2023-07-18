create database clientes;
use clientes;

create table cadastro_clientes(
	id int not null auto_increment primary key,
	nome_completo varchar(300),
    apelido varchar(100),
	celular char(13),
<<<<<<< HEAD:db_profissionais.sql
	aniversario varchar(50), 
=======
	aniversario varchar(11), 
>>>>>>> main:ProjetoEstetica/databases/database_clientes.sql
    cep varchar(50),
	rua varchar(300),
	numero varchar(10),
	comp varchar(100),
	bairro varchar(300),
	cidade varchar(100),
	estado char(3)
);

<<<<<<< HEAD:db_profissionais.sql
select * from cadastro_profissionais;

=======
select * from cadastro_clientes;
>>>>>>> main:ProjetoEstetica/databases/database_clientes.sql
