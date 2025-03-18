package co.edu.unbosque.model.persistence;

import java.util.ArrayList;
import co.edu.unbosque.model.VideoJuego;

public class VideoJuegoDAO implements OperacionDAO<VideoJuego> {
    private final String SERIAL_FILE_NAME = "videojuego.dat";
    private ArrayList<VideoJuego> listaVideoJuegos;
    
    public VideoJuegoDAO() {
		// TODO Auto-generated constructor stub
		listaVideoJuegos = new ArrayList<>();
		cargarSerializado();
	}

    @Override
    public void crear(VideoJuego nuevoDato) {
        listaVideoJuegos.add(nuevoDato);
        escribirSerializado();
    }

    @Override
    public int eliminar(int index) {
        if (index >= 0 && index < listaVideoJuegos.size()) {
            listaVideoJuegos.remove(index);
            escribirSerializado();
            return 0;
        } else {
            return 1;
        }
    }

    @Override
    public int actulizar(int index, VideoJuego nuevoDato) {
        if (index >= 0 && index < listaVideoJuegos.size()) {
            listaVideoJuegos.set(index, nuevoDato);
            escribirSerializado();
            return 0;
        } else {
            return 1;
        }
    }

    @Override
    public String mostrarTodo() {
        String salida = "";
        for (VideoJuego videoJuego : listaVideoJuegos) {
            salida += videoJuego.toString();
        }
        return salida;
    }

    @Override
    public void escribirSerializado() {
        FileManager.escribirArchivoSerializado(SERIAL_FILE_NAME, listaVideoJuegos);
    }

    @Override
    public void cargarSerializado() {
        listaVideoJuegos = (ArrayList<VideoJuego>) FileManager.leerArchivoSerialziado(SERIAL_FILE_NAME);
        if (listaVideoJuegos == null) {
            listaVideoJuegos = new ArrayList<>();
        }
    }

	public ArrayList<VideoJuego> getListaVideoJuegos() {
		return listaVideoJuegos;
	}

	public void setListaVideoJuegos(ArrayList<VideoJuego> listaVideoJuegos) {
		this.listaVideoJuegos = listaVideoJuegos;
	}
    
}