package POJO;

import java.io.Serializable;

import DAO.*;

public class Place implements Serializable {

	private static final long serialVersionUID = -3048706543695775020L;
	protected static DAOFactory factory = (DAOFactory)DAOFactory.getFactory(0);
	protected static PlaceDAO dao = factory.getPlaceDAO();
	
	//ATTRIBUTS
	private int id;
	private int prix;
	private int numPlace;
	private Representation representation;
	
	//CONSTRCTEUR
	public Place() {

	}
	
	public Place(int prix) {
		this.prix = prix;
	}
	
	public Place(int numPlace, int prix, Representation representation) {
		this.numPlace = numPlace;
		this.prix = prix;
		this.representation = representation;
	}
	
	//ACCESSEURS
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public int getPrix() {
		return prix;
	}
	public void setPrix(int prix) {
		this.prix = prix;
	}
	
	
	public int getNumPlace() {
		return numPlace;
	}
	public void setNumPlace(int numPlace) {
		this.numPlace = numPlace;
	}
	
	
	public Representation getRepresentation() {
		return representation;
	}
	public void setRepresentation(Representation representation) {
		this.representation = representation;
	}

	//METHODES
	public boolean ajout(Representation r) {
		dao.create(this);
		
		return dao.createAvecRepresentation(r);
	}
	
	public boolean ajoutCommande(Commande c) {
		return dao.createInPlaceCommande(this, c);
	}
	
	public Place findByAll() {
		return this;
	}

}
