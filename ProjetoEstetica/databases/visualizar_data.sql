create database teste;

create table test(data varchar(20), nome varchar(20));

insert into test(data, nome) values ("28/12/2004", "eduardo");
insert into test(data, nome) values ("10/11/2004", "diego");
select * from test where data like '28%';

