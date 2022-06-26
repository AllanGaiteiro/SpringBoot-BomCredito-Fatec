insert into customer (name,cpf) values 
 ('allan santos', '447.562.413-54'),
 ('allan almeida', '314.933.838-48'),
 ('allan silva', '881.873.116-33'),
 ('allan gaiteiro', '899.867.942-58'),
 ('allan souza', '655.113.421-69'),
 ('caio santos', '452.725.196-11'),
 ('caio almeida', '946.342.549-34'),
 ('caio silva', '883.366.177-96'),
 ('caio gaiteiro', '943.715.644-96'),
 ('caio souza', '575.332.844-27'),
 ('alex santos', '389.635.531-23'),
 ('alex almeida', '583.311.947-32'),
 ('alex silva', '865.712.212-64'),
 ('alex gaiteiro', '967.729.685-84'),
 ('alex souza', '522.884.985-81'),
 ('lucas santos', '564.923.298-37'),
 ('lucas almeida', '117.247.984-31'),
 ('lucas silva', '615.679.567-79'),
 ('lucas gaiteiro', '573.617.346-84'),
 ('lucas souza', '251.126.167-33'),
 ('marcos santos', '595.399.433-99'),
 ('marcos almeida', '314.676.338-69'),
 ('marcos silva', '111.567.166-13'),
 ('marcos gaiteiro', '745.491.857-87'),
 ('marcos souza', '288.135.719-26');


insert into institution (name,created_at) values 
('capital',now()),
('xcredit',now()),
('instituição1',now()),
('instituição2',now()),
('instituição3',now()),
('instituição4',now()),
('instituição5',now());

insert into opportunity (id_customer,id_institution,created_at) values 
(1,2,now()),
(1,2,'2022-03-26 01:05:19.890988'),
(1,2,now()),
(1, 1, '2022-02-18 01:05:19.890988' ),
(2, 1, '2022-01-11 01:05:19.890988' ),
(3, 1, '2022-02-22 01:05:19.890988' ),
(4, 1, '2022-04-22 01:05:19.890988' ),
(5, 1, '2022-05-09 01:05:19.890988' ),
(6, 1, '2022-03-11 01:05:19.890988' );