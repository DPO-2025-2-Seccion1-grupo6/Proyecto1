package uniandes.usuarios.dpoo;

import java.time.LocalDateTime;
import java.util.Objects;

public class Administrador extends Usuario {
	public Administrador(String id, String nombre, String email, String login, String password,double saldo) {
		super(id, nombre, email, login, password, saldo);
	}
	@Override
	public boolean esAdmin() { 
		return true; }
	
	 public void fijarTarifaServicio(Evento evento, double porcentaje) {
	        Objects.requireNonNull(evento, "evento");
	        if (porcentaje < 0) throw new IllegalArgumentException("el porcentaje no pueder ser menor a 0");
	        evento.setTarifaServicio(porcentaje);
	    }
	 public void fijarCuotaEmision(Evento evento, int valor) {
	        Objects.requireNonNull(evento, "evento");
	        if (valor < 0) throw new IllegalArgumentException("el valor no puede ser menor a 0");
	        evento.setCobroEmision(valor);
	    }
	 public void aprobarVenue(Venue venue) {
	        Objects.requireNonNull(venue, "venue");
	        venue.setAprobado(true);
	    }
	 public void cancelarEvento(Evento evento, String causa) {
	        Objects.requireNonNull(evento, "evento");
	        Objects.requireNonNull(causa, "causa");
	        evento.cancelar(causa);
}
	 public void autorizarReembolso(Tiquete tiquete, double monto) {
	        Objects.requireNonNull(tiquete, "tiquete");
	        if (monto < 0) throw new IllegalArgumentException("el monto no puede ser un numero negativo");
	        tiquete.autorizarReembolso(monto);     
	        Usuario usuario = tiquete.getDuenoActual();
	        if (usuario != null) usuario.acreditarSaldo(monto);
	 }
	 public double consultarFinanzas(Evento evento) {
	        Objects.requireNonNull(evento, "evento");
	        return evento.calcularIngresosTotales(); 
	 }
	 
}
