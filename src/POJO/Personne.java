package POJO;

import java.io.Serializable;

public class Personne implements Serializable{

	//Attributs
	private static final long serialVersionUID = -6819381459685578597L;
	protected int id;
	protected String nom;
	protected String prenom;
	protected String adresse;
	protected String email;
	protected String password;

	//Constructeur
	public Personne(String nom, String prenom, String adresse, String email, String password, int id) {
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
	
	
}
