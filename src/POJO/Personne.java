package POJO;

import java.io.Serializable;
import java.util.regex.*;

import DAO.AbstractDAOFactory;

public class Personne implements Serializable{

	//Attributs
	private static final long serialVersionUID = -6819381459685578597L;
	AbstractDAOFactory adf = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
	protected int id;
	protected String nom;
	protected String prenom;
	protected String adresse;
	protected String email;
	protected String password;


	//Constructeurs
	public Personne(String nom, String prenom, String adresse, String email, String password, int id) {
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.email = email;
		this.password = password;
	}
	
	public Personne(String nom, String prenom, String adresse, String email, String password) {
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.email = email;
		this.password = password;
	}
	
	//Accesseurs
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	
	public String getPrenom() {
		return nom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	//Méthodes	
	
	String regnom = "^[A-Za-z]+$" ;
	String regmail = "^[A-Za-z0-9]+@[A-Za-z]+.(com|be|eu|fr)$";
	
	//Regarder si tous les champs sont correct grâce à des REGEX
	public boolean verifierChamps(String nom, String prenom, String adresse, String email, String password) {
		
		if(nom.matches(regnom))
			if(prenom.matches(regnom))
				if(adresse.matches(regnom))
					if(email.matches(regmail))
							return true;
		return false;
	}
	
	
	
}
