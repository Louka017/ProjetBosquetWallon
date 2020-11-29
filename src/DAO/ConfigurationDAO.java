package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import POJO.*;

public class ConfigurationDAO implements DAO<Configuration> {
	
	private Connection connect = null;
	//Constructeur
	public ConfigurationDAO(Connection conn) {
		this.connect = conn;
	}

	
	//Fonctions
	public  boolean create(Configuration obj) {
		try {
			String create = "INSERT INTO CONFIGURATION (idConfiguration, Type, idSpectacle) "
					+ "values ('" + obj.getId() + "','" + obj.getType() + "',0);";
	
			connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeUpdate(create);
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
			return true;
	}
	
	public  boolean delete(Configuration obj) {
		return false;
	}
	
	public  boolean update(Configuration obj) {
		return false;
	}
	
	public Configuration find(int Id) {
		Configuration c = null;
		try {
			ResultSet result = connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
					.executeQuery("SELECT * FROM Configuration WHERE idConfiguration = " + Id + ";");
			if (result.first())
				c = new Configuration(result.getInt("idConfiguration"), result.getString("Type"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return c;
	}
	
	public Configuration findByIdSpectacle(int id) {
		Configuration c = null;
		
		try {
			ResultSet result = connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
					.executeQuery("SELECT * FROM Configuration WHERE idSpectacle = " + id + ";");
			if (result.first())
				c = new Configuration(result.getInt("idConfiguration"), result.getString("Type"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return c;
		
	}
	
	
	public  boolean AjouterAvecIdSpectacle(Spectacle obj) {
		try {
			String update ="UPDATE Configuration SET IdSpectacle = '" + obj.getId() + "' WHERE IdSpectacle = 0;";
			connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeUpdate(update);
		} 
		catch (SQLException e) {

			e.printStackTrace();
		}
		return true;
	}



}