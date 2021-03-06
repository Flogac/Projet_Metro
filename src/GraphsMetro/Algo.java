package GraphsMetro;

import java.sql.Time;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Algo {
	
	private GraphePointsGeo grapheDePoints;
	private PriorityQueue< PointGeoTemps > frontiere ;
	private	HashMap < SommetPointGeo , Time > coutJusqueLa ;
	private	HashMap < SommetPointGeo , SommetPointGeo > origine ;
	private PointGeoTemps pointActuel ;
	private Time nouveauCout ;
	
	public Algo( GraphePointsGeo grapheARentrer ){
		this.grapheDePoints = grapheARentrer ;
	}
	
	/*
	 * frontier = PriorityQueue()
frontier.put(start, 0)
came_from = {}
cost_so_far = {}
came_from[start] = None
cost_so_far[start] = 0

while not frontier.empty():
   current = frontier.get()

   if current == goal:
      break
   
   for next in graph.neighbors(current):
      new_cost = cost_so_far[current] + graph.cost(current, next)
      if next not in cost_so_far or new_cost < cost_so_far[next]:
         cost_so_far[next] = new_cost
         priority = new_cost
         frontier.put(next, priority)
         came_from[next] = current
	 */
	public void dijkstra( PointGeoTemps depart , PointGeoTemps arrivee ){

		this.pointActuel = depart ;
		this.frontiere = new PriorityQueue< PointGeoTemps >( ) ;
		this.coutJusqueLa = new HashMap < SommetPointGeo , Time >( grapheDePoints.getTaille( ) + 2 );
		this.origine = new HashMap < SommetPointGeo , SommetPointGeo > ( grapheDePoints.getTaille( ) + 2 );
		
		this.origine.put( this.pointActuel.getSommetLie( ) , null ) ;
		this.coutJusqueLa.put( this.pointActuel.getSommetLie( ) , new Time( 0 ) ) ;
		
		while (	! this.frontiere.isEmpty( ) 
			&& 	! this.pointActuel.estArrive( arrivee ) ){ 
			
			for( SommetPointGeo voisin : this.pointActuel.getVoisins( ) ){
				
				this.nouveauCout = new Time( this.pointActuel.getTempsMilliSecondes( ) + this.pointActuel.getDureeVoyage( voisin ) ) ;
				
				if(		! coutJusqueLa.containsKey( this.pointActuel )
					||	this.nouveauCout.compareTo( this.coutJusqueLa.get( this.pointActuel ) ) < 0 ){
					
					this.coutJusqueLa.put( voisin , this.nouveauCout ) ;
					this.frontiere.add( new PointGeoTemps( this.pointActuel.getSommetLie() , this.nouveauCout ) ) ;
					this.origine.put( voisin , this.pointActuel.getSommetLie() ) ;
					
				}
			}
			
			this.pointActuel = frontiere.remove() ;
		}
		
	}
	
}
