package POJO;

import java.io.Serializable;

import DAO.*;

public class Configuration implements Serializable {

	//Attributs
	private static final long serialVersionUID = -4973296506746715437L;

	protected static DAOFactory factory = (DAOFactory)DAOFactory.getFactory(0);
	protected static ConfigurationDAO dao = factory.getConfigurationDAO();
	
	private int id;
	private String type;
	private Categorie categorie;
	private int idSpectacle;
	
	//Constructeur
	public Configuration() {
		
	}
	
	public Configuration(String type, Categorie categorie) {
		this.type = type;
		this.categorie = categorie;
	}
	
	public Configuration(String type, int idSpectacle) {
		this.type = type;
		this.idSpectacle = idSpectacle;
	}
	
	public Configuration(int id, String type, Categorie categorie) {
		this.id = id;
		this.type = type;
		this.categorie = categorie;
	}
	
	public Configuration(int id, String type, int idSpectacle) {
		this.id = id;
		this.type = type;
		this.idSpectacle = idSpectacle;
	}
	
	//Accesseurs
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
	
	public int getIdSpectacle() {
		return idSpectacle;
	}
	public void setIdSpectacle(int idSpectacle) {
		this.idSpectacle = idSpectacle;
	}

	//Méthodes
	public boolean ajouterConfiguration() {
		return dao.create(this);
	}
	
	public Configuration findById(int id)
	{
		return dao.findById(id);
	}	
	
	public String toString() {
		return id + " " + type + " " + categorie + " " + idSpectacle;
	}
}
