package co.edu.unbosque.model.persistence;

import java.util.ArrayList;
import co.edu.unbosque.model.Cliente;

/**
 * Clase que implementa el DAO (Data Access Object) para gestionar objetos de tipo Cliente.
 * Proporciona métodos para operaciones CRUD y persistencia en archivos.
 */
public class ClienteDAO implements OperacionDAO<Cliente> {

    /**
     * Nombre del archivo serializado para almacenar objetos de tipo Cliente.
     */
    private final String SERIAL_FILE_NAME = "cliente.dat";

    /**
     * Lista de objetos de tipo Cliente gestionados por este DAO.
     */
    private ArrayList<Cliente> listaClientes;

    /**
     * Constructor que inicializa la lista y carga los datos serializados.
     */
    public ClienteDAO() {
        listaClientes = new ArrayList<>();
        cargarSerializado();
    }

    /**
     * Agrega un nuevo objeto de tipo Cliente a la lista y persiste los datos.
     * @param nuevoDato El nuevo objeto de tipo Cliente a agregar.
     */
    @Override
    public void crear(Cliente nuevoDato) {
        listaClientes.add(nuevoDato);
        escribirSerializado();
    }

    /**
     * Elimina un objeto de tipo Cliente de la lista según su índice y persiste los datos.
     * @param index El índice del objeto a eliminar.
     * @return 0 si la operación es exitosa, 1 si el índice es inválido.
     */
    @Override
    public int eliminar(int index) {
        if (index >= 0 && index < listaClientes.size()) {
            listaClientes.remove(index);
            escribirSerializado();
            return 0;
        } else {
            return 1;
        }
    }

    /**
     * Actualiza un objeto de tipo Cliente en la lista según su índice y persiste los datos.
     * @param index El índice del objeto a actualizar.
     * @param nuevoDato El nuevo objeto de tipo Cliente que reemplazará al existente.
     * @return 0 si la operación es exitosa, 1 si el índice es inválido.
     */
    @Override
    public int actulizar(int index, Cliente nuevoDato) {
        if (index >= 0 && index < listaClientes.size()) {
            listaClientes.set(index, nuevoDato);
            escribirSerializado();
            return 0;
        } else {
            return 1;
        }
    }

    /**
     * Verifica si existe un objeto de tipo Cliente en el índice especificado.
     * @param index El índice a verificar.
     * @return true si el índice es válido, false en caso contrario.
     */
    @Override
    public boolean encontrar(int index) {
        return index >= 0 && index < listaClientes.size();
    }

    /**
     * Retorna una representación en cadena de todos los objetos de tipo Cliente en la lista.
     * @return Una cadena con todos los objetos de tipo Cliente.
     */
    @Override
    public String mostrarTodo() {
        String salida = "";
        int a = 1;
        for (Cliente cliente : listaClientes) {
            salida += a + ". " + cliente.toString() + "\n";
            a++;
        }
        return salida;
    }

    /**
     * Escribe la lista de objetos de tipo Cliente en un archivo serializado.
     */
    @Override
    public void escribirSerializado() {
        FileManager.escribirArchivoSerializado(SERIAL_FILE_NAME, listaClientes);
    }

    /**
     * Carga la lista de objetos de tipo Cliente desde un archivo serializado.
     * Si el archivo está vacío o no existe, inicializa una nueva lista.
     */
    @Override
    public void cargarSerializado() {
        listaClientes = (ArrayList<Cliente>) FileManager.leerArchivoSerialziado(SERIAL_FILE_NAME);
        if (listaClientes == null) {
            listaClientes = new ArrayList<>();
        }
    }

    /**
     * Busca un objeto de tipo Cliente por su nombre y contraseña.
     * @param nombre El nombre del cliente.
     * @param contrasena La contraseña del cliente.
     * @return El objeto Cliente si se encuentra, null en caso contrario.
     */
    public Cliente encontrarUsuario(String nombre, String contrasena) {
        Cliente salida = null;
        for (Cliente cliente : listaClientes) {
            if (cliente.getNombre().equals(nombre) && cliente.getContrasena().equals(contrasena)) {
                salida = cliente;
            }
        }
        return salida;
    }

    /**
     * Obtiene la lista de objetos de tipo Cliente.
     * @return La lista de objetos de tipo Cliente.
     */
    public ArrayList<Cliente> getListaClientes() {
        return listaClientes;
    }

    /**
     * Establece una nueva lista de objetos de tipo Cliente.
     * @param listaClientes La nueva lista de objetos de tipo Cliente.
     */
    public void setListaClientes(ArrayList<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }
}