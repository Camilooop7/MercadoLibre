package co.edu.unbosque.model.persistence;

import java.util.ArrayList;
import co.edu.unbosque.model.Carrito;

/**
 * Clase en la cual se implementa la interfaz OperacionDAO
 */
public class CarritoDAO implements OperacionDAO<Carrito> {

	/**
	 * Se declara una variable constante definida por el final la cual no deja de
	 * ser modificada una vez inicializada y se le indica el tipo de archivo .dat
	 * 
	 */
	private final String SERIAL_FILE_NAME = "carrito.dat";

	/**
	 * Variable la cual contiene un arraylist y además se define el nombre.
	 */
	private ArrayList<Carrito> listaCarritos;

	/**
	 * Constructor en cual cual se llama al metodo de cargarSerializado y se
	 * inicializa la Arraylist.
	 */
	public CarritoDAO() {
		// TODO Auto-generated constructor stub
		listaCarritos = new ArrayList<>();
		cargarSerializado();
	}

	/**
	 * Metodo crear el cual recibe como parametro nuevoDato y se recurre a la lista
	 * agregando el nuevoDato además de eso se llama al metodo de
	 * escribirSerializado.
	 */
	@Override
	public void crear(Carrito nuevoDato) {
		listaCarritos.add(nuevoDato);
		escribirSerializado();
	}

	/**
	 * Metodo eliminar el cual recibe como parametro un dato tipo entero en el cual
	 * se incluye un condicional tipo if, verifica y recorre los limites de las
	 * lista eliminando el objeto en la posicion indicada, si no devuelve el numero
	 * indicado si no se cumple el ciclo. Se llama al metodo de escribirSerializado.
	 */
	@Override
	public int eliminar(int index) {
		if (index >= 0 && index < listaCarritos.size()) {
			listaCarritos.remove(index);
			escribirSerializado();
			return 0;
		} else {
			return 1;
		}
	}

	/**
	 * Metodo actualizar el cual recibe como parametro un dato tipo entero y
	 * nuevoDato en el cual se incluye un condicional tipo if, verifica y recorre
	 * los limites de las lista actualizando el objeto en la posicion indicada con
	 * el .set recibiendo los parametros definidos, si no devuelve el numero
	 * indicado si no se cumple el ciclo. Se llama al metodo de escribirSerializado.
	 */
	@Override
	public int actulizar(int index, Carrito nuevoDato) {
		if (index >= 0 && index < listaCarritos.size()) {
			listaCarritos.set(index, nuevoDato);
			escribirSerializado();
			return 0;
		} else {
			return 1;
		}
	}
	
	public boolean encontrar(int index) {
		// TODO Auto-generated method stub
		return index >= 0 && index < listaCarritos.size();
	}

	/**
	 * Metodo mosrtarTodo el cual no recibe parametros Se crea una variable tipo
	 * String y se recorre la lista con el uso del for y se realiza la concatenación
	 * de salida con el .toString, por ultimo se retorna la variable salida con su
	 * respectivo to string.
	 */
	@Override
	public String mostrarTodo() {
		String salida = "";
		for (Carrito carrito : listaCarritos) {
			salida += carrito.toString() + "\n";
		}
		return salida;
	}

	/**
	 * Metodo el cual tiene como objetivo guardar la lista definida dentro del
	 * archivo como .dat
	 */
	@Override
	public void escribirSerializado() {
		FileManager.escribirArchivoSerializado(SERIAL_FILE_NAME, listaCarritos);
	}

	/**
	 * Este metodo carga el archivo la lista en el archivoSerializado donde se lee
	 * la lista con el leerArchivoSerializado en este caso SERIAL_FILE_NAME. Se
	 * utiliza un condiconal tipo if en donde si la lista se encuentra vacia se
	 * inicializa un nuevo array para la lista.
	 */
	@Override
	public void cargarSerializado() {
		listaCarritos = (ArrayList<Carrito>) FileManager.leerArchivoSerialziado(SERIAL_FILE_NAME);
		if (listaCarritos == null) {
			listaCarritos = new ArrayList<>();
		}
	}

	public ArrayList<Carrito> getListaCarritos() {
		return listaCarritos;
	}

	public void setListaCarritos(ArrayList<Carrito> listaCarritos) {
		this.listaCarritos = listaCarritos;
	}

}