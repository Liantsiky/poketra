package project.models;

import ligeneric.annotation.Column;
import ligeneric.annotation.Foreign;

public class EmployeSalaire {
	@Foreign(join = "id_employe")
	Employe employe;
	
	@Foreign(join = "id_poste")
	Poste poste;
	
	@Column(name = "niveau")
	String niveau;
	
	@Column(name = "service")
	int anneeService;
	
	@Column(name = "salaire")
	double salaire;
	
	public EmployeSalaire() {
		// TODO Auto-generated constructor stub
	}
	
	//getters && setters
	public Employe getEmploye() {
		return employe;
	}
	public void setEmploye(Employe employe) {
		this.employe = employe;
	}
	
	public Poste getPoste() {
		return poste;
	}
	public void setPoste(Poste poste) {
		this.poste = poste;
	}
	
	public int getAnneeService() {
		return anneeService;
	}
	public void setAnneeService(int anneeService) {
		this.anneeService = anneeService;
	}
	
	public String getNiveau() {
		return niveau;
	}
	public void setNiveau(String niveau) {
		this.niveau = niveau;
	}
	
	public double getSalaire() {
		return salaire;
	}
	public void setSalaire(double salaire) {
		this.salaire = salaire;
	}
}
