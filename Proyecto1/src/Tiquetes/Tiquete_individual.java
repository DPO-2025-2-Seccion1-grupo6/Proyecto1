package Tiquetes;

import Eventos.Evento;
import Usuarios.Usuario;

public class Tiquete_individual{

	protected Evento evento;
    protected double precio;
    protected double cargoServicio;
    protected double cuotaFija;
    protected String id;
    protected boolean transferible;
    protected String numAsiento;
    private boolean reembolsado;
    private double montoReembolsado;
    private Usuario duenoActual;
    
    public Tiquete_individual(Evento evento, double precio, double cargoServicio, double cuotaFija,
                   String id, boolean transferible, String numAsiento) {
        this.evento = evento;
        this.precio = precio;
        this.cargoServicio = cargoServicio;
        this.cuotaFija = cuotaFija;
        this.id = id;
        this.transferible = transferible;
        this.numAsiento = numAsiento;
        
    }
    public void autorizarReembolso(double monto) {
        if (reembolsado) {
            throw new IllegalStateException("Este tiquete ya fue reembolsado previamente");
        }
        if (monto <= 0) {
            throw new IllegalArgumentException("El monto debe ser mayor que cero");
        }
        this.reembolsado = true;
        this.montoReembolsado = monto;
        System.out.println("✅ Reembolso autorizado por $" + monto + " para el tiquete " + id);
    }

    public Evento getEvento() { return evento; }
    public void setEvento(Evento evento) { this.evento = evento; }

    public double getPrecio() { return precio; }
    public void setPrecio(double precio) { this.precio = precio; }
    
    public Usuario getDuenoActual() {
        return duenoActual;
    }

    public void setDuenoActual(Usuario duenoActual) {
        this.duenoActual = duenoActual;
    }

    public double getCargoServicio() { return cargoServicio; }
    public void setCargoServicio(double cargoServicio) { this.cargoServicio = cargoServicio; }

    public double getCuotaFija() { return cuotaFija; }
    public void setCuotaFija(double cuotaFija) { this.cuotaFija = cuotaFija; }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public boolean isTransferible() { return transferible; }
    public void setTransferible(boolean transferible) { this.transferible = transferible; }

    public String getNumAsiento() { return numAsiento; }
    public void setNumAsiento(String numAsiento) { this.numAsiento = numAsiento; }

    public void mostrarInfoTiquete() {
        System.out.println("Tiquete ID: " + id + " | Evento: " + evento.getTipoEvento() +
                           " | Precio: " + precio + " | Asiento: " + numAsiento);
    }
}