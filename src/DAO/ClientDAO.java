package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import POJO.*;

public class ClientDAO implements DAO<Client> {
	
	private Connection connect = null;

	//Constructeurs
	public ClientDAO(Connection conn) {
		this.connect = conn;
	}


	//Fonctions
	public  boolean create(Client obj) {
		
		try {
		String create = "INSERT INTO Personne (Nom,Prenom,Rue,Numero,Ville,CodePostal,Discriminator,Email,MotDePasse) "
				+ "values ('" + obj.getNom() + "','" + obj.getPrenom() + "','" + obj.getRue() + "','" + obj.getNumero() + "','" + obj.getVille() + "','" + obj.getCp() + "','Client','"+ obj.getEmail() + "','" + obj.getPassword() + "');";
		System.out.println(create);
		connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY).executeUpdate(create);
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return true;
	}
	
	
	public  boolean delete(Client obj) {
		
		try {	
			String delete = "DELETE FROM Personne where idPersonne = " + obj.getId() + ";";
			System.out.println(delete);
			connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeUpdate(delete);
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return true;
	}
	
	
	public  boolean update(Client obj) {
			
		try {	
			String update = "UPDATE Personne set Nom = '"+ obj.getNom() + "', Prenom = '" + obj.getPrenom() + "', Rue= '" + obj.getRue() + "',Numero= '" + obj.getNumero() + "',Ville= '" + obj.getVille() + "',CodePostal= '" + obj.getCp() + "', Email = '" + obj.getEmail() + "', MotDePasse ='" + obj.getPassword() + "');";
			System.out.println(update);
			connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeUpdate(update);
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return true;
	}
	
	
	public Client find(int Id) {
		
		Client client = null;
		try {
			ResultSet result = connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
					.executeQuery("SELECT * FROM Personne WHERE idPersonne = " + Id + ";");
			if (result.first())
				client = new Client(result.getString("Nom"), result.getString("Prenom"), result.getString("Rue"),result.getInt("Numero"),result.getString("Ville"),result.getInt("CodePostal"),result.getString("Email"), result.getString("MotDePasse"), result.getInt("IdPersonne"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return client;
	}




}
