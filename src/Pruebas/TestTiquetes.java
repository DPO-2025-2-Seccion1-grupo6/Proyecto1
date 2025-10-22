package Pruebas;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import Eventos.Evento;
import Eventos.Venue;
import Tiquetes.Paquete_deluxe;
import Tiquetes.Tiquete_individual;
import Tiquetes.Tiquetes_multiples;

public class TestTiquetes {
	private Evento crearEventoDemo() throws Exception {
	    Venue v = new Venue("Coliseo", 5, -74, 4000, "Seguridad", "Coliseo Mayor");
	    return new Evento(1800, "Concierto", 20251210, 1900, v, 1200.0, 12);
	}


   private List<Tiquete_individual> crearListaTiquetes(Evento e) throws Exception {
        List<Tiquete_individual> lista = new ArrayList<>();
        lista.add(new Tiquete_individual(e, 100000, 3000, 2000, "M001", true,  "A1"));
        lista.add(new Tiquete_individual(e, 100000, 3000, 2000, "M002", true,  "A2"));
        lista.add(new Tiquete_individual(e, 100000, 3000, 2000, "M003", false, "A3"));
        return lista;
    }

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
            Eventos.Venue venue = new Eventos.Venue("Coliseo", 5, -74, 4000, "Sin pirotecnia", "MedPlus");
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


    @Test
    public void tiqueteTransferible_NoTransferible() throws Exception {
        Eventos.Venue v = new Eventos.Venue("Auditorio", 6, -74, 3000, "Sin humo", "Auditorio ML");
        Eventos.Evento e = new Eventos.Evento(1500, "Seminario", 20251115, 1000, v, 900.0, 6);

        Tiquete_individual tTrue  = new Tiquete_individual(e, 80000, 2000, 1000, "TX10", true,  "C3");
        Tiquete_individual tFalse = new Tiquete_individual(e, 80000, 2000, 1000, "TX11", false, "C4");

        assertTrue(tTrue.isTransferible());
        assertFalse(tFalse.isTransferible());
    }
    @Test
    public void dosTiqetesMismoEvento() throws Exception {
        Venue v = new Venue("Arena", 5, -74, 8000, "Sin humo", "Arena Norte");
        Evento e = new Evento(2200, "Charla", 20251106, 1000, v, 1100.0, 10);

        Tiquete_individual t1 = new Tiquete_individual(e, 70000, 2500, 1500, "M001", true,  "A5");
        Tiquete_individual t2 = new Tiquete_individual(e, 70000, 2500, 1500, "M002", false, "A6");

        assertEquals(e, t1.getEvento());
        assertEquals(e, t2.getEvento());
        assertNotEquals(t1.getId(), t2.getId());
        assertNotEquals(t1.getNumAsiento(), t2.getNumAsiento());
        assertTrue(t1.isTransferible());
        assertFalse(t2.isTransferible());
    }

    @Test
    public void mostrarInfo_IncluyeTipoEvento() throws Exception {
        Venue v = new Venue("Teatro", 5, -74, 4000, "Sin pirotecnia", "Teatro Colón");
        Evento e = new Evento(1800, "Obra", 20251210, 1900, v, 1200.0, 12);
        Tiquete_individual t = new Tiquete_individual(e, 90000, 3000, 2000, "TT01", true, "B12");

        java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
        java.io.PrintStream old = System.out;
        System.setOut(new java.io.PrintStream(baos));
        try { t.mostrarInfoTiquete(); } finally { System.setOut(old); }

        String out = baos.toString().toLowerCase();
        assertTrue(out.contains("obra"), "La impresión debe incluir el tipo de evento");
        assertTrue(out.contains("tt01"));
        assertTrue(out.contains("b12"));
    }
    @Test
    public void actualizarTiquete() throws Exception {
        Eventos.Venue v = new Eventos.Venue("Auditorio", 5, -74, 4000, "Seguro", "Auditorio Central");
        Eventos.Evento e = new Eventos.Evento(2000, "Charla", 20251201, 1900, v, 900.0, 8);

        Tiquete_individual t = new Tiquete_individual(e, 80000, 3000, 1500, "X1", true, "A10");

        t.setNumAsiento("Z99");
        t.setId("X2");
        t.setTransferible(false);

        assertEquals("Z99", t.getNumAsiento());
        assertEquals("X2", t.getId());
        assertFalse(t.isTransferible());
    }

    @Test
    public void actualizarTiquetePrecio() throws Exception {
        Eventos.Venue v = new Eventos.Venue("Plaza", 6, -74, 5000, "Seguro", "Plaza Claro");
        Eventos.Evento e = new Eventos.Evento(3000, "Concierto", 20251210, 2000, v, 1200.0, 12);

        Tiquete_individual t = new Tiquete_individual(e, 90000, 3000, 2000, "P01", true, "B1");
        t.setPrecio(95000);

        assertEquals(95000, t.getPrecio(), 0.0001);
    }

    @Test
    public void cambiarEvento() throws Exception {
        Eventos.Venue v1 = new Eventos.Venue("Teatro", 5, -74, 3000, "Sin pirotecnia", "Teatro Jorge Eliecer Gaitan");
        Eventos.Evento e1 = new Eventos.Evento(1500, "Obra", 20251205, 1900, v1, 800.0, 10);

        Eventos.Venue v2 = new Eventos.Venue("Arena", 6, -74, 6000, "Al aire libre", "Arena B");
        Eventos.Evento e2 = new Eventos.Evento(2500, "Feria", 20251206, 1600, v2, 1000.0, 8);

        Tiquete_individual t = new Tiquete_individual(e1, 70000, 2000, 1000, "EV01", true, "C7");
        assertEquals(e1, t.getEvento());

        t.setEvento(e2);
        assertEquals(e2, t.getEvento());
        assertNotEquals(e1, t.getEvento());
    }
    @Test
    public void multipack_CreaConLista() throws Exception {
        Evento e = crearEventoDemo();
        List<Tiquete_individual> lista = crearListaTiquetes(e);

        Tiquete_individual base = lista.get(0);

        Tiquetes_multiples pack = new Tiquetes_multiples(base, lista);

        assertNotNull(pack.getTiquetes());
        assertEquals(3, pack.getTiquetes().size());
        assertEquals("M001", pack.getTiquetes().get(0).getId());
        assertEquals("M003", pack.getTiquetes().get(2).getId());
    }

    @Test
    public void multipack_tiquetesReemplazaLaLista() throws Exception {
        Evento e = crearEventoDemo();
        List<Tiquete_individual> lista1 = crearListaTiquetes(e);
        Tiquete_individual base = lista1.get(0);

        Tiquetes_multiples pack = new Tiquetes_multiples(base, lista1);
        assertEquals(3, pack.getTiquetes().size());
        List<Tiquete_individual> lista2 = new ArrayList<>();
        lista2.add(new Tiquete_individual(e, 95000, 2500, 1800, "N001", true, "B10"));
        lista2.add(new Tiquete_individual(e, 95000, 2500, 1800, "N002", false, "B11"));

        pack.setTiquetes(lista2);
        assertEquals(2, pack.getTiquetes().size());
        assertEquals("N002", pack.getTiquetes().get(1).getId());
    }

    @Test
    public void multipack_mostrarInfoTiquetes() throws Exception {
        Evento e = crearEventoDemo();
        List<Tiquete_individual> lista = crearListaTiquetes(e);
        Tiquete_individual base = lista.get(0);

        Tiquetes_multiples pack = new Tiquetes_multiples(base, lista);

        java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
        java.io.PrintStream old = System.out;
        System.setOut(new java.io.PrintStream(baos));
        try {
            pack.mostrarInfoTiquetes();
        } finally {
            System.setOut(old);
        }
        String out = baos.toString();

        assertTrue(out.contains("Tiquete múltiple"));
        assertTrue(out.contains("M001"));
        assertTrue(out.contains("M002"));
        assertTrue(out.contains("M003"));
    }


    @Test
    public void deluxe_CreaConBeneficiosYLista() throws Exception {
        Evento e = crearEventoDemo();
        List<Tiquete_individual> lista = crearListaTiquetes(e);
        Tiquete_individual base = lista.get(0);

        String[] beneficios = new String[] { "Fast track", "Bebida", "Mercancia" };
        Paquete_deluxe deluxe = new Paquete_deluxe(base, lista, beneficios, lista.size());

        assertNotNull(deluxe.getTiquetes());        
        assertEquals(3, deluxe.getTiquetes().size());
    }

    @Test
    public void deluxe_mostrarBeneficios_ImprimeCadaBeneficio() throws Exception {
        Evento e = crearEventoDemo();
        List<Tiquete_individual> lista = crearListaTiquetes(e);
        Tiquete_individual base = lista.get(0);
        String[] beneficios = new String[] { "Fast track", "Bebida", "Mercancia" };

        Paquete_deluxe deluxe = new Paquete_deluxe(base, lista, beneficios, lista.size());

        java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
        java.io.PrintStream old = System.out;
        System.setOut(new java.io.PrintStream(baos));
        try {
            deluxe.mostrarBeneficios();
        } finally {
            System.setOut(old);
        }
        String out = baos.toString();

        assertTrue(out.contains("Beneficios del Paquete Deluxe"));
        assertTrue(out.contains("Fast track"));
        assertTrue(out.contains("Bebida"));
        assertTrue(out.contains("Mercancia"));
    }

    @Test
    public void deluxe_mostrarBeneficios() throws Exception {
        Evento e = crearEventoDemo();
        List<Tiquete_individual> lista = crearListaTiquetes(e);
        Tiquete_individual base = lista.get(0);

        Paquete_deluxe deluxe = new Paquete_deluxe(base, lista, null, lista.size());

        assertDoesNotThrow(deluxe::mostrarBeneficios);
    }
}




