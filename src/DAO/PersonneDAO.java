package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import POJO.*;

public class PersonneDAO implements DAO<Personne> {
	
	protected Connection connect = null;
	
	//Constructeur
	public PersonneDAO(Connection conn) {
		this.connect = conn;
	}
	
	//Fonctions
	public  boolean create(Personne obj) {
		return false;
	}
	
	public  boolean delete(Personne obj) {
		return false;
	}
	
	public  boolean update(Personne obj) {
		return false;
	}
	
	public Personne find(int Id) {
		Personne p = null;
		
		try {
			ResultSet result = connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
					.executeQuery("SELECT * FROM Personne WHERE idPersonne = " + Id + ";");
			if (result.first())
				p = new Personne(result.getString("Nom"), result.getString("Prenom"), result.getString("Rue"),result.getInt("Numero"),result.getString("Ville"),result.getInt("CodePostal"),result.getString("Email"), result.getString("MotDePasse"), result.getInt("IdPersonne"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return p;
	}
	
	
	public Personne findbyMail(String email) {
		Personne p = null;
		
		try {
			ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
					.executeQuery("SELECT * FROM Personne WHERE Email = '" + email + "';");
			if (result.first())
				p = new Personne(result.getString("Nom"), result.getString("Prenom"), result.getString("Rue"),result.getInt("Numero"),result.getString("Ville"),result.getInt("CodePostal"),result.getString("Email"), result.getString("MotDePasse"), result.getInt("IdPersonne"),result.getString("Discriminator"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return p;
	}
	
	
	
	
	public int verify(String email, String mdp) {
		try {
			ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM Personne WHERE Email = '" + email + "';");
			if (result.first()) {
				if(result.getString("MotDePasse").equals(mdp)) {
						return 1;
				}else {
						return 2;
				}
			}else {
				return 0;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	
}
