package Usuarios;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

import Eventos.Evento;
import Eventos.Finanzas;
import Eventos.Localidad;
import Eventos.Oferta;
import Eventos.Venue;

public class Promotor extends Usuario{
private int reputacion;
private String nit;

public Promotor(String id, String nombre, String email, String login, String password, double saldo,int reputacion, String nit ) {
	super(id,nombre,email,login,password,saldo);
	if (reputacion<0) throw new IllegalArgumentException("La reputacion no puede ser menor a 0");
	this.reputacion= reputacion;
	this.nit=Objects.requireNonNull(nit,"nit");


}
public Oferta crearOferta(Localidad localidad, int porcentajeDescuento, LocalDate fechaInicio, LocalDate fechaFin) {
	if (porcentajeDescuento <= 0 || porcentajeDescuento >= 1)throw new IllegalArgumentException("Descuento debe estar en (0,1)");
	if (fechaFin.isBefore(fechaInicio)) throw new IllegalArgumentException("Rango de fechas inválido");
	return new Oferta(fechaInicio, fechaFin,porcentajeDescuento, this,localidad);
}
public int getReputacion() {
	return reputacion;
}
public String getNit() {
	return nit;
}
public double consultarFinanzas(Finanzas finanzas) {
	Objects.requireNonNull(finanzas, "finanzas");
	return finanzas.calcularGananciasPromotor();
}
}