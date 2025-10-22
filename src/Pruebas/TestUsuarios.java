package Pruebas;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


import Usuarios.Cliente;
import Tiquetes.Tiquete_individual;

public class TestUsuarios {

    @Test
    public void crearClienteYValidarCampos() {
        Cliente cliente = new Cliente("C001", "Juan", "juan@mail.com", "juanp", "1234", 200000, "CC123", "3105555555");

        assertEquals("juanp", cliente.getLogin());
        assertEquals("1234", cliente.getPassword());
        assertEquals("CC123", cliente.getDocumento());
        assertEquals("3105555555", cliente.getTelefono());
        assertEquals(200000, cliente.getSaldo(), 0.0001);
    }

    @Test
    public void agregarTiqueteAlCliente() throws Exception {
        Cliente cliente = new Cliente("C002", "Ana", "ana@mail.com", "anap", "abcd", 0, "CC234", "3001234567");

        Tiquete_individual t = new Tiquete_individual(null,100000,3000,2000,"T001",true,"A12");

        int antes = cliente.getTiquet().size();
        cliente.agregarTiquete(t);
        int despues = cliente.getTiquet().size();

        assertEquals(antes + 1, despues);
        assertTrue(cliente.getTiquet().contains(t));
    }
   
}
