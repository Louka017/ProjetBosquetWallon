package POJO;

import java.io.Serializable;

public class Client  extends Personne implements Serializable {

	//Attributs
	private static final long serialVersionUID = 1328773664957190670L;

	//Constructeur
	public Client(String nom, String prenom, String adresse, String email, String password, int id) {
		super(nom, prenom, adresse, email, password, id);
		
	}

}
