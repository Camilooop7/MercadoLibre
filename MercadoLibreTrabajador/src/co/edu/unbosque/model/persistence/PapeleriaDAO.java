package co.edu.unbosque.model.persistence;

import java.util.ArrayList;
import co.edu.unbosque.model.Papeleria;

public class PapeleriaDAO implements OperacionDAO<Papeleria> {
    private final String SERIAL_FILE_NAME = "papeleria.dat";
    private ArrayList<Papeleria> listaPapeleria = new ArrayList<>();
    
    public PapeleriaDAO() {
		// TODO Auto-generated constructor stub
		listaPapeleria = new ArrayList<>();
		cargarSerializado();
	}

    @Override
    public void crear(Papeleria nuevoDato) {
        listaPapeleria.add(nuevoDato);
        escribirSerializado();
    }

    @Override
    public int eliminar(int index) {
        if (index >= 0 && index < listaPapeleria.size()) {
            listaPapeleria.remove(index);
            escribirSerializado();
            return 0;
        } else {
            return 1;
        }
    }

    @Override
    public int actulizar(int index, Papeleria nuevoDato) {
        if (index >= 0 && index < listaPapeleria.size()) {
            listaPapeleria.set(index, nuevoDato);
            escribirSerializado();
            return 0;
        } else {
            return 1;
        }
    }

    @Override
    public String mostrarTodo() {
        String salida = "";
        for (Papeleria papeleria : listaPapeleria) {
            salida += papeleria.toString();
        }
        return salida;
    }

    @Override
    public void escribirSerializado() {
        FileManager.escribirArchivoSerializado(SERIAL_FILE_NAME, listaPapeleria);
    }

    @Override
    public void cargarSerializado() {
        listaPapeleria = (ArrayList<Papeleria>) FileManager.leerArchivoSerialziado(SERIAL_FILE_NAME);
        if (listaPapeleria == null) {
            listaPapeleria = new ArrayList<>();
        }
    }
}