package POJO;

import java.io.Serializable;

import DAO.*;

public class Gestionnaire extends Personne implements Serializable{

	private static final long serialVersionUID = 5955414101805505499L;
	protected static DAOFactory factory = (DAOFactory)DAOFactory.getFactory(0);
	protected static GestionnaireDAO dao = factory.getGestionnaireDAO();

	//ATTRIBUT
	private PlanningSalle planningSalle;

	//CONSTRUCTEURS
	public Gestionnaire(String nom, String prenom, String rue, int numero, String ville, int cp, String email, String password, int id) {
		super(nom, prenom, rue, numero, ville, cp, email, password, id);
		
	}
	
	public Gestionnaire(String nom, String prenom, String rue, int numero, String ville, int cp, String email, String password) {
		super(nom, prenom, rue, numero, ville, cp, email, password);
		
	}

	//ACCESSEURS
	public PlanningSalle getPlanningSalle() {
		return planningSalle;
	}

	public void setPlanningSalle(PlanningSalle planningSalle) {
		this.planningSalle = planningSalle;
	}
}
