package co.edu.unbosque.model.persistence;

import java.util.ArrayList;
import co.edu.unbosque.model.Papeleria;

/**
 * Clase en la cual se implementa la interfaz OperacionDAO para realizar operaciones
 * sobre objetos de tipo Papeleria. Estas operaciones incluyen crear, eliminar,
 * actualizar, y mostrar todos los objetos almacenados, además de guardar y cargar
 * los datos de un archivo serializado.
 */
public class PapeleriaDAO implements OperacionDAO<Papeleria> {

    /**
     * Se declara una variable constante definida por el final la cual 
     * no se puede modificar una vez inicializada, y se le asigna el nombre 
     * del archivo serializado (papeleria.dat).
     */
    private final String SERIAL_FILE_NAME = "papeleria.dat";
    private final String TEXT_FILE_NAME = "papeleria.csv";
    
    /**
     * Se declara una lista de tipo ArrayList que almacenará los objetos Papeleria.
     */
    private ArrayList<Papeleria> listaPapeleria;
    
    /**
     * Constructor de la clase, en el cual se inicializa la lista de papelería
     * y se carga el archivo serializado si existe.
     */
    public PapeleriaDAO() {
        // Inicialización de la lista de papelería y carga del archivo serializado.
        listaPapeleria = new ArrayList<>();
        cargarSerializado();
    }

    /**
     * Método para crear un nuevo objeto Papeleria.
     * Recibe un objeto Papeleria como parámetro y lo agrega a la lista.
     * Luego, se llama al método para escribir la lista serializada en un archivo.
     */
    @Override
    public void crear(Papeleria nuevoDato) {
        // Agrega el nuevo objeto Papeleria a la lista y guarda la lista serializada.
        listaPapeleria.add(nuevoDato);
        escribirSerializado();
        escribirArchivo();
    }

    /**
     * Método para eliminar un objeto Papeleria por su índice en la lista.
     * Si el índice es válido, elimina el objeto y guarda la lista actualizada.
     * Si el índice no es válido, retorna 1.
     */
    @Override
    public int eliminar(int index) {
        if (index >= 0 && index < listaPapeleria.size()) {
            // Elimina el objeto en la posición indicada y guarda la lista actualizada.
            listaPapeleria.remove(index);
            escribirSerializado();
            escribirArchivo();
            return 0;
        } else {
            return 1;
        }
    }

    /**
     * Método para actualizar un objeto Papeleria en la lista.
     * Recibe el índice del objeto a actualizar y el nuevo objeto Papeleria.
     * Si el índice es válido, reemplaza el objeto en la lista y guarda la lista actualizada.
     * Si el índice no es válido, retorna 1.
     */
    @Override
    public int actulizar(int index, Papeleria nuevoDato) {
        if (index >= 0 && index < listaPapeleria.size()) {
            // Reemplaza el objeto en la posición indicada y guarda la lista actualizada.
            listaPapeleria.set(index, nuevoDato);
            escribirSerializado();
            escribirArchivo();
            return 0;
        } else {
            return 1;
        }
    }
    public boolean encontrar(int index) {
		// TODO Auto-generated method stub
		return index >= 0 && index < listaPapeleria.size();
	}

    /**
     * Método para mostrar todos los objetos Papeleria almacenados en la lista.
     * Se recorre la lista, concatenando los objetos a una cadena y la retorna.
     */
    @Override
    public String mostrarTodo() {
        String salida = "";
        for (Papeleria papeleria : listaPapeleria) {
            // Concatenación de la representación en cadena de cada objeto Papeleria.
            salida += papeleria.toString();
        }
        return salida;
    }

    /**
     * Método para escribir la lista de objetos Papeleria en un archivo serializado.
     * Llama al método de FileManager para guardar la lista en un archivo.
     */
    @Override
    public void escribirSerializado() {
        FileManager.escribirArchivoSerializado(SERIAL_FILE_NAME, listaPapeleria);
    }

    /**
     * Método para cargar los datos serializados desde un archivo.
     * Si el archivo no existe o está vacío, se inicializa una nueva lista vacía.
     */
    @Override
    public void cargarSerializado() {
        listaPapeleria = (ArrayList<Papeleria>) FileManager.leerArchivoSerialziado(SERIAL_FILE_NAME);
        if (listaPapeleria == null) {
            // Si no se pudo cargar el archivo, se inicializa una nueva lista vacía.
            listaPapeleria = new ArrayList<>();
        }
    }
    
    public void escribirArchivo() {
		String contenido ="";
		for (int i = 0; i < listaPapeleria.size(); i++) {
			contenido += listaPapeleria.get(i).getNombre()+";";
			contenido += listaPapeleria.get(i).getPrecio()+";";
			contenido += listaPapeleria.get(i).getId()+";";
			contenido += listaPapeleria.get(i).getImagen()+";";
			contenido += listaPapeleria.get(i).isEsPortatil()+";";
			contenido += listaPapeleria.get(i).getCantidadPorPaquete()+"\n";
		}
		FileManager.escribirArchivoTexto(TEXT_FILE_NAME, contenido);
	}

    /**
     * Método para obtener la lista de objetos Papeleria.
     */
    public ArrayList<Papeleria> getListaPapeleria() {
        return listaPapeleria;
    }

    /**
     * Método para establecer la lista de objetos Papeleria.
     */
    public void setListaPapeleria(ArrayList<Papeleria> listaPapeleria) {
        this.listaPapeleria = listaPapeleria;
    }
}
