package Pruebas;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;



import Tiquetes.Tiquete_individual;

public class TestTiquetes {

    @Test
    public void crearTiqueteIndividual() throws Exception {
        Tiquete_individual t = new Tiquete_individual(null,120000,5000,20000,"T001",true, "B10");
        assertEquals(120000, t.getPrecio(), 0.0001);
        assertTrue(t.isTransferible());
        assertEquals("T001", t.getId());
        assertEquals("B10", t.getNumAsiento());
    }

    @Test
    public void mostrarInfoTiquete() throws Exception {
        Eventos.Venue venue = new Eventos.Venue("Coliseo", 5, -74, 4000, "Seguridad", "Evento Prueba");
        Eventos.Evento evento = new Eventos.Evento(1800, "Concierto", 20251210, 1900, venue, 1200.0, 12);
        Tiquete_individual t = new Tiquete_individual(evento, 100000, 3000, 2000, "T001", true, "B10");
        assertDoesNotThrow(() -> t.mostrarInfoTiquete());
    }

    
    @Test
    public void mostrarInfoTiquete_Id_Asiento() throws Exception {
        java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
        java.io.PrintStream old = System.out;
        System.setOut(new java.io.PrintStream(baos));
        try {
            Eventos.Venue venue = new Eventos.Venue("Teatro", 5, -74, 4000, "Sin pirotecnia", "Teatro Colón");
            Eventos.Evento evento = new Eventos.Evento(1800,"Obra", 20251210, 1900, venue,1200.0,12);

            Tiquetes.Tiquete_individual t =new Tiquetes.Tiquete_individual(evento, 100000, 3000, 2000, "T777", true, "C15");
            t.mostrarInfoTiquete(); 
        } finally {
            System.setOut(old);
        }
        String out = baos.toString();
        org.junit.jupiter.api.Assertions.assertTrue(out.contains("T777"), "La salida debe incluir el ID");
        org.junit.jupiter.api.Assertions.assertTrue(out.contains("C15"),  "La salida debe incluir el asiento");
    }

  

}
