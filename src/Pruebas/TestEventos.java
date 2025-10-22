package Pruebas;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;



import Eventos.Evento;
import Eventos.Venue;

public class TestEventos {

    @Test
    public void crearVenueEvento() throws Exception {
        Venue venue = new Venue("Estadio", 4, -74, 5000, "Sin pirotecnia", "Plaza Claro");

        Evento evento = new Evento(3000,"Concierto",20251030,2000,venue,1500.0,10);

        assertEquals("Concierto", evento.getTipoEvento());
        assertEquals(3000, evento.getCapacidadEvento());
        assertEquals(20251030, evento.getFechaEvento());
        assertEquals(2000, evento.getHoraEvento());
        assertEquals(venue, evento.getVenueAsociado());
    }

    @Test
    public void finanzasSeInicializan() throws Exception {
        Venue venue = new Venue("Auditorio", 4, -74, 2000, "Sin humo", "Auditorio ML");
        Evento evento = new Evento(1500, "Charla", 20251010, 1900, venue, 1000.0, 15);

        assertNotNull(evento.getFinanzasTotales());
    }
    @Test
    public void eventosConDistintosVenuesIndependientes() throws Exception {
        Eventos.Venue v1 = new Eventos.Venue("Estadio", 5, -74, 4000, "Sin pirotecnia", "MedPlus");
        Eventos.Venue v2 = new Eventos.Venue("Auditorio", 6, -74, 2000, "Sin humo", "Auditorio ML");

        Eventos.Evento e1 = new Eventos.Evento(2500, "Charla",     20251120, 1930, v1, 1200.0, 12);
        Eventos.Evento e2 = new Eventos.Evento(1500, "Concierto",20251201, 2000, v2, 1500.0, 10);

        org.junit.jupiter.api.Assertions.assertEquals("Charla",      e1.getTipoEvento());
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
    @Test
    public void mismoDia_HorasDistintas() throws Exception {
        Venue v = new Venue("Coliseo", 6, -74, 9000, "Seguridad", "Movistar Arena");
        Evento e1 = new Evento(2000, "Congreso", 20251210, 900,  v, 1200.0, 10);
        Evento e2 = new Evento(2000, "Congreso", 20251210, 2000, v, 1200.0, 10);

        assertEquals(20251210, e1.getFechaEvento());
        assertEquals(e1.getFechaEvento(), e2.getFechaEvento());
        assertNotEquals(e1.getHoraEvento(), e2.getHoraEvento());
    }

    @Test
    public void valoresBasicosValidos() throws Exception {
        Venue v = new Venue("Parque", 4, -74, 6000, "Aire libre", "Parque de la 93");
        Evento e = new Evento(1800, "Festival", 20251215, 1830, v, 2000.0, 8);

        assertTrue(e.getCapacidadEvento() > 0);
        assertNotNull(e.getVenueAsociado());

        int fecha = e.getFechaEvento();
        assertTrue(fecha >= 20000101 && fecha <= 20991231, "Fecha fuera de rango YYYYMMDD");

        int hora = e.getHoraEvento();
        int hh = hora / 100, mm = hora % 100;
        assertTrue(hh >= 0 && hh <= 23 && mm >= 0 && mm <= 59, "Hora fuera de rango HHMM");
    }

    @Test
    public void finanzasInstanciaEnElMismoEvento() throws Exception {
        Venue v = new Venue("estadio", 5, -74, 5000, "Techado", "El campin");
        Evento e = new Evento(1500, "Charla", 20251130, 1000, v, 900.0, 6);

        Object f1 = e.getFinanzasTotales();
        Object f2 = e.getFinanzasTotales();

        assertNotNull(f1);
        assertSame(f1, f2, "En el mismo evento debe devolverse la misma instancia de finanzas");
    }

    @Test
    public void porcentajeYCobro() throws Exception {
        Venue v = new Venue("Arena", 6, -74, 12000, "Sin humo", "Arena Mayor");
        Evento e = new Evento(3000, "Expo", 20251220, 1100, v, 2500.0, 15);

        try {
            java.lang.reflect.Method mp = e.getClass().getMethod("getPorcentajeServicio");
            int p = ((Number) mp.invoke(e)).intValue();
            assertTrue(p >= 0, "Porcentaje de servicio debe ser no negativo");
        } catch (NoSuchMethodException ignore) {
        }

        try {
            java.lang.reflect.Method mc = e.getClass().getMethod("getCobroEmision");
            double c = ((Number) mc.invoke(e)).doubleValue();
            assertTrue(c >= 0.0, "Cobro de emisión debe ser no negativo");
        } catch (NoSuchMethodException ignore) {
        }
    }

    @Test
    public void mismoVenueCompartidoEventos() throws Exception {
        Venue v = new Venue("Teatro", 4, -74, 4500, "Sin pirotecnia", "Teatro Principal");
        Evento e1 = new Evento(1200, "Obra",  20251205, 1900, v, 800.0, 10);
        Evento e2 = new Evento(1400, "Opera", 20251206, 2000, v, 900.0, 12);

        assertSame(v, e1.getVenueAsociado());
        assertSame(v, e2.getVenueAsociado());
    }


}
