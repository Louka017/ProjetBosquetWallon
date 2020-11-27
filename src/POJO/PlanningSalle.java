package POJO;

import java.io.Serializable;
import java.util.*;

import DAO.*;

public class PlanningSalle implements Serializable {

	// Attributs
	private static final long serialVersionUID = 8581140104258101507L;

	protected static DAOFactory factory = (DAOFactory) DAOFactory.getFactory(0);
	protected static PlanningSalleDAO dao = factory.getPlanningSalleDAO();

	private int id;
	private Date dateDebutSal;
	private Date dateFinSal;
	/////////////////////////////////////////////////
	private List<Spectacle> spectacles;
	private Spectacle spectacle;
	//////////////////////////////////////////////////
	
	// Constructeurs
	public PlanningSalle() {

	}

	public PlanningSalle(int id) {
		this.id = id;
	}
	
	public PlanningSalle(Spectacle s) {
			spectacles.add(s);
	}

	public PlanningSalle(int id, Date dateDebutSal, Date dateFinSal, List<Spectacle> spectacles) {
		this.id = id;
		this.dateDebutSal = dateDebutSal;
		this.dateFinSal = dateFinSal;
		this.spectacles = spectacles;
	}

	public PlanningSalle(Date dateDebutSal, Date dateFinSal, List<Spectacle> spectacles) {
		this.dateDebutSal = dateDebutSal;
		this.dateFinSal = dateFinSal;
		this.spectacles = spectacles;
	}

	public PlanningSalle(int id, Date dateDebutSal, Date dateFinSal) {
		this.id = id;
		this.dateDebutSal = dateDebutSal;
		this.dateFinSal = dateFinSal;
	}

	public PlanningSalle(Date dateDebutSal, Date dateFinSal) {
		this.dateDebutSal = dateDebutSal;
		this.dateFinSal = dateFinSal;
	}

	// Accesseurs
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDateDebutSal() {
		return dateDebutSal;
	}

	public void setDateDebutSal(Date dateDebutSal) {
		this.dateDebutSal = dateDebutSal;
	}

	public Date getDateFinSal() {
		return dateFinSal;
	}

	public void setDateFinSal(Date dateFinSal) {
		this.dateFinSal = dateFinSal;
	}


	public List<Spectacle> getSpectacles() {
		return spectacles;
	}

	public void setSpectacles(List<Spectacle> spectacles) {
		this.spectacles = spectacles;
	}

	// Méthodes
	// Reserver la salle
	public boolean ajouterPlanning() {
		return dao.create(this);
	}

	// Trouver par date
	public PlanningSalle finfByDate() {
		return dao.findByDate(dateDebutSal, dateFinSal);
	}

	// Trouver par id
	public PlanningSalle find(int id) {
		return dao.find(id);
	}

	// ToString
	public String toString() {
		return id + " " + dateDebutSal + " " + dateFinSal;
	}

	// Verifier la disponibilité de la salle
	public int verify() {
		return dao.verify(dateDebutSal);
		
		
		/*
		 * List<PlanningSalle> test = dao for(var i : test) {
		 * if((this.getdateDebut().after(test.getDateDebtu)&&this.getDateDebut().before(
		 * test.getDateFin))||(this.getDateFin().before(test.getDateFin)&&this.
		 * getDatefin.after(test.getDateDebut)||(this.getDateDebut.before(test.
		 * getDetDateDebut)&&this.getDateFin.after(this.getDateFIn)) return false; }
		 * return true;
		 */
	}
	
	
	//AJOUTER SPECTACLE
	public boolean ajouterSpectacle(Spectacle s) {
		return s.ajoutPectacleAvecIdSalle(this);
	}



}
