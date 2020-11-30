package POJO;

import java.io.Serializable;

import DAO.*;

public class Configuration implements Serializable {

	private static final long serialVersionUID = -4973296506746715437L;
	protected static DAOFactory factory = (DAOFactory)DAOFactory.getFactory(0);
	protected static ConfigurationDAO dao = factory.getConfigurationDAO();

	//ATTRIBUTS
	private int id;
	private String type;
	private Categorie categorie;
	
	//CONSTRUCTEURS
	public Configuration() {
		
	}
	
	public Configuration(String type) {
		this.type = type;
	}
	
	public Configuration(int id,String type) {
		this.id = id;
		this.type = type;
	}
	
	
	public Configuration(String type, Categorie categorie) {
		this.type = type;
		this.categorie = categorie;
	}
	
	
	public Configuration(int id, String type, Categorie categorie) {
		this.id = id;
		this.type = type;
		this.categorie = categorie;
	}
	
	//ACCESSEURS
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	
	public Categorie getCategorie() {
		return categorie;
	}
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
	
	public int getNbrResteCategorie() {
		return categorie.getNbrPlaceDispo();
	}

	//METHODES
	//Ajouter une configuration
	public boolean ajouterConfiguration() {
		return dao.create(this);
	}

	public boolean ajouterIdSpectacle(Spectacle s) {
		dao.create(this);
		return dao.AjouterAvecIdSpectacle(s);
	}
	
	//Trouver une configuration
	public Configuration find(Spectacle s)
	{
		return dao.findByIdSpectacle(s.getId());
	}	
	
	//Afficher une configuration
	public String toString() {
		return id + " " + type + " " + categorie;
	}
	
	//Envoye l'objet pour ajouter une categorie
	public boolean ajouterCategorie(Categorie c) {
		return c.ajouterCategorie(this);
	}
	


}
