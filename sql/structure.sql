--confection_matiere
create table confection_matiere(
	id serial primary key,
	id_look int,
	id_taille int,
	id_matiere int,
	quantite double precision,
	foreign key (id_look) references look(id),
	foreign key (id_taille) references taille(id),
	foreign key (id_matiere) references matiere(id)
);

--confection_time
create table confection_time(
	id serial primary key,
	id_type int,
	id_look int,
	id_taille int,
	quantite double precision,
	foreign key (id_look) references look(id),
	foreign key (id_taille) references taille(id),
	foreign key (id_type) references type(id)
);

--poste
create table poste(
	id serial primary key,
	designation varchar(50),
	taux_horaire double precision
);

--employe
create table employe(
	id serial primary key,
	nom varchar(50),
	prenom varchar(50),
	date_de_naissance date,
	id_poste int,
	date_embauche date,
	foreign key (id_poste) references poste(id)
);

--anciennete
create table anciennete (
	 id serial primary key,
	 annee_min int,
	 annee_max int,
	 designation varchar(50),
	 taux_augmentation double precision
);

--client
create table client(
	id serial primary key,
	nom varchar(50),
	genre int,
	date_de_naissance date
);

--modele
create table modele (
	id serial primary key,
	designation varchar(100),
	id_type int,
	id_look int,
	id_taille int
	prix double precision,
	foreign key (id_type) references type(id),
	foreign key (id_taille) references taille(id),
	foreign key (id_look) references look(id)
);

--modele_matiere 
create table modele_matiere (
	id serial primary key,
	id_modele int,
	id_matiere int,
	foreign key (id_modele) references modele(id),
	foreign key (id_matiere) references matiere(id)
);

--modele_employe 
create table modele_employe(
	id serial primary key,
	id_modele int,
	id_employe int,
	foreign key (id_modele) references modele(id),
	foreign key (id_employe) references employe(id),
);
--vente
create table vente (
	id serial primary key,
	id_client int,
	date_vente date,
	foreign key (id_client) references client(id)
);

--vente_details
create table vente_details (
	id serial primary key,
	id_vente int,
	id_modele int,
	nombre int,
	foreign key (id_vente) references vente(id),
	foreign key (id_modele) references modele(id)
);

--production
create table production (
	id serial primary key,
	id_modele int,
	nombre int,
	date_production date,
	foreign key (id_modele) references modele(id)
);
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


