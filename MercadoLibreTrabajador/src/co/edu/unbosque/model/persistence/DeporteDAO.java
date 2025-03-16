package co.edu.unbosque.model.persistence;

import java.util.ArrayList;
import co.edu.unbosque.model.Deporte;

public class DeporteDAO implements OperacionDAO<Deporte> {
    private final String SERIAL_FILE_NAME = "deporte.dat";
    private ArrayList<Deporte> listaDeportes = new ArrayList<>();
    
    public DeporteDAO() {
		// TODO Auto-generated constructor stub
		listaDeportes = new ArrayList<>();
		cargarSerializado();
	}

    @Override
    public void crear(Deporte nuevoDato) {
        listaDeportes.add(nuevoDato);
        escribirSerializado();
    }

    @Override
    public int eliminar(int index) {
        if (index >= 0 && index < listaDeportes.size()) {
            listaDeportes.remove(index);
            escribirSerializado();
            return 0;
        } else {
            return 1;
        }
    }

    @Override
    public int actulizar(int index, Deporte nuevoDato) {
        if (index >= 0 && index < listaDeportes.size()) {
            listaDeportes.set(index, nuevoDato);
            escribirSerializado();
            return 0;
        } else {
            return 1;
        }
    }

    @Override
    public String mostrarTodo() {
        String salida = "";
        for (Deporte deporte : listaDeportes) {
            salida += deporte.toString();
        }
        return salida;
    }

    @Override
    public void escribirSerializado() {
        FileManager.escribirArchivoSerializado(SERIAL_FILE_NAME, listaDeportes);
    }

    @Override
    public void cargarSerializado() {
        listaDeportes = (ArrayList<Deporte>) FileManager.leerArchivoSerialziado(SERIAL_FILE_NAME);
        if (listaDeportes == null) {
            listaDeportes = new ArrayList<>();
        }
    }
}