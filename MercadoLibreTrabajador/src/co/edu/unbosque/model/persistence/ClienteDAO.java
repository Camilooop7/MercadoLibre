package co.edu.unbosque.model.persistence;

import java.util.ArrayList;
import co.edu.unbosque.model.Cliente;

public class ClienteDAO implements OperacionDAO<Cliente> {
    private final String SERIAL_FILE_NAME = "cliente.dat";
    private ArrayList<Cliente> listaClientes = new ArrayList<>();

    public ClienteDAO() {
		// TODO Auto-generated constructor stub
		listaClientes = new ArrayList<>();
		cargarSerializado();
	}
    
    @Override
    public void crear(Cliente nuevoDato) {
        listaClientes.add(nuevoDato);
        escribirSerializado();
    }

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

    @Override
    public String mostrarTodo() {
        String salida = "";
        for (Cliente cliente : listaClientes) {
            salida += cliente.toString();
        }
        return salida;
    }

    @Override
    public void escribirSerializado() {
        FileManager.escribirArchivoSerializado(SERIAL_FILE_NAME, listaClientes);
    }

    @Override
    public void cargarSerializado() {
        listaClientes = (ArrayList<Cliente>) FileManager.leerArchivoSerialziado(SERIAL_FILE_NAME);
        if (listaClientes == null) {
            listaClientes = new ArrayList<>();
        }
    }
}