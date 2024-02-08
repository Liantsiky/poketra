package project.controllers;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import etu2050.framework.Modelview;
import etu2050.framework.annotations.Url;
import ligeneric.dac.DAC;
import ligeneric.dao.DAO;
import project.models.ConfectionMatiere;
import project.models.ConfectionTime;
import project.models.Look;
import project.models.Matiere;
import project.models.Taille;
import project.models.Type;

public class ConfectionTimeController {

	@Url(lien = "confectionTimeInsert.do",args = true)
	public Modelview insert(int idLook, int idTaille, int idType,double temps) {
		HashMap<String,Object> o= new HashMap<>();
		Modelview result = new Modelview(o);
		ConfectionTime confectionTime = null;
		Connection con = null;
		try {
			con = DAC.getConnectionPostgreSQL("liantsiky","Mdpprom15", "poketra");
			Look look = DAO.findById(Look.class, idLook, con);
			Taille taille = DAO.findById(Taille.class, idTaille, con);
			Type type = DAO.findById(Type.class, idType, con);
			confectionTime = new ConfectionTime(look, taille, type, temps);
			DAO.insert(confectionTime, con);                     
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
	
	@Url(lien = "confectionTimeFormulaire.do",args = false)
	public Modelview formulaire() {
		HashMap<String,Object> o= new HashMap<>();
		Modelview result = new Modelview(o);
		List<Look> lookListe = null;
		List<Taille> tailleListe = null;
		List<Type> typeListe = null;
		Connection con = null;
		try {
			con = DAC.getConnectionPostgreSQL("liantsiky","Mdpprom15", "poketra");
			lookListe = DAO.findall(Look.class, con);
			tailleListe = DAO.findall(Taille.class, con);
			typeListe = DAO.findall(Type.class, con);
		} catch (Exception e) {
			// TODO: handle exception
		}
		result.addItem("looks", lookListe);
		result.addItem("tailles", tailleListe);
		result.addItem("types", typeListe);
		result.setPageJsp("ConfectionTimeFormulaire.jsp");
		return result;
	}
	
	@Url(lien = "confectionTimesDisplay.do",args = false)
	public Modelview displayAll() {
		HashMap<String,Object> o= new HashMap<>();
		Modelview result = new Modelview(o);
		List<ConfectionTime> liste = new ArrayList<ConfectionTime>();
		Connection con = null;
		try {
			con = DAC.getConnectionPostgreSQL("liantsiky","Mdpprom15", "poketra");
			liste = DAO.findall(ConfectionTime.class, con);                    
		} catch (Exception e) {
			// TODO: handle exception
		} 
//		finally {
//			con.close();
//		}
		result.addItem("liste", liste);
		result.setPageJsp("ConfectionTimesDisplay.jsp");
		return result;
	}
}
