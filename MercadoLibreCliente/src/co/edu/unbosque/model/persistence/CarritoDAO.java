package co.edu.unbosque.model.persistence;

import java.util.ArrayList;
import co.edu.unbosque.model.Carrito;

/**
 * Clase que implementa el DAO (Data Access Object) para gestionar objetos de tipo Carrito.
 * Proporciona métodos para operaciones CRUD y persistencia en archivos.
 */
public class CarritoDAO implements OperacionDAO<Carrito> {

    /**
     * Nombre del archivo serializado para almacenar objetos de tipo Carrito.
     */
    private final String SERIAL_FILE_NAME = "carrito.dat";

    /**
     * Lista de objetos de tipo Carrito gestionados por este DAO.
     */
    private ArrayList<Carrito> listaCarritos;

    /**
     * Constructor que inicializa la lista y carga los datos serializados.
     */
    public CarritoDAO() {
        listaCarritos = new ArrayList<>();
        cargarSerializado();
    }

    /**
     * Agrega un nuevo objeto de tipo Carrito a la lista y persiste los datos.
     * @param nuevoDato El nuevo objeto de tipo Carrito a agregar.
     */
    @Override
    public void crear(Carrito nuevoDato) {
        listaCarritos.add(nuevoDato);
        escribirSerializado();
    }

    /**
     * Elimina un objeto de tipo Carrito de la lista según su índice y persiste los datos.
     * @param index El índice del objeto a eliminar.
     * @return 0 si la operación es exitosa, 1 si el índice es inválido.
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
     * Actualiza un objeto de tipo Carrito en la lista según su índice y persiste los datos.
     * @param index El índice del objeto a actualizar.
     * @param nuevoDato El nuevo objeto de tipo Carrito que reemplazará al existente.
     * @return 0 si la operación es exitosa, 1 si el índice es inválido.
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

    /**
     * Verifica si existe un objeto de tipo Carrito en el índice especificado.
     * @param index El índice a verificar.
     * @return true si el índice es válido, false en caso contrario.
     */
    @Override
    public boolean encontrar(int index) {
        return index >= 0 && index < listaCarritos.size();
    }

    /**
     * Retorna una representación en cadena de todos los objetos de tipo Carrito en la lista.
     * @return Una cadena con todos los objetos de tipo Carrito.
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
     * Escribe la lista de objetos de tipo Carrito en un archivo serializado.
     */
    @Override
    public void escribirSerializado() {
        FileManager.escribirArchivoSerializado(SERIAL_FILE_NAME, listaCarritos);
    }

    /**
     * Carga la lista de objetos de tipo Carrito desde un archivo serializado.
     * Si el archivo está vacío o no existe, inicializa una nueva lista.
     */
    @Override
    public void cargarSerializado() {
        listaCarritos = (ArrayList<Carrito>) FileManager.leerArchivoSerialziado(SERIAL_FILE_NAME);
        if (listaCarritos == null) {
            listaCarritos = new ArrayList<>();
        }
    }

    /**
     * Obtiene la lista de objetos de tipo Carrito.
     * @return La lista de objetos de tipo Carrito.
     */
    public ArrayList<Carrito> getListaCarritos() {
        return listaCarritos;
    }

    /**
     * Establece una nueva lista de objetos de tipo Carrito.
     * @param listaCarritos La nueva lista de objetos de tipo Carrito.
     */
    public void setListaCarritos(ArrayList<Carrito> listaCarritos) {
        this.listaCarritos = listaCarritos;
    }
}