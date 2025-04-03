package co.edu.unbosque.model.persistence;

import java.util.ArrayList;
import co.edu.unbosque.model.Electrodomestico;

/**
 * Clase que implementa el DAO (Data Access Object) para gestionar objetos de tipo Electrodomestico.
 * Proporciona métodos para operaciones CRUD y persistencia en archivos.
 */
public class ElectrodomesticoDAO implements OperacionDAO<Electrodomestico> {

    /**
     * Nombre del archivo serializado para almacenar objetos de tipo Electrodomestico.
     */
    private final String SERIAL_FILE_NAME = "electrodomestico.dat";

    /**
     * Nombre del archivo de texto para almacenar objetos de tipo Electrodomestico en formato CSV.
     */
    private final String TEXT_FILE_NAME = "electrodomestico.csv";

    /**
     * Lista de objetos de tipo Electrodomestico gestionados por este DAO.
     */
    private ArrayList<Electrodomestico> listaElectrodomesticos;

    /**
     * Constructor que inicializa la lista y carga los datos serializados.
     */
    public ElectrodomesticoDAO() {
        listaElectrodomesticos = new ArrayList<>();
        cargarSerializado();
    }

    /**
     * Agrega un nuevo objeto de tipo Electrodomestico a la lista y persiste los datos.
     * @param nuevoDato El nuevo objeto de tipo Electrodomestico a agregar.
     */
    @Override
    public void crear(Electrodomestico nuevoDato) {
        listaElectrodomesticos.add(nuevoDato);
        escribirSerializado();
        escribirArchivo();
    }

    /**
     * Elimina un objeto de tipo Electrodomestico de la lista según su índice y persiste los datos.
     * @param index El índice del objeto a eliminar.
     * @return 0 si la operación es exitosa, 1 si el índice es inválido.
     */
    @Override
    public int eliminar(int index) {
        if (index >= 0 && index < listaElectrodomesticos.size()) {
            listaElectrodomesticos.remove(index);
            escribirSerializado();
            escribirArchivo();
            return 0;
        } else {
            return 1;
        }
    }

    /**
     * Actualiza un objeto de tipo Electrodomestico en la lista según su índice y persiste los datos.
     * @param index El índice del objeto a actualizar.
     * @param nuevoDato El nuevo objeto de tipo Electrodomestico que reemplazará al existente.
     * @return 0 si la operación es exitosa, 1 si el índice es inválido.
     */
    @Override
    public int actulizar(int index, Electrodomestico nuevoDato) {
        if (index >= 0 && index < listaElectrodomesticos.size()) {
            listaElectrodomesticos.set(index, nuevoDato);
            escribirSerializado();
            escribirArchivo();
            return 0;
        } else {
            return 1;
        }
    }

    /**
     * Verifica si existe un objeto de tipo Electrodomestico en el índice especificado.
     * @param index El índice a verificar.
     * @return true si el índice es válido, false en caso contrario.
     */
    @Override
    public boolean encontrar(int index) {
        return index >= 0 && index < listaElectrodomesticos.size();
    }

    /**
     * Retorna una representación en cadena de todos los objetos de tipo Electrodomestico en la lista.
     * @return Una cadena con todos los objetos de tipo Electrodomestico.
     */
    @Override
    public String mostrarTodo() {
        String salida = "";
        int a = 1;
        for (Electrodomestico electrodomestico : listaElectrodomesticos) {
            salida += a + ". " + electrodomestico.toString() + "\n";
            a++;
        }
        return salida;
    }

    /**
     * Escribe la lista de objetos de tipo Electrodomestico en un archivo serializado.
     */
    @Override
    public void escribirSerializado() {
        FileManager.escribirArchivoSerializado(SERIAL_FILE_NAME, listaElectrodomesticos);
    }

    /**
     * Carga la lista de objetos de tipo Electrodomestico desde un archivo serializado.
     * Si el archivo está vacío o no existe, inicializa una nueva lista.
     */
    @Override
    public void cargarSerializado() {
        listaElectrodomesticos = (ArrayList<Electrodomestico>) FileManager.leerArchivoSerialziado(SERIAL_FILE_NAME);
        if (listaElectrodomesticos == null) {
            listaElectrodomesticos = new ArrayList<>();
        }
    }

    /**
     * Escribe la lista de objetos de tipo Electrodomestico en un archivo de texto en formato CSV.
     */
    public void escribirArchivo() {
        String contenido = "";
        for (int i = 0; i < listaElectrodomesticos.size(); i++) {
            contenido += listaElectrodomesticos.get(i).getNombre() + ";";
            contenido += listaElectrodomesticos.get(i).getPrecio() + ";";
            contenido += listaElectrodomesticos.get(i).getId() + ";";
            contenido += listaElectrodomesticos.get(i).getFecha() + ";";
            contenido += listaElectrodomesticos.get(i).getImagen() + ";";
            contenido += listaElectrodomesticos.get(i).isEsPortatil() + ";";
            contenido += listaElectrodomesticos.get(i).getFuenteDeEnergia() + "\n";
        }
        FileManager.escribirArchivoTexto(TEXT_FILE_NAME, contenido);
    }

    /**
     * Obtiene la lista de objetos de tipo Electrodomestico.
     * @return La lista de objetos de tipo Electrodomestico.
     */
    public ArrayList<Electrodomestico> getListaElectrodomesticos() {
        return listaElectrodomesticos;
    }

    /**
     * Establece una nueva lista de objetos de tipo Electrodomestico.
     * @param listaElectrodomesticos La nueva lista de objetos de tipo Electrodomestico.
     */
    public void setListaElectrodomesticos(ArrayList<Electrodomestico> listaElectrodomesticos) {
        this.listaElectrodomesticos = listaElectrodomesticos;
    }
}