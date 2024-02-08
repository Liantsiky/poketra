package project.models;

import ligeneric.annotation.Column;
import ligeneric.annotation.Foreign;

public class ModelePrixConfection {
	@Foreign(join = "id_modele")
	Modele modele;
	
	@Column(name = "total")
	double total;
	
	public ModelePrixConfection() {
		// TODO Auto-generated constructor stub
	}
	
	//getters && setters
	public Modele getModele() {
		return modele;
	}
	public void setModele(Modele modele) {
		this.modele = modele;
	}
	
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	
}
