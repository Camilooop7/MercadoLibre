package co.edu.unbosque.model.persistence;

import java.util.ArrayList;
import co.edu.unbosque.model.Bano;

/**
 * Clase que implementa el DAO (Data Access Object) para gestionar objetos de tipo Bano.
 * Proporciona métodos para operaciones CRUD y persistencia en archivos.
 */
public class BanoDAO implements OperacionDAO<Bano> {

    /**
     * Nombre del archivo serializado para almacenar objetos de tipo Bano.
     */
    private final String SERIAL_FILE_NAME = "bano.dat";

    /**
     * Nombre del archivo de texto para almacenar objetos de tipo Bano en formato CSV.
     */
    private final String TEXT_FILE_NAME = "bano.csv";

    /**
     * Lista de objetos de tipo Bano gestionados por este DAO.
     */
    private ArrayList<Bano> listaBanos;

    /**
     * Constructor que inicializa la lista y carga los datos serializados.
     */
    public BanoDAO() {
        listaBanos = new ArrayList<>();
        cargarSerializado();
    }

    /**
     * Agrega un nuevo objeto de tipo Bano a la lista y persiste los datos.
     * @param nuevoDato El nuevo objeto de tipo Bano a agregar.
     */
    @Override
    public void crear(Bano nuevoDato) {
        listaBanos.add(nuevoDato);
        escribirSerializado();
        escribirArchivo();
    }

    /**
     * Elimina un objeto de tipo Bano de la lista según su índice y persiste los datos.
     * @param index El índice del objeto a eliminar.
     * @return 0 si la operación es exitosa, 1 si el índice es inválido.
     */
    @Override
    public int eliminar(int index) {
        if (index >= 0 && index < listaBanos.size()) {
            listaBanos.remove(index);
            escribirSerializado();
            escribirArchivo();
            return 0;
        } else {
            return 1;
        }
    }

    /**
     * Actualiza un objeto de tipo Bano en la lista según su índice y persiste los datos.
     * @param index El índice del objeto a actualizar.
     * @param nuevoDato El nuevo objeto de tipo Bano que reemplazará al existente.
     * @return 0 si la operación es exitosa, 1 si el índice es inválido.
     */
    @Override
    public int actulizar(int index, Bano nuevoDato) {
        if (index >= 0 && index < listaBanos.size()) {
            listaBanos.set(index, nuevoDato);
            escribirSerializado();
            escribirArchivo();
            return 0;
        } else {
            return 1;
        }
    }

    /**
     * Verifica si existe un objeto de tipo Bano en el índice especificado.
     * @param index El índice a verificar.
     * @return true si el índice es válido, false en caso contrario.
     */
    @Override
    public boolean encontrar(int index) {
        return index >= 0 && index < listaBanos.size();
    }

    /**
     * Retorna una representación en cadena de todos los objetos de tipo Bano en la lista.
     * @return Una cadena con todos los objetos de tipo Bano.
     */
    @Override
    public String mostrarTodo() {
        String salida = "";
        int a = 1;
        for (Bano bano : listaBanos) {
            salida += a + ". " + bano.toString() + "\n";
            a++;
        }
        return salida;
    }

    /**
     * Escribe la lista de objetos de tipo Bano en un archivo serializado.
     */
    @Override
    public void escribirSerializado() {
        FileManager.escribirArchivoSerializado(SERIAL_FILE_NAME, listaBanos);
    }

    /**
     * Carga la lista de objetos de tipo Bano desde un archivo serializado.
     * Si el archivo está vacío o no existe, inicializa una nueva lista.
     */
    @Override
    public void cargarSerializado() {
        listaBanos = (ArrayList<Bano>) FileManager.leerArchivoSerialziado(SERIAL_FILE_NAME);
        if (listaBanos == null) {
            listaBanos = new ArrayList<>();
        }
    }

    /**
     * Escribe la lista de objetos de tipo Bano en un archivo de texto en formato CSV.
     */
    public void escribirArchivo() {
        String contenido = "";
        for (int i = 0; i < listaBanos.size(); i++) {
            contenido += listaBanos.get(i).getNombre() + ";";
            contenido += listaBanos.get(i).getPrecio() + ";";
            contenido += listaBanos.get(i).getId() + ";";
            contenido += listaBanos.get(i).getFecha() + ";";
            contenido += listaBanos.get(i).getImagen() + ";";
            contenido += listaBanos.get(i).isEsDecoracion() + ";";
            contenido += listaBanos.get(i).isEsLimpieza() + "\n";
        }
        FileManager.escribirArchivoTexto(TEXT_FILE_NAME, contenido);
    }

    /**
     * Obtiene la lista de objetos de tipo Bano.
     * @return La lista de objetos de tipo Bano.
     */
    public ArrayList<Bano> getListaBanos() {
        return listaBanos;
    }

    /**
     * Establece una nueva lista de objetos de tipo Bano.
     * @param listaBanos La nueva lista de objetos de tipo Bano.
     */
    public void setListaBanos(ArrayList<Bano> listaBanos) {
        this.listaBanos = listaBanos;
    }
}
