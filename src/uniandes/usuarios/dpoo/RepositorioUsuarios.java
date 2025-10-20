package uniandes.usuarios.dpoo;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class RepositorioUsuarios {

    private String archivo;

    public RepositorioUsuarios(String archivo) {
        this.archivo = archivo;
    }

    public void guardarUsuario(Usuario usuario) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(archivo, true))) {
            if (usuario instanceof Cliente c) {
                pw.println("Cliente;" + c.getId() + ";" + c.getNombre() + ";" + c.getEmail() + ";" + c.getLogin() + ";" + c.getTelefono() + ";" + c.getDocumento() + ";" + c.getSaldo());
            } else if (usuario instanceof Promotor p) {
                pw.println("Promotor;" + p.getId() + ";" + p.getNombre() + ";" + p.getEmail() + ";" +  p.getLogin() + ";" + p.getNit() + ";" + p.getReputacion() + ";" + p.getSaldo());
            } else if (usuario instanceof Administrador a) {
                pw.println("Administrador;" + a.getId() + ";" + a.getNombre() + ";" + a.getEmail() + ";" +a.getLogin() + ";" + a.getSaldo());
            }
        } catch (IOException e) {
            System.err.println("Error al guardar usuario: " + e.getMessage());
        }
    }

    public List<Usuario> cargarUsuarios() {
        List<Usuario> lista = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(";");
                String tipo = partes[0];
                String id = partes[1];
                String nombre = partes[2];
                String email = partes[3];
                String login = partes[4];
                double saldo = Double.parseDouble(partes[partes.length - 1]);
                String password = "default";

                switch (tipo) {
                    case "Cliente":
                        String telefono = partes[5];
                        String documento = partes[6];
                        lista.add(new Cliente(id, nombre, email, login, password, saldo, documento, telefono));
                        break;
                    case "Promotor":
                        String nit = partes[5];
                        int reputacion = Integer.parseInt(partes[6]);
                        lista.add(new Promotor(id, nombre, email, login, password, saldo, reputacion, nit));
                        break;
                    case "Administrador":
                        lista.add(new Administrador(id, nombre, email, login, password, saldo));
                        break;
                }
            }
        } catch (IOException e) {
            System.err.println("Error al cargar usuarios: " + e.getMessage());
        }
        return lista;
    }
}
