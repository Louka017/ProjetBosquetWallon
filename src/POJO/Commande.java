package POJO;

import java.io.Serializable;
import java.util.List;

public class Commande implements Serializable {

	//Attributs
	private static final long serialVersionUID = -7833218115888236671L;
	private String modePayement;
	private String modeLivraison;
	private int cout;
	private List<Place> places;
	
	//Constructeur
	public Commande(String modePayement, String modeLivraison, int cout, List<Place> places) {
		this.modePayement = modePayement;
		this.modeLivraison = modeLivraison;
		this.cout = cout;
		this.places = places;
	}
	
	//Accesseurs
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


	
	

}
