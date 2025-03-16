package co.edu.unbosque.model;

public class Electrodomestico extends Oficina {

	private String fuenteDeEnergia;

	public Electrodomestico() {
		// TODO Auto-generated constructor stub
	}

	public Electrodomestico(String fuenteDeEnergia) {
		super();
		this.fuenteDeEnergia = fuenteDeEnergia;
	}

	public Electrodomestico(String nombre, int precio, int id, int cantidad, String imagen, boolean esPortatil,
			String fuenteDeEnergia) {
		super(nombre, precio, id, cantidad, imagen, esPortatil);
		this.fuenteDeEnergia = fuenteDeEnergia;
	}

	public Electrodomestico(String nombre, int precio, int id, int cantidad, String imagen, boolean esPortatil) {
		super(nombre, precio, id, cantidad, imagen, esPortatil);
		// TODO Auto-generated constructor stub
	}

	public String getFuenteDeEnergia() {
		return fuenteDeEnergia;
	}

	public void setFuenteDeEnergia(String fuenteDeEnergia) {
		this.fuenteDeEnergia = fuenteDeEnergia;
	}

	@Override
	public String toString() {
		return super.toString() + "¿Que fuente de energía tiene? " + fuenteDeEnergia;
	}

}
