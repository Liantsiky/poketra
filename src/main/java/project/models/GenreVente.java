package project.models;

import ligeneric.annotation.Column;
import ligeneric.annotation.Foreign;

public class GenreVente {
	@Foreign(join = "id_modele")
	Modele modele;
	
	@Column(name = "nombre")
	int nombre;
	
//	@Column(name = "nombre_genre")
//	int nombreGenre;
	
	@Column(name = "genre")
	int genre;
	
	public GenreVente() {
		// TODO Auto-generated constructor stub
	}
	public String getGenreString(){
		String result = "Homme";
		if(this.getGenre() == 0) {
			result = "Femme";
		}
		return result;
	}
	//getters && setters 
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
	
//	public int getNombreGenre() {
//		return nombreGenre;
//	}
//	public void setNombreGenre(int nombreGenre) {
//		this.nombreGenre = nombreGenre;
//	}
//	
	public int getGenre() {
		return this.genre;
	}
	public void setGenre(int genre) {
		this.genre = genre;
	}
}
