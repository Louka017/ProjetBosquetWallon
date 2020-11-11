package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import POJO.*;

public class PersonneDAO extends DAO<Personne> {
	
	//Constructeur
	public PersonneDAO(Connection conn) {
		super(conn);
	}
	
	//Fonctions
	public  boolean create(Personne obj) {
		return false;
	}
	
	public  boolean delete(Personne obj) {
		return false;
	}
	
	public  boolean update(Personne obj) {
		return false;
	}
	
	public Personne find(int Id) {
		Personne s = null;
		return s;
	}

}
