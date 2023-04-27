create database EC1_PALOMINO;
use EC1_PALOMINO;

create table tb_marca(
codigo_Marca int primary key auto_increment,
nom_Marca varchar(70)
);

create table tb_autos(
codigo_Auto int primary key auto_increment,
descripcion_Auto varchar(30),
precio_Auto double,
stock_auto int,
codigo_Marca int
);

alter table tb_autos add constraint FK01 foreign key(codigo_Marca) references tb_marca(codigo_Marca);


insert into tb_marca values(null,'Chevrolet'),(null,'Mazda'),(null,'Subaru');
select*from tb_marca;
insert into tb_autos values(null,'Camaro 265',5323.99,3,1),(null,'AerobicNX3',4353.65,8,2),(null,'CiprésGold',4983.99,2,3);
select*from tb_autos;
