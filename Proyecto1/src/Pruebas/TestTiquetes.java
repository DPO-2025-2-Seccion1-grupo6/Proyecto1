package Pruebas;

public class TestTiquetes {
	import static org.junit.jupiter.api.Assertions.*;
	import org.junit.jupiter.api.Test;
	import PaqueteEventos.*;

	public class TestTiquetes {

	    
	    public void testCrearTiqueteIndividual() {
	        Evento evento = new Evento(null, "Concierto", true, 20251030, 2000);
	        Tiquete tiquete = new Tiquete(evento, 120000, 5000, 20000, "T001", "A12", true);
	        int precio = tiquete.getPrecio();
	        assertEquals(120000, precio);
	        assertTrue(tiquete.isTransferible());
	    }

	    
	    public void testMostrarInfoTiquete() {
	        Evento evento = new Evento(null, "Obra", true, 20251010, 1900);
	        Tiquete tiquete = new Tiquete(evento, 100000, 3000, 20000, "T002", "B10", false);
	        String info = tiquete.mostrarInfoTiquete();
	        assertTrue(info.contains("T002"));
	        assertTrue(info.contains("Obra"));
	    }
	}
}
