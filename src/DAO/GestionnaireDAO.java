package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import POJO.*;

public class GestionnaireDAO extends DAO<Gestionnaire> {
	
	//Constructeur
	public GestionnaireDAO(Connection conn) {
		super(conn);
	}
	
	//Fonctions
	public  boolean create(Gestionnaire obj) {
		
		try {
			String create = "INSERT INTO Personne (Nom,Prenom,Adresse,Discriminator,Email,MotDePasse) "
					+ "values ('" + obj.getNom() + "','" + obj.getPrenom() + "','" + obj.getAdresse() + "','Artiste','"+ obj.getEmail() + "','" + obj.getPassword() + "');";
			System.out.println(create);
			connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeUpdate(create);
			}
			
			catch(Exception e) {
				return false;
			}
			return true;
	}
	
	public  boolean delete(Gestionnaire obj) {
		
		try {	
			String delete = "DELETE FROM Personne where idPersonne = " + obj.getId() + ";";
			System.out.println(delete);
			connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeUpdate(delete);
		}
		catch(Exception e) {
			return false;
		}
		return true;
	}
	
	public  boolean update(Gestionnaire obj) {
		
		try {	
			String update = "UPDATE Personne set Nom = '"+ obj.getNom() + "', Prenom = '" + obj.getPrenom() + "', Adresse= '" + obj.getAdresse() + "', Email = '" + obj.getEmail() + "', MotDePasse ='" + obj.getPassword() + "');";
			System.out.println(update);
			connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeUpdate(update);
		}
		catch(Exception e) {
			return false;
		}
		return true;
	}
	
	public Gestionnaire find(int Id) {

		Gestionnaire gestionnaire = null;
		try {
			ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
					.executeQuery("SELECT * FROM Personne WHERE idPersonne = " + Id + ";");
			if (result.first())
				gestionnaire = new Gestionnaire(result.getString("Nom"), result.getString("Prenom"), result.getString("Adresse"),result.getString("Email"), result.getString("MotDePasse"), result.getInt("IdPersonne"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return gestionnaire;
	}

}