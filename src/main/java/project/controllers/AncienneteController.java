package project.controllers;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import etu2050.framework.Modelview;
import etu2050.framework.annotations.Url;
import ligeneric.dac.DAC;
import ligeneric.dao.DAO;
import project.models.Anciennete;
import project.models.Look;
import project.models.Matiere;
import project.models.Taille;

public class AncienneteController {
	@Url(lien = "ancienneteInsert.do",args = true)
	public Modelview insert(int anneeMin,int anneeMax,String designation,double tauxAugmentation) {
		HashMap<String,Object> o= new HashMap<>();
		Modelview result = new Modelview(o);
		Anciennete anciennete = null;
		try (Connection con = DAC.getConnectionPostgreSQL("liantsiky","Mdpprom15", "poketra")){
			anciennete = new Anciennete(anneeMin, anneeMax, designation, tauxAugmentation);
			DAO.insert(anciennete, con);                     
		} catch (Exception e) {
			// TODO: handle exception
		} 
		result.addItem("depense", "Hello");
		result.setPageJsp("Succes.jsp");
		return result;
	}
	
	@Url(lien = "ancienneteFormulaire.do",args = false)
	public Modelview formulaire() {
		HashMap<String,Object> o= new HashMap<>();
		Modelview result = new Modelview(o);
		result.addItem("matieres", "hello");
		result.setPageJsp("AncienneteFormulaire.jsp");
		return result;
	}
	
	@Url(lien = "anciennetesDisplay.do",args = false)
	public Modelview displayAll() {
		HashMap<String,Object> o= new HashMap<>();
		Modelview result = new Modelview(o);
		List<Anciennete> liste = new ArrayList<Anciennete>();
		try (Connection con =  DAC.getConnectionPostgreSQL("liantsiky","Mdpprom15", "poketra")){
			liste = DAO.findall(Anciennete.class, con);                    
		} catch (Exception e) {
			// TODO: handle exception
		} 
//		finally {
//			con.close();
//		}
		result.addItem("liste", liste);
		result.setPageJsp("AnciennetesDisplay.jsp");
		return result;
	}
}
