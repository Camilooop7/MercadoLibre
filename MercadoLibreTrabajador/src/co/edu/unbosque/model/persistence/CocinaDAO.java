package co.edu.unbosque.model.persistence;

import java.util.ArrayList;
import co.edu.unbosque.model.Cocina;
import co.edu.unbosque.model.Trabajador;

/**
 * Clase en la cual se implementa la interfaz OperacionDAO
 */
public class CocinaDAO implements OperacionDAO<Cocina> {

	/**
	 * Se declara una variable constante definida por el final la cual no deja de
	 * ser modificada una vez inicializada y se le indica el tipo de archivo .dat
	 * 
	 */
	private final String SERIAL_FILE_NAME = "cocina.dat";
	private final String TEXT_FILE_NAME = "cocina.csv";

	/**
	 * Variable la cual contiene un arraylist y además se define el nombre.
	 */
	private ArrayList<Cocina> listaCocinas;

	/**
	 * Constructor en cual cual se llama al metodo de cargarSerializado y se
	 * inicializa la Arraylist.
	 */
	public CocinaDAO() {
		// TODO Auto-generated constructor stub
		listaCocinas = new ArrayList<>();
		cargarSerializado();

	}

	/**
	 * Metodo crear el cual recibe como parametro nuevoDato y se recurre a la lista
	 * agregando el nuevoDato además de eso se llama al metodo de
	 * escribirSerializado.
	 */
	@Override
	public void crear(Cocina nuevoDato) {
		listaCocinas.add(nuevoDato);
		escribirSerializado();
		escribirArchivor();
	}

	/**
	 * Metodo eliminar el cual recibe como parametro un dato tipo entero en el cual
	 * se incluye un condicional tipo if, verifica y recorre los limites de las
	 * lista eliminando el objeto en la posicion indicada, si no devuelve el numero
	 * indicado si no se cumple el ciclo. Se llama al metodo de escribirSerializado.
	 */
	@Override
	public int eliminar(int index) {
		if (index >= 0 && index < listaCocinas.size()) {
			listaCocinas.remove(index);
			escribirSerializado();
			escribirArchivor();
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
	public int actulizar(int index, Cocina nuevoDato) {
		if (index >= 0 && index < listaCocinas.size()) {
			listaCocinas.set(index, nuevoDato);
			escribirSerializado();
			escribirArchivor();
			return 0;
		} else {
			return 1;
		}
	}

	public boolean encontrar(int index) {
		// TODO Auto-generated method stub
		return index >= 0 && index < listaCocinas.size();
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
		int a = 1;
		for (Cocina cocina : listaCocinas) {
			salida += a + ". " + cocina.toString() + "\n";
			a++;
		}
		return salida;
	}

	public boolean encontrarNombre(String nombre) {
		for (Cocina cocina : listaCocinas) {
			if (cocina.getNombre().equals(nombre)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Metodo el cual tiene como objetivo guardar la lista definida dentro del
	 * archivo como .dat
	 */
	@Override
	public void escribirSerializado() {
		FileManager.escribirArchivoSerializado(SERIAL_FILE_NAME, listaCocinas);
	}

	/**
	 * Este metodo carga el archivo la lista en el archivoSerializado donde se lee
	 * la lista con el leerArchivoSerializado en este caso SERIAL_FILE_NAME. Se
	 * utiliza un condiconal tipo if en donde si la lista se encuentra vacia se
	 * inicializa un nuevo array para la lista.
	 */
	@Override
	public void cargarSerializado() {
		listaCocinas = (ArrayList<Cocina>) FileManager.leerArchivoSerialziado(SERIAL_FILE_NAME);
		if (listaCocinas == null) {
			listaCocinas = new ArrayList<>();
		}
	}

	public void escribirArchivor() {
		String contenido = "";
		for (int i = 0; i < listaCocinas.size(); i++) {
			contenido += listaCocinas.get(i).getNombre() + ";";
			contenido += listaCocinas.get(i).getPrecio() + ";";
			contenido += listaCocinas.get(i).getId() + ";";
			contenido += listaCocinas.get(i).getFecha() + ";";
			contenido += listaCocinas.get(i).getImagen() + ";";
			contenido += listaCocinas.get(i).isEsDecoracion() + ";";
			contenido += listaCocinas.get(i).isResisteAltaTemperatuta() + ";";
			contenido += listaCocinas.get(i).isEsPeligroso() + "\n";
		}
		FileManager.escribirArchivoTexto(TEXT_FILE_NAME, contenido);
	}

	public ArrayList<Cocina> getListaCocinas() {
		return listaCocinas;
	}

	public void setListaCocinas(ArrayList<Cocina> listaCocinas) {
		this.listaCocinas = listaCocinas;
	}

}