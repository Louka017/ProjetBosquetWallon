package POJO;

import java.io.Serializable;
import java.util.List;

import DAO.DAOFactory;
import DAO.PersonneDAO;

public class Personne implements Serializable{

	private static final long serialVersionUID = -6819381459685578597L;	
	protected static DAOFactory factory = (DAOFactory)DAOFactory.getFactory(0);
	protected static PersonneDAO dao = factory.getPersonneDAO();
	
	//ATTRIBUTS
	protected int id;
	protected String nom;
	protected String prenom;
	protected String rue;
	protected int numero;
	protected String ville;
	protected int cp;
	protected String email;
	protected String password;
	protected String discriminator;
	private Gestionnaire g;

	//CONSTRUCTEURS
	public Personne() {
		
	}
	
	public Personne(String email) {
		this.email=email;
	}
	
	public Personne(String email, String password) {
		this.email=email;
		this.password = password;
	}
	
	public Personne(String nom, String prenom,String rue, int numero, String ville, int cp, String email, String password) {
		this.nom = nom;
		this.prenom = prenom;
		this.rue = rue;
		this.numero = numero;
		this.ville = ville;
		this.cp = cp;
		this.email = email;
		this.password = password;
	}

	public Personne(String nom, String prenom, String rue, int numero, String ville, int cp, String email, String password, int id) {
		this.nom = nom;
		this.prenom = prenom;
		this.rue = rue;
		this.numero = numero;
		this.ville = ville;
		this.cp = cp;
		this.email = email;
		this.password = password;
	}
	
	public Personne(String nom, String prenom,String rue, int numero, String ville, int cp, String email, String password, int id, String discriminator) {
		this.nom = nom;
		this.prenom = prenom;
		this.rue = rue;
		this.numero = numero;
		this.ville = ville;
		this.cp = cp;
		this.email = email;
		this.password = password;
		this.id = id;
		this.discriminator = discriminator;
	}	
	
	//ACCESSEURS
	public int getId() {
		return this.id;
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
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	
	public String getRue() {
		return rue;
	}
	public void setRue(String rue) {
		this.rue = rue;
	}
	
	
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero= numero;
	}
	
	
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	
	
	public int getCp() {
		return cp;
	}
	public void setCp(int cp) {
		this.cp = cp;
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
	
	
	public String getDiscriminator() {
		return discriminator;
	}
	public void setDiscriminator(String discriminator) {
		this.discriminator = discriminator;
	}
	
	public Gestionnaire getGestionnaire() {
		return g;
	}
	public void setGetionnaire(Gestionnaire g) {
		this.g = g;
	}
	
	//METHODES	
	//Verifier mail et mdp
	public int verifer(){
		Personne p = dao.verify(this);
		
		if(this.email.equals(p.getEmail())) {
			if(this.password.equals(p.getPassword())) {
				return 1;		
			}
			return 2; 
		}
		return 0;
	}

	//Afficher une personne
	public String ToString(){
		return nom + " " + prenom;
	}
	
	//Trouver une personne par mail
	public Personne findbyMail() {
			return dao.findbyMail(this);
	}

	//Ajouter un artiste à un spectacle
	public boolean ajout(){
		return dao.create(this);
	}
	
	//Ajouter une réservation en lui envoyant l'objet personne
	public boolean ajouterReservation(Reservation r) {
		return r.ajoutReservationAvecIdGestionnaire(this);
	}
	
	//Ajouter une Personne suivi de l'IdSpectale 
	public boolean ajouterPlanningSalle(Spectacle s) {
		dao.create(this);
		return dao.create(s);
	}
	
	//Trouver Gestionnaire
	public Gestionnaire findGestionnaire(){
		return dao.findGestionnaire(this.id);
	}
	//Trouver tous les planning salle
	public List<PlanningSalle> findAllPlanningSalle(){
		Gestionnaire gestio = (this.findGestionnaire());
		return gestio.findAllPlanningSalle();
	}
	
}
