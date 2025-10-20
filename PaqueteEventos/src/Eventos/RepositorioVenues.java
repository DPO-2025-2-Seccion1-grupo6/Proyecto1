package Eventos;

import java.util.HashMap;
import java.util.Map;

public class RepositorioVenues {
	private Map<Integer, Venue> venuesActivos;
	private Map<Integer, Venue> venuesInactivos;
	
	public RepositorioVenues(){
		venuesActivos = new HashMap<Integer, Venue>();
		venuesInactivos = new HashMap <Integer, Venue>();
	}
	
	public void agregarVenueActivo(Venue venue) {
		venuesActivos.put(venue.getIdVenue(), venue);
	}
	public void agregarVenueInactivo(Venue venue) {
		venuesInactivos.put(venue.getIdVenue(), venue);
	}
	public void desactivarVenue(Venue venue) {
		int id = venue.getIdVenue();
		venuesActivos.remove(id);
		venuesInactivos.put(id, venue);
	}
	public void rechazarVenue(Venue venue) {
		int id  = venue.getIdVenue();
		venuesInactivos.remove(id);
	}
}
