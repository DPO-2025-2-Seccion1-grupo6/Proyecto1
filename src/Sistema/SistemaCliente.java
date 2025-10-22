package Sistema;

import java.util.Scanner;
import Usuarios.Cliente;

public class SistemaCliente extends SubSistema {

    private Scanner sc = new Scanner(System.in);

    public SistemaCliente(Cliente cliente) {
        super(cliente);
    }

    @Override
    public void mostrarMenu() {
        int opcion = -1;
        do {
            System.out.println("\n=== MENÚ CLIENTE ===");
            System.out.println("1. Ver eventos disponibles");
            System.out.println("2. Comprar tiquete");
            System.out.println("3. Transferir tiquete");
            System.out.println("4. Consultar saldo");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1 -> verEventos();
                case 2 -> comprarTiquete();
                case 3 -> transferirTiquete();
                case 4 -> consultarSaldo();
                case 0 -> System.out.println("Saliendo del sistema de cliente...");
                default -> System.out.println("Opción inválida.");
            }

        } while (opcion != 0);
    }

    private void verEventos() {
        System.out.println("→ Listando eventos disponibles...");
    }

    private void comprarTiquete() {
        System.out.println("→ Compra de tiquete simulada.");
    }

    private void transferirTiquete() {
        System.out.println("→ Tiquete transferido correctamente.");
    }

    private void consultarSaldo() {
        Cliente c = (Cliente) usuario;
        System.out.println("Tu saldo actual es: $" + c.getSaldo());
    }
}