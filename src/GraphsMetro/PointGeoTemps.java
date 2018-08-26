package GraphsMetro;

import java.sql.Time;
import java.util.List;

public class PointGeoTemps implements Comparable<PointGeoTemps> , TraitementVoyage {

	private Time temps ; 
	private SommetPointGeo sommetLie ;
	
	public PointGeoTemps( double latitudeC, double longitudeC ) {
		this.setSommetLie(new SommetPointGeo( latitudeC , longitudeC )) ;
		temps = new Time(0);
		// TODO Auto-generated constructor stub
	}

	public PointGeoTemps( SommetPointGeo sommetALie , Time cout ) {
		this.sommetLie = sommetALie ;
		this.temps = cout ;
	}
	
	@Override
	public int compareTo(PointGeoTemps autreChemin) {
		return this.temps.compareTo( autreChemin.getTemps() );
	}
	
	public Time getTemps() {
		return temps;
	}

	public void setTemps(Time temps) {
		this.temps = temps;
	}
	
	public long getTempsMilliSecondes(){
		return this.temps.getTime() ;
	}

	public SommetPointGeo getSommetLie() {
		return sommetLie;
	}

	public void setSommetLie(SommetPointGeo sommetLie) {
		this.sommetLie = sommetLie;
	}

	public List<SommetPointGeo> getVoisins() {
		return this.sommetLie.getVoisins();
	}

	public void setVoisins(List<SommetPointGeo> voisins) {
		this.sommetLie.setVoisins(voisins);
	}

	public boolean estArrive(PointGeoTemps arrivee) {
		if( 	this.sommetLie.getLatitude() == arrivee.getSommetLie().getLatitude() 
			&&	this.sommetLie.getLongitude() == arrivee.getSommetLie().getLongitude() )
			return true;
		
		return false;
	}

	@Override
	public long getDureeVoyage(PointGeo destination) {
		return this.sommetLie.getDureeVoyage(destination);
	}
	
}
