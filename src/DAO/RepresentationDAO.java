package DAO;

import java.sql.Connection;
import POJO.*;

public class RepresentationDAO implements DAO<Representation> {
	
	protected Connection connect = null;
	
	//Constructeur
	public RepresentationDAO(Connection conn) {
		this.connect=conn;
	}
	
	//Fonctions
	public  boolean create(Representation obj) {
		return false;
	}
	
	public  boolean delete(Representation obj) {
		return false;
	}
	
	public  boolean update(Representation obj) {
		return false;
	}
	
	public Representation find(int Id) {
		Representation s = null;
		return s;
	}



}
