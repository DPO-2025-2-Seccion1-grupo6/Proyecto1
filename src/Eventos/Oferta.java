package Eventos;

import java.time.LocalDate;

import Usuarios.Promotor;

public class Oferta {
	private LocalDate fechaInicio;
	private LocalDate fechaFin;
	private int porcentajeDescuento;
	private boolean esActiva;
	private Localidad localidadAsociada;
	private Promotor promotor;
	
	
	public Oferta(LocalDate fechaInicio, LocalDate fechaFin, int porcentajeDescuento,Promotor promotor, Localidad localidad) {
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.porcentajeDescuento = porcentajeDescuento;
		esActiva = true;
		localidadAsociada = localidad;
		this.promotor = promotor;
	}
	
	public double aplicarDescuento() {
		double precio = localidadAsociada.getPrecio();
		double rst = precio * porcentajeDescuento / 100;
		return rst;
	}

	public LocalDate getFechaInicio() {
		return fechaInicio;
	}


	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}


	public LocalDate getFechaFin() {
		return fechaFin;
	}


	public void setFechaFin(LocalDate fechaFin) {
		this.fechaFin = fechaFin;
	}


	public int getPorcentajeDescuento() {
		return porcentajeDescuento;
	}


	public void setPorcentajeDescuento(int porcentajeDescuento) {
		this.porcentajeDescuento = porcentajeDescuento;
	}


	public boolean isEsActiva() {
		return esActiva;
	}
	public void desactivarDescuento() {
		this.esActiva = false;
		localidadAsociada.setOferta(null);
	}

	public Localidad getLocalidadAsociada() {
		return localidadAsociada;
	}


	public void setLocalidadAsociada(Localidad localidadAsociada) {
		this.localidadAsociada = localidadAsociada;
	}
	
	
}
