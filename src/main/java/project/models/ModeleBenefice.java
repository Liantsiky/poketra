package project.models;

import ligeneric.annotation.Column;
import ligeneric.annotation.Foreign;

public class ModeleBenefice {
	@Foreign(join = "id_modele")
	
	Modele modele;
	@Column(name = "benefice")
	double benefice;
	
	public ModeleBenefice() {
		// TODO Auto-generated constructor stub
	}
	
	//getters and setters
	public Modele getModele() {
		return modele;
	}
	public void setModele(Modele modele) {
		this.modele = modele;
	}
	
	public double getBenefice() {
		return benefice;
	}
	public void setBenefice(double benefice) {
		this.benefice = benefice;
	}
	
}
