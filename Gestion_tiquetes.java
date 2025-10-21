package uniandes.tiquetes.dpoo;

import java.util.List;
import java.util.Objects;


public class Gestion_tiquetes {

	public Gestion_tiquetes() {
        
    }

    
    public Venta comprarTiqueteIndividual(Evento evento, Localidad localidad, Asiento asiento, String tipoPago) {
        Objects.requireNonNull(evento, "evento");
        Objects.requireNonNull(localidad, "localidad");
        Objects.requireNonNull(asiento, "asiento");
        Objects.requireNonNull(tipoPago, "tipoPago");

        
        return null;
    }

    
    public Venta comprarPalco(Evento evento, Localidad localidad, List<Asiento> asientos, String tipoPago) {
        Objects.requireNonNull(evento, "evento");
        Objects.requireNonNull(localidad, "localidad");
        Objects.requireNonNull(asientos, "asientos");
        Objects.requireNonNull(tipoPago, "tipoPago");

        
        return null;
    }

    // Firma exacta según UML: comprarAbono(eventos: List<Evento>, localidad: Localidad, tipoPago: String): Venta
    public Venta comprarAbono(List<Evento> eventos, Localidad localidad, String tipoPago) {
        Objects.requireNonNull(eventos, "eventos");
        Objects.requireNonNull(localidad, "localidad");
        Objects.requireNonNull(tipoPago, "tipoPago");

        // stub: devuelve null
        return null;
    }

    
    public boolean transferirTiquete(Tiquete_individual tiquete, Cliente receptor, String passwordEmisor) {
        Objects.requireNonNull(tiquete, "tiquete");
        Objects.requireNonNull(receptor, "receptor");
        Objects.requireNonNull(passwordEmisor, "passwordEmisor");

       
        return false;
    }

    
    public void solicitarReembolso(Tiquete_individual tiquete, String motivo) {
        Objects.requireNonNull(tiquete, "tiquete");
        Objects.requireNonNull(motivo, "motivo");

        
    }
	    
}
