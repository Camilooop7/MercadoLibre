package co.edu.unbosque.model.persistence;

import java.util.ArrayList;
import co.edu.unbosque.model.Carrito;

public class CarritoDAO implements OperacionDAO<Carrito> {
    private final String SERIAL_FILE_NAME = "carrito.dat";
    private ArrayList<Carrito> listaCarritos = new ArrayList<>();
    
	public CarritoDAO() {
		// TODO Auto-generated constructor stub
		listaCarritos = new ArrayList<>();
		cargarSerializado();
	}
    @Override
    public void crear(Carrito nuevoDato) {
        listaCarritos.add(nuevoDato);
        escribirSerializado();
    }

    @Override
    public int eliminar(int index) {
        if (index >= 0 && index < listaCarritos.size()) {
            listaCarritos.remove(index);
            escribirSerializado();
            return 0;
        } else {
            return 1;
        }
    }

    @Override
    public int actulizar(int index, Carrito nuevoDato) {
        if (index >= 0 && index < listaCarritos.size()) {
            listaCarritos.set(index, nuevoDato);
            escribirSerializado();
            return 0;
        } else {
            return 1;
        }
    }

    @Override
    public String mostrarTodo() {
        String salida = "";
        for (Carrito carrito : listaCarritos) {
            salida += carrito.toString();
        }
        return salida;
    }

    @Override
    public void escribirSerializado() {
        FileManager.escribirArchivoSerializado(SERIAL_FILE_NAME, listaCarritos);
    }

    @Override
    public void cargarSerializado() {
        listaCarritos = (ArrayList<Carrito>) FileManager.leerArchivoSerialziado(SERIAL_FILE_NAME);
        if (listaCarritos == null) {
            listaCarritos = new ArrayList<>();
        }
    }
}