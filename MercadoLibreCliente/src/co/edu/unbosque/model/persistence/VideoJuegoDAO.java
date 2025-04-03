package co.edu.unbosque.model.persistence;

import java.util.ArrayList;
import co.edu.unbosque.model.VideoJuego;

/**
 * Clase que implementa el DAO (Data Access Object) para gestionar objetos de tipo VideoJuego.
 * Proporciona métodos para operaciones CRUD y persistencia en archivos.
 */
public class VideoJuegoDAO implements OperacionDAO<VideoJuego> {

    /**
     * Nombre del archivo serializado para almacenar objetos de tipo VideoJuego.
     */
    private final String SERIAL_FILE_NAME = "videojuego.dat";

    /**
     * Nombre del archivo de texto para almacenar objetos de tipo VideoJuego en formato CSV.
     */
    private final String TEXT_FILE_NAME = "videojuego.csv";

    /**
     * Lista de objetos de tipo VideoJuego gestionados por este DAO.
     */
    private ArrayList<VideoJuego> listaVideoJuegos;

    /**
     * Constructor que inicializa la lista y carga los datos serializados.
     */
    public VideoJuegoDAO() {
        listaVideoJuegos = new ArrayList<>();
        cargarSerializado();
    }

    /**
     * Agrega un nuevo objeto de tipo VideoJuego a la lista y persiste los datos.
     * @param nuevoDato El nuevo objeto de tipo VideoJuego a agregar.
     */
    @Override
    public void crear(VideoJuego nuevoDato) {
        listaVideoJuegos.add(nuevoDato);
        escribirSerializado();
        escribirArchivo();
    }

    /**
     * Elimina un objeto de tipo VideoJuego de la lista según su índice y persiste los datos.
     * @param index El índice del objeto a eliminar.
     * @return 0 si la operación es exitosa, 1 si el índice es inválido.
     */
    @Override
    public int eliminar(int index) {
        if (index >= 0 && index < listaVideoJuegos.size()) {
            listaVideoJuegos.remove(index);
            escribirSerializado();
            escribirArchivo();
            return 0;
        } else {
            return 1;
        }
    }

    /**
     * Actualiza un objeto de tipo VideoJuego en la lista según su índice y persiste los datos.
     * @param index El índice del objeto a actualizar.
     * @param nuevoDato El nuevo objeto de tipo VideoJuego que reemplazará al existente.
     * @return 0 si la operación es exitosa, 1 si el índice es inválido.
     */
    @Override
    public int actulizar(int index, VideoJuego nuevoDato) {
        if (index >= 0 && index < listaVideoJuegos.size()) {
            listaVideoJuegos.set(index, nuevoDato);
            escribirSerializado();
            escribirArchivo();
            return 0;
        } else {
            return 1;
        }
    }

    /**
     * Verifica si existe un objeto de tipo VideoJuego en el índice especificado.
     * @param index El índice a verificar.
     * @return true si el índice es válido, false en caso contrario.
     */
    @Override
    public boolean encontrar(int index) {
        return index >= 0 && index < listaVideoJuegos.size();
    }

    /**
     * Retorna una representación en cadena de todos los objetos de tipo VideoJuego en la lista.
     * @return Una cadena con todos los objetos de tipo VideoJuego.
     */
    @Override
    public String mostrarTodo() {
        String salida = "";
        int a = 1;
        for (VideoJuego videoJuego : listaVideoJuegos) {
            salida += a + ". " + videoJuego.toString() + "\n";
            a++;
        }
        return salida;
    }

    /**
     * Escribe la lista de objetos de tipo VideoJuego en un archivo serializado.
     */
    @Override
    public void escribirSerializado() {
        FileManager.escribirArchivoSerializado(SERIAL_FILE_NAME, listaVideoJuegos);
    }

    /**
     * Carga la lista de objetos de tipo VideoJuego desde un archivo serializado.
     * Si el archivo está vacío o no existe, inicializa una nueva lista.
     */
    @Override
    public void cargarSerializado() {
        listaVideoJuegos = (ArrayList<VideoJuego>) FileManager.leerArchivoSerialziado(SERIAL_FILE_NAME);
        if (listaVideoJuegos == null) {
            listaVideoJuegos = new ArrayList<>();
        }
    }

    /**
     * Escribe la lista de objetos de tipo VideoJuego en un archivo de texto en formato CSV.
     */
    public void escribirArchivo() {
        String contenido = "";
        for (int i = 0; i < listaVideoJuegos.size(); i++) {
            contenido += listaVideoJuegos.get(i).getNombre() + ";";
            contenido += listaVideoJuegos.get(i).getPrecio() + ";";
            contenido += listaVideoJuegos.get(i).getId() + ";";
            contenido += listaVideoJuegos.get(i).getFecha() + ";";
            contenido += listaVideoJuegos.get(i).getImagen() + ";";
            contenido += listaVideoJuegos.get(i).isEsAccesorio() + ";";
            contenido += listaVideoJuegos.get(i).getReferenciaConsola() + "\n";
        }
        FileManager.escribirArchivoTexto(TEXT_FILE_NAME, contenido);
    }

    /**
     * Obtiene la lista de objetos de tipo VideoJuego.
     * @return La lista de objetos de tipo VideoJuego.
     */
    public ArrayList<VideoJuego> getListaVideoJuegos() {
        return listaVideoJuegos;
    }

    /**
     * Establece una nueva lista de objetos de tipo VideoJuego.
     * @param listaVideoJuegos La nueva lista de objetos de tipo VideoJuego.
     */
    public void setListaVideoJuegos(ArrayList<VideoJuego> listaVideoJuegos) {
        this.listaVideoJuegos = listaVideoJuegos;
    }
}