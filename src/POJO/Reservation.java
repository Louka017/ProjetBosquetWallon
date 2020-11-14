package POJO;

import java.io.Serializable;

import DAO.*;

public class Reservation implements Serializable {

	//Attributs
	private static final long serialVersionUID = 2752339235768498033L;

	protected static DAOFactory factory = (DAOFactory)DAOFactory.getFactory(0);
	protected static ReservationDAO dao = factory.getReservationDAO();
	
	private int accompte;
	private int solde;
	private String statut;
	private int prix;
	private PlanningSalle planningSale;
	
	//Constructeur
	public Reservation(int accompte, int solde, String statut, int prix, PlanningSalle planningSale) {
		this.accompte = accompte;
		this.solde = solde;
		this.statut = statut;
		this.prix = prix;
		this.planningSale = planningSale;
	}
	
	//Accesseurs
	public int getAccompte() {
		return accompte;
	}
	public void setAccompte(int accompte) {
		this.accompte = accompte;
	}
	
	
	public int getSolde() {
		return solde;
	}
	public void setSolde(int solde) {
		this.solde = solde;
	}
	
	
	public String getStatut() {
		return statut;
	}
	public void setStatut(String statut) {
		this.statut = statut;
	}
	
	
	public int getPrix() {
		return prix;
	}
	public void setPrix(int prix) {
		this.prix = prix;
	}
	
	
	public PlanningSalle getPlanningSale() {
		return planningSale;
	}
	public void setPlanningSale(PlanningSalle planningSale) {
		this.planningSale = planningSale;
	}

}
