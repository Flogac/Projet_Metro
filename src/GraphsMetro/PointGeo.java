package GraphsMetro;

public abstract class PointGeo {

	private double latitude ;
	private double longitude ;
	
	public PointGeo( double latitudeC , double longitudeC ){
		this.setLatitude(latitudeC) ;
		this.setLongitude(longitudeC) ;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	
}
