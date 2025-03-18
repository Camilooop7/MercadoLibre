package co.edu.unbosque.model;

import java.io.Serializable;

public class Bano extends Hogar implements Serializable{
	private boolean esLimpieza;


	public Bano() {
		// TODO Auto-generated constructor stub
	}

	public Bano(boolean esLimpieza) {
		super();
		this.esLimpieza = esLimpieza;
	}

	public Bano(String nombre, int precio, int id, int cantidad, String imagen, boolean esDecoracion,
			boolean esLimpieza) {
		super(nombre, precio, id, cantidad, imagen, esDecoracion);
		this.esLimpieza = esLimpieza;
	}

	public Bano(String nombre, int precio, int id, int cantidad, String imagen, boolean esDecoracion) {
		super(nombre, precio, id, cantidad, imagen, esDecoracion);
		// TODO Auto-generated constructor stub
	}

	public boolean isEsLimpieza() {
		return esLimpieza;
	}

	public void setEsLimpieza(boolean esLimpieza) {
		this.esLimpieza = esLimpieza;
	}

	@Override
	public String toString() {
		return super.toString() + "¿Es de limpieza? " + esLimpieza;
	}

}
