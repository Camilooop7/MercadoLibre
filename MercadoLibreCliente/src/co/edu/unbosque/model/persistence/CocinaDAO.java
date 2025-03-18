package co.edu.unbosque.model.persistence;

import java.util.ArrayList;
import co.edu.unbosque.model.Cocina;

public class CocinaDAO implements OperacionDAO<Cocina> {
    private final String SERIAL_FILE_NAME = "cocina.dat";
    private ArrayList<Cocina> listaCocinas;
    
    public CocinaDAO() {
		// TODO Auto-generated constructor stub
		listaCocinas = new ArrayList<>();
		cargarSerializado();
	}

    @Override
    public void crear(Cocina nuevoDato) {
        listaCocinas.add(nuevoDato);
        escribirSerializado();
    }

    @Override
    public int eliminar(int index) {
        if (index >= 0 && index < listaCocinas.size()) {
            listaCocinas.remove(index);
            escribirSerializado();
            return 0;
        } else {
            return 1;
        }
    }

    @Override
    public int actulizar(int index, Cocina nuevoDato) {
        if (index >= 0 && index < listaCocinas.size()) {
            listaCocinas.set(index, nuevoDato);
            escribirSerializado();
            return 0;
        } else {
            return 1;
        }
    }

    @Override
    public String mostrarTodo() {
        String salida = "";
        for (Cocina cocina : listaCocinas) {
            salida += cocina.toString();
        }
        return salida;
    }

    @Override
    public void escribirSerializado() {
        FileManager.escribirArchivoSerializado(SERIAL_FILE_NAME, listaCocinas);
    }

    @Override
    public void cargarSerializado() {
        listaCocinas = (ArrayList<Cocina>) FileManager.leerArchivoSerialziado(SERIAL_FILE_NAME);
        if (listaCocinas == null) {
            listaCocinas = new ArrayList<>();
        }
    }

	public ArrayList<Cocina> getListaCocinas() {
		return listaCocinas;
	}

	public void setListaCocinas(ArrayList<Cocina> listaCocinas) {
		this.listaCocinas = listaCocinas;
	}
    
}