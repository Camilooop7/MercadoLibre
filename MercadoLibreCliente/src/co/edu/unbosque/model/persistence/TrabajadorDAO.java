package co.edu.unbosque.model.persistence;

import java.util.ArrayList;
import co.edu.unbosque.model.Trabajador;

/**
 * Clase que implementa el DAO (Data Access Object) para gestionar objetos de tipo Trabajador.
 * Proporciona métodos para operaciones CRUD y persistencia en archivos.
 */
public class TrabajadorDAO implements OperacionDAO<Trabajador> {

    /**
     * Nombre del archivo serializado para almacenar objetos de tipo Trabajador.
     */
    private final String SERIAL_FILE_NAME = "trabajador.dat";

    /**
     * Lista de objetos de tipo Trabajador gestionados por este DAO.
     */
    private ArrayList<Trabajador> listaTrabajadores;

    /**
     * Constructor que inicializa la lista y carga los datos serializados.
     */
    public TrabajadorDAO() {
        listaTrabajadores = new ArrayList<>();
        cargarSerializado();
    }

    /**
     * Agrega un nuevo objeto de tipo Trabajador a la lista y persiste los datos.
     * @param nuevoDato El nuevo objeto de tipo Trabajador a agregar.
     */
    @Override
    public void crear(Trabajador nuevoDato) {
        listaTrabajadores.add(nuevoDato);
        escribirSerializado();
    }

    /**
     * Elimina un objeto de tipo Trabajador de la lista según su índice y persiste los datos.
     * @param index El índice del objeto a eliminar.
     * @return 0 si la operación es exitosa, 1 si el índice es inválido.
     */
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

    /**
     * Actualiza un objeto de tipo Trabajador en la lista según su índice y persiste los datos.
     * @param index El índice del objeto a actualizar.
     * @param nuevoDato El nuevo objeto de tipo Trabajador que reemplazará al existente.
     * @return 0 si la operación es exitosa, 1 si el índice es inválido.
     */
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

    /**
     * Verifica si existe un objeto de tipo Trabajador en el índice especificado.
     * @param index El índice a verificar.
     * @return true si el índice es válido, false en caso contrario.
     */
    @Override
    public boolean encontrar(int index) {
        return index >= 0 && index < listaTrabajadores.size();
    }

    /**
     * Retorna una representación en cadena de todos los objetos de tipo Trabajador en la lista.
     * @return Una cadena con todos los objetos de tipo Trabajador.
     */
    @Override
    public String mostrarTodo() {
        String salida = "";
        int a = 1;
        for (Trabajador trabajador : listaTrabajadores) {
            salida += a + ". " + trabajador.toString() + "\n";
            a++;
        }
        return salida;
    }

    /**
     * Escribe la lista de objetos de tipo Trabajador en un archivo serializado.
     */
    @Override
    public void escribirSerializado() {
        FileManager.escribirArchivoSerializado(SERIAL_FILE_NAME, listaTrabajadores);
    }

    /**
     * Carga la lista de objetos de tipo Trabajador desde un archivo serializado.
     * Si el archivo está vacío o no existe, inicializa una nueva lista.
     */
    @Override
    public void cargarSerializado() {
        listaTrabajadores = (ArrayList<Trabajador>) FileManager.leerArchivoSerialziado(SERIAL_FILE_NAME);
        if (listaTrabajadores == null) {
            listaTrabajadores = new ArrayList<>();
        }
    }

    /**
     * Busca un objeto de tipo Trabajador por su nombre y contraseña.
     * @param nombre El nombre del trabajador.
     * @param contrasena La contraseña del trabajador.
     * @return El objeto Trabajador si se encuentra, null en caso contrario.
     */
    public Trabajador encontrarUsuario(String nombre, String contrasena) {
        Trabajador salida = null;
        for (Trabajador trabajador : listaTrabajadores) {
            if (trabajador.getNombre().equals(nombre) && trabajador.getContrasena().equals(contrasena)) {
                salida = trabajador;
            }
        }
        return salida;
    }

    /**
     * Verifica si existe un objeto de tipo Trabajador con el nombre especificado.
     * @param nombre El nombre a verificar.
     * @return true si el nombre existe, false en caso contrario.
     */
    public boolean encontrarNombre(String nombre) {
        for (Trabajador trabajador : listaTrabajadores) {
            if (trabajador.getNombre().equals(nombre)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Obtiene la lista de objetos de tipo Trabajador.
     * @return La lista de objetos de tipo Trabajador.
     */
    public ArrayList<Trabajador> getListaTrabajadores() {
        return listaTrabajadores;
    }

    /**
     * Establece una nueva lista de objetos de tipo Trabajador.
     * @param listaTrabajadores La nueva lista de objetos de tipo Trabajador.
     */
    public void setListaTrabajadores(ArrayList<Trabajador> listaTrabajadores) {
        this.listaTrabajadores = listaTrabajadores;
    }
}