package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import POJO.*;

public class PlanningSalleDAO extends DAO<PlanningSalle> {
	
	//Constructeur
	public PlanningSalleDAO(Connection conn) {
		super(conn);
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
