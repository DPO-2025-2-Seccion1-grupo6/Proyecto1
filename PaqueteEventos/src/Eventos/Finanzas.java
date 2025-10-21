package Eventos;

import java.util.ArrayList;
import java.util.List;

public class Finanzas{
	private double precioBase;//localidades
	private double ganancias;//localidades y eventos - calculado
	private int cantidadVendidos;//localidades y eventos - calculado
	private int porcentajeVenta;//localidades y eventos - calculado
	private double tarifaServicio;//eventos
	private double cobroEmision;//eventos
	private List<Finanzas> subFinanzas;//eventos
	private Localidad localidadAsociada;//localidades
	private Evento eventoAsociado;//eventos
	private double precioF;//localidades
	
	
	public Finanzas(double precio, Localidad localidad, Oferta oferta) {
		precioBase = precio;
		localidadAsociada = localidad;
		subFinanzas = new ArrayList<Finanzas>();
		cantidadVendidos = localidad.getCapacidad()- localidad.contarDisponibilidad();
		if (oferta != null) {
			precioF= oferta.aplicarDescuento();
		}
		else {
			precioF = precioBase;
		}
	}
	public Finanzas(double cobroEmision, double tarifaServicio, Evento eventoAsociado) {
		this.cobroEmision = cobroEmision;
		this.tarifaServicio = tarifaServicio;
		cantidadVendidos = eventoAsociado.getCapacidadEvento() - eventoAsociado.getDisponibilidad();
		subFinanzas = new ArrayList<Finanzas>();
		this.eventoAsociado = eventoAsociado;
	}
	public int getCandidadVentas() {
		return cantidadVendidos;
	}
	public double calcularGananciasLocalidad() {
		double ganancias = 0;
		if (localidadAsociada.tieneOferta() == false) {
			ganancias = (cantidadVendidos * precioBase);
		}
		else {
			ganancias = precioF * cantidadVendidos;
		}
		return ganancias;
	}
	public double calcularGananciasPromotor() {
		double ganancias = 0;
		for (Finanzas finanzasLocalidad:subFinanzas) {
			ganancias += finanzasLocalidad.calcularGananciasLocalidad();
		}
		return ganancias;
	}
	public int getCantidadVentasEvento() {
		return cantidadVendidos;
	}
	public double calcularGananciasTiquetera() {
		double ganancias = 0;
		double gananciasServicio = (precioF * tarifaServicio)/100;
		ganancias = gananciasServicio + cobroEmision;
		return ganancias * cantidadVendidos;
	}
	public double getPorcentajeVentaLocalidad() {
		return (cantidadVendidos * 100)/ localidadAsociada.getCapacidad();
	}
	public double getPorcentajeVentaEvento() {
		return (cantidadVendidos * 100) / eventoAsociado.getCapacidadEvento();
		
	}
	
	
}
