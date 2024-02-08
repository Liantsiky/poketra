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
import project.models.Matiere;
import project.models.ModeleMatiere;
import project.models.Taille;

public class MatiereController {

	@Url(lien = "matiereInsert.do",args = true)
	public Modelview insert(String designation) {
		HashMap<String,Object> o= new HashMap<>();
		Modelview result = new Modelview(o);
		Matiere matiere = new Matiere();
		matiere.setDesignation(designation);
		try (Connection con = DAC.getConnectionPostgreSQL("liantsiky","Mdpprom15", "poketra")){
			DAO.insert(matiere, con);                     
		} catch (Exception e) {
			// TODO: handle exception
		} 
		result.addItem("depense", "Hello");
		result.setPageJsp("Succes.jsp");
		return result;
	}
	
	@Url(lien = "matiereFormulaire.do",args = false)
	public Modelview formulaire() {
		HashMap<String,Object> o= new HashMap<>();
		Modelview result = new Modelview(o);

		result.addItem("depense", "Hello"); //sous-forme
		result.setPageJsp("MatiereFormulaire.jsp");
		return result;
	}
	
	@Url(lien = "matieresDisplay.do",args = false)
	public Modelview displayAll() {
		HashMap<String,Object> o= new HashMap<>();
		Modelview result = new Modelview(o);
		List<Matiere> liste = new ArrayList<Matiere>();
		try(Connection con = DAC.getConnectionPostgreSQL("liantsiky","Mdpprom15", "poketra")) {
			liste = DAO.findall(Matiere.class, con);                    
		} catch (Exception e) {
			// TODO: handle exception
		} 
		result.addItem("liste", liste);
		result.setPageJsp("MatieresDisplay.jsp");
		return result;
	}
	
	@Url(lien = "matieresChoosing.do",args = false)
	public Modelview choosing() {
		HashMap<String,Object> o= new HashMap<>();
		Modelview result = new Modelview(o);
		List<Matiere> liste = new ArrayList<Matiere>();
		try(Connection con = DAC.getConnectionPostgreSQL("liantsiky","Mdpprom15", "poketra")) {
			liste = DAO.findall(Matiere.class, con);                    
		} catch (Exception e) {
			// TODO: handle exception
		} 
		result.addItem("liste", liste);
		result.setPageJsp("MatieresChoosing.jsp");
		return result;
	}
	
	@Url(lien = "matieresChoosingResult.do",args = true)
	public Modelview choosingResult(int idMatiere) {
		HashMap<String,Object> o= new HashMap<>();
		Modelview result = new Modelview(o);
		List<ModeleMatiere> liste = new ArrayList<ModeleMatiere>();
		try(Connection con = DAC.getConnectionPostgreSQL("liantsiky","Mdpprom15", "poketra")) {
			liste = DAO.findPredicat(ModeleMatiere.class, con, "id_matiere="+idMatiere);
			for (ModeleMatiere modeleMatiere : liste) {
				String predicat = "id_matiere="+idMatiere+" and id_look="+modeleMatiere.getModele().getLook().getId()+" and id_taille="+modeleMatiere.getModele().getTaille().getId();               
				modeleMatiere.getModele().setConfectionMatieres(DAO.findPredicat(ConfectionMatiere.class, con, predicat));
			}
		} catch (Exception e) {
			System.out.println(e);
		} 
		result.addItem("liste", liste);
		result.setPageJsp("MatieresChoosingResult.jsp");
		return result;
	}
}
