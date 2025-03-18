package co.edu.unbosque.model;

import java.io.Serializable;

public abstract class Hogar extends Producto implements Serializable{

	private boolean esDecoracion;

	public Hogar() {
		// TODO Auto-generated constructor stub
	}

	public Hogar(boolean esDecoracion) {
		super();
		this.esDecoracion = esDecoracion;
	}

	public Hogar(String nombre, int precio, int id, int cantidad, String imagen, boolean esDecoracion) {
		super(nombre, precio, id, cantidad, imagen);
		this.esDecoracion = esDecoracion;
	}

	public Hogar(String nombre, int precio, int id, int cantidad, String imagen) {
		super(nombre, precio, id, cantidad, imagen);
		// TODO Auto-generated constructor stub
	}

	public boolean isEsDecoracion() {
		return esDecoracion;
	}

	public void setEsDecoracion(boolean esDecoracion) {
		this.esDecoracion = esDecoracion;
	}

	@Override
	public String toString() {
		return super.toString() + "¿Es decoración? " + esDecoracion;
	}

}
