package POJO;

import java.io.Serializable;
import java.util.List;

import DAO.*;

public class Commande implements Serializable {

	private static final long serialVersionUID = -7833218115888236671L;	
	protected static DAOFactory factory = (DAOFactory)DAOFactory.getFactory(0);
	protected static CommandeDAO dao = factory.getCommandeDAO();
	
	//ATTRIBUTS
	private int id;
	private String modePayement;
	private String modeLivraison;
	private int cout;
	private List<Place> places;
	
	//CONSTRUCTEURS
	public Commande(String modePayement, String modeLivraison, int cout) {
		this.modePayement = modePayement;
		this.modeLivraison = modeLivraison;
		this.cout = cout;
	}
	
	public Commande(int id,String modePayement, String modeLivraison, int cout) {
		this.setId(id);
		this.modePayement = modePayement;
		this.modeLivraison = modeLivraison;
		this.cout = cout;
	}
	
	public Commande(String modePayement, String modeLivraison, int cout, List<Place> places) {
		this.modePayement = modePayement;
		this.modeLivraison = modeLivraison;
		this.cout = cout;
		this.places = places;
	}
	
	//ACCESSEURS
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getModePayement() {
		return modePayement;
	}
	public void setModePayement(String modePayement) {
		this.modePayement = modePayement;
	}
	
	
	public String getModeLivraison() {
		return modeLivraison;
	}
	public void setModeLivraison(String modeLivraison) {
		this.modeLivraison = modeLivraison;
	}
	
	
	public int getCout() {
		return cout;
	}
	public void setCout(int cout) {
		this.cout = cout;
	}
	
	
	public List<Place> getPlaces() {
		return places;
	}
	public void setPlaces(List<Place> places) {
		this.places = places;
	}


	//METHODES
	public boolean ajoutAvecPersonne(Personne p) {
		dao.create(this);
		return dao.updateAvecIdPersonne(p);
	}
	
	public Commande findByAll(Personne p) {
		return dao.findByAll(this.getModePayement(), this.getModeLivraison(), this.getCout(), p);
	}


}
