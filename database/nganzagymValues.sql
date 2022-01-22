use nganzagym;

insert into pessoa  (nome, genero, chave)
values
("Wilson Kiangana",'masculino','0000777pppmmm'),
("Tambu Jenny",'masculino','11155566888'),
("Manuel Machado",'masculino','333442288');

insert into cargo  (cargo)
values ("Admin"),("Professor"),("Usuario");

insert into Funcionario  (idpessoa, idcargo)
values (1,1),(2,1),(3,1);

insert into usuario  (idfuncionario, codigo, senha)
values (1,'1','123'),(2,'2','123'),(3,'3','123');


select *from usuario;