package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import POJO.*;

public class SpectacleDAO extends DAO<Spectacle> {
	
	//Constructeur
	public SpectacleDAO(Connection conn) {
		super(conn);
	}
	
	//Fonctions
	public  boolean create(Spectacle obj) {
		return false;
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
