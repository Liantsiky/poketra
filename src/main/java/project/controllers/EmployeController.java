package project.controllers;

import java.sql.Connection;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import etu2050.framework.Modelview;
import etu2050.framework.annotations.Url;
import ligeneric.dac.DAC;
import ligeneric.dao.DAO;
import project.models.ConfectionTime;
import project.models.Employe;
import project.models.EmployeSalaire;
import project.models.Look;
import project.models.Poste;
import project.models.Taille;
import project.models.Type;

public class EmployeController {
	
	@Url(lien = "employeSalaire.do",args = false)
	public Modelview salaire() {
		HashMap<String,Object> o= new HashMap<>();
		Modelview result = new Modelview(o);
		List <EmployeSalaire> liste = new ArrayList<EmployeSalaire>();
		try (Connection con = DAC.getConnectionPostgreSQL("liantsiky","Mdpprom15", "poketra")) {
			liste = DAO.findallView(EmployeSalaire.class, "v_employe_salaire", con) ;                 
		} catch (Exception e) {
			// TODO: handle exception
		} 
		
		result.addItem("liste", liste);
		result.setPageJsp("EmployeSalaire.jsp");
		return result;
	}
	
	@Url(lien = "employeInsert.do",args = true)
	public Modelview insert(String nom,String prenom,int idPoste,LocalDate dateDeNaissance,LocalDate dateEmbauche) {
		HashMap<String,Object> o= new HashMap<>();
		Modelview result = new Modelview(o);
		Employe employe = null;
		try (Connection con = DAC.getConnectionPostgreSQL("liantsiky","Mdpprom15", "poketra")) {
			Poste poste = DAO.findById(Poste.class, idPoste, con);
			employe = new Employe(nom, prenom,poste, dateDeNaissance, dateEmbauche);
			DAO.insert(employe, con);                     
		} catch (Exception e) {
			// TODO: handle exception
		} 
		
		result.addItem("depense", "Hello");
		result.setPageJsp("Succes.jsp");
		return result;
	}
	
	@Url(lien = "employeFormulaire.do",args = false)
	public Modelview formulaire() {
		HashMap<String,Object> o= new HashMap<>();
		Modelview result = new Modelview(o);
		List<Poste> posteListe= null;
		try(Connection con = DAC.getConnectionPostgreSQL("liantsiky","Mdpprom15", "poketra")) {

			posteListe = DAO.findall(Poste.class, con);                    
		} catch (Exception e) {
			// TODO: handle exception
		} 
		result.addItem("postes", posteListe); //sous-forme
		result.setPageJsp("EmployeFormulaire.jsp");
		return result;
	}
	
	@Url(lien = "employesDisplay.do",args = false)
	public Modelview displayAll() {
		HashMap<String,Object> o= new HashMap<>();
		Modelview result = new Modelview(o);
		List<Employe> liste = new ArrayList<Employe>();
		Connection con = null;
		try {
			con = DAC.getConnectionPostgreSQL("liantsiky","Mdpprom15", "poketra");
			liste = DAO.findall(Employe.class, con);                    
		} catch (Exception e) {
			// TODO: handle exception
		} 
		result.addItem("liste", liste);
		result.setPageJsp("EmployesDisplay.jsp");
		return result;
	}
}
