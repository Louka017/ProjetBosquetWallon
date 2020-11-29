package POJO;

import java.io.Serializable;
import java.util.List;

import DAO.CategorieDAO;
import DAO.DAOFactory;

public class Categorie implements Serializable {

	private static final long serialVersionUID = 3633610078969934440L;
	protected static DAOFactory factory = (DAOFactory)DAOFactory.getFactory(0);
	protected static CategorieDAO dao = factory.getCategorieDAO();
	
	//ATTRIBUTS
	private int id;
	private String type;
	private int prix;
	private int nbrPlaceDispo;
	private int nbrPlaceMax;

	//CONSTRUCTEURS
	public Categorie() {
		
	}
	
	public Categorie(String type, int prix, int nbrPlaceDispo, int nbrPlaceMax) {
		this.type = type;
		this.prix = prix;
		this.nbrPlaceDispo = nbrPlaceDispo;
		this.nbrPlaceMax = nbrPlaceMax;
	}

	public Categorie(int id, String type, int prix, int nbrPlaceDispo, int nbrPlaceMax) {
		this.id = id;
		this.type = type;
		this.prix = prix;
		this.nbrPlaceDispo = nbrPlaceDispo;
		this.nbrPlaceMax = nbrPlaceMax;
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
	
	
	public int getPrix() {
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
	
	
	//Méthodes
	//Ajouter
	public boolean ajouterCategorie() {
		return dao.create(this);
	}
	
	//Limite places DEBOUT
	public boolean verifyDebout(int libre) {
		if(libre < 0 || libre > 8000)
			return false;
		return true;
	}
	
	//Limite places CONCERT
	public boolean verifyBronze(int bronze) {
		if(bronze < 0 || bronze > 3000)
			return false;
		return true;
	}
	
	public boolean verifyArgent(int argent) {
		if(argent < 0 || argent > 1500)
			return false;
		return true;
	}
	
	public boolean verifyOr(int or) {
		if(or < 0 || or > 500)
			return false;
		return true;
	}
	
	//Limite places CIRQUE
	public boolean verifyBronze2(int bronze) {
		if(bronze < 0 || bronze > 1500)
			return false;
		return true;
	}
	
	public boolean verifyOr2(int or) {
		if(or < 0 || or > 2000)
			return false;
		return true;
	}
	
	public boolean verifyDiamant(int diamant) {
		if(diamant < 0 || diamant > 1000)
			return false;
		return true;
	}
	
	//Ajouter une Categorie
	public boolean ajouterCategorie(Configuration c) {
		dao.create(this);
		return dao.AjouterAvecIdConfiguration(c);
	}
	
	public Categorie findByConfiguration(Configuration c) {
		return dao.findByIdConfiguration(c.getId());
	}
	
	public List<Categorie> findAllByConfiguration(Configuration c) {
		return dao.findAllByIdConfiguration(c.getId());
	}
}
