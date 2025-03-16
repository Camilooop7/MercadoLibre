package co.edu.unbosque.model.persistence;

public interface OperacionDAO<C> {

	public void crear(C nuevoDato);

	public int eliminar(int index);

	public int elimininar(C datoEliminar);

	public int actulizar(int index, C nuevoDato);

	public String mostrarTodo();

	public int cantidad();

	public boolean encontrar(int index);

	public void escribirEnArchivo();

	public void cargarDesdeArchivo();

}
