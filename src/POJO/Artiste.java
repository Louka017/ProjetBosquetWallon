package POJO;

import java.io.Serializable;

public class Artiste extends Personne implements Serializable {

	//Attributs
	private static final long serialVersionUID = 9149868084737096938L;

	//Constructeur
	public Artiste(String nom, String prenom, String adresse, String email, String password, int id) {
		super(nom, prenom, adresse, email, password, id);
	}

}
