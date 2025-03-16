package co.edu.unbosque.model;

public abstract class Ocio extends Producto {
	private boolean esAccesorio;

	public Ocio() {
		// TODO Auto-generated constructor stub
	}

	public Ocio(boolean esAccesorio) {
		super();
		this.esAccesorio = esAccesorio;
	}

	public Ocio(String nombre, int precio, int id, int cantidad, String imagen, boolean esAccesorio) {
		super(nombre, precio, id, cantidad, imagen);
		this.esAccesorio = esAccesorio;
	}

	public Ocio(String nombre, int precio, int id, int cantidad, String imagen) {
		super(nombre, precio, id, cantidad, imagen);
		// TODO Auto-generated constructor stub
	}

	public boolean isEsAccesorio() {
		return esAccesorio;
	}

	public void setEsAccesorio(boolean esAccesorio) {
		this.esAccesorio = esAccesorio;
	}

	@Override
	public String toString() {
		return super.toString() + "¿Es accesorio? " + esAccesorio;
	}

}
