package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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

	
	public Representation findByDate(Date date, Date heureDebut, Date heureFindate) {
		Representation s = null;
		
		SimpleDateFormat localDateFormat = new SimpleDateFormat("yyyy-MM-dd");	
		SimpleDateFormat localDateFormatLong = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Timestamp t = new Timestamp(date.getTime());
		t.setNanos(00);
		Timestamp u = new Timestamp(heureDebut.getTime());
		u.setNanos(00);
		Timestamp v = new Timestamp(heureFindate.getTime());
		v.setNanos(00);
		
		try {
			String query = "SELECT * from Representation where (Date='" + localDateFormat.format(t) +"') and (HeureDebut = '"+localDateFormatLong.format(u)+"') and (HeureFin ='"+localDateFormatLong.format(v)+"') ";
			
			ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
					.executeQuery(query);
			
			if (result.first())
				s = new Representation(result.getInt("idRepresentation"), result.getDate("Date"),result.getDate("HeureDebut"),result.getDate("HeureFin"));
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return s;
	}



}
