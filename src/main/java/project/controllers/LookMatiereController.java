package project.controllers;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import etu2050.framework.Modelview;
import etu2050.framework.annotations.Url;
import ligeneric.dac.DAC;
import ligeneric.dao.DAO;
import project.models.Look;
import project.models.LookMatiere;
import project.models.Matiere;

public class LookMatiereController {
	@Url(lien = "lookMatiereInsert.do",args = true)
	public Modelview insert(int idMatiere,int idLook) {
		HashMap<String,Object> o= new HashMap<>();
		Modelview result = new Modelview(o);
		LookMatiere lookMatiere = new LookMatiere();
		try (Connection con = DAC.getConnectionPostgreSQL("liantsiky","Mdpprom15", "poketra")){
			Matiere matiere = DAO.findById(Matiere.class, idMatiere, con);
			Look look = DAO.findById(Look.class, idLook, con);
			lookMatiere.setMatiere(matiere);
			lookMatiere.setLook(look);
			DAO.insert(lookMatiere, con);                     
		} catch (Exception e) {
			// TODO: handle exception
		} 
		result.addItem("depense", "Hello");
		result.setPageJsp("Succes.jsp");
		return result;
	}
	
	@Url(lien = "lookMatiereFormulaire.do",args = false)
	public Modelview formulaire() {
		HashMap<String,Object> o= new HashMap<>();
		Modelview result = new Modelview(o);

		result.addItem("depense", "Hello"); //sous-forme
		result.setPageJsp("LookMatiereFormulaire.jsp");
		return result;
	}
	
	@Url(lien = "lookMatieresDisplay.do",args = false)
	public Modelview displayAll() {
		HashMap<String,Object> o= new HashMap<>();
		Modelview result = new Modelview(o);
		List<LookMatiere> liste = new ArrayList<LookMatiere>();
		try(Connection con = DAC.getConnectionPostgreSQL("liantsiky","Mdpprom15", "poketra")) {
			liste = DAO.findall(LookMatiere.class, con);                    
		} catch (Exception e) {
			// TODO: handle exception
		} 
		result.addItem("liste", liste);
		result.setPageJsp("LookMatieresDisplay.jsp");
		return result;
	}
}
