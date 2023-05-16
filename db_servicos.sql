USE servicos;
CREATE TABLE cadastro_servicos(
nomeServico varchar(300),
categoria varchar(100),
tipoServico varchar(100),
custoProd double,
precoVenda double,
Desconto int,
duracaoAproximada int,
tipo varchar(50),
percentComissao int,
descontarCustoProd bool
);