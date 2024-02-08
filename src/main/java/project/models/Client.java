package project.models;

import java.time.LocalDate;

import ligeneric.annotation.Column;
import ligeneric.annotation.PkType;
import ligeneric.annotation.Primary;
import ligeneric.annotation.Table;

@Table(name = "client")
public class Client {
	@Primary(pktype = PkType.AUTO)
	@Column(name = "id")
	int id;
	
	@Column(name = "nom")
	String nom;
	
	@Column(name = "genre")
	int genre;
	
	@Column(name = "date_de_naissance")
	LocalDate dateDeNaissance;
	
	//constructor
	public Client() {
		// TODO Auto-generated constructor stub
	}
	public Client(String nom,int genre,LocalDate dateDeNaissance) {
		this.setNom(nom);
		this.setGenre(genre);
		this.setDateDeNaissance(dateDeNaissance);
	}

	//getters && setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public int getGenre() {
		return genre;
	}
	public void setGenre(int genre) {
		this.genre = genre;
	}
	
	public LocalDate getDateDeNaissance() {
		return dateDeNaissance;
	}
	public void setDateDeNaissance(LocalDate dateDeNaissance) {
		this.dateDeNaissance = dateDeNaissance;
	}
}
