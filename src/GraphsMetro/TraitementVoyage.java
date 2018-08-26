package GraphsMetro;

import java.util.List;

public interface TraitementVoyage {

	public List<SommetPointGeo> getVoisins() ;
	
	public void setVoisins(List<SommetPointGeo> voisins) ;
	
	public long getDureeVoyage( PointGeo destination ) ;
	
}
