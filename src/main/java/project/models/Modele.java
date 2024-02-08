package project.models;

import java.util.List;

import ligeneric.annotation.Column;
import ligeneric.annotation.Foreign;
import ligeneric.annotation.PkType;
import ligeneric.annotation.Primary;
import ligeneric.annotation.Table;

@Table(name = "modele")
public class Modele {
	@Primary(pktype = PkType.AUTO)
	@Column(name = "id")
	int id;
	
	@Foreign(join = "id_type")
	Type type;
	
	@Foreign(join = "id_look")
	Look look;
	
	@Foreign(join = "id_taille")
	Taille taille;
	
	@Column(name = "prix")
	double prix;
	
//	List<Matiere> matieres;
	
	List<ConfectionMatiere> confectionMatieres;
	
	//constructor
	public Modele() {
		// TODO Auto-generated constructor stub
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
	
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
//	
//	public List<Matiere> getMatieres() {
//		return matieres;
//	}
//	public void setMatieres(List<Matiere> matieres) {
//		this.matieres = matieres;
//	}
	
	public List<ConfectionMatiere> getConfectionMatieres() {
		return confectionMatieres;
	}
	public void setConfectionMatieres(List<ConfectionMatiere> confectionMatieres) {
		this.confectionMatieres = confectionMatieres;
	}
	
}
