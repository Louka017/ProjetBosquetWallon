package DAO;

import java.sql.Connection;
import POJO.*;

public class ConfigurationDAO implements DAO<Configuration> {
	
	private Connection connect = null;
	//Constructeurs
	public ConfigurationDAO(Connection conn) {
		this.connect = conn;
	}

	
	//Fonctions
	public  boolean create(Configuration obj) {
		return false;
	}
	
	public  boolean delete(Configuration obj) {
		return false;
	}
	
	public  boolean update(Configuration obj) {
		return false;
	}
	
	public Configuration find(int Id) {
		Configuration s = null;
		return s;
	}



}