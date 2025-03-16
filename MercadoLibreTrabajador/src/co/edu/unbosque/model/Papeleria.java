package co.edu.unbosque.model;

public class Papeleria extends Oficina {
	private int cantidadPorPaquete;

	public Papeleria() {
		// TODO Auto-generated constructor stub
	}

	public Papeleria(int cantidadPorPaquete) {
		super();
		this.cantidadPorPaquete = cantidadPorPaquete;
	}

	public Papeleria(String nombre, int precio, int id, int cantidad, String imagen, boolean esPortatil,
			int cantidadPorPaquete) {
		super(nombre, precio, id, cantidad, imagen, esPortatil);
		this.cantidadPorPaquete = cantidadPorPaquete;
	}

	public Papeleria(String nombre, int precio, int id, int cantidad, String imagen, boolean esPortatil) {
		super(nombre, precio, id, cantidad, imagen, esPortatil);
		// TODO Auto-generated constructor stub
	}

	public int getCantidadPorPaquete() {
		return cantidadPorPaquete;
	}

	public void setCantidadPorPaquete(int cantidadPorPaquete) {
		this.cantidadPorPaquete = cantidadPorPaquete;
	}

	@Override
	public String toString() {
		return super.toString() + "Cuantos vienen en el paquete: " + cantidadPorPaquete;
	}

}
