package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import POJO.*;

public class ConfigurationDAO extends DAO<Configuration> {
	
	//Constructeur
	public ConfigurationDAO(Connection conn) {
		super(conn);
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