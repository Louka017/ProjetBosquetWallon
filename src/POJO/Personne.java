package POJO;

import java.io.Serializable;
import DAO.DAOFactory;
import DAO.PersonneDAO;

public class Personne implements Serializable{

	//Attributs
	private static final long serialVersionUID = -6819381459685578597L;
	
	protected static DAOFactory factory = (DAOFactory)DAOFactory.getFactory(0);
	protected static PersonneDAO dao = factory.getPersonneDAO();
	
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
	//////////////////////////////////////////////////////////////////////////
	private int idSpectacle; //ATTENTION
	/////////////////////////////////////////////////////////////////////////


	//Constructeurs
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
	
	public Personne(int id, int idSpectacle) {
		this.id = id;
		this.idSpectacle = idSpectacle;
		
		}
	
	public Personne(String email, String password) {
		this.email=email;
		this.password = password;
	}
	
	
	public Personne(String email) {
		this.email=email;
		
	}
	
	public Personne() {
		
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
	
	
	public int getIdSpectacle() {
		return idSpectacle;
	}
	public void setIdSpectacle(int idSpectacle) {
		this.idSpectacle = idSpectacle;
	}
	
	//Méthodes	
	

	

	//Verifier mail et mdp
	public int verifer()
	{
		return dao.verify(email, password);
							//this
	}

	//Afficher une personne
	public String ToString()
	{
		return nom + " " + prenom;
	}
	
	//Trouver une personne par mail
	public Personne findbyMail() {
			return dao.findbyMail(this);
	}

	//ajouter
	public boolean ajout()
	{
		return dao.create(this);
	}
	
	//AJOUTER
	public boolean ajouterReservation(Reservation r) {
		return r.ajoutReservationAvecIdGestionnaire(this);
	}
	
	
	//AJOUTER Planning_salle
	public boolean ajouterPlanningSalle(Spectacle s) {
		dao.create(this);
		
		return dao.create(s);
	}
	
}
