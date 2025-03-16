package co.edu.unbosque.model;

public abstract class Oficina extends Producto {
	private boolean esPortatil;

	public Oficina() {
		// TODO Auto-generated constructor stub
	}

	public Oficina(boolean esPortatil) {
		super();
		this.esPortatil = esPortatil;
	}

	public Oficina(String nombre, int precio, int id, int cantidad, String imagen, boolean esPortatil) {
		super(nombre, precio, id, cantidad, imagen);
		this.esPortatil = esPortatil;
	}

	public Oficina(String nombre, int precio, int id, int cantidad, String imagen) {
		super(nombre, precio, id, cantidad, imagen);
		// TODO Auto-generated constructor stub
	}

	public boolean isEsPortatil() {
		return esPortatil;
	}

	public void setEsPortatil(boolean esPortatil) {
		this.esPortatil = esPortatil;
	}

	@Override
	public String toString() {
		return super.toString() + "¿Es portatil? " + esPortatil;
	}

}
