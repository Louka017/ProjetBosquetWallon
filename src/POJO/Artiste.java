package POJO;

import java.io.Serializable;
import java.util.List;
import DAO.*;

public class Artiste extends Personne implements Serializable {

	//ATTRIBUTS
	private static final long serialVersionUID = 9149868084737096938L;
	
	protected static DAOFactory factory = (DAOFactory)DAOFactory.getFactory(0);
	protected static ArtisteDAO dao = factory.getArtisteDAO();
	
	//CONSTRUCTEURS
	public Artiste(String nom, String prenom, String rue, int numero, String ville, int cp, String email, String password, int id) {
		super(nom, prenom, rue, numero, ville, cp, email, password, id);
	}
	
	public Artiste(String nom, String prenom, String rue, int numero, String ville, int cp, String email, String password) {
		super(nom, prenom, rue, numero, ville, cp, email, password);
	}

	public Artiste() {
	}
	
	
	//METHODES
	//Ajouter un artiste
	public boolean ajoutArtiste() {
		return dao.create(this);
	}
	
	//Regarder si tous les champs sont correct gr�ce � des REGEX
	String regnom = "^[A-Za-z]+$" ;
	String regmail = "^[A-Za-z0-9.-]+@[A-Za-z]+.(com|be|eu|fr)$";
	String regrue = "^[A-Za-z -]+$" ;
	String regnum = "^[0-9]+$";
	String regcp = "^[0-9]{4}$";
	
	public boolean verifierChamps() {
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
	
	//Liste d'artistes
	public List<Artiste> listeArtistes(){
		return dao.listeArtistes();
	}
	
	//Afficher les infos
	public String toString() {
		return  nom + " " + prenom;
	}
}
