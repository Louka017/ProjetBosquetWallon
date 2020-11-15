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
	
	public Personne(String email, String password) {
		this.email=email;
		this.password = password;
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
	
	
	//Méthodes	
	
	String regnom = "^[A-Za-z]+$" ;
	String regmail = "^[A-Za-z0-9-.]+@[A-Za-z]+.(com|be|eu|fr)$";
	String regrue = "^[A-Za-z -]+$" ;
	String regnum = "^(([0-9]+) | ([0-9]+(a|b|c|d))) $";
	String regcp = "^[0-9]{4}$";
	//Regarder si tous les champs sont correct grâce à des REGEX
	public boolean verifierChamps(String nom, String prenom, String rue, int numero, String ville, int cp, String email, String password) {
		
		String num =  String. valueOf(numero);
		String cdp = String. valueOf(cp);
		
		if(nom.matches(regnom))
			if(prenom.matches(regnom))
				if(rue.matches(regrue))
					if(num.matches(regnum))
						if(cdp.matches(regcp))
							if(email.matches(regmail))
									return true;
		return false;
	}
	

	//Verifier mail et mdp
	public int verifer(String email, String mdp)
	{
		return dao.verify(email, mdp);
	}

		
	

	
	

	
}
