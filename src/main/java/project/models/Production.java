package project.models;

import java.time.LocalDate;

import ligeneric.annotation.Column;
import ligeneric.annotation.Foreign;
import ligeneric.annotation.PkType;
import ligeneric.annotation.Primary;
import ligeneric.annotation.Table;

@Table(name = "production")
public class Production {
	
	@Primary(pktype = PkType.AUTO)
	@Column(name = "id")
	int id;
	
	@Foreign(join = "id_modele")
	Modele modele;
	
	@Column(name = "nombre")
	int nombre;
	
	@Column(name = "date_production")
	LocalDate dateProduction;
	
	//constructor
	public Production() {}
	
	//getters && setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public Modele getModele() {
		return modele;
	}
	public void setModele(Modele modele) {
		this.modele = modele;
	}
	
	public int getNombre() {
		return nombre;
	}
	public void setNombre(int nombre) {
		this.nombre = nombre;
	}
	
	public LocalDate getDateProduction() {
		return dateProduction;
	}
	public void setDateProduction(LocalDate dateProduction) {
		this.dateProduction = dateProduction;
	}

}
