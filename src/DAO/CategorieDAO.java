package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

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
		String create = "INSERT INTO Categorie (Type, Prix, NbrPlaceDispo, NbrPlaceMax, idConfiguration) "
				+ "values ('" + obj.getType() + "','" + obj.getPrix() + "','" + obj.getNbrPlaceDispo() + "','" + obj.getNbrPlaceMax()+ "','" + obj.getIdConfiguration() + "');";

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


}
