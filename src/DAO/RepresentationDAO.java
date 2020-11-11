package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import POJO.*;

public class RepresentationDAO extends DAO<Representation> {
	
	//Constructeur
	public RepresentationDAO(Connection conn) {
		super(conn);
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
