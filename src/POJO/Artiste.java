package POJO;

import java.io.Serializable;
import java.util.List;
import DAO.*;

public class Artiste extends Personne implements Serializable {

	//Attributs
	private static final long serialVersionUID = 9149868084737096938L;
	
	protected static DAOFactory factory = (DAOFactory)DAOFactory.getFactory(0);
	protected static ArtisteDAO dao = factory.getArtisteDAO();
	
	//Constructeur
	public Artiste(String nom, String prenom, String rue, int numero, String ville, int cp, String email, String password, int id) {
		super(nom, prenom, rue, numero, ville, cp, email, password, id);
	}
	
	public Artiste(String nom, String prenom, String rue, int numero, String ville, int cp, String email, String password) {
		super(nom, prenom, rue, numero, ville, cp, email, password);
	}

	public Artiste() {}
	
	
	//Méthodes
	
	
	//Ajouter un artiste
	public boolean ajoutArtiste() {
		return dao.create(this);
	}
	
	//Regarder si tous les champs sont correct grâce à des REGEX
	String regnom = "^[A-Za-z]+$" ;
	String regmail = "^[A-Za-z0-9.-]+@[A-Za-z]+.(com|be|eu|fr)$";
	String regrue = "^[A-Za-z -]+$" ;
	String regnum = "^[0-9]+$";
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
	
	//Liste
	public List<Artiste> TESTONS(){
		return dao.TESTONS();
	}
	
	//Afficher les infos
	public String toString() {
		return nom + " " + prenom;
	}
}
