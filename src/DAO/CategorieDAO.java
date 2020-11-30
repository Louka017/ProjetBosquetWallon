package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import POJO.*;

public class CategorieDAO implements DAO<Categorie> {
	
	private Connection connect = null;
	
	//Constructeur
	public CategorieDAO(Connection conn) {
		this.connect = conn;
	}
	
	//Fonctions
	public  boolean create(Categorie obj) {
		try {
		String create = "INSERT INTO Categorie (Type, Prix, NbrPlaceDispo, NbrPlaceMax) "
				+ "values ('" + obj.getType() + "','" + obj.getPrix() + "','" + obj.getNbrPlaceDispo() + "','" + obj.getNbrPlaceMax()+ "');";

		connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeUpdate(create);
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return true;
	}
	
	public  boolean delete(Categorie obj) {
		return false;
	}
	
	public  boolean update(Categorie obj) {
		return false;
	}
	
	public  Categorie find(int Id) {
		Categorie s = null;
		return s;
	}
	
	
	

	public  boolean AjouterAvecIdConfiguration(Configuration obj) {
		try {
			String update ="UPDATE Categorie SET idConfiguration = '" + obj.getId() + "' WHERE idConfiguration = 0;";
			connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeUpdate(update);
		} 
		catch (SQLException e) {

			e.printStackTrace();
		}
		return true;
	}

	
	public Categorie findByIdConfiguration(int id) {
		Categorie c = null;
		
		try {
			ResultSet result = connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
					.executeQuery("SELECT * FROM Categorie WHERE idConfiguration = " + id + ";");
			if (result.first())
				c = new Categorie(result.getInt("idCategorie"), result.getString("Type"),result.getInt("Prix"),result.getInt("NbrPlaceDispo"),result.getInt("NbrPlaceMax"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return c;
	}
	
	public List<Categorie> findAllByIdConfiguration(int id){
		List<Categorie> categories = new ArrayList<Categorie>();
		try {

			String query = "SELECT * FROM Categorie WHERE idConfiguration = " + id + ";";
			ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
					.executeQuery(query);
				while(result.next()) {
					Categorie	c = new Categorie(result.getInt("idCategorie"), result.getString("Type"),result.getInt("Prix"),result.getInt("NbrPlaceDispo"),result.getInt("NbrPlaceMax"));
					categories.add(c);
				}	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return categories;
	}
	
	
	public boolean ajouterAvecReresentation(int id) {
		try {
			String update ="UPDATE Categorie SET idRepresentation = '" + id + "' WHERE idRepresentation = 0;";
			connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeUpdate(update);
		} 
		catch (SQLException e) {

			e.printStackTrace();
		}
		return true;
	}
	

	public List<Categorie> findAllByConfigurationAndRepresentation(Configuration c, Representation r){
		List<Categorie> categories = new ArrayList<Categorie>();
		try {

			String query = "SELECT * FROM Categorie WHERE (idConfiguration = '" + c.getId() + "') AND (idRepresentation ='"+r.getId()+"');";
			ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
					.executeQuery(query);
				while(result.next()) {
					Categorie	cat = new Categorie(result.getInt("idCategorie"), result.getString("Type"),result.getInt("Prix"),result.getInt("NbrPlaceDispo"),result.getInt("NbrPlaceMax"));
					categories.add(cat);
				}	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return categories;
	}
	
	public boolean updateWithInt (Categorie obj) {
		try {	
			String update = "UPDATE Categorie  set Type = '"+ obj.getType() + "', Prix = '" + obj.getPrix() + "', NbrPlaceDispo= '" + obj.getNbrPlaceDispo() + "',NbrPlaceMax= '" + obj.getNbrPlaceMax() + "'WHERE (idConfiguration = '" + obj.getId() + "') ;";
			System.out.println(update);
			connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeUpdate(update);
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return true;
	}
	
	
	
}
