create or replace view v_Annee_service as
select id id_employe,  (current_date - date_embauche)/365  annee_service
    from employe;