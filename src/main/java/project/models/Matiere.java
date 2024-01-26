package project.models;

import ligeneric.annotation.Column;
import ligeneric.annotation.PkType;
import ligeneric.annotation.Primary;
import ligeneric.annotation.Table;

@Table(name = "matiere")
public class Matiere {
	
	@Primary(pktype = PkType.AUTO)
	@Column(name = "id")
	int id;
	
	@Column(name = "designation")
	String designation;
	
	public Matiere() {}
	
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
}
