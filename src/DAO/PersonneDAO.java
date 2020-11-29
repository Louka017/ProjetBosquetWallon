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
		
		try {
		String create = "INSERT INTO Personne_Spectacle (idPersonne, idSpectacle)"
				+ "values ('" + obj.getId() + "',0);";

		connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeUpdate(create);
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return true;
		
	}
	
	public  boolean create(Spectacle obj) {
		
		try {
			String update ="UPDATE Personne_Spectacle SET IdSpectacle = '" + obj.getId() + "' WHERE idSpectacle = 0;";

		connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeUpdate(update);
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return true;
		
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
	
	
	public Personne findbyMail(Personne obj) {
		Personne p = null;
		
		try {
			ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
					.executeQuery("SELECT * FROM Personne WHERE Email = '" + obj.getEmail() + "';");
			if (result.first())
				p = new Personne(result.getString("Nom"), result.getString("Prenom"), result.getString("Rue"),result.getInt("Numero"),result.getString("Ville"),result.getInt("CodePostal"),result.getString("Email"), result.getString("MotDePasse"), result.getInt("IdPersonne"),result.getString("Discriminator"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return p;
	}
	
	
	
	
	public Personne verify(Personne obj) {
		Personne p = null;
		try {
			ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM Personne WHERE Email = '" + obj.getEmail() + "';");
				if (result.first())
					 p = new Personne(result.getString("Nom"), result.getString("Prenom"), result.getString("Rue"),result.getInt("Numero"),result.getString("Ville"),result.getInt("CodePostal"),result.getString("Email"), result.getString("MotDePasse"), result.getInt("IdPersonne"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return p;
	}
	
	
}
