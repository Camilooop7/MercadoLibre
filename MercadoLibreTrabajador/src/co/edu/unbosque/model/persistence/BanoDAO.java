package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.Bano;

public class BanoDAO implements OperacionDAO<Bano> {
	private final String SERIAL_FILE_NAME = "bano.dat"; 
	
	private ArrayList<Bano> listaBanos = new ArrayList<>();
	
	public BanoDAO() {
		// TODO Auto-generated constructor stub
		listaBanos = new ArrayList<>();
		cargarSerializado();
	}
	
	@Override
	public void crear(Bano nuevoDato) {
		// TODO Auto-generated method stub
		listaBanos.add(nuevoDato);
        escribirSerializado();
	}

	@Override
	public int eliminar(int index) {
		// TODO Auto-generated method stub
		if (index >= 0 && index < listaBanos.size()) {
            listaBanos.remove(index);
            escribirSerializado();
            return 0;
        } else {
            return 1;
        }
	}

	@Override
	public int actulizar(int index, Bano nuevoDato) {
		// TODO Auto-generated method stub
		if (index >= 0 && index < listaBanos.size()) {
            listaBanos.set(index,nuevoDato);
            escribirSerializado();
            return 0;
        } else {
            return 1;
        }
	}

	@Override
	public String mostrarTodo() {
		// TODO Auto-generated method stub
        String salida = null;
        for (Bano bebida : listaBanos) {
            salida +=bebida.toString();
        }
        return salida.toString();
	}
	
	@Override
	public void escribirSerializado() {
		FileManager.escribirArchivoSerializado(SERIAL_FILE_NAME,listaBanos);
	}
	
	@Override
	public void cargarSerializado() {
		listaBanos = (ArrayList<Bano>) FileManager.leerArchivoSerialziado(SERIAL_FILE_NAME);
		if(listaBanos == null) {
			listaBanos = new ArrayList<>();
		}
	}
	

}
