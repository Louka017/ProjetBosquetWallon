package POJO;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import DAO.*;

public class PlanningSalle implements Serializable {

	private static final long serialVersionUID = 8581140104258101507L;
	protected static DAOFactory factory = (DAOFactory) DAOFactory.getFactory(0);
	protected static PlanningSalleDAO dao = factory.getPlanningSalleDAO();

	//ATTRIBUTS
	private int id;
	private Date dateDebutSal;
	private Date dateFinSal;
	private List<Spectacle> spectacles;
	private Spectacle spectacle;
	
	//CONSTRUCTEUR
	public PlanningSalle() {

	}

	public PlanningSalle(int id) {
		this.id = id;
	}
	
	public PlanningSalle(Spectacle s) {
			spectacles.add(s);
	}
	
	public PlanningSalle(Date dateDebutSal, Date dateFinSal) {
		this.dateDebutSal = dateDebutSal;
		this.dateFinSal = dateFinSal;
	}
	
	public PlanningSalle(int id, Date dateDebutSal, Date dateFinSal) {
		this.id = id;
		this.dateDebutSal = dateDebutSal;
		this.dateFinSal = dateFinSal;
	}

	public PlanningSalle(Date dateDebutSal, Date dateFinSal, List<Spectacle> spectacles) {
		this.dateDebutSal = dateDebutSal;
		this.dateFinSal = dateFinSal;
		this.spectacles = spectacles;
	}
	
	public PlanningSalle(int id, Date dateDebutSal, Date dateFinSal, List<Spectacle> spectacles) {
		this.id = id;
		this.dateDebutSal = dateDebutSal;
		this.dateFinSal = dateFinSal;
		this.spectacles = spectacles;
	}

	//ACCESSEURS
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

	
	public Spectacle getSpectacle() {
		return spectacle;
	}

	public void setSpectacle(Spectacle spectacle) {
		this.spectacle = spectacle;
	}
	
	//METHODES
	//Ajouter un planningSalle
	public boolean ajouterPlanning() {
		return dao.create(this);
	}

	//Trouver par date
	public PlanningSalle finfByDate() {
		return dao.findByDate(dateDebutSal, dateFinSal);
	}

	//Trouver par id
	public PlanningSalle find(int id) {
		return dao.find(id);
	}

	//Afficher un PlanningSalle
	public String toString() {
		return id + " " + dateDebutSal + " " + dateFinSal;
	}

	//Verifier la disponibilité de la salle
	public int verifyy() {
		return dao.verify(dateDebutSal);
	}
	
	//Ajouter un spectacle en envoyant l'objet
	public boolean ajouterSpectacle(Spectacle s) {
		return s.ajoutPectacleAvecIdSalle(this);
	}
	
	//Voir si la date est deja reservée
	public boolean verify() {
	  List<PlanningSalle> test = dao.verify();
	  for(var i : test){
		  if((this.getDateDebutSal().after(i.getDateDebutSal())&&this.getDateDebutSal().before(i.getDateFinSal()))||(this.getDateFinSal().before(i.getDateFinSal())&&this.getDateFinSal().after(i.getDateDebutSal()))||(this.getDateDebutSal().before(i.getDateDebutSal())&&this.getDateFinSal().after(this.getDateFinSal())))
				  return false;
		  }
	  return true;
	}
	
	//Obtenir une date avec comme heure 12:00:00
	public String obtenirEnFormatCorrect(Date d) {
		String goodDate = null;
		DateFormat dateFormatLong = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String strDate = dateFormatLong.format(d);
		String[] splitArray = null;
		splitArray = strDate.split(" ");
		for(int i = 0; i< splitArray.length;i++){
			   //RECUPERE JUSTE LA DATE
				 goodDate = splitArray[0];
		}
		goodDate = goodDate + " 12:00:00";
		return goodDate;
	}
	


}
