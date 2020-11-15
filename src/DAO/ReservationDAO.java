package DAO;

import java.sql.Connection;
import POJO.*;

public class ReservationDAO implements DAO<Reservation> {
	
	protected Connection connect = null;
	
	//Constructeur
	public ReservationDAO(Connection conn) {
		super();
	}

	
	//Fonctions
	public  boolean create(Reservation obj) {
		return false;
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



}
