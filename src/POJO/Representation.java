package POJO;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import DAO.*;

public class Representation implements Serializable {

	private static final long serialVersionUID = -7253524476235799528L;
	protected static DAOFactory factory = (DAOFactory) DAOFactory.getFactory(0);
	protected static RepresentationDAO dao = factory.getRepresentationDAO();
	
	//ATTRIBUTS
	private int id;
	private Date date;
	private Date heureDebut;
	private Date heureFin;
	private Spectacle spectacle;
	
	//Constructeur
	public Representation() {

	}
	
	public Representation(Date date, Date heureDebut, Date heureFin) {
		this.date = date;
		this.heureDebut = heureDebut;
		this.heureFin = heureFin;
	}
	
	public Representation(Date date, Date heureDebut, Date heureFin, Spectacle spectacle) {
		this.date = date;
		this.heureDebut = heureDebut;
		this.heureFin = heureFin;
		this.spectacle = spectacle;
	}
	
	public Representation(int id,Date date, Date heureDebut, Date heureFin) {
		this.id = id;
		this.date = date;
		this.heureDebut = heureDebut;
		this.heureFin = heureFin;
	}
	
	
	//ACCESSEURS
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	
	public Date getHeureDebut() {
		return heureDebut;
	}
	public void setHeureDebut(Date heureDebut) {
		this.heureDebut = heureDebut;
	}
	
	
	public Date getHeureFin() {
		return heureFin;
	}
	public void setHeureFin(Date heureFin) {
		this.heureFin = heureFin;
	}
	
	public int getSpectacle() {
		return spectacle.getId();
	}
	public void setSpectacle(Spectacle spectacle) {
		this.spectacle = spectacle;
	}

	
	//METHODES
	//Ajouter representation
	public boolean ajouterRps() {
		return dao.create(this);
	}
	
	//Liste
	public List<Representation> listeRepresentations(int idS){
		return dao.listeRepresentations(idS);
	}
	
	//Afficher Representation
	public String toString() {	
		DateFormat dateFormat = new SimpleDateFormat("HH:mm");
		String strDate = dateFormat.format(heureDebut); 
		String strDate2 = dateFormat.format(heureFin);
		return date + "       " + strDate + "            " + strDate2;
	}
	
	//Regarder si la date de la representation est comprise dans les jours où la salle est louée
	public boolean verifyDateRepresentation(PlanningSalle i) {
		  if((this.getDate().before(i.getDateDebutSal()) || this.getDate().after(i.getDateFinSal()))){
			  return false;
		  }
		  return true;
	}
	
	//Regarder si l'heure de la représentation peut être correctement ajoutée. Obligé de comparer par rapport aux parametres plutot qu'à l'objet lui même pour les heures à cause du java.sql.Date, impossible de récupérer l'heure de l'objet tant qu'il n'est pas créer dans la db
	public int verifyHeureRepresentation(PlanningSalle ps, Date hd, Date hf){
		String strHeureDebut, goodHeureDeb, goodMinuteDeb;
		String strHeureFin, goodHeureFin, goodMinuteFin;
		int VraiHeureDeb = 0, VraiMinuteDeb=0;
		int VraiHeureFin = 0, VraiMinuteFin=0;
		DateFormat dateFormat = new SimpleDateFormat("HH:mm");
		String[] splitArray = null;
		String[] splitArray2 = null;
		int heureD = hd.getHours();
		int minuteD = hd.getMinutes();
		int heureF = hf.getHours();
		int minuteF = hf.getMinutes();
		List<Representation> liste = listeRepresentations(ps.getId());
		for(Representation r : liste) {
			if(r.getDate().equals(this.getDate())) {
				strHeureDebut = dateFormat.format(r.getHeureDebut());
				strHeureFin = dateFormat.format(r.getHeureFin());		
				splitArray = strHeureDebut.split(":");
				splitArray2 = strHeureFin.split(":");
				
				for(int i = 0; i< splitArray.length;i++){
					   //RECUPERE JUSTE L'HEURE
						 goodHeureDeb = splitArray[0];
						 VraiHeureDeb = Integer.parseInt(goodHeureDeb);
						 goodMinuteDeb = splitArray[1];
						 VraiMinuteDeb = Integer.parseInt(goodMinuteDeb);
				}
				for(int i = 0; i< splitArray2.length;i++){
					   //RECUPERE JUSTE L'HEURE
						goodHeureFin = splitArray2[0];
						VraiHeureFin = Integer.parseInt(goodHeureFin);
						goodMinuteFin = splitArray2[1];
						VraiMinuteFin = Integer.parseInt(goodMinuteFin);
				}
				
				if( ((heureD > VraiHeureDeb)&&(heureD < VraiHeureFin)) ) {
					return 0;
				}
				
				if( (heureD == VraiHeureDeb)&&(heureD < VraiHeureFin))  {
					return 0;
				}
				
				if( (heureD < VraiHeureDeb)&&(heureF >= VraiHeureFin) ) {
					return 0;
				}
					  	  
			}
			return 1;
		}
		return 1;
	}
	
	
	public Representation findByDate(){
		return dao.findByDate(this.date, this.heureDebut, this.heureFin);
	}
	

	
}
