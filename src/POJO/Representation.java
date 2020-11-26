package POJO;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import DAO.*;

public class Representation implements Serializable {

	//Attributs
	private static final long serialVersionUID = -7253524476235799528L;

	protected static DAOFactory factory = (DAOFactory) DAOFactory.getFactory(0);
	protected static RepresentationDAO dao = factory.getRepresentationDAO();
	
	private int id;
	private Date date;
	private Date heureDebut;
	private Date heureFin;
	private int idSpectacle;
	
	//Constructeur
	public Representation() {

	}
	
	public Representation(Date date, Date heureDebut, Date heureFin, int idSpectacle) {
		this.date = date;
		this.heureDebut = heureDebut;
		this.heureFin = heureFin;
		this.idSpectacle = idSpectacle;
	}
	
	public Representation(int id,Date date, Date heureDebut, Date heureFin, int idSpectacle) {
		this.id = id;
		this.date = date;
		this.heureDebut = heureDebut;
		this.heureFin = heureFin;
		this.idSpectacle = idSpectacle;
	}
	
	//Accesseur
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	
	public Date getHeureDebut() {
		return heureDebut;
	}
	public void setHeureDebut(Date heureDebut) {
		this.heureDebut = heureDebut;
	}
	
	
	public Date getHeureFin() {
		return heureFin;
	}
	public void setHeureFin(Date heureFin) {
		this.heureFin = heureFin;
	}
	
	
	public int getSpectacle() {
		return idSpectacle;
	}
	public void setSpectacle(int idSpectacle) {
		this.idSpectacle = idSpectacle;
	}
	
	//Méthodes
	public boolean ajouterRps() {
		return dao.create(this);
	}
	
	//Liste
	public List<Representation> listeRepresentations(int idR){
		return dao.listeRepresentations(idR);
	}
	
	//toString
	public String toString() {	
		DateFormat dateFormat = new SimpleDateFormat("hh:mm");
		String strDate = dateFormat.format(heureDebut); 
		String strDate2 = dateFormat.format(heureFin);
		return date + "       " + strDate + "            " + strDate2;
	}
	
}
