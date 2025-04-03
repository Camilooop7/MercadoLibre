package co.edu.unbosque.model.persistence;

import java.util.ArrayList;
import co.edu.unbosque.model.Cocina;

/**
 * Clase que implementa el DAO (Data Access Object) para gestionar objetos de tipo Cocina.
 * Proporciona métodos para operaciones CRUD y persistencia en archivos.
 */
public class CocinaDAO implements OperacionDAO<Cocina> {

    /**
     * Nombre del archivo serializado para almacenar objetos de tipo Cocina.
     */
    private final String SERIAL_FILE_NAME = "cocina.dat";

    /**
     * Nombre del archivo de texto para almacenar objetos de tipo Cocina en formato CSV.
     */
    private final String TEXT_FILE_NAME = "cocina.csv";

    /**
     * Lista de objetos de tipo Cocina gestionados por este DAO.
     */
    private ArrayList<Cocina> listaCocinas;

    /**
     * Constructor que inicializa la lista y carga los datos serializados.
     */
    public CocinaDAO() {
        listaCocinas = new ArrayList<>();
        cargarSerializado();
    }

    /**
     * Agrega un nuevo objeto de tipo Cocina a la lista y persiste los datos.
     * @param nuevoDato El nuevo objeto de tipo Cocina a agregar.
     */
    @Override
    public void crear(Cocina nuevoDato) {
        listaCocinas.add(nuevoDato);
        escribirSerializado();
        escribirArchivo();
    }

    /**
     * Elimina un objeto de tipo Cocina de la lista según su índice y persiste los datos.
     * @param index El índice del objeto a eliminar.
     * @return 0 si la operación es exitosa, 1 si el índice es inválido.
     */
    @Override
    public int eliminar(int index) {
        if (index >= 0 && index < listaCocinas.size()) {
            listaCocinas.remove(index);
            escribirSerializado();
            escribirArchivo();
            return 0;
        } else {
            return 1;
        }
    }

    /**
     * Actualiza un objeto de tipo Cocina en la lista según su índice y persiste los datos.
     * @param index El índice del objeto a actualizar.
     * @param nuevoDato El nuevo objeto de tipo Cocina que reemplazará al existente.
     * @return 0 si la operación es exitosa, 1 si el índice es inválido.
     */
    @Override
    public int actulizar(int index, Cocina nuevoDato) {
        if (index >= 0 && index < listaCocinas.size()) {
            listaCocinas.set(index, nuevoDato);
            escribirSerializado();
            escribirArchivo();
            return 0;
        } else {
            return 1;
        }
    }

    /**
     * Verifica si existe un objeto de tipo Cocina en el índice especificado.
     * @param index El índice a verificar.
     * @return true si el índice es válido, false en caso contrario.
     */
    @Override
    public boolean encontrar(int index) {
        return index >= 0 && index < listaCocinas.size();
    }

    /**
     * Retorna una representación en cadena de todos los objetos de tipo Cocina en la lista.
     * @return Una cadena con todos los objetos de tipo Cocina.
     */
    @Override
    public String mostrarTodo() {
        String salida = "";
        int a = 1;
        for (Cocina cocina : listaCocinas) {
            salida += a + ". " + cocina.toString() + "\n";
            a++;
        }
        return salida;
    }

    /**
     * Escribe la lista de objetos de tipo Cocina en un archivo serializado.
     */
    @Override
    public void escribirSerializado() {
        FileManager.escribirArchivoSerializado(SERIAL_FILE_NAME, listaCocinas);
    }

    /**
     * Carga la lista de objetos de tipo Cocina desde un archivo serializado.
     * Si el archivo está vacío o no existe, inicializa una nueva lista.
     */
    @Override
    public void cargarSerializado() {
        listaCocinas = (ArrayList<Cocina>) FileManager.leerArchivoSerialziado(SERIAL_FILE_NAME);
        if (listaCocinas == null) {
            listaCocinas = new ArrayList<>();
        }
    }

    /**
     * Escribe la lista de objetos de tipo Cocina en un archivo de texto en formato CSV.
     */
    public void escribirArchivo() {
        String contenido = "";
        for (int i = 0; i < listaCocinas.size(); i++) {
            contenido += listaCocinas.get(i).getNombre() + ";";
            contenido += listaCocinas.get(i).getPrecio() + ";";
            contenido += listaCocinas.get(i).getId() + ";";
            contenido += listaCocinas.get(i).getFecha() + ";";
            contenido += listaCocinas.get(i).getImagen() + ";";
            contenido += listaCocinas.get(i).isEsDecoracion() + ";";
            contenido += listaCocinas.get(i).isResisteAltaTemperatuta() + ";";
            contenido += listaCocinas.get(i).isEsPeligroso() + "\n";
        }
        FileManager.escribirArchivoTexto(TEXT_FILE_NAME, contenido);
    }

    /**
     * Obtiene la lista de objetos de tipo Cocina.
     * @return La lista de objetos de tipo Cocina.
     */
    public ArrayList<Cocina> getListaCocinas() {
        return listaCocinas;
    }

    /**
     * Establece una nueva lista de objetos de tipo Cocina.
     * @param listaCocinas La nueva lista de objetos de tipo Cocina.
     */
    public void setListaCocinas(ArrayList<Cocina> listaCocinas) {
        this.listaCocinas = listaCocinas;
    }
}