package co.edu.unbosque.model.persistence;

/**
 * Interfaz que define las operaciones básicas para un DAO (Data Access Object).
 * Estas operaciones incluyen métodos para crear, eliminar, actualizar, mostrar todos los
 * objetos, y métodos para cargar y guardar los datos serializados.
 * @param <C> Tipo genérico de los objetos que serán gestionados por el DAO.
 */
public interface OperacionDAO<C> {

    /**
     * Crea un nuevo objeto de tipo C y lo agrega a la fuente de datos.
     * @param nuevoDato El nuevo objeto a agregar.
     */
    public void crear(C nuevoDato);

    /**
     * Elimina un objeto de tipo C en función de su índice en la fuente de datos.
     * @param index El índice del objeto a eliminar.
     * @return 0 si la eliminación fue exitosa, o 1 si el índice es inválido.
     */
    public int eliminar(int index);

    /**
     * Actualiza un objeto de tipo C en la fuente de datos.
     * @param index El índice del objeto a actualizar.
     * @param nuevoDato El nuevo objeto que reemplazará al existente.
     * @return 0 si la actualización fue exitosa, o 1 si el índice es inválido.
     */
    public int actulizar(int index, C nuevoDato);

    /**
     * Muestra todos los objetos de tipo C almacenados en la fuente de datos.
     * @return Una cadena de texto que contiene la representación de todos los objetos.
     */
    public String mostrarTodo();

    /**
     * Verifica si existe un objeto de tipo C en el índice especificado.
     * @param index El índice a verificar.
     * @return true si el índice es válido, false en caso contrario.
     */
    public boolean encontrar(int index);

    /**
     * Carga los datos serializados desde un archivo o fuente de datos.
     * Este método es responsable de recuperar los datos previamente almacenados.
     */
    public void cargarSerializado();

    /** 
     * Escribe los datos serializados en un archivo o fuente de datos.
     * Este método guarda el estado actual de los objetos almacenados en la fuente de datos.
     */
    public void escribirSerializado();
}

