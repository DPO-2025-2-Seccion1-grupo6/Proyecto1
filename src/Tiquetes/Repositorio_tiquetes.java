package Tiquetes;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import Eventos.Asiento;
import Eventos.Evento;



public class Repositorio_tiquetes {



	    private String archivo;

	    public Repositorio_tiquetes(String archivo) {
	        this.archivo = archivo;
	    }

	    public void guardarTiquete(Tiquete_individual tiquete) {
	        try (PrintWriter pw = new PrintWriter(new FileWriter(archivo, true))) {

	            if (tiquete instanceof Paquete_deluxe deluxe) {
	                pw.println("Deluxe;" +
	                        deluxe.getId() + ";" +
	                        //deluxe.getEvento().getId() + ";" +
	                        deluxe.getPrecio() + ";" +
	                        deluxe.getCargoServicio() + ";" +
	                        deluxe.getCuotaFija() + ";" +
	                        //deluxe.isTransferible() + ";" +
	                        //deluxe.getCantidadTiquetes() + ";" +
	                        String.join(",", deluxe.getBeneficios()));

	            } else if (tiquete instanceof Tiquetes_multiples multiple) {
	                pw.println("Multiple;" +
	                        multiple.getId() + ";" +
	                        //multiple.getEvento().getId() + ";" +
	                        multiple.getPrecio() + ";" +
	                        multiple.getCargoServicio() + ";" +
	                        multiple.getCuotaFija() + ";" +
	                        multiple.isTransferible() + ";" +
	                        multiple.getCantidadTiquetes());

	            } else if (tiquete instanceof Tiquete_individual individual) {
	                pw.println("Individual;" +
	                        individual.getId() + ";" +
	                        //individual.getEvento().getId() + ";" +
	                        individual.getPrecio() + ";" +
	                        individual.getCargoServicio() + ";" +
	                        individual.getCuotaFija() + ";" +
	                        //individual.isTransferible() + ";" +
	                        (individual.getAsiento() != null ? individual.getAsiento().getNumero() : "N/A"));
	            }

	        } catch (IOException e) {
	            System.err.println("Error al guardar tiquete: " + e.getMessage());
	        }
	    }


	    public List<Tiquete_individual> cargarTiquetes() {
	        List<Tiquete_individual> lista = new ArrayList<>();

	        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
	            String linea;

	            while ((linea = br.readLine()) != null) {
	                String[] partes = linea.split(";");
	                String tipo = partes[0];
	                String id = partes[1];
	                String idEvento = partes[2];
	                int precio = Integer.parseInt(partes[3]);
	                int cargoServicio = Integer.parseInt(partes[4]);
	                int cuotaFija = Integer.parseInt(partes[5]);
	                boolean transferible = Boolean.parseBoolean(partes[6]);


	                Evento evento = new Evento(idEvento, "Evento cargado", null, null);
	                Asiento asiento = new Asiento("A1"); 

	                switch (tipo) {
	                    case "Deluxe":
	                        int cantidadTiquetesDeluxe = Integer.parseInt(partes[7]);
	                        String[] beneficios = partes[8].split(",");
	                        lista.add(new Paquete_deluxe(evento, precio, cargoServicio, cuotaFija,
	                                id, "A1", transferible, cantidadTiquetesDeluxe, beneficios));
	                        break;

	                    case "Multiple":
	                        int cantidadTiquetes = Integer.parseInt(partes[7]);
	                        lista.add(new Tiquetes_multiples(evento, precio, cargoServicio, cuotaFija,
	                                id, "A1", transferible, cantidadTiquetes));
	                        break;

	                    case "Individual":
	                        lista.add(new Tiquete_individual(evento, precio, cargoServicio, cuotaFija,
	                                id, "A1", transferible));
	                        break;
	                }
	            }
	        } catch (IOException e) {
	            System.err.println("Error al cargar tiquetes: " + e.getMessage());
	        }

	        return lista;
	    }
}