package uniandes.usuarios.dpoo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class Promotor extends Usuario{
private int reputacion;
private String nit;

public Promotor(String id, String nombre, String email, String login, String password, double saldo,int reputacion, String nit ) {
	super(id,nombre,email,login,password,saldo);
	if (reputacion<0) throw new IllegalArgumentException("La reputacion no puede ser menor a 0");
	this.reputacion= reputacion;
	this.nit=Objects.requireNonNull(nit,"nit");
	
	
}
public Evento crearEvento(String nombre, String tipoEvento, LocalDate fechaEvento, LocalTime horaEvento,Venue venue, double porcentajeVenta, double tarifaServicio, int cuotaEmision) {
	Objects.requireNonNull(nombre); 
	Objects.requireNonNull(tipoEvento);
	Objects.requireNonNull(fechaEvento); 
	Objects.requireNonNull(horaEvento);
	Objects.requireNonNull(venue);
	if (porcentajeVenta < 0 || porcentajeVenta > 1) throw new IllegalArgumentException("porcentajeVentas debe ser de 0 a 1");
	if (tarifaServicio < 0) throw new IllegalArgumentException("la tarifa de servicio no debe ser meno a 0");
	if (cuotaEmision < 0) throw new IllegalArgumentException("su cuota de emision no puede ser meno a 0");

	return new Evento(UUID.randomUUID().toString(), nombre, tipoEvento, fechaEvento, horaEvento,venue, porcentajeVenta, tarifaServicio, cuotaEmision, this);

}
public void configurarLocalidades(Evento evento, List<Localidad> localidades) {
    Objects.requireNonNull(evento); 
    Objects.requireNonNull(localidades);
    evento.configurarLocalidades(localidades);
    
}
public Oferta crearOferta(Localidad localidad, double porcentajeDescuento, LocalDate fechaInicio, LocalDate fechaFin) {
	if (porcentajeDescuento <= 0 || porcentajeDescuento >= 1)throw new IllegalArgumentException("Descuento debe estar en (0,1)");
	if (fechaFin.isBefore(fechaInicio)) throw new IllegalArgumentException("Rango de fechas inválido");
	return new Oferta(UUID.randomUUID().toString(), localidad, porcentajeDescuento, fechaInicio, fechaFin, this);
}
public int getReputacion() {
	return reputacion;
}
public String getNit() {
	return nit;
}
public double consultarFinanzas(Evento evento) {
	Objects.requireNonNull(evento, "evento");
	return evento.calcularIngresoPromotor();
}
}
