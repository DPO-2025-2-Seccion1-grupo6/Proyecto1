package Eventos;

import java.util.HashMap;
import java.util.Map;
import java.io.*;



public class RepositorioEventos implements Serializable{
	private static final long serialVersionUID = 1L;
	private Map<Integer, Evento> eventosActivos;
	private Map<Integer, Evento> eventosInactivos;
	private static final String ARCHIVO = "Achivos_Persistidos/ARCHIVO_EVENTOS.dat";
	
	public RepositorioEventos(){
		eventosActivos = new HashMap<Integer, Evento>();
		eventosInactivos = new HashMap <Integer, Evento>();
	}
	
	public void agregarEventoActivo(Evento evento) {
		eventosActivos.put(evento.getIdEvento(), evento);
	}
	public void agregarEventoInactivo(Evento evento) {
		eventosInactivos.put(evento.getIdEvento(), evento);
	}
	public void finalizarEvento(Evento evento) {
		int id = evento.getIdEvento();
		eventosActivos.remove(id);
		eventosInactivos.put(id, evento);
	}
	

    public void guardar() {
    	try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ARCHIVO))) {
            oos.writeObject(this);
            System.out.println("Repositorios guardados correctamente.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public static RepositorioEventos cargar() {
    	try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ARCHIVO))) {
            return (RepositorioEventos) ois.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado, se creará uno nuevo.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return new RepositorioEventos();
    }
    public Map<Integer, Evento> getVenuesActivos() {
        return eventosActivos;
    }

    public Map<Integer, Evento> getVenuesInactivos() {
        return eventosInactivos;
    }
}
