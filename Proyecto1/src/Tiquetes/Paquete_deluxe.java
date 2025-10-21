package Tiquetes;

import java.util.List;

public class Paquete_deluxe extends Tiquetes_multiples {

	 	private String[] beneficios;
	    private int tiquetesIncluidos;

	    public Paquete_deluxe(Tiquete_individual base, List<Tiquete_individual> tiquetes,
	                          String[] beneficios, int tiquetesIncluidos) {
	        super(base, tiquetes);
	        this.beneficios = beneficios;
	        this.tiquetesIncluidos = tiquetesIncluidos;
	    }

	    public String[] getBeneficios() {
	        return beneficios;
	    }

	    public void setBeneficios(String[] beneficios) {
	        this.beneficios = beneficios;
	    }

	    public int getTiquetesIncluidos() {
	        return tiquetesIncluidos;
	    }

	    public void setTiquetesIncluidos(int tiquetesIncluidos) {
	        this.tiquetesIncluidos = tiquetesIncluidos;
	    }

	    public void mostrarBeneficios() {
	        System.out.println("Beneficios del Paquete Deluxe:");
	        if (beneficios != null && beneficios.length > 0) {
	            for (String b : beneficios) {
	                System.out.println("- " + b);
	            }
	        } else {
	            System.out.println("No hay beneficios registrados para este paquete.");
	        }
	    }

}