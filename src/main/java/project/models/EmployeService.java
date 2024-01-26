package project.models;

import ligeneric.annotation.Column;
import ligeneric.annotation.Foreign;

public class EmployeService {
	
	@Foreign(join = "id_employe")
	Employe employe;
	
	@Column(name = "annee_service")
	int anneeService;
	
	//constructor
	public EmployeService() {}
	
	//getters && setters
	public Employe getEmploye() {
		return employe;
	}
	public void setEmploye(Employe employe) {
		this.employe = employe;
	}
	
	public int getAnneeService() {
		return anneeService;
	}
	public void setAnneeService(int anneeService) {
		this.anneeService = anneeService;
	}
}
