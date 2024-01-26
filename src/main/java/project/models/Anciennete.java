package project.models;

import ligeneric.annotation.Column;
import ligeneric.annotation.PkType;
import ligeneric.annotation.Primary;
import ligeneric.annotation.Table;

@Table(name = "anciennete")
public class Anciennete {
	
	@Primary(pktype = PkType.AUTO)
	@Column(name = "id")
	int id;
	
	@Column(name = "annee_min")
	int anneeMin;
	
	@Column(name = "annee_max")
	int anneeMax;
	
	@Column(name = "designation")
	String designation;
	
	@Column(name = "taux_augmentation")
	double tauxAugmentation;
	
	public Anciennete() {}
	
	//getters && setters
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public int getAnneeMin() {
		return anneeMin;
	}
	public void setAnneeMin(int anneeMin) {
		this.anneeMin = anneeMin;
	}
	
	public int getAnneeMax() {
		return anneeMax;
	}
	public void setAnneeMax(int anneeMax) {
		this.anneeMax = anneeMax;
	}
	
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	
	public double getTauxAugmentation() {
		return tauxAugmentation;
	}
	public void setTauxAugmentation(double tauxAugmentation) {
		this.tauxAugmentation = tauxAugmentation;
	}
	
}
