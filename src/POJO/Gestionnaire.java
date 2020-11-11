package POJO;

import java.io.Serializable;

import DAO.AbstractDAOFactory;
import DAO.DAO;

public class Gestionnaire extends Personne implements Serializable{

	//Attributs
	private static final long serialVersionUID = 5955414101805505499L;
	AbstractDAOFactory adf = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
	DAO<Gestionnaire> dao = adf.getGestionnaireDAO();

	//Constructeur
	public Gestionnaire(String nom, String prenom, String rue, int numero, String ville, int cp, String email, String password, int id) {
		super(nom, prenom, rue, numero, ville, cp, email, password, id);
		
	}
	
	public Gestionnaire(String nom, String prenom, String rue, int numero, String ville, int cp, String email, String password) {
		super(nom, prenom, rue, numero, ville, cp, email, password);
		
	}

}
