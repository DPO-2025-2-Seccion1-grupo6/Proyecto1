package Pruebas;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;



import Eventos.Evento;
import Eventos.Venue;

public class TestEventos {

    @Test
    public void crearVenueYEventol() throws Exception {
        Venue venue = new Venue("Teatro", 4, -74, 5000, "Sin pirotecnia", "Teatro Nacional");

        Evento evento = new Evento(3000,"Concierto",20251030,2000,venue,1500.0,10);

        assertEquals("Concierto", evento.getTipoEvento());
        assertEquals(3000, evento.getCapacidadEvento());
        assertEquals(20251030, evento.getFechaEvento());
        assertEquals(2000, evento.getHoraEvento());
        assertEquals(venue, evento.getVenueAsociado());
    }

    @Test
    public void finanzasSeInicializan() throws Exception {
        Venue venue = new Venue("Auditorio", 4, -74, 2000, "Sin humo", "Auditorio Uni");
        Evento evento = new Evento(1500, "Obra", 20251010, 1900, venue, 1000.0, 15);

        assertNotNull(evento.getFinanzasTotales());
    }
    @Test
    public void eventosConDistintosVenuesIndependientes() throws Exception {
        Eventos.Venue v1 = new Eventos.Venue("Teatro", 5, -74, 4000, "Sin pirotecnia", "Teatro Colón");
        Eventos.Venue v2 = new Eventos.Venue("Auditorio", 6, -74, 2000, "Sin humo", "Auditorio Uni");

        Eventos.Evento e1 = new Eventos.Evento(2500, "Obra",     20251120, 1930, v1, 1200.0, 12);
        Eventos.Evento e2 = new Eventos.Evento(1500, "Concierto",20251201, 2000, v2, 1500.0, 10);

        org.junit.jupiter.api.Assertions.assertEquals("Obra",      e1.getTipoEvento());
        org.junit.jupiter.api.Assertions.assertEquals("Concierto", e2.getTipoEvento());

        org.junit.jupiter.api.Assertions.assertEquals(v1, e1.getVenueAsociado());
        org.junit.jupiter.api.Assertions.assertEquals(v2, e2.getVenueAsociado());

        org.junit.jupiter.api.Assertions.assertEquals(20251120, e1.getFechaEvento());
        org.junit.jupiter.api.Assertions.assertEquals(20251201, e2.getFechaEvento());
        org.junit.jupiter.api.Assertions.assertEquals(1930, e1.getHoraEvento());
        org.junit.jupiter.api.Assertions.assertEquals(2000, e2.getHoraEvento());
    }

    @Test
    public void eventoPorcentajeYCobro() throws Exception {
        Eventos.Venue v = new Eventos.Venue("Coliseo", 6, -74, 12000, "Sin humo", "Coliseo Mayor");
        Eventos.Evento e = new Eventos.Evento(3000, "Feria", 20251210, 1000, v, 2000.0, 15);

        try {
            java.lang.reflect.Method m = e.getClass().getMethod("getPorcentajeServicio");
            Object val = m.invoke(e);
            org.junit.jupiter.api.Assertions.assertEquals(15, ((Number)val).intValue());
        } catch (NoSuchMethodException ignore) {
        }

        try {
            java.lang.reflect.Method m = e.getClass().getMethod("getCobroEmision");
            Object val = m.invoke(e);
            org.junit.jupiter.api.Assertions.assertEquals(2000.0, ((Number)val).doubleValue(), 0.0001);
        } catch (NoSuchMethodException ignore) {
        }
    }

    @Test
    public void finanzasInicializadas_IndependientesPorEvento() throws Exception {
        Eventos.Venue v = new Eventos.Venue("Arena", 5, -74, 8000, "Sin pólvora", "Arena Norte");
        Eventos.Evento e1 = new Eventos.Evento(1800, "Charla", 20251105, 900, v, 900.0, 8);
        Eventos.Evento e2 = new Eventos.Evento(2200, "Seminario", 20251106, 1000, v, 1100.0, 10);

        org.junit.jupiter.api.Assertions.assertNotNull(e1.getFinanzasTotales());
        org.junit.jupiter.api.Assertions.assertNotNull(e2.getFinanzasTotales());
        org.junit.jupiter.api.Assertions.assertNotSame(e1.getFinanzasTotales(), e2.getFinanzasTotales(),
                "Cada evento debe tener su propio objeto Finanzas");
    }

}
