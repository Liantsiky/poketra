package project.controllers;

import java.sql.Connection;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import etu2050.framework.Modelview;
import etu2050.framework.annotations.Url;
import ligeneric.dac.DAC;
import ligeneric.dao.DAO;
import project.models.Modele;
import project.models.ModeleVente;
import project.models.Production;

public class ProductionController {
	
	@Url(lien = "stock.do",args = false)
	public Modelview stock() {
		HashMap<String,Object> o= new HashMap<>();
		Modelview result = new Modelview(o);
		List <ModeleVente> liste = new ArrayList<ModeleVente>();
		try (Connection con = DAC.getConnectionPostgreSQL("liantsiky","Mdpprom15", "poketra")){
			liste = DAO.findallView(ModeleVente.class, "v_stock", con);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		} 
		result.addItem("liste", liste);
		result.setPageJsp("Stock.jsp");
		return result;
	}
	
	@Url(lien = "productionInsert.do",args = true)
	public Modelview insert(int idModele, int nombre, LocalDate dateProduction) {
		HashMap<String,Object> o= new HashMap<>();
		Modelview result = new Modelview(o);
		Production production = new Production();
		try (Connection con = DAC.getConnectionPostgreSQL("liantsiky","Mdpprom15", "poketra")){
			Modele modele = DAO.findById(Modele.class, idModele, con);
			production.setModele(modele);
			production.setNombre(nombre);
			production.setDateProduction(dateProduction);
			DAO.insert(production, con);                     
		} catch (Exception e) {
			// TODO: handle exception
		} 
		result.addItem("depense", "Hello");
		result.setPageJsp("Succes.jsp");
		return result;
	}
	
	@Url(lien = "productionFormulaire.do",args = false)
	public Modelview formulaire() {
		HashMap<String,Object> o= new HashMap<>();
		Modelview result = new Modelview(o);

		result.addItem("depense", "Hello"); //sous-forme
		result.setPageJsp("ProductionFormulaire.jsp");
		return result;
	}
	
	@Url(lien = "productionsDisplay.do",args = false)
	public Modelview displayAll() {
		HashMap<String,Object> o= new HashMap<>();
		Modelview result = new Modelview(o);
		List<Production> liste = new ArrayList<Production>();
		try(Connection con = DAC.getConnectionPostgreSQL("liantsiky","Mdpprom15", "poketra")) {
			liste = DAO.findall(Production.class, con);                    
		} catch (Exception e) {
			// TODO: handle exception
		} 
		result.addItem("liste", liste);
		result.setPageJsp("ProductionsDisplay.jsp");
		return result;
	}
}
