package Sistema;

import java.util.Scanner;

public class SistemaMain {

	private static Scanner sc = new Scanner(System.in);
	private SistemaAdministrador administrador;
	private SistemaCliente cliente;
	private SistemaPromotor promotor;
	
	public static void main() {
		SistemaMain sistema = new SistemaMain();
		sistema.iniciar();
		
	}
	public void registrarUsuario() {
		
	}
	public void loguearUsuario() {
		
	}
	public void crearSubsistema() {
		
	}
	public void iniciar() {
		System.out.println("Bienvenido a BoletaMaster");
		System.out.println("Registrarse(0) o loguearse(1)");
		int opcion = sc.nextInt();
		
	}
	
	
	
}
