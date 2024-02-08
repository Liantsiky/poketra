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
import project.models.Matiere;
import project.models.Modele;
import project.models.ModeleBenefice;
import project.models.ModelePrixConfection;
import project.models.Type;

public class ModeleController {
	
	@Url(lien = "beneficeCompare.do",args = false)
	public Modelview beneficeCompare() {
		HashMap<String,Object> o= new HashMap<>();
		Modelview result = new Modelview(o);

		result.addItem("depense", "Hello"); //sous-forme
		result.setPageJsp("BeneficeCompare.jsp");
		return result;
	}
	
	@Url(lien = "beneficeCompareResult.do",args = true)
	public Modelview beneficeCompareResult(double minimum,double maximum) {
		HashMap<String,Object> o= new HashMap<>();
		Modelview result = new Modelview(o);
		List <ModeleBenefice> liste = new ArrayList<ModeleBenefice>();
		try (Connection con = DAC.getConnectionPostgreSQL("liantsiky","Mdpprom15", "poketra")){
			liste = DAO.findPredicatView(ModeleBenefice.class, "v_benefice", con, "benefice>="+minimum +" and benefice<="+maximum);                   
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		} 
		result.addItem("liste", liste);
		result.addItem("minimum",minimum);
		result.addItem("maximum", maximum);
		result.setPageJsp("BeneficeCompareResult.jsp");
		return result;
	}
	@Url(lien = "confectionPriceCompare.do",args = false)
	public Modelview confectionPriceCompare() {
		HashMap<String,Object> o= new HashMap<>();
		Modelview result = new Modelview(o);

		result.addItem("depense", "Hello"); //sous-forme
		result.setPageJsp("ConfectionPriceCompare.jsp");
		return result;
	}
	
	@Url(lien = "confectionPriceCompareResult.do",args = true)
	public Modelview confectionPriceCompareResult(double minimum,double maximum) {
		HashMap<String,Object> o= new HashMap<>();
		Modelview result = new Modelview(o);
		List <ModelePrixConfection> liste = new ArrayList<ModelePrixConfection>();
		try (Connection con = DAC.getConnectionPostgreSQL("liantsiky","Mdpprom15", "poketra")){
			liste = DAO.findPredicatView(ModelePrixConfection.class, "v_mp_prix_confection", con, "total>="+minimum +" and total<="+maximum);                   
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		} 
		result.addItem("liste", liste);
		result.addItem("minimum",minimum);
		result.addItem("maximum", maximum);
		result.setPageJsp("ConfectionPriceCompareResult.jsp");
		return result;
	}
	@Url(lien = "modeleInsert.do",args = true)
	public Modelview insert(int idType, int idLook, double prix) {
		HashMap<String,Object> o= new HashMap<>();
		Modelview result = new Modelview(o);
		Modele modele = new Modele();
		try (Connection con = DAC.getConnectionPostgreSQL("liantsiky","Mdpprom15", "poketra")){
			Type type = DAO.findById(Type.class, idType, con);
			Look look = DAO.findById(Look.class, idLook, con);
			modele.setType(type);
			modele.setLook(look);
			modele.setPrix(prix);
			DAO.insert(modele, con);                     
		} catch (Exception e) {
			// TODO: handle exception
		} 
		result.addItem("depense", "Hello");
		result.setPageJsp("Succes.jsp");
		return result;
	}
	
	@Url(lien = "modeleFormulaire.do",args = false)
	public Modelview formulaire() {
		HashMap<String,Object> o= new HashMap<>();
		Modelview result = new Modelview(o);

		result.addItem("depense", "Hello"); //sous-forme
		result.setPageJsp("ModeleFormulaire.jsp");
		return result;
	}
	
	@Url(lien = "modelesDisplay.do",args = false)
	public Modelview displayAll() {
		HashMap<String,Object> o= new HashMap<>();
		Modelview result = new Modelview(o);
		List<Modele> liste = new ArrayList<Modele>();
		try(Connection con = DAC.getConnectionPostgreSQL("liantsiky","Mdpprom15", "poketra")) {
			liste = DAO.findall(Modele.class, con);                    
		} catch (Exception e) {
			// TODO: handle exception
		} 
		result.addItem("liste", liste);
		result.setPageJsp("ModelesDisplay.jsp");
		return result;
	}
}
