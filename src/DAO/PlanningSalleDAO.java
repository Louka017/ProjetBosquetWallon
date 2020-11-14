package DAO;

import java.sql.Connection;
import POJO.*;

public class PlanningSalleDAO implements DAO<PlanningSalle> {
	
	protected Connection connect = null;
	//Constructeur
	public PlanningSalleDAO(Connection conn) {
		this.connect = conn;
	}
	
	//Fonctions
	public  boolean create(PlanningSalle obj) {
		return false;
	}
	
	public  boolean delete(PlanningSalle obj) {
		return false;
	}
	
	public  boolean update(PlanningSalle obj) {
		return false;
	}
	
	public PlanningSalle find(int Id) {
		PlanningSalle s = null;
		return s;
	}


}
