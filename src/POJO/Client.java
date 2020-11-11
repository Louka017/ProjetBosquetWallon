package POJO;

import java.io.Serializable;
import DAO.*;

public class Client  extends Personne implements Serializable {

	//Attributs
	private static final long serialVersionUID = 1328773664957190670L;
	AbstractDAOFactory adf = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
	DAO<Client> dao = adf.getClientDAO();

	//Constructeurs
	public Client(String nom, String prenom, String adresse, String email, String password, int id) {
		super(nom, prenom, adresse, email, password, id);	
	}
	
	public Client(String nom, String prenom, String adresse, String email, String password) {
		super(nom, prenom, adresse, email, password);
	}

	
	//Méthodes
	
	
	//Ajouter un client
	public boolean ajoutClient() {
		return dao.create(this);
	}
	
	//Regarder si tous les champs sont correct grâce à des REGEX
	String regnom = "^[A-Za-z]+$" ;
	String regmail = "^[A-Za-z0-9]+@[A-Za-z]+.(com|be|eu|fr)$";
	
	public boolean verifierChamps(String nom, String prenom, String adresse, String email, String password) {
		
		if(nom.matches(regnom))
			if(prenom.matches(regnom))
				if(adresse.matches(regnom))
					if(email.matches(regmail))
							return true;
		return false;
	}
	
	
	
}
