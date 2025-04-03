package co.edu.unbosque.model.persistence;

import java.util.ArrayList;
import co.edu.unbosque.model.Deporte;

/**
 * Clase que implementa el DAO (Data Access Object) para gestionar objetos de tipo Deporte.
 * Proporciona métodos para operaciones CRUD y persistencia en archivos.
 */
public class DeporteDAO implements OperacionDAO<Deporte> {

    /**
     * Nombre del archivo serializado para almacenar objetos de tipo Deporte.
     */
    private final String SERIAL_FILE_NAME = "deporte.dat";

    /**
     * Nombre del archivo de texto para almacenar objetos de tipo Deporte en formato CSV.
     */
    private final String TEXT_FILE_NAME = "deporte.csv";

    /**
     * Lista de objetos de tipo Deporte gestionados por este DAO.
     */
    private ArrayList<Deporte> listaDeportes;

    /**
     * Constructor que inicializa la lista y carga los datos serializados.
     */
    public DeporteDAO() {
        listaDeportes = new ArrayList<>();
        cargarSerializado();
    }

    /**
     * Agrega un nuevo objeto de tipo Deporte a la lista y persiste los datos.
     * @param nuevoDato El nuevo objeto de tipo Deporte a agregar.
     */
    @Override
    public void crear(Deporte nuevoDato) {
        listaDeportes.add(nuevoDato);
        escribirSerializado();
        escribirArchivo();
    }

    /**
     * Elimina un objeto de tipo Deporte de la lista según su índice y persiste los datos.
     * @param index El índice del objeto a eliminar.
     * @return 0 si la operación es exitosa, 1 si el índice es inválido.
     */
    @Override
    public int eliminar(int index) {
        if (index >= 0 && index < listaDeportes.size()) {
            listaDeportes.remove(index);
            escribirSerializado();
            escribirArchivo();
            return 0;
        } else {
            return 1;
        }
    }

    /**
     * Actualiza un objeto de tipo Deporte en la lista según su índice y persiste los datos.
     * @param index El índice del objeto a actualizar.
     * @param nuevoDato El nuevo objeto de tipo Deporte que reemplazará al existente.
     * @return 0 si la operación es exitosa, 1 si el índice es inválido.
     */
    @Override
    public int actulizar(int index, Deporte nuevoDato) {
        if (index >= 0 && index < listaDeportes.size()) {
            listaDeportes.set(index, nuevoDato);
            escribirSerializado();
            escribirArchivo();
            return 0;
        } else {
            return 1;
        }
    }

    /**
     * Verifica si existe un objeto de tipo Deporte en el índice especificado.
     * @param index El índice a verificar.
     * @return true si el índice es válido, false en caso contrario.
     */
    @Override
    public boolean encontrar(int index) {
        return index >= 0 && index < listaDeportes.size();
    }

    /**
     * Retorna una representación en cadena de todos los objetos de tipo Deporte en la lista.
     * @return Una cadena con todos los objetos de tipo Deporte.
     */
    @Override
    public String mostrarTodo() {
        String salida = "";
        int a = 1;
        for (Deporte deporte : listaDeportes) {
            salida += a + ". " + deporte.toString() + "\n";
            a++;
        }
        return salida;
    }

    /**
     * Escribe la lista de objetos de tipo Deporte en un archivo serializado.
     */
    @Override
    public void escribirSerializado() {
        FileManager.escribirArchivoSerializado(SERIAL_FILE_NAME, listaDeportes);
    }

    /**
     * Carga la lista de objetos de tipo Deporte desde un archivo serializado.
     * Si el archivo está vacío o no existe, inicializa una nueva lista.
     */
    @Override
    public void cargarSerializado() {
        listaDeportes = (ArrayList<Deporte>) FileManager.leerArchivoSerialziado(SERIAL_FILE_NAME);
        if (listaDeportes == null) {
            listaDeportes = new ArrayList<>();
        }
    }

    /**
     * Escribe la lista de objetos de tipo Deporte en un archivo de texto en formato CSV.
     */
    public void escribirArchivo() {
        String contenido = "";
        for (int i = 0; i < listaDeportes.size(); i++) {
            contenido += listaDeportes.get(i).getNombre() + ";";
            contenido += listaDeportes.get(i).getPrecio() + ";";
            contenido += listaDeportes.get(i).getId() + ";";
            contenido += listaDeportes.get(i).getFecha() + ";";
            contenido += listaDeportes.get(i).getImagen() + ";";
            contenido += listaDeportes.get(i).isEsAccesorio() + ";";
            contenido += listaDeportes.get(i).getDeporte() + "\n";
        }
        FileManager.escribirArchivoTexto(TEXT_FILE_NAME, contenido);
    }

    /**
     * Obtiene la lista de objetos de tipo Deporte.
     * @return La lista de objetos de tipo Deporte.
     */
    public ArrayList<Deporte> getListaDeportes() {
        return listaDeportes;
    }

    /**
     * Establece una nueva lista de objetos de tipo Deporte.
     * @param listaDeportes La nueva lista de objetos de tipo Deporte.
     */
    public void setListaDeportes(ArrayList<Deporte> listaDeportes) {
        this.listaDeportes = listaDeportes;
    }
}