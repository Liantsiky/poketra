--poste
insert into poste (designation,taux_horaire) values
('couturier',2500),
('accessoiriste',4000),
('maroquineur','3500'),
('livreur','2500');

--employe
insert into employe (nom,prenom,date_de_naissance,id_poste,date_embauche) values
('Rakoto','Yves','2000-04-10',4,'2022-11-02'),
('Randria','Jeanne','1997-11-03',3,'2020-11-02'),
('Razato','Aime','1999-06-23',2,'2016-11-02'),
('Rakoto','Jean','1995-04-03',1,'2018-11-02');

--anciennete
insert into anciennete (annee_min,annee_max,designation,taux_augmentation) values
(0,1,'ouvrier',1),
(2,4,'senior',2),
(5,100,'expert',3);

--client
insert into client (nom,genre,date_de_naissance) values
('Julie',0,'2000-11-01'),
('Manon',0,'2001-05-12'),
('Seheno',0,'2002-08-11'),
('Jackline',0,'2001-05-23'),
('Tojo',1,'2002-07-28'),
('Robera',1,'2002-04-05'),
('Balita',1,'2000-02-15'),
('Njato',1,'2003-03-08');

--vente
insert into vente (id_client,date_vente) values
(1,'2023-04-05'),
(2,'2023-04-05'),
(3,'2023-04-05'),
(4,'2023-04-05'),
(5,'2023-04-05'),
(6,'2023-04-05'),
(7,'2023-04-05'),
(8,'2023-04-05');

--vente details
insert into vente_details (id_vente,id_modele,nombre) values
(1,1,2),
(1,2,3),
(2,4,4),
(3,5,2),
(4,5,6),

(5,4,1),
(5,3,3),
(6,6,2),
(6,5,2),
(7,1,6),
(7,2,1),
(7,3,2),
(8,6,1);

--taille
insert into taille (designation) values
('PM'),
('M');

--matiere 
insert into matiere (designation,prix) values
('coton',4000),
('raphia',4500);

--look_matiere
insert into look_matiere(id_look,id_matiere) values
(1,4),
(2,3),
(3,2),
(3,3);


--modele
insert into modele (id_type,id_look,id_taille,prix) values
(1,1,4,60000),
(1,1,5,90000),
(1,2,5,80000),
(2,1,4,45000),
(2,3,4,40000),
(2,3,5,50000);

--production
insert into production (id_modele,nombre,date_production) values
(1,15,'2023-02-22'),
(2,15,'2023-02-22'),
(3,15,'2023-02-22'),
(4,15,'2023-02-22'),
(5,15,'2023-02-22'),
(6,15,'2023-02-22');
--modele_matiere
insert into modele_matiere(id_modele,id_matiere) values
--modele 1
(1,1),
--modele 2
(2,1),
--modele 3
(3,1),
(3,3),
--modele 4
(4,2),
(4,4),
--modele 5
(5,2),
--modele 6
(6,2);
--modele_employe
insert into modele_employe (id_modele,id_employe) values 
--modele 1
(1,1),
(1,3),
--modele 2
(2,1),
(2,2),
(2,4),
--modele 3
(3,2),
(3,3),
--modele 4
(4,2),
(4,3),
(4,4),
--modele 5
(5,2),
(5,4),
--modele 6
(6,2);

--confection_matiere
insert into confection_matiere (id_look,id_taille,id_matiere,quantite) values
--look 1 PM
(1,4,4,2),
(1,4,2,2),
(1,4,1,1),
--look 1 M
(1,5,4,3),
(1,5,2,3),
(1,5,1,2),
--look 2 PM
(2,4,3,1),
(2,4,1,2),
--look 2 M
(2,5,3,2),
(2,5,1,3),
--look 3 PM
(3,4,3,2),
(3,4,2,2),
--look 3 M
(3,5,3,4),
(3,5,2,3);

--confection_time
insert into confection_time (id_look,id_taille,id_type,quantite) values
--look 1 PM
(1,4,1,2),
(1,4,2,1),
--look 1 M
(1,5,1,3),
(1,5,2,3),
--look 2 PM
(2,4,1,1),
(2,4,2,2),
--look 2 M
(2,5,1,2),
(2,5,2,3),
--look 3 PM
(3,4,1,2),
(3,4,2,2),
--look 3 M
(3,5,1,3),
(3,5,2,3);

























