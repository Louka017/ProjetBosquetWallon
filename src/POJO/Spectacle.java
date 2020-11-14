package POJO;

import java.io.Serializable;
import java.util.*;

import DAO.*;

public class Spectacle implements Serializable{

	//Attributs
	private static final long serialVersionUID = -3582331972992320638L;

	protected static DAOFactory factory = (DAOFactory)DAOFactory.getFactory(0);
	protected static SpectacleDAO dao = factory.getSpectacleDAO();
	
	private String titre;
	private int nbrPlaceParClient;
	private Configuration configuration;
	private List<Artiste> artistes;
	private List<Representation> representations;
	
	//Constructeur
	public Spectacle(String titre, int nbrPlaceParClient, Configuration configuration,List<Artiste> artistes,List<Representation> representations) {
		this.titre = titre;
		this.nbrPlaceParClient = nbrPlaceParClient;
		this.configuration = configuration;
		this.artistes = artistes;
		this.representations = representations;
	}
	
	//Accesseurs
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

}
