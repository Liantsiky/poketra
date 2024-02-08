package project.models;

import ligeneric.annotation.Column;
import ligeneric.annotation.Foreign;
import ligeneric.annotation.PkType;
import ligeneric.annotation.Primary;
import ligeneric.annotation.Table;

@Table(name = "confection_time")
public class ConfectionTime {
	
	@Primary(pktype = PkType.AUTO)
	@Column(name = "id")
	int id;
	
	@Foreign(join = "id_type")
	Type type;
	
	@Foreign(join = "id_look")
	Look look;
	
	@Foreign(join = "id_taille")
	Taille taille;
	
	@Column(name = "temps")
	double temps;
	
	//contructor
	public ConfectionTime() {}
	
	public ConfectionTime(Look look,Taille taille,Type type,double temps) {
		this.setLook(look);
		this.setTaille(taille);
		this.setType(type);
		this.setTemps(temps);
	}
	//getters && setters 
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}
	
	public Look getLook() {
		return look;
	}
	public void setLook(Look look) {
		this.look = look;
	}
	
	public Taille getTaille() {
		return taille;
	}
	public void setTaille(Taille taille) {
		this.taille = taille;
	}
	
	public double getTemps() {
		return temps;
	}
	public void setTemps(double temps) {
		this.temps = temps;
	}
	
}
