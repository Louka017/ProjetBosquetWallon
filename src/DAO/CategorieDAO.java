package DAO;

import java.sql.Connection;
import POJO.*;

public class CategorieDAO implements DAO<Categorie> {
	
	private Connection connect = null;
	
	//Constructeur
	public CategorieDAO(Connection conn) {
		this.connect = conn;
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
