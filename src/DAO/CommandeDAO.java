package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import POJO.*;

public class CommandeDAO extends DAO<Commande> {
	
	//Constructeur
	public CommandeDAO(Connection conn) {
		super(conn);
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
