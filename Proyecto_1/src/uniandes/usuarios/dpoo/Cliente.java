package uniandes.usuarios.dpoo;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Cliente extends Usuario {
private String documento;
private String telefono;
private final Set<Tiquete> tiquetes= new HashSet<>();

public Cliente (String id, String nombre, String email, String login, String password, double saldo,String documento, String telefono) {
	super(id,nombre,email,login,password,saldo);
	this.documento=Objects.requireNonNull(documento,"documento");
	this.telefono=Objects.requireNonNull(telefono,"telefono");
}

public String getDocumento() {
	return documento;
}

public String getTelefono() {
	return telefono;
}
public set<Tiquete> getTiquet(){
	return tiquetes;
	
public void agregarTiquete(Tiquete tiquete) {
    Objects.requireNonNull(tiquete, "tiquete");
    tiquetes.add(tiquete);

}

}