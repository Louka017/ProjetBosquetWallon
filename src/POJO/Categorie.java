package POJO;

import java.io.Serializable;
import DAO.CategorieDAO;
import DAO.DAOFactory;



public class Categorie implements Serializable {

	//Attributs
	private static final long serialVersionUID = 3633610078969934440L;

	protected static DAOFactory factory = (DAOFactory)DAOFactory.getFactory(0);
	protected static CategorieDAO dao = factory.getCategorieDAO();
	
	private String type;
	private int prix;
	private int nbrPlaceDispo;
	private int nbrPlaceMax;
	private int idConfiguration;
	
	//Constructeur
	public Categorie() {
		
	}
	
	public Categorie(String type, int prix, int nbrPlaceDispo, int nbrPlaceMax) {
		this.type = type;
		this.prix = prix;
		this.nbrPlaceDispo = nbrPlaceDispo;
		this.nbrPlaceMax = nbrPlaceMax;
	}
	
	public Categorie(String type, int prix, int nbrPlaceDispo, int nbrPlaceMax, int idConfiguration) {
		this.type = type;
		this.prix = prix;
		this.nbrPlaceDispo = nbrPlaceDispo;
		this.nbrPlaceMax = nbrPlaceMax;
		this.idConfiguration = idConfiguration;
	}
	
	//Accesseurs
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	
	public float getPrix() {
		return prix;
	}
	public void setPrix(int prix) {
		this.prix = prix;
	}
	
		
	public int getNbrPlaceDispo() {
		return nbrPlaceDispo;
	}
	public void setNbrPlaceDispo(int nbrPlaceDispo) {
		this.nbrPlaceDispo = nbrPlaceDispo;
	}
	
	
	public int getNbrPlaceMax() {
		return nbrPlaceMax;
	}
	public void setNbrPlaceMax(int nbrPlaceMax) {
		this.nbrPlaceMax = nbrPlaceMax;
	}
	
	public int getIdConfiguration() {
		return idConfiguration;
	}
	public void setIdConfiguration(int idConfiguration) {
		this.idConfiguration = idConfiguration;
	}
	
	//Méthodes
	public boolean ajouterCategorie() {
		return dao.create(this);
	}
	
}
