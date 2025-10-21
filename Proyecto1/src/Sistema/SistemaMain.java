package Sistema;

import java.util.HashSet;
import java.util.Scanner;
import java.util.UUID;

import Usuarios.Administrador;
import Usuarios.Cliente;
import Usuarios.Promotor;
import Usuarios.RepositorioUsuarios;
import Usuarios.Usuario;

public class SistemaMain {

	private static Scanner sc = new Scanner(System.in);
	private SistemaAdministrador sistemaAdministrador;
	private SistemaCliente sistemaCliente;
	private SistemaPromotor sistemaPromotor;
	private Usuario usuarioActual;
    private RepositorioUsuarios repo;
	
	public static void main(String[] args) {
		SistemaMain sistema = new SistemaMain();
		sistema.iniciar();
		
	}
	public void iniciar() {
		boolean opcionCorrecta = false;
		System.out.println("Bienvenido a BoletaMaster");
		System.out.println("Registrarse(0) o loguearse(1)");
		int opcion = sc.nextInt();
		while (opcionCorrecta != true) {
			if(opcion == 1) {
				loguearUsuario();
				opcionCorrecta = true;
			}
			if(opcion == 2) {
				registrarUsuario();
				opcionCorrecta = true;
			}
			else {
				System.out.println("Opcion incorrecta");
			}
		}
		
		
	}
	public void registrarUsuario() {
        System.out.println("=== Registro de usuario ===");
        System.out.println("Tipo (1=Cliente, 2=Promotor, 3=Administrador): ");
        int tipo = sc.nextInt(); sc.nextLine();

        System.out.print("Nombre: "); String nombre = sc.nextLine();
        System.out.print("Email: "); String email = sc.nextLine();
        System.out.print("Login: "); String login = sc.nextLine();
        System.out.print("Password: "); String password = sc.nextLine();

        String id = UUID.randomUUID().toString();
        double saldo = 0;

        Usuario nuevo = null;

        switch (tipo) {
            case 1 -> {
                System.out.print("Documento: "); String documento = sc.nextLine();
                System.out.print("Teléfono: "); String telefono = sc.nextLine();
                nuevo = new Cliente(id, nombre, email, login, password, saldo, documento, telefono);
            }
            case 2 -> {
                System.out.print("NIT: "); String nit = sc.nextLine();
                nuevo = new Promotor(id, nombre, email, login, password, saldo, 0, nit);
            }
            case 3 -> {
                nuevo = new Administrador(id, nombre, email, login, password, saldo);
            }
        }

        repo.guardarUsuario(nuevo);
        System.out.println("✅ Usuario registrado correctamente.");
    }

    public boolean loguearUsuario() {
        System.out.println("=== Inicio de sesión ===");
        System.out.print("Login: ");
        String login = sc.nextLine();
        System.out.print("Password: ");
        String pass = sc.nextLine();

        HashSet<Usuario> usuarios = repo.cargarUsuarios();

        for (Usuario u : usuarios) {
            if (u.autenticador(login, pass)) {
                usuarioActual = u;
                System.out.println("✅ Bienvenido " + u.getNombre() + " (" + u.getClass().getSimpleName() + ")");
                return true;
            }
        }

        System.out.println("Credenciales incorrectas.");
        return false;
    }
    public void crearSubsistema() {
        if (usuarioActual instanceof Administrador) {
            sistemaAdministrador = new SistemaAdministrador((Administrador) usuarioActual);
            sistemaAdministrador.mostrarMenu();
        } else if (usuarioActual instanceof Cliente) {
            sistemaCliente = new SistemaCliente((Cliente) usuarioActual);
            sistemaCliente.mostrarMenu();
        } else if (usuarioActual instanceof Promotor) {
            sistemaPromotor = new SistemaPromotor((Promotor) usuarioActual);
            sistemaPromotor.mostrarMenu();
        } else {
            System.out.println("Tipo de usuario desconocido.");
        }
    }
	
	
	
}
