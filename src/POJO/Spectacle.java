package POJO;

import java.io.Serializable;
import java.util.*;

import DAO.*;

public class Spectacle implements Serializable{

	//Attributs
	private static final long serialVersionUID = -3582331972992320638L;

	protected static DAOFactory factory = (DAOFactory)DAOFactory.getFactory(0);
	protected static SpectacleDAO dao = factory.getSpectacleDAO();
	
	private int id;
	private String titre;
	private int nbrPlaceParClient;
	private Configuration configuration;
	private List<Artiste> artistes;
	private List<Representation> representations;
	private int idSalle;

	
	
	//Constructeurs
	public Spectacle()
	{
		
	}
	
	public Spectacle(String titre, int nbrPlaceParClient,int idSalle) {
		this.titre = titre;
		this.nbrPlaceParClient = nbrPlaceParClient;
		this.idSalle =idSalle;
	}
	
	public Spectacle(int id,String titre, int nbrPlaceParClient,int idSalle) {
		this.id = id;
		this.titre = titre;
		this.nbrPlaceParClient = nbrPlaceParClient;
		this.idSalle =idSalle;
	}
	
	public Spectacle(String titre, int nbrPlaceParClient,int idSalle,List<Artiste> artistes) {
		this.titre = titre;
		this.nbrPlaceParClient = nbrPlaceParClient;
		this.idSalle =idSalle;
		this.artistes = artistes;
	}
	
	public Spectacle(String titre, int nbrPlaceParClient, Configuration configuration,List<Artiste> artistes,List<Representation> representations) {
		this.titre = titre;
		this.nbrPlaceParClient = nbrPlaceParClient;
		this.configuration = configuration;
		this.artistes = artistes;
		this.representations = representations;
	}
	
	//Accesseurs
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	
	
	public int getNbrPlaceParClient() {
		return nbrPlaceParClient;
	}
	public void setNbrPlaceParClient(int nbrPlaceParClient) {
		this.nbrPlaceParClient = nbrPlaceParClient;
	}
	
	
	public Configuration getConfiguration() {
		return configuration;
	}
	public void setConfiguration(Configuration configuration) {
		this.configuration = configuration;
	}
	
	
	public List<Artiste> getArtistes() {
		return artistes;
	}
	public void setArtistes(List<Artiste> artistes) {
		this.artistes = artistes;
	}
	
	
	public List<Representation> getRepresentations() {
		return representations;
	}
	public void setRepresentations(List<Representation> representations) {
		this.representations = representations;
	}
	
	
	public int getIdSalle() {
		return idSalle;
	}
	public void setIdSalle(int idSalle) {
		this.idSalle = idSalle;
	}

	//Méthodes
	public boolean ajouterSpectacle() 
	{
		return dao.create(this);
	}
	
	public Spectacle findByTitre(String titre) {
		return dao.findByTitle(titre);
	}
	
	//Liste
	public List<Spectacle> listeSpectacles(){
		return dao.listeSpectacles();
	}
	
	//ToString
	public String toString()
	{
		return titre;
	}
}
