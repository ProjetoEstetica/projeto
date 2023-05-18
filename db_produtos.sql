create database produtos;
use produtos;

create table cadastro_produtos(
	id int not null auto_increment primary key,
	produto varchar(300),
    tipo_produto varchar(100),
	custo double,
	preco_venda double, 
    desc_max int,
	desc_promo int,
	comissao int,
	desc_custoComissao boolean
);


