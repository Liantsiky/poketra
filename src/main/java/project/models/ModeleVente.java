package project.models;

import ligeneric.annotation.Column;
import ligeneric.annotation.Foreign;

public class ModeleVente {
	@Foreign(join = "id_modele")
	Modele modele;
	
	@Column(name = "total")
	int total;
	
	public ModeleVente() {
		// TODO Auto-generated constructor stub
	}
	
	//getters && setters 
	public Modele getModele() {
		return modele;
	}
	public void setModele(Modele modele) {
		this.modele = modele;
	}
	
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
}
