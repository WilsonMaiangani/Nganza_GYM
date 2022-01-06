drop database if exists nganzagym;
create database nganzagym
default character set utf8
default collate utf8_general_ci;

use nganzagym;

drop table if exists `Pessoa`;

create table if not exists Pessoa(
Id 	  int not null primary key auto_increment ,
Nome  nvarchar(100) not null ,
Genero  enum('masculino','femenino') not null ,
DataNascimento date not null ,
Chave nvarchar(100) UNIQUE
) default charset = utf8;

drop table if exists `Cargo`;

create table if not exists Cargo(
Id 	  int not null primary key auto_increment ,
Cargo  nvarchar(100) not null
) default charset = utf8;

drop table if exists `Funcionario`;

create table if not exists Funcionario(
Id 	  int not null primary key auto_increment ,
IdPessoa  int not null,
IdCargo  int not null,
foreign key (IdPessoa) references Pessoa (Id),
foreign key (IdCargo) references Cargo (Id)
) default charset = utf8;

drop table if exists `Usuario`;

create table if not exists Usuario(
Id 	  int not null primary key auto_increment ,
IdFuncionario  int not null,
Codigo  nvarchar(100) not null,
Senha  nvarchar(100) not null,
foreign key (IdFuncionario) references Funcionario (Id)
) default charset = utf8;