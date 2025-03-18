package co.edu.unbosque.model.persistence;

/*
 * Interfaz que define las operaciones básicas para un DAO (Data Access Object).
 * Estas operaciones incluyen métodos para crear, eliminar, actualizar, mostrar todos los
 * objetos, y métodos para cargar y guardar los datos serializados.
 */
public interface OperacionDAO<C> {

    /*
     * Método para crear un nuevo objeto de tipo C.
     * Recibe como parámetro un objeto nuevo de tipo C y lo agrega a la fuente de datos.
     */
    public void crear(C nuevoDato);

    /*
     * Método para eliminar un objeto de tipo C en función de su índice en la fuente de datos.
     * Recibe como parámetro el índice del objeto a eliminar.
     * Retorna 0 si la eliminación fue exitosa, o 1 si el índice es inválido.
     */
    public int eliminar(int index);

    /*
     * Método para actualizar un objeto de tipo C en la fuente de datos.
     * Recibe como parámetros el índice del objeto a actualizar y el nuevo objeto de tipo C.
     * Retorna 0 si la actualización fue exitosa, o 1 si el índice es inválido.
     */
    public int actulizar(int index, C nuevoDato);

    /*
     * Método para mostrar todos los objetos de tipo C almacenados en la fuente de datos.
     * Retorna una cadena de texto que contiene la representación de todos los objetos.
     */
    public String mostrarTodo();

    /*
     * Método para cargar los datos serializados desde un archivo o fuente de datos.
     * Este método es responsable de recuperar los datos previamente almacenados.
     */
    public void cargarSerializado();

    /*
     * Método para escribir los datos serializados en un archivo o fuente de datos.
     * Este método guarda el estado actual de los objetos almacenados en la fuente de datos.
     */
    public void escribirSerializado();

}

