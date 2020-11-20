package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

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
		String create = "INSERT INTO Spectacle (Titre, NbrPlaceMax, idArtiste, idSalle) "
				+ "values ('" + obj.getTitre() + "','" + obj.getNbrPlaceParClient() + "','"+ obj.getida()+ "','"+ obj.getId() + "');";
		System.out.println(create);
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



}
