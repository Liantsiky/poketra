package project.models;

import java.time.LocalDate;

import ligeneric.annotation.Column;
import ligeneric.annotation.Foreign;
import ligeneric.annotation.PkType;
import ligeneric.annotation.Primary;
import ligeneric.annotation.Table;

@Table(name = "vente")
public class Vente {
	@Primary(pktype = PkType.AUTO)
	@Column(name = "id")
	int id;
	
	@Foreign(join = "id_client")
	Client client;
	
	@Column(name = "date_vente")
	LocalDate dateVente;
	
	//constructor
	public Vente() {
		// TODO Auto-generated constructor stub
	}
	
	//getters && setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	
	public LocalDate getDateVente() {
		return dateVente;
	}
	public void setDateVente(LocalDate dateVente) {
		this.dateVente = dateVente;
	}
}
