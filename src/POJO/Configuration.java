package POJO;

import java.io.Serializable;

import DAO.*;

public class Configuration implements Serializable {

	//Attributs
	private static final long serialVersionUID = -4973296506746715437L;

	protected static DAOFactory factory = (DAOFactory)DAOFactory.getFactory(0);
	protected static ConfigurationDAO dao = factory.getConfigurationDAO();
	
	private String type;
	private String description;
	private Categorie categorie;
	
	//Constructeur
	public Configuration(String type, String description, Categorie categorie) {
		this.type = type;
		this.description = description;
		this.categorie = categorie;
	}
	
	//Accesseurs
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	public Categorie getCategorie() {
		return categorie;
	}
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

}
