package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import POJO.*;


public class ArtisteDAO extends DAO<Artiste> {
	
	//Constructeur
	public ArtisteDAO(Connection conn) {
		super(conn);
	}
	
	//Fonctions
	public  boolean create(Artiste obj) {
		try {
			
		String ajout = "INSERT INTO Personne (Nom,Prenom,Adresse,Discriminator,Email,MotDePasse) "
				+ "values ('" + obj.getNom() + "','" + obj.getPrenom() + "','" + obj.getAdresse() + "','Artiste','"+ obj.getEmail() + "','" + obj.getPassword() + "');";
		System.out.println(ajout);
		connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
				.executeUpdate(ajout);
		}
		catch(Exception e) {
			return false;
		}
		return true;
	}
	
	public  boolean delete(Artiste obj) {
		
	}
	
	public  boolean update(Artiste obj) {
		
	}
	
	public  Artiste find(int Id) {
		
	}

}
