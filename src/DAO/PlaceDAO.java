package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import POJO.*;

public class PlaceDAO implements DAO<Place> {
	
	private Connection connect = null;
	
	//Constructeur
	public PlaceDAO(Connection conn) {
		this.connect = conn;
	}
	
	//Fonctions
	public  boolean create(Place obj) {
		try {
		String create = "INSERT INTO Place (Prix)"
				+ "values ('" + obj.getPrix() + "');";
	
		connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeUpdate(create);
		
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return true;
	}
	
	
	public  boolean delete(Place obj) {
		return false;
	}
	
	public  boolean update(Place obj) {
		return false;
	}
	
	public Place find(int Id) {
		Place s = null;
		return s;
	}

	public boolean createAvecRepresentation(Representation obj) {
		try {
			String update ="UPDATE Place Set idrepresentation = '" + obj.getId() + "' WHERE idRepresentation = 0;";
			connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeUpdate(update);
			
		} 
		catch (SQLException e) {

			e.printStackTrace();
		}
		return true;
	}
	
	//PEUT ETRE SUPPRIMER
	public boolean createInPlaceCommande(Place obj, Commande c) {
		try {
		String create = "INSERT INTO Place_Commande (idPlace, idCommande)" 
									+ "values ('" + obj.getId() + "','" + c.getId()+"');";
	
		connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeUpdate(create);
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return true;
	
	}
}
