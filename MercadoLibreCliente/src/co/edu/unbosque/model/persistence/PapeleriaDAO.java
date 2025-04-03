package co.edu.unbosque.model.persistence;

import java.util.ArrayList;
import co.edu.unbosque.model.Papeleria;

/**
 * Clase que implementa el DAO (Data Access Object) para gestionar objetos de tipo Papeleria.
 * Proporciona métodos para operaciones CRUD y persistencia en archivos.
 */
public class PapeleriaDAO implements OperacionDAO<Papeleria> {

    /**
     * Nombre del archivo serializado para almacenar objetos de tipo Papeleria.
     */
    private final String SERIAL_FILE_NAME = "papeleria.dat";

    /**
     * Nombre del archivo de texto para almacenar objetos de tipo Papeleria en formato CSV.
     */
    private final String TEXT_FILE_NAME = "papeleria.csv";

    /**
     * Lista de objetos de tipo Papeleria gestionados por este DAO.
     */
    private ArrayList<Papeleria> listaPapeleria;

    /**
     * Constructor que inicializa la lista y carga los datos serializados.
     */
    public PapeleriaDAO() {
        listaPapeleria = new ArrayList<>();
        cargarSerializado();
    }

    /**
     * Agrega un nuevo objeto de tipo Papeleria a la lista y persiste los datos.
     * @param nuevoDato El nuevo objeto de tipo Papeleria a agregar.
     */
    @Override
    public void crear(Papeleria nuevoDato) {
        listaPapeleria.add(nuevoDato);
        escribirSerializado();
        escribirArchivo();
    }

    /**
     * Elimina un objeto de tipo Papeleria de la lista según su índice y persiste los datos.
     * @param index El índice del objeto a eliminar.
     * @return 0 si la operación es exitosa, 1 si el índice es inválido.
     */
    @Override
    public int eliminar(int index) {
        if (index >= 0 && index < listaPapeleria.size()) {
            listaPapeleria.remove(index);
            escribirSerializado();
            escribirArchivo();
            return 0;
        } else {
            return 1;
        }
    }

    /**
     * Actualiza un objeto de tipo Papeleria en la lista según su índice y persiste los datos.
     * @param index El índice del objeto a actualizar.
     * @param nuevoDato El nuevo objeto de tipo Papeleria que reemplazará al existente.
     * @return 0 si la operación es exitosa, 1 si el índice es inválido.
     */
    @Override
    public int actulizar(int index, Papeleria nuevoDato) {
        if (index >= 0 && index < listaPapeleria.size()) {
            listaPapeleria.set(index, nuevoDato);
            escribirSerializado();
            escribirArchivo();
            return 0;
        } else {
            return 1;
        }
    }

    /**
     * Verifica si existe un objeto de tipo Papeleria en el índice especificado.
     * @param index El índice a verificar.
     * @return true si el índice es válido, false en caso contrario.
     */
    @Override
    public boolean encontrar(int index) {
        return index >= 0 && index < listaPapeleria.size();
    }

    /**
     * Retorna una representación en cadena de todos los objetos de tipo Papeleria en la lista.
     * @return Una cadena con todos los objetos de tipo Papeleria.
     */
    @Override
    public String mostrarTodo() {
        String salida = "";
        int a = 1;
        for (Papeleria papeleria : listaPapeleria) {
            salida += a + ". " + papeleria.toString() + "\n";
            a++;
        }
        return salida;
    }

    /**
     * Escribe la lista de objetos de tipo Papeleria en un archivo serializado.
     */
    @Override
    public void escribirSerializado() {
        FileManager.escribirArchivoSerializado(SERIAL_FILE_NAME, listaPapeleria);
    }

    /**
     * Carga la lista de objetos de tipo Papeleria desde un archivo serializado.
     * Si el archivo está vacío o no existe, inicializa una nueva lista.
     */
    @Override
    public void cargarSerializado() {
        listaPapeleria = (ArrayList<Papeleria>) FileManager.leerArchivoSerialziado(SERIAL_FILE_NAME);
        if (listaPapeleria == null) {
            listaPapeleria = new ArrayList<>();
        }
    }

    /**
     * Escribe la lista de objetos de tipo Papeleria en un archivo de texto en formato CSV.
     */
    public void escribirArchivo() {
        String contenido = "";
        for (int i = 0; i < listaPapeleria.size(); i++) {
            contenido += listaPapeleria.get(i).getNombre() + ";";
            contenido += listaPapeleria.get(i).getPrecio() + ";";
            contenido += listaPapeleria.get(i).getId() + ";";
            contenido += listaPapeleria.get(i).getFecha() + ";";
            contenido += listaPapeleria.get(i).getImagen() + ";";
            contenido += listaPapeleria.get(i).isEsPortatil() + ";";
            contenido += listaPapeleria.get(i).getCantidadPorPaquete() + "\n";
        }
        FileManager.escribirArchivoTexto(TEXT_FILE_NAME, contenido);
    }

    /**
     * Obtiene la lista de objetos de tipo Papeleria.
     * @return La lista de objetos de tipo Papeleria.
     */
    public ArrayList<Papeleria> getListaPapeleria() {
        return listaPapeleria;
    }

    /**
     * Establece una nueva lista de objetos de tipo Papeleria.
     * @param listaPapeleria La nueva lista de objetos de tipo Papeleria.
     */
    public void setListaPapeleria(ArrayList<Papeleria> listaPapeleria) {
        this.listaPapeleria = listaPapeleria;
    }
}
