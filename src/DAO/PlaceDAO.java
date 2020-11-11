package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import POJO.*;

public class PlaceDAO extends DAO<Place> {
	
	//Constructeur
	public PlaceDAO(Connection conn) {
		super(conn);
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
