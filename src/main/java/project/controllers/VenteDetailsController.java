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
import project.models.Client;
import project.models.Modele;
import project.models.Vente;
import project.models.VenteDetails;

public class VenteDetailsController {
	@Url(lien = "venteDetailsInsert.do",args = true)
	public Modelview insert(int idVente,int idModele,int nombre) {
		HashMap<String,Object> o= new HashMap<>();
		Modelview result = new Modelview(o);
		VenteDetails venteDetails = new VenteDetails();
		try (Connection con = DAC.getConnectionPostgreSQL("liantsiky","Mdpprom15", "poketra")){
			Vente vente = DAO.findById(Vente.class, idVente, con);
			Modele modele = DAO.findById(Modele.class, idModele, con);
			venteDetails.setVente(vente);
			venteDetails.setModele(modele);
			venteDetails.setNombre(nombre);
			DAO.insert(venteDetails, con);                     
		} catch (Exception e) {
			// TODO: handle exception
		} 
		result.addItem("depense", "Hello");
		result.setPageJsp("Succes.jsp");
		return result;
	}
	
	@Url(lien = "venteDetailsFormulaire.do",args = false)
	public Modelview formulaire() {
		HashMap<String,Object> o= new HashMap<>();
		Modelview result = new Modelview(o);

		result.addItem("depense", "Hello"); //sous-forme
		result.setPageJsp("VenteDetailsFormulaire.jsp");
		return result;
	}
	
	@Url(lien = "venteDetailsDisplay.do",args = false)
	public Modelview displayAll() {
		HashMap<String,Object> o= new HashMap<>();
		Modelview result = new Modelview(o);
		List<VenteDetails> liste = new ArrayList<VenteDetails>();
		try(Connection con = DAC.getConnectionPostgreSQL("liantsiky","Mdpprom15", "poketra")) {
			liste = DAO.findall(VenteDetails.class, con);                    
		} catch (Exception e) {
			// TODO: handle exception
		} 
		result.addItem("liste", liste);
		result.setPageJsp("VenteDetailsDisplay.jsp");
		return result;
	}
}
