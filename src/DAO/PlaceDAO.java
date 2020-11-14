package DAO;

import java.sql.Connection;
import POJO.*;

public class PlaceDAO implements DAO<Place> {
	
	private Connection connect = null;
	//Constructeur
	public PlaceDAO(Connection conn) {
		this.connect = conn;
	}
	
	//Fonctions
	public  boolean create(Place obj) {
		return false;
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


}
