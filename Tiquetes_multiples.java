package uniandes.tiquetes.dpoo;

import java.util.List;

public class Tiquetes_multiples extends Tiquete_individual {

    protected List<Tiquete_individual> tiquetes;

    public Tiquetes_multiples(Tiquete_individual base, List<Tiquete_individual> tiquetes) {
        super(base.getEvento(), base.getPrecio(), base.getCargoServicio(), base.getCuotaFija(),
              base.getId(), base.isTransferible(), base.getNumAsiento());
        this.tiquetes = tiquetes;
    }

    public List<Tiquete_individual> getTiquetes() {
        return tiquetes;
    }

    public void setTiquetes(List<Tiquete_individual> tiquetes) {
        this.tiquetes = tiquetes;
    }

    public void mostrarInfoTiquetes() {
        System.out.println("Tiquete múltiple con " + (tiquetes == null ? 0 : tiquetes.size()) + " entradas:");
        if (tiquetes != null) {
            for (Tiquete_individual t : tiquetes) {
                t.mostrarInfoTiquete();
            }
        }
    }
}