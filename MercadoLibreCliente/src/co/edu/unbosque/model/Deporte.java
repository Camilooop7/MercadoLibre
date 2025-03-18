package co.edu.unbosque.model;

import java.io.Serializable;

public class Deporte extends Ocio implements Serializable{
	private String deporte;

	public Deporte() {
		// TODO Auto-generated constructor stub
	}

	public Deporte(String deporte) {
		super();
		this.deporte = deporte;
	}

	public Deporte(String nombre, int precio, int id, int cantidad, String imagen, boolean esAccesorio,
			String deporte) {
		super(nombre, precio, id, cantidad, imagen, esAccesorio);
		this.deporte = deporte;
	}

	public Deporte(String nombre, int precio, int id, int cantidad, String imagen, boolean esAccesorio) {
		super(nombre, precio, id, cantidad, imagen, esAccesorio);
		// TODO Auto-generated constructor stub
	}

	public String getDeporte() {
		return deporte;
	}

	public void setDeporte(String deporte) {
		this.deporte = deporte;
	}

	@Override
	public String toString() {
		return super.toString() + "Deporte: " + deporte;
	}

}
