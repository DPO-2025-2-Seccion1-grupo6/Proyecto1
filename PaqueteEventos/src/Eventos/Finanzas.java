package Eventos;

import java.util.ArrayList;
import java.util.List;

public class Finanzas{
	private double precioBase;
	private double ganancias;
	private int cantidadVendidos;
	private int porcentajeVenta;
	private double tarifaServicio;
	private double cobroEmision;
	private List<Finanzas> subFinanzas;
	private Localidad localidadAsociada;
	private Evento eventoAsociado;
	
	
	public Finanzas(double precio, Localidad localidad) {
		precioBase = precio;
		localidadAsociada = localidad;
	}
	public Finanzas(double cobroEmision, double tarifaServicio, Evento eventoAsociado) {
		this.cobroEmision = cobroEmision;
		this.tarifaServicio = tarifaServicio;
		subFinanzas = new ArrayList<Finanzas>();
		this.eventoAsociado = eventoAsociado;
	}
	
}
