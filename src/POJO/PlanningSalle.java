package POJO;

import java.io.Serializable;
import java.util.*;

import DAO.*;

public class PlanningSalle implements Serializable{

	//Attributs
	private static final long serialVersionUID = 8581140104258101507L;
	
	protected static DAOFactory factory = (DAOFactory)DAOFactory.getFactory(0);
	protected static PlanningSalleDAO dao = factory.getPlanningSalleDAO();
	
	private int id;
	private Date dateDebutSal;
	private Date dateFinSal;
	private List<Spectacle> spectacle;
	
	//Constructeurs
	public PlanningSalle(int id, Date dateDebutSal, Date dateFinSal, List<Spectacle> spectacle) {
		this.id = id;
		this.dateDebutSal = dateDebutSal;
		this.dateFinSal = dateFinSal;
		this.spectacle = spectacle;
	}
	
	public PlanningSalle(Date dateDebutSal, Date dateFinSal, List<Spectacle> spectacle) {
		this.dateDebutSal = dateDebutSal;
		this.dateFinSal = dateFinSal;
		this.spectacle = spectacle;
	}
	
	public PlanningSalle(int id,Date dateDebutSal, Date dateFinSal) {
		this.id = id;
		this.dateDebutSal = dateDebutSal;
		this.dateFinSal = dateFinSal;
	}
	
	public PlanningSalle(Date dateDebutSal, Date dateFinSal) {
		this.dateDebutSal = dateDebutSal;
		this.dateFinSal = dateFinSal;
	}
	
	//Accesseurs
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
	
	
	public List<Spectacle> getSpectacle() {
		return spectacle;
	}
	public void setSpectacle(List<Spectacle> spectacle) {
		this.spectacle = spectacle;
	}
	
	//Reserver la salle
	public boolean ajouterPlanning(){
		return dao.create(this);
	}
	
	//TEST
	public PlanningSalle finfByDate(Date db, Date df)
	{
		return dao.findByDate(db, df);
	}
	
	public PlanningSalle find(int id) {
		return dao.find(id);
	}
	

	public String ToString()
	{
		return id + " " + dateDebutSal + " " + dateFinSal;
	}
	

}
