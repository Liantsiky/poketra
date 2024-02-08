package project.controllers;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import etu2050.framework.Modelview;
import etu2050.framework.annotations.Url;
import ligeneric.dac.DAC;
import ligeneric.dao.DAO;
import project.models.Taille;

public class TailleController {
	
	@Url(lien = "tailleInsert.do",args = true)
	public Modelview insert(String designation) {
		HashMap<String,Object> o= new HashMap<>();
		Modelview result = new Modelview(o);
		Taille taille = new Taille();
		taille.setDesignation(designation);
		Connection con = null;
		try {
			con = DAC.getConnectionPostgreSQL("liantsiky","Mdpprom15", "poketra");
			DAO.insert(taille, con);                     
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
	
	@Url(lien = "tailleFormulaire.do",args = false)
	public Modelview formulaire() {
		HashMap<String,Object> o= new HashMap<>();
		Modelview result = new Modelview(o);

		result.addItem("depense", "Hello"); //sous-forme
		result.setPageJsp("TailleFormulaire.jsp");
		return result;
	}
	
	@Url(lien = "taillesDisplay.do",args = false)
	public Modelview displayAll() {
		HashMap<String,Object> o= new HashMap<>();
		Modelview result = new Modelview(o);
		List<Taille> liste = new ArrayList<Taille>();
		Connection con = null;
		try {
			con = DAC.getConnectionPostgreSQL("liantsiky","Mdpprom15", "poketra");
			liste = DAO.findall(Taille.class, con);                    
		} catch (Exception e) {
			// TODO: handle exception
		} 
//		finally {
//			con.close();
//		}
		result.addItem("liste", liste);
		result.setPageJsp("TaillesDisplay.jsp");
		return result;
	}
	
}
