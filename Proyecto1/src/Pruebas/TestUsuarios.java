package Pruebas;

import Usuarios.Cliente;

public class TestUsuarios {

    
    public void testAutenticarUsuario() {
        
        Cliente cliente = new Cliente("C001", "Juan", "juan@mail.com", "juanp", "1234", 200000, "CC123", "3105555555");
        
        
        boolean autenticado = cliente.autenticar("juanp", "1234");
        
        
        assertTrue(autenticado);
    }

    
    public void testAcreditarYDebitarSaldo() {
        
        Cliente cliente = new Cliente("C002", "Ana", "ana@mail.com", "ana", "abcd", 100000, "CC124", "3110000000");
        
        
        cliente.acreditarSaldo(50000);
        cliente.debitarSaldo(20000);
        
        
        assertEquals(130000, cliente.getSaldo());
    }

    
    public void testAdministradorFijarTarifaServicio() {
        
        Administrador admin = new Administrador("A001", "Admin", "admin@mail.com", "root", "admin", 0);
        Evento evento = new Evento(null, "Concierto", true, 20251020, 1800);
        
        
        admin.fijarTarifaServicio(evento, 0.15);
        
        
        assertEquals(0.15, evento.getTarifaServicio());
    }
}}
