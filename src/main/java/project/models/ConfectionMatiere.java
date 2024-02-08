package project.models;

import ligeneric.annotation.Column;
import ligeneric.annotation.Foreign;
import ligeneric.annotation.PkType;
import ligeneric.annotation.Primary;
import ligeneric.annotation.Table;

@Table(name = "confection_matiere")
public class ConfectionMatiere {
	
	@Primary(pktype = PkType.AUTO)
	@Column(name = "id")
	int id;
	
	@Foreign(join = "id_look")
	Look look;
	
	@Foreign(join = "id_taille")
	Taille taille;
	
	@Foreign(join = "id_matiere")
	Matiere matiere;
	
	@Column(name = "quantite")
	double quantite;
	
	//constructor
	public ConfectionMatiere() {}
	
	public ConfectionMatiere (Look look,Taille taille,Matiere matiere,double quantite) {
		this.setLook(look);
		this.setTaille(taille);
		this.setMatiere(matiere);
		this.setQuantite(quantite);
	}
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
	
	public Taille getTaille() {
		return taille;
	}
	public void setTaille(Taille taille) {
		this.taille = taille;
	}
	
	public Matiere getMatiere() {
		return matiere;
	}
	public void setMatiere(Matiere matiere) {
		this.matiere = matiere;
	}
	
	public double getQuantite() {
		return quantite;
	}
	public void setQuantite(double quantite) {
		this.quantite = quantite;
	}
	
}
