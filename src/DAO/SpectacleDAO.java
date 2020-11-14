package DAO;

import java.sql.Connection;
import POJO.*;

public class SpectacleDAO implements DAO<Spectacle> {
	
	protected Connection connect = null;
	//Constructeur
	public SpectacleDAO(Connection conn) {
		this.connect=conn;
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
