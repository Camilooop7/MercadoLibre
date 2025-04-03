package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.TrabajadorActual;

/**
 * Clase deTrabajadorActualDAO
 */
public class TrabajadorActualDAO {
	/**
	 * Se declara una variable constante definida por el final la cual no deja de
	 * ser modificada una vez inicializada y se le indica el tipo de archivo .dat
	 * 
	 */
	private final String SERIAL_FILE_NAME = "trabajadorActual.dat";
	private final String TEXT_FILE_NAME = "trabajadorActual.csv";
	/**
	 * Variable la cual contiene un arraylist y además se define el nombre.
	 */
	private ArrayList<TrabajadorActual> listaProductosT;
	/*
	 * Constructor en cual cual se llama al metodo de cargarSerializado y se
	 * inicializa la Arraylist.
	 */
	public TrabajadorActualDAO() {
		listaProductosT = new ArrayList<>();
		cargarSerializado();
		// TODO Auto-generated constructor stub
	}
	/**
	 * Metodo crear el cual recibe como parametro nuevoDato y se recurre a la lista
	 * agregando el nuevoDato además de eso se llama al metodo de
	 * escribirSerializado.
	 */
	
	public void crear(TrabajadorActual nuevoDato) {
		listaProductosT.add(nuevoDato);
		escribirArchivoTexto();
		escribirSerializado();
	}
	/**
	 * Metodo el cual tiene como objetivo guardar la lista definida dentro del
	 * archivo como .dat
	 */
	public void escribirSerializado() {
		FileManager.escribirArchivoSerializado(SERIAL_FILE_NAME, listaProductosT);
	}
	/**
	 * Este metodo carga el archivo la lista en el archivoSerializado donde se lee
	 * la lista con el leerArchivoSerializado en este caso SERIAL_FILE_NAME. Se
	 * utiliza un condiconal tipo if en donde si la lista se encuentra vacia se
	 * inicializa un nuevo array para la lista.
	 */
	public void cargarSerializado() {
		
		listaProductosT = (ArrayList<TrabajadorActual>) FileManager.leerArchivoSerialziado(SERIAL_FILE_NAME);
		if (listaProductosT == null) {
			listaProductosT = new ArrayList<>();
		}
	}
	/**
	 * Este metodo carga el archivo la lista en el archivo csv donde se escribe
	 * la lista con el escribirArchivoTexto en este caso TEXT_FILE_NAME.
	 * 
	 */
	
	public void escribirArchivoTexto() {
		String contenido = "";
		for (int i = 0; i < listaProductosT.size(); i++) {
			contenido += listaProductosT.get(i).getNombre()+";";
			contenido += listaProductosT.get(i).getFecha()+";";
			contenido += listaProductosT.get(i).getProducto()+"\n";
		}
		FileManager.escribirArchivoTexto(TEXT_FILE_NAME, contenido);
	}
	
	public ArrayList<TrabajadorActual> getListaProductosT() {
		return listaProductosT;
	}

	public void setListaProductosT(ArrayList<TrabajadorActual> listaProductosT) {
		this.listaProductosT = listaProductosT;
	}
}
