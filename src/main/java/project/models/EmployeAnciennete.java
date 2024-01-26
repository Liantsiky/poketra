package project.models;

import ligeneric.annotation.Foreign;

public class EmployeAnciennete {
	
	@Foreign(join = "id_employe")
	Employe employe;
	
	@Foreign(join = "id_anciennete")
	Anciennete anciennete;
	
	
	double salaire;
	
	int anneeService;
	
	
	public EmployeAnciennete() {}
	
	//getters && setters
	public Employe getEmploye() {
		return employe;
	}
	public void setEmploye(Employe employe) {
		this.employe = employe;
	}
	
	public Anciennete getAnciennete() {
		return anciennete;
	}
	public void setAnciennete(Anciennete anciennete) {
		this.anciennete = anciennete;
	}
	
	public double getSalaire() {
		return salaire;
	}
	public void setSalaire(double salaire) {
		this.salaire = salaire;
	}
	
	public int getAnneeService() {
		return anneeService;
	}
	public void setAnneeService(int anneeService) {
		this.anneeService = anneeService;
	}
}
