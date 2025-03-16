package co.edu.unbosque.model;

public abstract class Usuario {
	private String nombre;
	private String contrasena;

	public Usuario() {
		// TODO Auto-generated constructor stub
	}

	public Usuario(String nombre, String contrasena) {
		super();
		this.nombre = nombre;
		this.contrasena = contrasena;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	@Override
	public String toString() {
		return "Nombre: " + nombre + "Contrasena: " + contrasena;
	}

}
