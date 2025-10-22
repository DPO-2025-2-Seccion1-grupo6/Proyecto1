package Eventos;

import java.util.ArrayList;
import java.util.List;

public class Localidad {
	private int idLocalidad = 0;
	private double precio;
	private String caracteristicas;
	private boolean esNumerada;
	private boolean disponible;
	private int vendidos = 0;
	private List<Asiento> asientosDisponibles;
	private List<Asiento> asientosOcupados;
	private Finanzas finanzas;
	private Evento eventoAsociado;
	private int numAsiento = 1;
	private char fila = 'A';
	private int capacidad;
	private Oferta oferta = null;
	
	public Localidad(Evento evento, double precio, String caracteristicas, boolean esNumerada, boolean disponible, int capacidad)throws Exception 
	{
		this.precio = precio;
		this.caracteristicas = caracteristicas;
		this.esNumerada = esNumerada;
		this.disponible = disponible;
		if (esNumerada == true) {
			this.asientosDisponibles = new ArrayList<Asiento>();
			this.asientosOcupados = new ArrayList<Asiento>();
		}
		this.finanzas = new Finanzas(this.precio, this, oferta);
		this.eventoAsociado = evento;
		this.capacidad = capacidad;
	}
	public List<Asiento>getAsientosDisponibles() {
		return asientosDisponibles;
	}
	public List<Asiento>getAsientosOcupados() {
		return asientosOcupados;
	}
	public void asociarOferta(Oferta oferta) {
		this.oferta = oferta;
	}
	public void reservar(Asiento asiento) {
		if(esNumerada == true) {
			asientosDisponibles.remove(asiento);
			asientosOcupados.add(asiento);
			vendidos ++;
		}
		else {
		vendidos ++;
		if (vendidos == capacidad) {
			disponible = false;
		}
		}
	}
	public void liberar(Asiento asiento) {
		if(esNumerada == true) {
			asientosOcupados.remove(asiento);
			asientosDisponibles.add(asiento);
			vendidos --;
		}
		else {
		vendidos --;
		}
	}
	public int contarDisponibilidad() {
		if (capacidad == vendidos) {
			return 0;
		}
		else {
			return capacidad - vendidos;
		}
	}
	public boolean tieneOferta() {
		if (oferta != null) {
			return true;
		}
		else {
			return false;
		}
	}
	public void agregarAsiento(Asiento asiento, int asientoXFila) throws Exception{
		if(asientosDisponibles.size() < capacidad) {
			asiento.setNumeroAsiento(numAsiento);
			
			asiento.setLocalidadAsociada(this);
			
			asientosDisponibles.add(asiento);
			numAsiento ++;
			if (numAsiento > asientoXFila) {
				numAsiento = 1;
				this.fila ++;
			} 
		}
		else {
			throw new Exception("Capacidad de la localidad Excedida");
		}
		
	}
	public boolean getDisponible() {
		return disponible;
	}
	public int getIdLocalidad() {
		return idLocalidad;
	}
	public void setIdLocalidad(int idLocalidad) {
		this.idLocalidad = idLocalidad;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public String getCaracteristicas() {
		return caracteristicas;
	}
	public void setCaracteristicas(String caracteristicas) {
		this.caracteristicas = caracteristicas;
	}
	public boolean isDisponible() {
		return disponible;
	}
	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}
	public Finanzas getFinanzas() {
		return finanzas;
	}
	public void setFinanzas(Finanzas finanzas) {
		this.finanzas = finanzas;
	}
	public Evento getEventoAsociado() {
		return eventoAsociado;
	}
	public void setEventoAsociado(Evento eventoAsociado) {
		this.eventoAsociado = eventoAsociado;
	}
	public int getNumAsiento() {
		return numAsiento;
	}
	public void setNumAsiento(int numAsiento) {
		this.numAsiento = numAsiento;
	}
	public char getFila() {
		return fila;
	}
	public void setFila(char fila) {
		this.fila = fila;
	}
	public int getCapacidad() {
		return capacidad;
	}
	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}
	public Oferta getOferta() {
		return oferta;
	}
	public void setOferta(Oferta oferta) {
		this.oferta = oferta;
	}


}
