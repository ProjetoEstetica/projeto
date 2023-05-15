use projeto_estetica;


create table cadastro_profissionais(
	nome_completo varchar(300),
    apelido varchar(100),
	celular char(13),
	aniversario date # insert into campo set evento = str_to_date ('31/05/2023', '%d%m%a')
);

create table endereco_profissionais(
	cep varchar(50),
	rua varchar(300),
	numero int,
	comp varchar(100),
	bairro varchar(300),
	cidade varchar(100),
	estado char(3)
);


