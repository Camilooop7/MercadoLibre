package co.edu.unbosque.model;

import java.io.Serializable;

public class Cocina extends Hogar implements Serializable{
	private boolean resisteAltaTemperatuta;
	private boolean esPeligroso;

	public Cocina() {
		// TODO Auto-generated constructor stub
	}

	public Cocina(boolean resisteAltaTemperatuta, boolean esPeligroso) {
		super();
		this.resisteAltaTemperatuta = resisteAltaTemperatuta;
		this.esPeligroso = esPeligroso;
	}

	public Cocina(String nombre, int precio, int id, int cantidad, String imagen, boolean esDecoracion,
			boolean resisteAltaTemperatuta, boolean esPeligroso) {
		super(nombre, precio, id, cantidad, imagen, esDecoracion);
		this.resisteAltaTemperatuta = resisteAltaTemperatuta;
		this.esPeligroso = esPeligroso;
	}

	public Cocina(String nombre, int precio, int id, int cantidad, String imagen, boolean esDecoracion) {
		super(nombre, precio, id, cantidad, imagen, esDecoracion);
		// TODO Auto-generated constructor stub
	}

	public boolean isResisteAltaTemperatuta() {
		return resisteAltaTemperatuta;
	}

	public void setResisteAltaTemperatuta(boolean resisteAltaTemperatuta) {
		this.resisteAltaTemperatuta = resisteAltaTemperatuta;
	}

	public boolean isEsPeligroso() {
		return esPeligroso;
	}

	public void setEsPeligroso(boolean esPeligroso) {
		this.esPeligroso = esPeligroso;
	}

	@Override
	public String toString() {
		return super.toString() + "¿Resiste altas temperaturas? " + resisteAltaTemperatuta + "¿Es peligroso?"
				+ esPeligroso;
	}

}
