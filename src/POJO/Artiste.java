package POJO;

import java.io.Serializable;

import DAO.AbstractDAOFactory;

public class Artiste extends Personne implements Serializable {

	//Attributs
	private static final long serialVersionUID = 9149868084737096938L;
	AbstractDAOFactory adf = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
	
	
	//Constructeur
	public Artiste(String nom, String prenom, String adresse, String email, String password, int id) {
		super(nom, prenom, adresse, email, password, id);
	}

}
