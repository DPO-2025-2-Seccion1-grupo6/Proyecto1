package Eventos;

public class Asiento {
	private int numeroAsiento;
	private boolean disponible;
	private char fila;
	public Localidad localidadAsociada;
	public int getNumeroAsiento() {
		return numeroAsiento;
	}
	public void setNumeroAsiento(int numeroAsiento) {
		this.numeroAsiento = numeroAsiento;
	}
	public boolean isDisponible() {
		return disponible;
	}
	public char getFila() {
		return fila;
	}
	public void setFila(char fila) {
		this.fila = fila;
	}
	public void setLocalidadAsociada(Localidad localidad) {
		this.localidadAsociada = localidad;
	}
	public void reservar() {
		disponible = false;
	}
	public void liberar() {
		disponible = true;
	}
}
