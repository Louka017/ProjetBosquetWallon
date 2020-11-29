package POJO;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import DAO.*;

public class Representation implements Serializable {

	private static final long serialVersionUID = -7253524476235799528L;
	protected static DAOFactory factory = (DAOFactory) DAOFactory.getFactory(0);
	protected static RepresentationDAO dao = factory.getRepresentationDAO();
	
	//ATTRIBUTS
	private int id;
	private Date date;
	private Date heureDebut;
	private Date heureFin;
	private Spectacle spectacle;
	
	//Constructeur
	public Representation() {

	}
	
	public Representation(Date date, Date heureDebut, Date heureFin) {
		this.date = date;
		this.heureDebut = heureDebut;
		this.heureFin = heureFin;
	}
	
	public Representation(Date date, Date heureDebut, Date heureFin, Spectacle spectacle) {
		this.date = date;
		this.heureDebut = heureDebut;
		this.heureFin = heureFin;
		this.spectacle = spectacle;
	}
	
	public Representation(int id,Date date, Date heureDebut, Date heureFin) {
		this.id = id;
		this.date = date;
		this.heureDebut = heureDebut;
		this.heureFin = heureFin;
	}
	
	
	//ACCESSEURS
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
		return spectacle.getId();
	}
	public void setSpectacle(Spectacle spectacle) {
		this.spectacle = spectacle;
	}

	
	//METHODES
	//Ajouter representation
	public boolean ajouterRps() {
		return dao.create(this);
	}
	
	//Liste
	public List<Representation> listeRepresentations(int idS){
		return dao.listeRepresentations(idS);
	}
	
	//Afficher Representation
	public String toString() {	
		DateFormat dateFormat = new SimpleDateFormat("HH:mm");
		String strDate = dateFormat.format(heureDebut); 
		String strDate2 = dateFormat.format(heureFin);
		return date + "       " + strDate + "            " + strDate2;
	}
	
}
