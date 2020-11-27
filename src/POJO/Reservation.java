package POJO;

import java.io.Serializable;

import DAO.*;

public class Reservation implements Serializable {

	//Attributs
	private static final long serialVersionUID = 2752339235768498033L;

	protected static DAOFactory factory = (DAOFactory)DAOFactory.getFactory(0);
	protected static ReservationDAO dao = factory.getReservationDAO();
	
	private int id;
	private int acompte;
	private int solde;
	private String statut;
	private int prix;
	///////////////////////////////////////
	private PlanningSalle planningSalle;
	////////////////////////////////////////
	
	//Constructeurs
	public Reservation() {

	}
	
	
	public Reservation(int acompte, int solde, String statut, int prix, PlanningSalle planningSalle) {
		this.acompte = acompte;
		this.solde = solde;
		this.statut = statut;
		this.prix = prix;
		this.planningSalle = planningSalle;
	}
	
	//Accesseurs
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public int getAcompte() {
		return acompte;
	}
	public void setAcompte(int acompte) {
		this.acompte = acompte;
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
	
	
	public PlanningSalle getPlanningSalle() {
		return planningSalle;
	}
	public void setPlanningSale(PlanningSalle planningSalle) {
		this.planningSalle = planningSalle;
	}
	
	
	public int getIdPlanningSalle() {
		return planningSalle.getId();
	}
	
	
	
	//Ajouter Reservation
	public boolean ajoutReservationAvecIdGestionnaire(Personne o){
		dao.create(this);
		return dao.ajouterOrganisateuraLaResr(o);
	}
}