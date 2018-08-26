package GraphsMetro;

import java.util.List;

public class SommetPointGeo extends PointGeo implements TraitementVoyage {

	private List<SommetPointGeo> voisins ;
	
	public SommetPointGeo(double latitudeC, double longitudeC) {
		super(latitudeC, longitudeC);
		// TODO Auto-generated constructor stub
	}

	public List<SommetPointGeo> getVoisins() {
		return voisins;
	}

	public void setVoisins(List<SommetPointGeo> voisins) {
		this.voisins = voisins;
	}
	
	public long getDureeVoyage( PointGeo destination ){
		
		if( destination instanceof Station )
			return this.getDureeVoyageInt( (Station) destination ) ;
		
		if( destination instanceof Coordonnees )
			return this.getDureeVoyageInt( (Station) destination ) ;
		
		return 0 ;
	}
	
	private long getDureeVoyageInt( Station destination ){
		return 0;
	}

	public long getDureeVoyageInt( Coordonnees destination ){
		return 0;
	}
	
}
