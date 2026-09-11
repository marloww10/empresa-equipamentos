insert into usuario (nome, email, senha) values
('Marlon', 'marlon@gmail.com', '123'),
('Lucas', 'lucas@gmail.com', '123'),
('Ana', 'ana@gmail.com', '123'),
('Carlos', 'carlos@gmail.com', '123'),
('Juliana', 'juliana@gmail.com', '123');

insert into equipamento
(marca, modelo, categoria, potencia, material, peso, dimensao, cor, quantidade, quantidademinima)
values
('Epson', 'PowerLite E20', 'Projetor', 340.0, 'Plástico', 2.7, 30.0, 'Branco', 10.0, 3.0),
('JBL', 'PartyBox 110', 'Caixa de Som', 160.0, 'Plástico', 10.8, 29.0, 'Preto', 8.0, 2.0),
('Dell', 'Inspiron 15', 'Notebook', 65.0, 'Plástico e Alumínio', 1.7, 36.0, 'Prata', 5.0, 2.0),
('Samsung', 'Smart TV 50', 'Televisão', 145.0, 'Plástico', 11.5, 112.0, 'Preto', 4.0, 1.0),
('Shure', 'SM58', 'Microfone', 0.0, 'Metal', 0.3, 16.0, 'Preto', 12.0, 4.0),
('Intelbras', 'VIP 1230', 'Câmera', 12.0, 'Plástico', 0.5, 15.0, 'Branco', 6.0, 2.0),
('Behringer', 'Xenyx 1202', 'Mesa de Som', 22.0, 'Metal', 2.4, 24.0, 'Preto', 3.0, 3.0),
('BenQ', 'MW560', 'Projetor', 280.0, 'Plástico', 2.3, 30.0, 'Branco', 2.0, 3.0);

select * from equipamento e 