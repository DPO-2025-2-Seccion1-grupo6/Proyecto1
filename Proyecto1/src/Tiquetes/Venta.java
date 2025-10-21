package Tiquetes;
import java.time.LocalDateTime;
import java.util.List;

public class Venta {

	private double cobroTotal;
    private String tipoPago;
    private LocalDateTime fechaPago;
    private String estado;
    private String idVenta;
    private List<Tiquete_individual> tiquetes;

    public Venta(double cobroTotal, String tipoPago, LocalDateTime fechaPago,
                 String estado, String idVenta, List<Tiquete_individual> tiquetes) {
        this.cobroTotal = cobroTotal;
        this.tipoPago = tipoPago;
        this.fechaPago = fechaPago;
        this.estado = estado;
        this.idVenta = idVenta;
        this.tiquetes = tiquetes;
    }

    public double getCobroTotal() {
        return cobroTotal;
    }

    public void setCobroTotal(double cobroTotal) {
        this.cobroTotal = cobroTotal;
    }

    public String getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(String tipoPago) {
        this.tipoPago = tipoPago;
    }

    public LocalDateTime getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(LocalDateTime fechaPago) {
        this.fechaPago = fechaPago;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(String idVenta) {
        this.idVenta = idVenta;
    }

    public List<Tiquete_individual> getTiquetes() {
        return tiquetes;
    }

    public void setTiquetes(List<Tiquete_individual> tiquetes) {
        this.tiquetes = tiquetes;
    }
}