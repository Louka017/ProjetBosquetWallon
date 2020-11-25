package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


import POJO.*;

public class PlanningSalleDAO implements DAO<PlanningSalle> {
	
	protected Connection connect = null;
	
	//Constructeur
	public PlanningSalleDAO(Connection conn) {
		this.connect = conn;
	}
	

	//Fonctions
	public  boolean create(PlanningSalle obj) {

		try {
			PreparedStatement ps= null;
			String create = "INSERT INTO PlanningSalle (DateDebut, DateFin) VALUES (?,?)";
			ps = connect.prepareStatement(create);
			connect.createStatement();		
			ps.setDate(1, (java.sql.Date) obj.getDateDebutSal());
			ps.setDate(2, (java.sql.Date)obj.getDateFinSal());
			ps.executeUpdate();
			}
			catch(SQLException e) {
				e.printStackTrace();
			return false;
			
			}
		return true;
	}
	
	public  boolean delete(PlanningSalle obj) {
		return false;
	}
	
	public  boolean update(PlanningSalle obj) {
		return false;
	}
	
	public PlanningSalle find(int Id) {

		PlanningSalle s = null;

		try {
			ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
					.executeQuery("SELECT * FROM PlanningSalle WHERE idSalle = '" + Id + "';");
			if (result.first())
				s = new PlanningSalle(result.getInt("idSalle"),result.getDate("DateDebut"), result.getDate("DateFin"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return s;
	}
	
	
	public PlanningSalle findByDate(Date db, Date df) {
		PlanningSalle s = new PlanningSalle();
		SimpleDateFormat localDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");	
		
		Timestamp t = new Timestamp(db.getTime());

		t.setNanos(00);
		try {
			String query = "SELECT * from PlanningSalle where (DateDebut='" + localDateFormat.format(t) +"')";

		
			ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
					.executeQuery(query);

			if(result.first())
				s = new PlanningSalle(result.getInt("idSalle"),result.getDate("DateDebut"), result.getDate("DateFin"));

			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return s;
	}


}
