package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import POJO.*;

public class CategorieDAO extends DAO<Categorie> {
	
	//Constructeur
	public CategorieDAO(Connection conn) {
		super(conn);
	}
	
	//Fonctions
	public  boolean create(Categorie obj) {
		return false;
	}
	
	public  boolean delete(Categorie obj) {
		return false;
	}
	
	public  boolean update(Categorie obj) {
		return false;
	}
	
	public  Categorie find(int Id) {
		Categorie s = null;
		return s;
	}

}
