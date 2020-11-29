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
	

	
	//Constructeurs
	public Spectacle()
	{
		
	}
	
	public Spectacle(int id, String titre, int nbrPlaceParClient)
	{
		this.id=id;
		this.titre = titre;
		this.nbrPlaceParClient = nbrPlaceParClient;
	}
	
	
	public Spectacle(String titre, int nbrPlaceParClient) {
		this.titre = titre;
		this.nbrPlaceParClient = nbrPlaceParClient;
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
		return this.id;
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
	
	


	//Méthodes
	public boolean ajouterSpectacle() 
	{
		return dao.create(this);
	}
	
	public Spectacle findByTitre() {
		return dao.findByTitle(this.titre);
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
	
	public int trouveidSalle() {
		return dao.trouveidSalle(this);
	}
	
	//AjouterViaPlanningSalle
	public boolean ajoutPectacleAvecIdSalle(PlanningSalle ps) {
		dao.create(this);
		
		return dao.ajouterAvecIdSalle(ps);
	}
	
	//Ajouter Personne_Spectacle
	public boolean ajouterPlanningSalle(Personne p) {
		return p.ajouterPlanningSalle(this);
	}
	
	
	//AjouterCategorie
	public boolean ajouterConfiguration(Configuration conf) {
		return conf.ajouterIdSpectacle(this);
	}
	


}
