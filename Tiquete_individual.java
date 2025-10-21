package uniandes.tiquetes.dpoo;

public class Tiquete_individual {

	protected Evento evento;
    protected double precio;
    protected double cargoServicio;
    protected double cuotaFija;
    protected String id;
    protected boolean transferible;
    protected String numAsiento;

    public Tiquete(Evento evento, double precio, double cargoServicio, double cuotaFija,
                   String id, boolean transferible, String numAsiento) {
        this.evento = evento;
        this.precio = precio;
        this.cargoServicio = cargoServicio;
        this.cuotaFija = cuotaFija;
        this.id = id;
        this.transferible = transferible;
        this.numAsiento = numAsiento;
    }

    public Evento getEvento() { return evento; }
    public void setEvento(Evento evento) { this.evento = evento; }

    public double getPrecio() { return precio; }
    public void setPrecio(double precio) { this.precio = precio; }

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
        System.out.println("Tiquete ID: " + id + " | Evento: " + evento.getNombre() +
                           " | Precio: " + precio + " | Asiento: " + numAsiento);
    }
}
