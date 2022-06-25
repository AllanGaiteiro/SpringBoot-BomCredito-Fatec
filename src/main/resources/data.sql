insert into customer (name,cpf) values 
('Allan','333.333.333-23'),
('Allan2','333.333.333-23'),
('Allan3','333.333.333-23');

insert into institution (name,created_at) values 
('capital',now()),
('xcredit',now()),
('teste',now());

insert into opportunity (id_customer,id_institution,created_at) values 
(1,2,now()),
(1,2,now()),
(1,2,now());