use projeto_estetica;

create table cadastro_clientes(
	nome_completo varchar(300),
    apelido varchar(100),
	celular char(13),
	aniversario date # insert into campo set evento = str_to_date ('31/05/2023', '%d%m%a')
);

create table endereco_clientes(
	cep varchar(50),
	rua varchar(300),
	numero int,
	comp varchar(100),
	bairro varchar(300),
	cidade varchar(100),
	estado char(3)
);

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

create table cadastro_services(
	nome_servico varchar(300),
    categoria varchar(100),
	tipoServico varchar(100),
	custoProd double,
	precoVenda double,
	Desconto int,
	duracaoAproximada int
);

create table services_comissoes(
	tipo_comissao varchar(50), # percentual
	percentComissao int,
	descontarCustoProd bool
);


