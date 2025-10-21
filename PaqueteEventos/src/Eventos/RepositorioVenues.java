/*package Eventos;

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
}*/
package Eventos;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class RepositorioVenues implements Serializable {
    private static final long serialVersionUID = 1L;
    private Map<Integer, Venue> venuesActivos;
    private Map<Integer, Venue> venuesInactivos;
    private static final String ARCHIVO = "Archivos_Persistidos/ARCHIVO_VENUES.dat";

    public RepositorioVenues() {
        venuesActivos = new HashMap<>();
        venuesInactivos = new HashMap<>();
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
        int id = venue.getIdVenue();
        venuesInactivos.remove(id);
    }

    public void guardar() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ARCHIVO))) {
            oos.writeObject(this);
            System.out.println("Repositorio de venues guardado correctamente.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static RepositorioVenues cargar() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ARCHIVO))) {
            return (RepositorioVenues) ois.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado, se creará un nuevo repositorio de venues.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return new RepositorioVenues();
    }
    public Map<Integer, Venue> getVenuesActivos() {
        return venuesActivos;
    }

    public Map<Integer, Venue> getVenuesInactivos() {
        return venuesInactivos;
    }
}
