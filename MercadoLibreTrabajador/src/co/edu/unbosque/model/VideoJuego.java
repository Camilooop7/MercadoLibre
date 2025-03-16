package co.edu.unbosque.model;

public class VideoJuego extends Ocio {

	private String referenciaConsola;

	public VideoJuego() {
		// TODO Auto-generated constructor stub
	}

	public VideoJuego(String referenciaConsola) {
		super();
		this.referenciaConsola = referenciaConsola;
	}

	public VideoJuego(String nombre, int precio, int id, int cantidad, String imagen, boolean esAccesorio,
			String referenciaConsola) {
		super(nombre, precio, id, cantidad, imagen, esAccesorio);
		this.referenciaConsola = referenciaConsola;
	}

	public VideoJuego(String nombre, int precio, int id, int cantidad, String imagen, boolean esAccesorio) {
		super(nombre, precio, id, cantidad, imagen, esAccesorio);
		// TODO Auto-generated constructor stub
	}

	public String getReferenciaConsola() {
		return referenciaConsola;
	}

	public void setReferenciaConsola(String referenciaConsola) {
		this.referenciaConsola = referenciaConsola;
	}

	@Override
	public String toString() {
		return super.toString() + "¿Que consola es? " + referenciaConsola;
	}

}
