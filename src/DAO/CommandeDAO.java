package DAO;

import java.sql.Connection;
import POJO.*;

public class CommandeDAO implements DAO<Commande> {
	
	private Connection connect = null;
	
	//Constructeur
	public CommandeDAO(Connection conn) {
		this.connect = conn;
	}

	
	//Fonctions
	public  boolean create(Commande obj) {
		return false;
	}
	
	public  boolean delete(Commande obj) {
		return false;
	}
	
	public  boolean update(Commande obj) {
		return false;
	}
	
	public Commande find(int Id) {
		Commande s = null;
		return s;
	}



}
