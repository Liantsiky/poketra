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
import project.models.Type;

public class TypeController {
	@Url(lien = "typeInsert.do",args = true)
	public Modelview insert(String designation) {
		HashMap<String,Object> o= new HashMap<>();
		Modelview result = new Modelview(o);
		Type type = new Type();
		type.setDesignation(designation);
		Connection con = null;
		try {
			con = DAC.getConnectionPostgreSQL("liantsiky","Mdpprom15", "poketra");
			DAO.insert(type, con);                     
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
	
	@Url(lien = "typeFormulaire.do",args = false)
	public Modelview formulaire() {
		HashMap<String,Object> o= new HashMap<>();
		Modelview result = new Modelview(o);

		result.addItem("depense", "Hello"); //sous-forme
		result.setPageJsp("TypeFormulaire.jsp");
		return result;
	}
	
	@Url(lien = "typesDisplay.do",args = false)
	public Modelview displayAll() {
		HashMap<String,Object> o= new HashMap<>();
		Modelview result = new Modelview(o);
		List<Type> liste = new ArrayList<Type>();
		Connection con = null;
		try {
			con = DAC.getConnectionPostgreSQL("liantsiky","Mdpprom15", "poketra");
			liste = DAO.findall(Type.class, con);                    
		} catch (Exception e) {
			// TODO: handle exception
		} 
//		finally {
//			con.close();
//		}
		result.addItem("liste", liste);
		result.setPageJsp("TypesDisplay.jsp");
		return result;
	}
	
}
