package Eventos;

public class Venue {
	private String tipoVenue;
	private int latitud;
	private int longitud;
	private int capacidadMaxima;
	private String restriccionesUso;
	private String nombreVenue;
	private int idVenue;
	private Evento eventoAsociado;
	private static int idSecuencial = 1;
	
	public Venue(String tipoVenue, int latitud, int longitud, int capacidadMaxima,
			String restriccionesUso, String nombre) throws Exception {
			this.tipoVenue = tipoVenue;
			this.latitud = latitud;
			this.longitud = longitud;
			if (capacidadMaxima>0) {
				this.capacidadMaxima = capacidadMaxima;
			}
			else {
				throw new Exception("La capacidad del venue es negativa");
			}
			
			this.restriccionesUso = restriccionesUso;
			this.nombreVenue = nombre;
			idVenue = idSecuencial;
			idSecuencial ++;
	}

	public boolean Asignar(Evento evento) {
		if (this.eventoAsociado != null) {
			return false; // ya ocupado
		}
		this.eventoAsociado = evento;
		return true;
	}
	public void liberarEvento() {
		eventoAsociado = null;
	}
	public String getUbicacion() {
		int lat = latitud;
		int lon = longitud;
		String rst = Integer.toString(lat) +","+ Integer.toString(lon);
		return rst;
	}
	
	public String getTipoVenue() {
		return tipoVenue;
	}

	public void setTipoVenue(String tipoVenue) {
		this.tipoVenue = tipoVenue;
	}

	public int getCapacidadMaxima() {
		return capacidadMaxima;
	}

	public void setCapacidadMaxima(int capacidadMaxima) {
		this.capacidadMaxima = capacidadMaxima;
	}

	public String getRestriccionesUso() {
		return restriccionesUso;
	}

	public void setRestriccionesUso(String restriccionesUso) {
		this.restriccionesUso = restriccionesUso;
	}

	public String getNombreVenue() {
		return nombreVenue;
	}

	public void setNombreVenue(String nombreVenue) {
		this.nombreVenue = nombreVenue;
	}

	public int getIdVenue() {
		return idVenue;
	}

	public void setIdVenue(int idVenue) {
		this.idVenue = idVenue;
	}

	public Evento getEventoAsociado() {
		return eventoAsociado;
	}

	public void setEventoAsociado(Evento eventoAsociado) {
		this.eventoAsociado = eventoAsociado;
	}
	
	
}
