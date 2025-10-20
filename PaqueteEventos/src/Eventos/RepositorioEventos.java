package Eventos;

import java.util.HashMap;
import java.util.Map;

public class RepositorioEventos {
	private Map<Integer, Evento> eventosActivos;
	private Map<Integer, Evento> eventosInactivos;
	
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
}
