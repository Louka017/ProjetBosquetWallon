package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import POJO.*;

public class ReservationDAO implements DAO<Reservation> {
	
	protected Connection connect = null;
	
	//Constructeur
	public ReservationDAO(Connection conn) {
		this.connect = conn;
	}

	
	//Fonctions
	public  boolean create(Reservation obj) {

		try {
			String create = "INSERT INTO Reservation (Acompte, Solde, Statut, Prix, idSalle) "
					+ "values ('" + obj.getAcompte()+ "','" + obj.getSolde() + "','" + obj.getStatut() + "','" + obj.getPrix()+ "','"+ obj.getIdPlanningSalle() +"');";
			connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeUpdate(create);
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
			return true;
		
	}
	
	public  boolean delete(Reservation obj) {
		return false;
	}
	
	public  boolean update(Reservation obj) {
		return false;
	}
	
	public Reservation find(int Id) {
		Reservation s = null;
		return s;
	}
	
	
	public  boolean ajouterOrganisateuraLaResr(Personne o) {
		try {
			String update ="UPDATE Reservation Set idOrganisateur = '" + o.getId() + "' WHERE idOrganisateur = 0;";
			connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeUpdate(update);
			
		} 
		catch (SQLException e) {

			e.printStackTrace();
		}
		return true;
	}



}
