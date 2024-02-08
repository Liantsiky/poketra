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
import project.models.GenreVente;
import project.models.Modele;
import project.models.ModeleVente;
import project.models.Vente;

public class VenteController {
	
	@Url(lien = "venteGenre.do",args = false)
	public Modelview venteGenre() {
		HashMap<String,Object> o= new HashMap<>();
		Modelview result = new Modelview(o);
		List<Modele> liste = new ArrayList<Modele>();
		try (Connection con = DAC.getConnectionPostgreSQL("liantsiky","Mdpprom15", "poketra")){
			liste = DAO.findall(Modele.class, con);
			             
		} catch (Exception e) {
			// TODO: handle exception
		} 
		result.addItem("liste", liste);
		result.setPageJsp("VenteGenre.jsp");
		return result;
	}
	
	@Url(lien = "venteGenreResult.do",args = true)
	public Modelview venteGenreResult(int idModele) {
		HashMap<String,Object> o= new HashMap<>();
		Modelview result = new Modelview(o);
		List <GenreVente> liste = new ArrayList<GenreVente>();
		ModeleVente modeleVente = new ModeleVente();
		try (Connection con = DAC.getConnectionPostgreSQL("liantsiky","Mdpprom15", "poketra")){
			modeleVente = DAO.findPredicatView(ModeleVente.class, "v_total_vente", con, "id_modele="+idModele).get(0);
			liste = DAO.findPredicatView(GenreVente.class, "v_vente_genre", con, "id_modele="+idModele);
			             
		} catch (Exception e) {
			System.out.println(e);		
			} 
		result.addItem("liste", liste);
		result.addItem("modeleVente", modeleVente);
		result.setPageJsp("VenteGenreResult.jsp");
		return result;
	}
	
	@Url(lien = "venteInsert.do",args = true)
	public Modelview insert(int idClient,LocalDate dateVente) {
		HashMap<String,Object> o= new HashMap<>();
		Modelview result = new Modelview(o);
		Vente vente = new Vente();
		try (Connection con = DAC.getConnectionPostgreSQL("liantsiky","Mdpprom15", "poketra")){
			Client client = DAO.findById(Client.class, idClient, con);
			vente.setClient(client);
			vente.setDateVente(dateVente);
			DAO.insert(vente, con);                     
		} catch (Exception e) {
			// TODO: handle exception
		} 
		result.addItem("depense", "Hello");
		result.setPageJsp("Succes.jsp");
		return result;
	}
	
	@Url(lien = "venteFormulaire.do",args = false)
	public Modelview formulaire() {
		HashMap<String,Object> o= new HashMap<>();
		Modelview result = new Modelview(o);

		result.addItem("depense", "Hello"); //sous-forme
		result.setPageJsp("VenteFormulaire.jsp");
		return result;
	}
	
	@Url(lien = "ventesDisplay.do",args = false)
	public Modelview displayAll() {
		HashMap<String,Object> o= new HashMap<>();
		Modelview result = new Modelview(o);
		List<Vente> liste = new ArrayList<Vente>();
		try(Connection con = DAC.getConnectionPostgreSQL("liantsiky","Mdpprom15", "poketra")) {
			liste = DAO.findall(Vente.class, con);                    
		} catch (Exception e) {
			// TODO: handle exception
		} 
		result.addItem("liste", liste);
		result.setPageJsp("VentesDisplay.jsp");
		return result;
	}
}
