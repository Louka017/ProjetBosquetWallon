package POJO;

import java.io.Serializable;

import DAO.AbstractDAOFactory;
import DAO.DAO;

public class Place implements Serializable {

	//Attriubts
	private static final long serialVersionUID = -3048706543695775020L;
	AbstractDAOFactory adf = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
	DAO<Place> dao = adf.getPlaceDAO();
	private int prix;
	private int numPlace;
	private Representation representation;
	
	//Constructeur
	public Place(int numPlace, int prix, Representation representation) {
		this.numPlace = numPlace;
		this.prix = prix;
		this.representation = representation;
	}
	
	//Accesseurs
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

}
