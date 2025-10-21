package Usuarios;
import java.time.LocalDateTime;
import java.util.Objects;




public abstract class Usuario {
protected String id;
protected String nombre;
protected String email;
protected String login;
protected String password;
protected double saldo;
protected  LocalDateTime fechaRegistro;

public Usuario (String id, String nombre, String email, String login, String password, double saldo) {
	this.nombre=Objects.requireNonNull(nombre,"nombre");
	this.email=Objects.requireNonNull(email,"email");
	this.login=Objects.requireNonNull(login,"login");
	this.password=Objects.requireNonNull(password,"password");
	this.saldo= saldo;
	this.fechaRegistro= LocalDateTime.now();

}
public boolean autenticador(String login, String password) {
	return Objects.equals(this.login, login) && Objects.equals(this.password, password);
}

public void acreditarSaldo(double monto) {
	if(monto<=0) throw new IllegalArgumentException("El monto debe ser positivo y mayor a cero");
	this.saldo+= monto;
}
public void debitarSaldo(double monto) {
	if (monto <= 0) throw new IllegalArgumentException("Monto debe ser positivo");
	if (monto > this.saldo) throw new IllegalStateException("Saldo insuficiente");
	this.saldo -= monto;
}
public boolean esAdmin() {
    return false;
}
public String getId() {
	return id;
}
public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = Objects.requireNonNull(nombre,"nombre");
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = Objects.requireNonNull(email,"email");
}
public String getLogin() {
	return login;
}
public void setLogin(String login) {
	this.login = Objects.requireNonNull(login,"login");
}
public LocalDateTime getFechaRegistro() {
	return fechaRegistro;
}
public void setFechaRegistro(LocalDateTime fechaRegistro) {
	this.fechaRegistro = (fechaRegistro != null) ? fechaRegistro : LocalDateTime.now();
	}
public double getSaldo() {
	return saldo;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}

}