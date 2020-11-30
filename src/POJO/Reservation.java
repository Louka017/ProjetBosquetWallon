package POJO;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import DAO.*;

public class Reservation implements Serializable {

	private static final long serialVersionUID = 2752339235768498033L;
	protected static DAOFactory factory = (DAOFactory)DAOFactory.getFactory(0);
	protected static ReservationDAO dao = factory.getReservationDAO();
	
	//ATTRIBUTS
	private int id;
	private int acompte;
	private int solde;
	private int prix;
	private String statut;
	private PlanningSalle planningSalle;
	
	//CONSTRUCTEURS
	public Reservation() {

	}
	
	public Reservation(int acompte, int solde, String statut, int prix, PlanningSalle planningSalle) {
		this.acompte = acompte;
		this.solde = solde;
		this.statut = statut;
		this.prix = prix;
		this.planningSalle = planningSalle;
	}
	
	//ACCESSEURS
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

	//METHODES
	//Ajouter une Reservation
	public boolean ajoutReservationAvecIdGestionnaire(Personne o){
		dao.create(this);
		return dao.ajouterOrganisateuraLaResr(o);
	}
	
	//Calcul du nombre de jour entre Date debut et date fin
	public int calculerDifferenceJour() {
		PlanningSalle ps = this.getPlanningSalle();
		Date db = ps.getDateDebutSal();
		Date df = ps.getDateFinSal();
		long debutlong = db.getTime();
		long finlong = df.getTime();
		@SuppressWarnings("unused")
		DateFormat dateFormatLong = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		long correctDate =((finlong - debutlong) / 79377416);
		int correcteDate = (int)correctDate;
		System.out.println("Nbr de jours entre la date de debut et date de fin = " + correcteDate);
		return correcteDate;		
	}
	
	//Calcul du prix
	@SuppressWarnings("deprecation")
	public void calculPrix(int differencejours) {
		@SuppressWarnings("unused")
		DateFormat dateFormatLong = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date dd = planningSalle.getDateDebutSal();
		int prix = 0;
		for(int i=0; i<differencejours ; i++) {	
			if(dd.getDay() == 5 || dd.getDay() == 6) {
				prix += 4500;
			}
			else {
				prix +=3000;
			}
			long debutlong = dd.getTime();
			debutlong += 79377416;	
			try {
				dd = new java.sql.Date (debutlong);	
			} 
			catch(Exception e) {
			}					
		}
		this.setPrix(prix);
	}
}