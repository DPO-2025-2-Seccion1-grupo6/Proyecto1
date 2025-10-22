	package Pruebas;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import Eventos.Evento;
import Eventos.Venue;
import Tiquetes.Tiquete_individual;
import Usuarios.Administrador;
import Usuarios.Cliente;
import Usuarios.Promotor;
import Usuarios.Usuario;
	
	public class TestUsuarios {
	
	    @Test
	    public void crearCliente() {
	        Cliente cliente = new Cliente("C001", "Juan", "juan@gmail.com", "juanp", "1234", 200000, "CC123", "3105555555");
	
	        assertEquals("juanp", cliente.getLogin());
	        assertEquals("1234", cliente.getPassword());
	        assertEquals("CC123", cliente.getDocumento());
	        assertEquals("3105555555", cliente.getTelefono());
	        assertEquals(200000, cliente.getSaldo(), 0.0001);
	    }
	
	    @Test
	    public void agregarTiqueteAlCliente() throws Exception {
	        Cliente cliente = new Cliente("C002", "Ana", "ana@gmail.com", "anap", "abcd", 0, "CC234", "3001234567");
	
	        Tiquete_individual t = new Tiquete_individual(null,100000,3000,2000,"T001",true,"A12");
	
	        int antes = cliente.getTiquet().size();
	        cliente.agregarTiquete(t);
	        int despues = cliente.getTiquet().size();
	
	        assertEquals(antes + 1, despues);
	        assertTrue(cliente.getTiquet().contains(t));
	    }
	    @Test
	    public void clienteSaldoSeActualiza() throws Exception {
	        Cliente c = new Cliente("C003", "Luis", "luismail@hotmail.com", "luisp", "pass", 50000, "CC345", "3012345678");

	        c.acreditarSaldo(25000);

	        assertEquals(75000, c.getSaldo(), 0.0001, "El saldo debe actualizarse correctamente");
	    }


	    @Test
	    public void clienteAgregaMultiplesTiquetes() throws Exception {
	        Cliente c = new Cliente("C004", "Maria", "maria@hotmail.com", "mariap", "clave", 100000, "CC567", "3125556666");

	        Tiquete_individual t1 = new Tiquete_individual(null, 50000, 2000, 1000, "T200", true, "A1");
	        Tiquete_individual t2 = new Tiquete_individual(null, 60000, 3000, 1500, "T201", false, "A2");

	        c.agregarTiquete(t1);
	        c.agregarTiquete(t2);

	        assertEquals(2, c.getTiquet().size(), "Debe tener dos tiquetes");
	    }

	    @Test
	    public void clienteDatosPersonalesCorrectos() {
	        Cliente c = new Cliente("C005", "Valeria", "vale@gmail.com", "vale123", "clave", 150000, "CC678", "3152223333");

	        assertAll("Datos personales del cliente",
	            () -> assertEquals("Valeria", c.getNombre()),
	            () -> assertEquals("vale@gmail.com", c.getEmail()),
	            () -> assertEquals("vale123", c.getLogin())
	        );
	    }
	   
	    @Test
	    public void EsAdmin() {
	        Administrador admin = new Administrador("A10", "Root", "root@mail.com", "root", "toor", 0.0);

	        assertTrue(admin instanceof Usuario);
	        assertTrue(admin.esAdmin(), "Administrador.esAdmin() debe ser true");

	        assertNotNull(admin.getId(), "El id del admin no debe ser null");
	        assertFalse(String.valueOf(admin.getId()).isBlank(), "El id del admin no debe estar vacío");

	        assertEquals("Root", admin.getNombre());
	        assertEquals("root@mail.com", admin.getEmail());
	        assertEquals("root", admin.getLogin());
	        assertEquals("toor", admin.getPassword());
	        assertEquals(0.0, admin.getSaldo(), 0.0001);
	    }



	    @Test
	    public void adminAutorizaReembolso() throws Exception {
	        Venue v = new Venue("Teatro", 5, -74, 4000, "Sin pirotecnia", "Movistar Arena");
	        Evento e = new Evento(1500, "Obra", 20251210, 1900, v, 1200.0, 12);
	        Tiquete_individual t = new Tiquete_individual(e, 90000, 3000, 2000, "R001", true, "A1");

	        Cliente dueno = new Cliente("C1", "Ana", "ana@hotmail.com", "ana", "123", 5000.0, "CC1", "3000000000");
	        t.setDuenoActual(dueno);

	        Administrador admin = new Administrador("A1", "Admin", "a@mail.com", "admin", "pw", 0.0);

	        double saldoAntes = dueno.getSaldo();
	        admin.autorizarReembolso(t, 2000.0);
	        double saldoDespues = dueno.getSaldo();

	        assertEquals(saldoAntes + 2000.0, saldoDespues, 0.0001, "El reembolso debe acreditarse al dueño");
	    }

	    @Test
	    public void adminConsultarFinanzas() throws Exception {
	        Venue v = new Venue("Coliseo", 6, -74, 8000, "Seguridad", "MedPlus");
	        Evento e = new Evento(2000, "Concierto", 20251201, 2000, v, 1500.0, 10);

	        Administrador admin = new Administrador("A2", "Alice", "ali@hotmail.com", "alice", "pw", 0.0);
	        double valor = admin.consultarFinanzas(e.getFinanzasTotales());
	        assertTrue(valor >= 0, "consultarFinanzas debe retornar un número válido");
	    }

	    @Test
	    public void promotorBasico() {
	        Promotor p = new Promotor("P10", "Pro", "pro@gmail.com", "promo", "123", 10000.0, 5, "NIT-999");

	        assertTrue(p instanceof Usuario);

	        assertNotNull(p.getId(), "El id del promotor no debe ser null");
	        assertFalse(String.valueOf(p.getId()).isBlank(), "El id del promotor no debe estar vacío");

	        assertEquals("Pro", p.getNombre());
	        assertEquals("pro@gmail.com", p.getEmail()); 
	        assertEquals("promo", p.getLogin());
	        assertEquals("123", p.getPassword());
	        assertEquals(10000.0, p.getSaldo(), 0.0001);

	        assertEquals(5, p.getReputacion());
	        assertEquals("NIT-999", p.getNit());
	    }


	    @Test
	    public void promotorReputacionNegativa() {
	        assertThrows(IllegalArgumentException.class, () ->
	            new Promotor("P11", "Bad", "badi@gmail.com", "bad", "pw", 0.0, -1, "NIT-1")
	        );
	    }

	

	}
	
	
