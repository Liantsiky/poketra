package project.models;

import ligeneric.annotation.Column;
import ligeneric.annotation.PkType;
import ligeneric.annotation.Primary;
import ligeneric.annotation.Table;

@Table(name = "poste")
public class Poste {
	
	@Primary(pktype = PkType.AUTO)
	@Column(name = "id")
	int id;
	
	@Column(name = "designation")
	String designation;
	
	@Column(name = "taux_horaire")
	double tauxHoraire;
	
	public Poste() {}
	
	//getters && setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	
	public double getTauxHoraire() {
		return tauxHoraire;
	}
	public void setTauxHoraire(double tauxHoraire) {
		this.tauxHoraire = tauxHoraire;
	}
}
