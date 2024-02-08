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

public class ClientController {
	
	@Url(lien = "clientInsert.do",args = true)
	public Modelview insert(String nom,boolean genre,LocalDate dateDeNaissance) {
		HashMap<String,Object> o= new HashMap<>();
		Modelview result = new Modelview(o);
		Client client = new Client(nom,genre,dateDeNaissance);
		try (Connection con = DAC.getConnectionPostgreSQL("liantsiky","Mdpprom15", "poketra")) {
			DAO.insert(client, con);                     
		} catch (Exception e) {
			// TODO: handle exception
		} 
		result.addItem("depense", "Hello");
		result.setPageJsp("Succes.jsp");
		return result;
	}
	
	@Url(lien = "clientFormulaire.do",args = false)
	public Modelview formulaire() {
		HashMap<String,Object> o= new HashMap<>();
		Modelview result = new Modelview(o);

		result.addItem("depense", "Hello"); //sous-forme
		result.setPageJsp("ClientFormulaire.jsp");
		return result;
	}
	
	@Url(lien = "clientsDisplay.do",args = false)
	public Modelview displayAll() {
		HashMap<String,Object> o= new HashMap<>();
		Modelview result = new Modelview(o);
		List<Client> liste = new ArrayList<Client>();
		try(Connection 	con = DAC.getConnectionPostgreSQL("liantsiky","Mdpprom15", "poketra")) {
		
			liste = DAO.findall(Client.class, con);                    
		} catch (Exception e) {
			// TODO: handle exception
		} 
		result.addItem("liste", liste);
		result.setPageJsp("ClientsDisplay.jsp");
		return result;
	}
}
