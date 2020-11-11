package POJO;

import java.io.Serializable;
import java.util.*;

import DAO.AbstractDAOFactory;
import DAO.DAO;

public class Representation implements Serializable {

	//Attributs
	private static final long serialVersionUID = -7253524476235799528L;
	AbstractDAOFactory adf = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
	DAO<Representation> dao = adf.getRepresentationDAO();
	private Date date;
	private Date heureDebut;
	private Date heureFin;
	private Spectacle spectacle;
	
	//Constructeur
	public Representation(Date date, Date heureDebut, Date heureFin,Spectacle spectacle) {
		this.date = date;
		this.heureDebut = heureDebut;
		this.heureFin = heureFin;
		this.spectacle = spectacle;
	}
	
	//Accesseur
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
	
	
	public Spectacle getSpectacle() {
		return spectacle;
	}
	public void setSpectacle(Spectacle spectacle) {
		this.spectacle = spectacle;
	}

}
