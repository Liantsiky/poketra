create or replace view v_Annee_service as
select id id_employe,  (current_date - date_embauche)/365  annee_service
    from employe;
    
--fonctionnalite 3 
	-- view pour avoir modele + matiere + prix
create or replace view v_modele_matiere as
select id_modele, mo.id_taille, id_matiere,designation,prix
	from modele_matiere m
	join matiere ma
	on m.id_matiere = ma.id
	
create or replace view v_modele_taille as 
	select v.*, id_taille,id_look
	from v_modele_matiere v
	join modele mo
	on v.id_modele = mo.id
	
	-- view pour avoir v_modele_matiere + confection_matiere
create or replace view v_mp_prix_confection as
select id_modele, sum(prix*quantite) total
	from v_modele_taille v
	join confection_matiere c
	on v.id_matiere = c.id_matiere
	where v.id_taille = c.id_taille and v.id_look=c.id_look
	group by id_modele;
	
	
select v.id_modele,v.id_matiere,v.prix,c.quantite,v.id_taille,v.id_look, c.quantite, (v.prix*c.quantite) total
    from v_modele_taille v
    join confection_matiere c
    on v.id_matiere = c.id_matiere
    where v.id_taille = c.id_taille and v.id_look=c.id_look

--fonctionnalite 4 
		-- view calcul service
	create or replace view v_employe_service as
    select id id_employe,id_poste,date_part('YEAR',now())- date_part('YEAR',date_embauche)service
    	from employe
    ;
    
    	--view join anciennete
    create or replace view v_employe_anciennete as
    select a.*, v.*
    from v_employe_service v
    join anciennete a on v.service between a.annee_min and a.annee_max
    
    	--view join poste and calcule salaire
    create or replace view v_employe_salaire as
    select v.id_employe, v.id_poste,v.designation niveau,v.service,(v.taux_augmentation*p.taux_horaire) salaire
    from v_employe_anciennete v
    join poste p 
    on v.id_poste = p.id
    	
    	--view join ce dernier avec les modeles ou ils travaillent
    create or replace view v_employe_salaire_modele as
    select v.*,id_modele,mo.id_type,mo.id_look,mo.id_taille
    from v_employe_salaire v
    join modele_employe m on v.id_employe=m.id_employe
    join modele mo on m.id_modele=mo.id
    	
    	--view join v_employe_salaire_modele and confection_time
    create or replace view v_main_oeuvre as 
    select v.id_modele, sum(c.quantite*v.salaire) main_oeuvre
    from v_employe_salaire_modele v
    join confection_time c 
    on v.id_type = c.id_type
    where v.id_look = c.id_look and v.id_taille = c.id_taille
    	group by id_modele
    
    	--view calcule total fabrication
    create or replace view v_coup_fabrication as
    select v1.id_modele, (v1.main_oeuvre+ v2.total) coup_fabrication
    from v_main_oeuvre v1
    join v_mp_prix_confection v2
    on v1.id_modele = v2.id_modele
    
    	--view calcule benefice
    create or replace view v_benefice as
    select id id_modele, m.prix - v.coup_fabrication benefice
    from modele m
    join v_coup_fabrication v 
    on m.id = v.id_modele
    
--fonctionnalite 6 
	select v.id, id_client,id_modele,nombre,genre
	from vente v
	join vente_details v1 on v.id=v1.id_vente
	join client c on v.id_client = c.id;
		
		--view calcule total vente par genre
	create or replace view v_vente_genre as
	select id_modele,sum(nombre) nombre,genre
	from vente v
	join vente_details v1 on v.id=v1.id_vente
	join client c on v.id_client = c.id
		group by id_modele,genre 
		order by id_modele
		
--fonctionnalite 7 
		--view as total vente
	create or replace view v_total_vente as
	select id_modele,sum(nombre) total
	from vente v
	join vente_details v1 on v.id=v1.id_vente
	join client c on v.id_client = c.id
		group by id_modele
		order by id_modele
		
		--view as total production
	create or replace view v_total_production as
	select id_modele,sum(nombre) total
	from production group by id_modele;
	
		--view as total stock
	create or replace view v_stock as
	select p.id_modele, p.total-v.total total
	from v_total_vente v
	join v_total_production p
	on v.id_modele = p.id_modele
	
    
    
    
    
    
    
    
    
    
    

	
	