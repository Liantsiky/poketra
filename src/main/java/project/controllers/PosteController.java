package project.controllers;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import etu2050.framework.Modelview;
import etu2050.framework.annotations.Url;
import ligeneric.dac.DAC;
import ligeneric.dao.DAO;
import project.models.Matiere;
import project.models.Poste;

public class PosteController {
	
	@Url(lien = "test.do",args = false)
	public Modelview test() {
		HashMap<String,Object> o= new HashMap<>();
		Modelview result = new Modelview(o);
		result.addItem("depense", "Hello");
		result.setPageJsp("index.jsp");
		return result;
	}
	@Url(lien = "posteInsert.do",args = true)
	public Modelview insert(String designation,double tauxHoraire) {
		HashMap<String,Object> o= new HashMap<>();
		Modelview result = new Modelview(o);
		Poste poste = new Poste();
		poste.setDesignation(designation);
		poste.setTauxHoraire(tauxHoraire);
		try (Connection con = DAC.getConnectionPostgreSQL("liantsiky","Mdpprom15", "poketra")) {
			DAO.insert(poste, con);                     
		} catch (Exception e) {
			// TODO: handle exception
		} 
		result.addItem("depense", "Hello");
		result.setPageJsp("Succes.jsp");
		return result;
	}
	
	@Url(lien = "posteFormulaire.do",args = false)
	public Modelview formulaire() {
		HashMap<String,Object> o= new HashMap<>();
		Modelview result = new Modelview(o);

		result.addItem("depense", "Hello"); //sous-forme
		result.setPageJsp("PosteFormulaire.jsp");
		return result;
	}
	
	@Url(lien = "postesDisplay.do",args = false)
	public Modelview displayAll() {
		HashMap<String,Object> o= new HashMap<>();
		Modelview result = new Modelview(o);
		List<Poste> liste = new ArrayList<Poste>();
		try(Connection con = DAC.getConnectionPostgreSQL("liantsiky","Mdpprom15", "poketra")) {
			liste = DAO.findall(Poste.class, con);                    
		} catch (Exception e) {
			// TODO: handle exception
		} 
		result.addItem("liste", liste);
		result.setPageJsp("PostesDisplay.jsp");
		return result;
	}
}
