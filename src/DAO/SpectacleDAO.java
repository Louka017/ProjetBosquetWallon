package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import POJO.*;

public class SpectacleDAO implements DAO<Spectacle> {
	
	protected Connection connect = null;
	
	//Constructeur
	public SpectacleDAO(Connection conn) {
		this.connect=conn;
	}

	//Fonctions
	public  boolean create(Spectacle obj) {
		try {
		String create = "INSERT INTO Spectacle (Titre, NbrPlaceMax) "
				+ "values ('" + obj.getTitre() + "','" + obj.getNbrPlaceParClient() + "');";
	
		connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeUpdate(create);
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return true;
	}
	
	public  boolean delete(Spectacle obj) {
		return false;
	}
	
	public  boolean update(Spectacle obj) {
		return false;
	}
	
	public Spectacle find(int Id) {
		Spectacle s = null;
		return s;
	}

	
	public Spectacle findByTitle(String titre) {
		Spectacle s = null;
		try {
			ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
					.executeQuery("SELECT * FROM Spectacle WHERE Titre = '" + titre + "';");
			if (result.first()) {
				s = new Spectacle(result.getInt("idSpectacle"),result.getString("Titre"),result.getInt("NbrPlaceMax")); 
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return s;
	}
	
	public List<Spectacle> listeSpectacles() {
		List<Spectacle> spectacles = new ArrayList<Spectacle>();
		try {

			String query = "SELECT * from Spectacle";
			ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
					.executeQuery(query);
				while(result.next()) {
					Spectacle spectacle = new Spectacle(result.getInt("idSpectacle"), result.getString("Titre"),result.getInt("NbrPlaceMax"), result.getInt("idSalle"));
					spectacles.add(spectacle);
				}	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return spectacles;
	}

	
	public int trouveidSalle(Spectacle obj) {
		int res=0;
		try {
			ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
					.executeQuery("SELECT * FROM Spectacle WHERE Titre = '" + obj.getTitre() + "';");
			if (result.first()) {
				res =  result.getInt("idSalle"); 
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;	
	}
	
	
	public  boolean ajouterAvecIdSalle(PlanningSalle obj) {
		try {
			String update ="UPDATE Spectacle Set IdSalle = '" + obj.getId() + "' WHERE IdSalle = 0;";
			connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeUpdate(update);
			
		} 
		catch (SQLException e) {

			e.printStackTrace();
		}
		return true;
	}

}
