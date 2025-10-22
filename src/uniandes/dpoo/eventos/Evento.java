package Eventos;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Evento {
private String tipoEvento;//1
private int idEvento;//1
private int fechaEvento;//1
private int horaEvento;//1
private Venue venueAsociado;//1
private int capacidadEvento;
private int capacidadActualLocalidades;
private Finanzas finanzasTotales;//1
private TreeMap<Integer, Localidad> localidades;//1
//private Promotor promotorEvento;
private static int idSecuencial = 1;
private int idLocalidad = 1;

public Evento(int capacidadEvento, String tipoEvento,int fechaEvento, int horaEvento, Venue venueAsociado, double cobroEmision, int porcentajeServicio)throws Exception 
{
	if(venueAsociado.getCapacidadMaxima() < capacidadEvento) {
		throw new Exception("La capacidad del Venue no soporta la cantidad esperada de personas para el evento");
	}
	this.capacidadEvento = capacidadEvento;
	this.tipoEvento = tipoEvento;
	this.fechaEvento = fechaEvento;
	this.horaEvento = horaEvento;
	asignarVenue(venueAsociado);
	//this.promotorEvento = promotorEvento;
	idEvento = idSecuencial;
	idSecuencial ++;
	localidades = new TreeMap<Integer, Localidad>();
	finanzasTotales = new Finanzas(cobroEmision, porcentajeServicio, this);
	
}
public void agregarLocalidad(Localidad localidad) throws Exception{
	if (localidad.getCapacidad() > capacidadEvento || localidad.getCapacidad() + capacidadActualLocalidades > capacidadEvento) {
		throw new Exception("La capacidad de la localidad es mayor de lo que puede soportar el evento");
	}
	//set idlocalidad para mantener un id en cada localidad segun evento
	localidad.setIdLocalidad(idLocalidad);
	
	//mandarse a si mismo para asociarse con la localidad
	localidad.setEventoAsociado(this);
	//Meter la localidad a localidades
	localidades.put(idLocalidad, localidad);
	idLocalidad ++;
	capacidadActualLocalidades += localidades.get(idLocalidad).getCapacidad();
}
public void eliminarLocalidad(int idLocalidad) {
	if(localidades.get(idLocalidad)!= null) {
		capacidadActualLocalidades -= localidades.get(idLocalidad).getCapacidad();
		localidades.remove(idLocalidad);
	}
}
public void asignarVenue(Venue venue) {
	venueAsociado = venue;
	venue.Asignar(this);
}
/*public void cancelarEvento() {
	
}*/ //Se debe mirar primero como se hacen los reembolsos

public Localidad getLocalidadPorID(int id) {
	return localidades.get(id);
}
public ArrayList<Localidad> getLocalidadesDisponibles(){
	ArrayList<Localidad> rst = new ArrayList<Localidad>();
	for (Map.Entry<Integer, Localidad> localidad: localidades.entrySet()){
		Localidad valor = localidad.getValue();
		if (valor.getDisponible() == true) {
			rst.add(valor);
		}
	}
	return rst;
}
public int getDisponibilidad() {
	int rst = 0;
	for (Map.Entry<Integer, Localidad> localidad: localidades.entrySet()){
		Localidad valor = localidad.getValue();
		rst += valor.contarDisponibilidad();
	}
	return rst;
}
public String getTipoEvento() {
	return tipoEvento;
}
public void setTipoEvento(String tipoEvento) {
	this.tipoEvento = tipoEvento;
}
public int getIdEvento() {
	return idEvento;
}
public void setIdEvento(int idEvento) {
	this.idEvento = idEvento;
}
public int getFechaEvento() {
	return fechaEvento;
}
public void setFechaEvento(int fechaEvento) {
	this.fechaEvento = fechaEvento;
}
public int getHoraEvento() {
	return horaEvento;
}
public void setHoraEvento(int horaEvento) {
	this.horaEvento = horaEvento;
}
public Venue getVenueAsociado() {
	return venueAsociado;
}
public void setVenueAsociado(Venue venueAsociado) {
	this.venueAsociado = venueAsociado;
}
public int getCapacidadEvento() {
	return capacidadEvento;
}
public void setCapacidadEvento(int capacidadEvento) {
	this.capacidadEvento = capacidadEvento;
}
public Finanzas getFinanzasTotales() {
	return finanzasTotales;
}
public void setFinanzasTotales(Finanzas finanzasTotales) {
	this.finanzasTotales = finanzasTotales;
}
public TreeMap<Integer, Localidad> getLocalidades() {
	return localidades;
}
public void setLocalidades(TreeMap<Integer, Localidad> localidades) {
	this.localidades = localidades;
}


}
