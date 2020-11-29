package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import POJO.*;

public class CommandeDAO implements DAO<Commande> {
	
	private Connection connect = null;
	
	//Constructeur
	public CommandeDAO(Connection conn) {
		this.connect = conn;
	}

	
	//Fonctions
	public  boolean create(Commande obj) {
		try {
		String create = "INSERT INTO Commande (ModePayement, ModeLivraison, Cout)"
				+ "values ('" + obj.getModePayement() + "','" + obj.getModeLivraison() + "', '" + obj.getCout() + "');";
	
		connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeUpdate(create);
		 
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return true;
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
	
	public  boolean updateAvecIdPersonne(Personne obj) {
		try {
			String update ="UPDATE Commande Set idPersonne = '" + obj.getId() + "' WHERE idPersonne = 0;";
			connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeUpdate(update);	
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}
	
	
	public Commande findByAll(String payement, String livraison, int cout, Personne p) {
		Commande c = null;
		try {
			ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
					.executeQuery("SELECT * FROM Commande WHERE ModePayement = '" + payement + "' AND ModeLivraison= '"+ livraison+"' AND Cout = '"+ cout +"' AND idPersonne = '"+p.getId()+"' ;");
			if (result.first()) {
				c = new Commande(result.getInt("idCommande"),result.getString("ModePayement"),result.getString("ModeLivraison"),result.getInt("Cout")); 
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return c;
	}



}
