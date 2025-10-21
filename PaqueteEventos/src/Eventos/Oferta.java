package Eventos;

public class Oferta {
	private int fechaInicio;
	private int fechaFin;
	private int porcentajeDescuento;
	private boolean esActiva;
	private Localidad localidadAsociada;
	
	
	public Oferta(int fechaInicio, int fechaFin, int porcentajeDescuento, Localidad localidad) {
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.porcentajeDescuento = porcentajeDescuento;
		esActiva = true;
		localidadAsociada = localidad;
	}
	
	public double aplicarDescuento() {
		double precio = localidadAsociada.getPrecio();
		double rst = precio * porcentajeDescuento / 100;
		return rst;
	}

	public int getFechaInicio() {
		return fechaInicio;
	}


	public void setFechaInicio(int fechaInicio) {
		this.fechaInicio = fechaInicio;
	}


	public int getFechaFin() {
		return fechaFin;
	}


	public void setFechaFin(int fechaFin) {
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
