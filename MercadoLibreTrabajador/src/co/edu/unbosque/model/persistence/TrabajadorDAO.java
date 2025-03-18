package co.edu.unbosque.model.persistence;

import java.util.ArrayList;
import co.edu.unbosque.model.Trabajador;

public class TrabajadorDAO implements OperacionDAO<Trabajador> {
	private final String SERIAL_FILE_NAME = "trabajador.dat";
	private ArrayList<Trabajador> listaTrabajadores;

	public TrabajadorDAO() {
		// TODO Auto-generated constructor stub
		listaTrabajadores = new ArrayList<>();
		cargarSerializado();
	}

	@Override
	public void crear(Trabajador nuevoDato) {
		listaTrabajadores.add(nuevoDato);
		escribirSerializado();
	}

	@Override
	public int eliminar(int index) {
		if (index >= 0 && index < listaTrabajadores.size()) {
			listaTrabajadores.remove(index);
			escribirSerializado();
			return 0;
		} else {
			return 1;
		}
	}

	@Override
	public int actulizar(int index, Trabajador nuevoDato) {
		if (index >= 0 && index < listaTrabajadores.size()) {
			listaTrabajadores.set(index, nuevoDato);
			escribirSerializado();
			return 0;
		} else {
			return 1;
		}
	}

	@Override
	public String mostrarTodo() {
		String salida = "";
		for (Trabajador trabajador : listaTrabajadores) {
			salida += trabajador.toString();
		}
		return salida;
	}

	@Override
	public void escribirSerializado() {
		FileManager.escribirArchivoSerializado(SERIAL_FILE_NAME, listaTrabajadores);
	}

	@Override
	public void cargarSerializado() {
		listaTrabajadores = (ArrayList<Trabajador>) FileManager.leerArchivoSerialziado(SERIAL_FILE_NAME);
		if (listaTrabajadores == null) {
			listaTrabajadores = new ArrayList<>();
		}
	}

	public Trabajador encontrarUsuario(String a, String b) {

		Trabajador salida = null;

		for (Trabajador trabajador : listaTrabajadores) {

			if (trabajador.getNombre().equals(a) && trabajador.getContrasena().equals(b)) {

				salida = trabajador;

			}

		}
		return salida;

	}

	public ArrayList<Trabajador> getListaTrabajadores() {
		return listaTrabajadores;
	}

	public void setListaTrabajadores(ArrayList<Trabajador> listaTrabajadores) {
		this.listaTrabajadores = listaTrabajadores;
	}

}