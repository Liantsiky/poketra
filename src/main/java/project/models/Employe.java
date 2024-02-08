package project.models;

import java.time.LocalDate;

import ligeneric.annotation.Column;
import ligeneric.annotation.Foreign;
import ligeneric.annotation.PkType;
import ligeneric.annotation.Primary;
import ligeneric.annotation.Table;

@Table(name = "employe")
public class Employe {
	
	@Primary(pktype = PkType.AUTO)
	@Column(name = "id")
	int id;
	
	@Column(name = "nom")
	String nom;
	
	@Column(name = "prenom")
	String prenom;
	
	@Column(name = "date_de_naissance")
	LocalDate dateDeNaissance;
	
	@Foreign(join = "id_poste")
	Poste poste;
	
	@Column(name = "date_embauche")
	LocalDate dateEmbauche;
	
	
	//constructor
	public Employe() {}
	
	public Employe(String nom,String prenom,Poste poste,LocalDate dateDeNaissance,LocalDate dateEmbauche) {
		this.setNom(nom);
		this.setPrenom(prenom);
		this.setPoste(poste);
		this.setDateDeNaissance(dateDeNaissance);
		this.setDateEmbauche(dateEmbauche);
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
	
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	public LocalDate getDateDeNaissance() {
		return dateDeNaissance;
	}
	public void setDateDeNaissance(LocalDate dateDeNaissance) {
		this.dateDeNaissance = dateDeNaissance;
	}
	
	public Poste getPoste() {
		return poste;
	}
	public void setPoste(Poste poste) {
		this.poste = poste;
	}
	
	public LocalDate getDateEmbauche() {
		return dateEmbauche;
	}
	public void setDateEmbauche(LocalDate dateEmbauche) {
		this.dateEmbauche = dateEmbauche;
	}
}
