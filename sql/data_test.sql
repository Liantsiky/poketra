--poste
insert into poste (designation,taux_horaire) values
('maroquineur','3500'),
('livreur','2500');

--employe
insert into employe (nom,prenom,date_de_naissance,id_poste,date_embauche) values
('Rakoto','Jean','1995-04-03',1,'2018-11-02');

--anciennete
insert into anciennete (annee_min,annee_max,designation,taux_augmentation) values
(0,1,'ouvrier',1),
(2,4,'senior',2),
(5,100,'expert',3);