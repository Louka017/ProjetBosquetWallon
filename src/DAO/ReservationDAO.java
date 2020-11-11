package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import POJO.*;

public class ReservationDAO extends DAO<Reservation> {
	
	//Constructeur
	public ReservationDAO(Connection conn) {
		super(conn);
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
