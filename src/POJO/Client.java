package POJO;

import java.io.Serializable;
import java.util.List;

import DAO.*;

public class Client  extends Personne implements Serializable {

	//Attributs
	private static final long serialVersionUID = 1328773664957190670L;
	
	protected static DAOFactory factory = (DAOFactory)DAOFactory.getFactory(0);
	protected static ClientDAO dao = factory.getClientDAO();

	//Constructeurs
	public Client(String nom, String prenom, String rue, int numero, String ville, int cp, String email, String password, int id) {
		super(nom, prenom, rue, numero, ville, cp, email, password, id);	
	}
	
	public Client(String nom, String prenom, String rue, int numero, String ville, int cp, String email, String password) {
		super(nom, prenom, rue, numero, ville, cp, email, password);
	}

	
	//M�thodes
	
	//Ajouter un client
	public boolean ajoutClient() {
		return dao.create(this);
	}
	
	//Regarder si tous les champs sont correct gr�ce � des REGEX
	String regnom = "^[A-Za-z]+$" ;
	String regmail = "^[A-Za-z0-9.-]+@[A-Za-z]+.(com|be|eu|fr)$";
	String regrue = "^[A-Za-z -]+$" ;
	String regnum = "^[0-9]+$";
	String regcp = "^[0-9]{4}$";
	
	
	//Regarder si tous les champs sont correct gr�ce � des REGEX
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
