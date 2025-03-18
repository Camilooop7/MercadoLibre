package co.edu.unbosque.model.persistence;

public interface OperacionDAO<C> {

	public void crear(C nuevoDato);

	public int eliminar(int index);

	public int actulizar(int index, C nuevoDato);

	public String mostrarTodo();

	public void cargarSerializado();
	
	public void escribirSerializado();

}
