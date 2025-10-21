package Pruebas;

public class TestEventos {
	import static org.junit.jupiter.api.Assertions.*;
	import org.junit.jupiter.api.Test;
	import PaqueteEventos.*;

	public class TestEventos {

	    
	    public void testCrearEventoActivo() {
	        Evento evento = new Evento(null, "Festival", true, 20251225, 2000);
	        assertTrue(evento.isActivo());
	        assertEquals("Festival", evento.getTipoEvento());
	    }

	    @Test
	    public void testCancelarEvento() {
	        Evento evento = new Evento(null, "Teatro", true, 20251110, 2100);
	        evento.cancelar("Causa: Clima");
	        assertFalse(evento.isActivo());
	    }
	}
}
