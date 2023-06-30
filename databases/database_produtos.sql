create database produtos;

use produtos;

create table cadastro_produtos(
id INT not null AUTO_INCREMENT PRIMARY KEY,
produto varchar(350), 
tipo_produto varchar(150), 
custo double, 
preco_venda double, 
desconto_max double, 
desconto_promo double, 
comissao int, 
desconta_comi varchar(4));

ALTER TABLE cadastro_produtos CHANGE desconto_comi desconta_comi varchar(4);
ALTER TABLE cadastro_produtos CHANGE proco_venda  preco_venda double;
 
select * from cadastro_produtos;
