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

public class LookController {

	@Url(lien = "lookInsert.do",args = true)
	public Modelview insert(String designation) {
		HashMap<String,Object> o= new HashMap<>();
		Modelview result = new Modelview(o);
		Look look = new Look();
		look.setDesignation(designation);
		Connection con = null;
		try {
			con = DAC.getConnectionPostgreSQL("liantsiky","Mdpprom15", "poketra");
			DAO.insert(look, con);                     
		} catch (Exception e) {
			// TODO: handle exception
		} 
//		finally {
//			con.close();
//		}
		result.addItem("depense", "Hello");
		result.setPageJsp("Succes.jsp");
		return result;
	}
	
	@Url(lien = "lookFormulaire.do",args = false)
	public Modelview formulaire() {
		HashMap<String,Object> o= new HashMap<>();
		Modelview result = new Modelview(o);

		result.addItem("depense", "Hello"); //sous-forme
		result.setPageJsp("LookFormulaire.jsp");
		return result;
	}
	
	@Url(lien = "looksDisplay.do",args = false)
	public Modelview displayAll() {
		HashMap<String,Object> o= new HashMap<>();
		Modelview result = new Modelview(o);
		List<Look> liste = new ArrayList<Look>();
		try (Connection con = DAC.getConnectionPostgreSQL("liantsiky","Mdpprom15", "poketra")){
			
			liste = DAO.findall(Look.class, con);                    
		} catch (Exception e) {
			// TODO: handle exception
		} 
		result.addItem("liste", liste);
		result.setPageJsp("LooksDisplay.jsp");
		return result;
	}
	
	@Url(lien = "looksChoosing.do",args = false)
	public Modelview choosing() {
		HashMap<String,Object> o= new HashMap<>();
		Modelview result = new Modelview(o);
		List<Look> liste = new ArrayList<Look>();
		try (Connection con = DAC.getConnectionPostgreSQL("liantsiky","Mdpprom15", "poketra")){
			
			liste = DAO.findall(Look.class, con);                    
		} catch (Exception e) {
			// TODO: handle exception
		} 
		result.addItem("liste", liste);
		result.setPageJsp("LooksChoosing.jsp");
		return result;
	}
	
	
		@Url(lien = "looksChoosingResult.do",args = true)
	public Modelview choosingResult(int idLook) {
		HashMap<String,Object> o= new HashMap<>();
		Modelview result = new Modelview(o);
		List<LookMatiere> liste = new ArrayList<LookMatiere>();
		try (Connection con = DAC.getConnectionPostgreSQL("liantsiky","Mdpprom15", "poketra")){
//			Look look = DAO.findById(Look.class, idLook, con);
			liste = DAO.findPredicat(LookMatiere.class, con, "id_look="+idLook);                    
		} catch (Exception e) {
			// TODO: handle exception
		} 
		result.addItem("liste", liste);
		result.setPageJsp("LooksChoosingResult.jsp");
		return result;
	}
}
