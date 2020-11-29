package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import POJO.*;

public class RepresentationDAO implements DAO<Representation> {
	
	protected Connection connect = null;
	
	//Constructeur
	public RepresentationDAO(Connection conn) {
		this.connect=conn;
	}
	
	//Fonctions
	public  boolean create(Representation obj) {
		try {
			PreparedStatement ps= null;
			String create = "INSERT INTO Representation (Date, HeureDebut, HeureFin, idSpectacle) VALUES (?,?,?,?)";
			ps = connect.prepareStatement(create);
			connect.createStatement();		
			ps.setDate(1, (java.sql.Date) obj.getDate());			
			ps.setDate(2, (java.sql.Date) obj.getHeureDebut());
			ps.setDate(3, (java.sql.Date) obj.getHeureFin());
			ps.setInt(4, obj.getSpectacle());
			ps.executeUpdate();
			}
			catch(SQLException e) {
				e.printStackTrace();
			return false;
			
			}
		return true;
	}
	
	public  boolean delete(Representation obj) {
		return false;
	}
	
	public  boolean update(Representation obj) {
		return false;
	}
	
	public Representation find(int Id) {
		Representation s = null;
		return s;
	}
	
	public List<Representation> listeRepresentations(int Id) {
		List<Representation> representations = new ArrayList<Representation>();
		try {

			String query = "SELECT * from Representation where IdSpectacle =" + Id +  ";";
			ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
					.executeQuery(query);
				while(result.next()) {
					Representation representation = new Representation(result.getInt("idRepresentation"),result.getDate("Date"),result.getTime("HeureDebut"),result.getTime("HeureFin"));
					representations.add(representation);
				}	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return representations;
	}



}
