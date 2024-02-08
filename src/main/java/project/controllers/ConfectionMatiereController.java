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
import project.models.Look;
import project.models.Matiere;
import project.models.Poste;
import project.models.Taille;

public class ConfectionMatiereController {
	@Url(lien = "confectionMatiereInsert.do",args = true)
	public Modelview insert(int idLook, int idTaille, int idMatiere,double quantite) {
		HashMap<String,Object> o= new HashMap<>();
		Modelview result = new Modelview(o);
		ConfectionMatiere confectionMatiere = null;
		Connection con = null;
		try {
			con = DAC.getConnectionPostgreSQL("liantsiky","Mdpprom15", "poketra");
			Look look = DAO.findById(Look.class, idLook, con);
			Taille taille = DAO.findById(Taille.class, idTaille, con);
			Matiere matiere = DAO.findById(Matiere.class, idMatiere, con);
			confectionMatiere = new ConfectionMatiere(look, taille, matiere, quantite);
			DAO.insert(confectionMatiere, con);                     
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
	
	@Url(lien = "confectionMatiereFormulaire.do",args = false)
	public Modelview formulaire() {
		HashMap<String,Object> o= new HashMap<>();
		Modelview result = new Modelview(o);
		List<Look> lookListe = null;
		List<Taille> tailleListe = null;
		List<Matiere> matiereListe = null;
		Connection con = null;
		try {
			con = DAC.getConnectionPostgreSQL("liantsiky","Mdpprom15", "poketra");
			lookListe = DAO.findall(Look.class, con);
			tailleListe = DAO.findall(Taille.class, con);
			matiereListe = DAO.findall(Matiere.class, con);
		} catch (Exception e) {
			// TODO: handle exception
		}
		result.addItem("looks", lookListe);
		result.addItem("tailles", tailleListe);
		result.addItem("matieres", matiereListe);
		result.setPageJsp("ConfectionMatiereFormulaire.jsp");
		return result;
	}
	
	@Url(lien = "confectionMatieresDisplay.do",args = false)
	public Modelview displayAll() {
		HashMap<String,Object> o= new HashMap<>();
		Modelview result = new Modelview(o);
		List<ConfectionMatiere> liste = new ArrayList<ConfectionMatiere>();
		Connection con = null;
		try {
			con = DAC.getConnectionPostgreSQL("liantsiky","Mdpprom15", "poketra");
			liste = DAO.findall(ConfectionMatiere.class, con);                    
		} catch (Exception e) {
			// TODO: handle exception
		} 
//		finally {
//			con.close();
//		}
		result.addItem("liste", liste);
		result.setPageJsp("ConfectionMatieresDisplay.jsp");
		return result;
	}
}
