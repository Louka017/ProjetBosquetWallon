package POJO;

import java.io.Serializable;

import DAO.AbstractDAOFactory;
import DAO.DAO;

public class Organisateur extends Personne implements Serializable{

	//Attribut
	private static final long serialVersionUID = 8324249115653293376L;
	AbstractDAOFactory adf = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
	DAO<Organisateur> dao = adf.getOrganisateurDAO();
	
	
	//Constructeurs
	public Organisateur(String nom, String prenom, String rue, int numero, String ville, int cp, String email, String password, int id) {
		super(nom, prenom, rue, numero, ville, cp, email, password, id);
		
	}
	
	public Organisateur(String nom, String prenom, String rue, int numero, String ville, int cp, String email, String password) {
		super(nom, prenom, rue, numero, ville, cp, email, password);
		
	}
	
	//Méthodes
	
	//Ajouter un client
		public boolean ajoutOrganisateur() {
			return dao.create(this);
		}
		
		//Regarder si tous les champs sont correct grâce à des REGEX
		String regnom = "^[A-Za-z]+$" ;
		String regmail = "^[A-Za-z0-9]+@[A-Za-z]+.(com|be|eu|fr)$";
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



}
