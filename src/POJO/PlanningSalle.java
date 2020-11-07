package POJO;

import java.io.Serializable;
import java.util.*;

public class PlanningSalle implements Serializable{

	//Attributs
	private static final long serialVersionUID = 8581140104258101507L;
	private Date dateDebutRes;
	private Date dateFinRes;
	private List<Spectacle> spectacle;
	
	//Constructeur
	public PlanningSalle(Date dateDebutRes, Date dateFinRes, List<Spectacle> spectacle) {
		this.dateDebutRes = dateDebutRes;
		this.dateFinRes = dateFinRes;
		this.spectacle = spectacle;
	}
	
	//Accesseurs
	public Date getDateDebutRes() {
		return dateDebutRes;
	}
	public void setDateDebutRes(Date dateDebutRes) {
		this.dateDebutRes = dateDebutRes;
	}
	
	
	public Date getDateFinRes() {
		return dateFinRes;
	}
	public void setDateFinRes(Date dateFinRes) {
		this.dateFinRes = dateFinRes;
	}
	
	
	public List<Spectacle> getSpectacle() {
		return spectacle;
	}
	public void setSpectacle(List<Spectacle> spectacle) {
		this.spectacle = spectacle;
	}

}
