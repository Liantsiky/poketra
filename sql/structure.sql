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

