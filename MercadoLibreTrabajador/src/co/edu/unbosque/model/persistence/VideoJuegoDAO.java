package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.VideoJuego;
/**
 * Clase en la cual se implementa la interfaz OperacionDAO
 */
public class VideoJuegoDAO implements OperacionDAO<VideoJuego> {
	/**
	 * Se declara una variable constante definida por el final la cual 
	 * no deja de ser modificada una vez inicializada y se le indica el 
	 * tipo de archivo .dat
	 * 
	 */
    private final String SERIAL_FILE_NAME = "videojuego.dat";
    private final String TEXT_FILE_NAME = "videojuego.csv";
    /**
	 * Variable la cual contiene un arraylist y además se define el nombre.
	 */
    private ArrayList<VideoJuego> listaVideoJuegos;
    /*
	 * Constructor en cual cual se llama al metodo de cargarSerializado y
	 * se inicializa la Arraylist.
	 */
    
    public VideoJuegoDAO() {
		// TODO Auto-generated constructor stub
		listaVideoJuegos = new ArrayList<>();
		cargarSerializado();
	}
    /**
	 *Metodo crear el cual recibe como parametro nuevoDato y se recurre a la lista agregando el nuevoDato
	 *además de eso se llama al metodo de escribirSerializado. 
	 */

    
    @Override
    public void crear(VideoJuego nuevoDato) {
        listaVideoJuegos.add(nuevoDato);
        escribirSerializado();
        escribirArchivo();
    }
    /**
	 *Metodo eliminar el cual recibe como parametro un dato tipo entero en el cual se incluye
	 *un condicional tipo if, verifica y recorre los limites de las lista eliminando 
	 *el objeto en la posicion indicada, si no devuelve el numero indicado si no se cumple el ciclo.
	 *Se llama al metodo de escribirSerializado. 
	 */

    @Override
    public int eliminar(int index) {
        if (index >= 0 && index < listaVideoJuegos.size()) {
            listaVideoJuegos.remove(index);
            escribirSerializado();
            escribirArchivo();
            return 0;
        } else {
            return 1;
        }
    }
 
    /**
	 *Metodo actualizar el cual recibe como parametro un dato tipo entero y nuevoDato en el cual se incluye
	 *un condicional tipo if, verifica y recorre los limites de las lista actualizando 
	 *el objeto en la posicion indicada con el .set recibiendo los parametros definidos, si no devuelve 
	 *el numero indicado si no se cumple el ciclo.
	 *Se llama al metodo de escribirSerializado. 
	 */

    @Override
    public int actulizar(int index, VideoJuego nuevoDato) {
        if (index >= 0 && index < listaVideoJuegos.size()) {
            listaVideoJuegos.set(index, nuevoDato);
            escribirSerializado();
            escribirArchivo();
            return 0;
        } else {
            return 1;
        }
    }
    public boolean encontrar(int index) {
 		// TODO Auto-generated method stub
 		return index >= 0 && index < listaVideoJuegos.size();
 	}

	/**
	 *Metodo mosrtarTodo el cual no recibe parametros 
	 *Se crea una variable tipo String y se recorre la lista con el uso del for 
	 * y se realiza la concatenación de salida con el .toString, por ultimo se retorna la variable 
	 * salida con su respectivo to string.
	 */

    @Override
    public String mostrarTodo() {
        String salida = "";
        int a = 1;
        for (VideoJuego videoJuego : listaVideoJuegos) {
            salida +=a + ". "+ videoJuego.toString() + "\n";
            a++;
        }
        return salida;
    }
    /**
	 * Metodo el cual tiene como objetivo guardar la lista definida dentro del archivo como .dat
	 */

    @Override
    public void escribirSerializado() {
        FileManager.escribirArchivoSerializado(SERIAL_FILE_NAME, listaVideoJuegos);
    }

	

    /**
	 * Este metodo carga el archivo la lista en el archivoSerializado
	 * donde se lee la lista con el leerArchivoSerializado en este caso SERIAL_FILE_NAME.
	 * Se utiliza un condiconal tipo if en donde si la lista se encuentra vacia se inicializa 
	 * un nuevo array para la lista.
	 */
    @Override
    public void cargarSerializado() {
        listaVideoJuegos = (ArrayList<VideoJuego>) FileManager.leerArchivoSerialziado(SERIAL_FILE_NAME);
        if (listaVideoJuegos == null) {
            listaVideoJuegos = new ArrayList<>();
        }
    }
    public void escribirArchivo() {
		String contenido ="";
		for (int i = 0; i < listaVideoJuegos.size(); i++) {
			contenido += listaVideoJuegos.get(i).getNombre()+";";
			contenido += listaVideoJuegos.get(i).getPrecio()+";";
			contenido += listaVideoJuegos.get(i).getId()+";";
			contenido += listaVideoJuegos.get(i).getFecha()+";";
			contenido += listaVideoJuegos.get(i).getImagen()+";";
			contenido += listaVideoJuegos.get(i).isEsAccesorio()+";";
			contenido += listaVideoJuegos.get(i).getReferenciaConsola()+"\n";
		}
		FileManager.escribirArchivoTexto(TEXT_FILE_NAME, contenido);
	}

	public ArrayList<VideoJuego> getListaVideoJuegos() {
		return listaVideoJuegos;
	}

	public void setListaVideoJuegos(ArrayList<VideoJuego> listaVideoJuegos) {
		this.listaVideoJuegos = listaVideoJuegos;
	}
    
}