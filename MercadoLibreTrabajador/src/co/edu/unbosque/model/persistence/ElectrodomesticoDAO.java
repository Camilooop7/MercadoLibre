package co.edu.unbosque.model.persistence;

import java.util.ArrayList;
import co.edu.unbosque.model.Electrodomestico;

public class ElectrodomesticoDAO implements OperacionDAO<Electrodomestico> {
    private final String SERIAL_FILE_NAME = "electrodomestico.dat";
    private ArrayList<Electrodomestico> listaElectrodomesticos = new ArrayList<>();

    public ElectrodomesticoDAO() {
		// TODO Auto-generated constructor stub
		listaElectrodomesticos = new ArrayList<>();
		cargarSerializado();
	}
    @Override
    public void crear(Electrodomestico nuevoDato) {
        listaElectrodomesticos.add(nuevoDato);
        escribirSerializado();
    }

    @Override
    public int eliminar(int index) {
        if (index >= 0 && index < listaElectrodomesticos.size()) {
            listaElectrodomesticos.remove(index);
            escribirSerializado();
            return 0;
        } else {
            return 1;
        }
    }

    @Override
    public int actulizar(int index, Electrodomestico nuevoDato) {
        if (index >= 0 && index < listaElectrodomesticos.size()) {
            listaElectrodomesticos.set(index, nuevoDato);
            escribirSerializado();
            return 0;
        } else {
            return 1;
        }
    }

    @Override
    public String mostrarTodo() {
        String salida = "";
        for (Electrodomestico electrodomestico : listaElectrodomesticos) {
            salida += electrodomestico.toString();
        }
        return salida;
    }

    @Override
    public void escribirSerializado() {
        FileManager.escribirArchivoSerializado(SERIAL_FILE_NAME, listaElectrodomesticos);
    }

    @Override
    public void cargarSerializado() {
        listaElectrodomesticos = (ArrayList<Electrodomestico>) FileManager.leerArchivoSerialziado(SERIAL_FILE_NAME);
        if (listaElectrodomesticos == null) {
            listaElectrodomesticos = new ArrayList<>();
        }
    }
}