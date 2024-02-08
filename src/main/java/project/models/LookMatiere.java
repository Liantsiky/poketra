package project.models;

import ligeneric.annotation.Column;
import ligeneric.annotation.Foreign;
import ligeneric.annotation.PkType;
import ligeneric.annotation.Primary;
import ligeneric.annotation.Table;

@Table(name = "look_matiere")
public class LookMatiere {
	
	@Primary(pktype = PkType.AUTO)
	@Column(name = "id")
	int id;
	
	@Foreign(join = "id_look")
	Look look;
	
	@Foreign(join = "id_matiere")
	Matiere matiere;
	
	//constructor
	public LookMatiere() {}
	
	//getters && setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public Look getLook() {
		return look;
	}
	public void setLook(Look look) {
		this.look = look;
	}
	
	public Matiere getMatiere() {
		return matiere;
	}
	public void setMatiere(Matiere matiere) {
		this.matiere = matiere;
	}
}
