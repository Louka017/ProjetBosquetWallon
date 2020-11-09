package POJO;

import java.io.Serializable;

public class Organisateur extends Personne implements Serializable{

	//Attribut
	private static final long serialVersionUID = 8324249115653293376L;

	//Constructeur
	public Organisateur(String nom, String prenom, String adresse, String email, String password, int id) {
		super(nom, prenom, adresse, email, password, id);
		
	}

}
