package Sistema;

import java.util.Scanner;
import Usuarios.Promotor;

public class SistemaPromotor extends SubSistema {

    private Scanner sc = new Scanner(System.in);

    public SistemaPromotor(Promotor promotor) {
        super(promotor);
    }

    @Override
    public void mostrarMenu() {
        int opcion = -1;
        do {
            System.out.println("\n=== MENÚ PROMOTOR ===");
            System.out.println("1. Crear evento propio");
            System.out.println("2. Consultar ganancias");
            System.out.println("3. Aplicar oferta a localidad");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1 -> crearEvento();
                case 2 -> consultarGanancias();
                case 3 -> aplicarOferta();
                case 0 -> System.out.println("Saliendo del sistema de promotor...");
                default -> System.out.println("Opción inválida.");
            }

        } while (opcion != 0);
    }

    private void crearEvento() {
        System.out.println("→ Evento creado correctamente.");
    }

    private void consultarGanancias() {
        System.out.println("→ Mostrando ganancias de tus eventos...");
    }

    private void aplicarOferta() {
        System.out.println("→ Oferta aplicada correctamente.");
    }
}