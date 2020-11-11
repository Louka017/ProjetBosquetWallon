package POJO;

import java.io.Serializable;

import DAO.AbstractDAOFactory;

public class Gestionnaire extends Personne implements Serializable{

	//Attributs
	private static final long serialVersionUID = 5955414101805505499L;
	AbstractDAOFactory adf = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);

	//Constructeur
	public Gestionnaire(String nom, String prenom, String adresse, String email, String password, int id) {
		super(nom, prenom, adresse, email, password, id);
		
	}
	
	public Gestionnaire(String nom, String prenom, String adresse, String email, String password) {
		super(nom, prenom, adresse, email, password);
		
	}

}
