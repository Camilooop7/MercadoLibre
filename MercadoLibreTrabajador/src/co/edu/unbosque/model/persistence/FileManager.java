package co.edu.unbosque.model.persistence;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class FileManager {
//funcion especial de leer y guaradr archivos

	// estos 3 son para acrhivos de texto
	private static Scanner lectorArchivo;
	private static File archivo;
	private static PrintWriter escritorArchivo;
	private static final String RUTA_CARPETA = "src/archivos";
	// atributos para archivos serealizado
	private static FileOutputStream fos; // sirve para ubcar el archivo
	private static ObjectOutputStream oos;// para escribir obejtos en el arvhivo
	private static FileInputStream fis;
	private static ObjectInputStream ois;

	public static void crarCarpeta() {
		archivo = new File(RUTA_CARPETA);
		if (!archivo.exists() || !archivo.isDirectory()) {
			archivo.mkdir();// cree la carpeta
		}

	}

	public static void escribirArchivoTexto(String nombreArchivo, String contenido) {
		try {
			archivo = new File(RUTA_CARPETA + "/" + nombreArchivo);
			if (!archivo.exists()) {
				archivo.createNewFile();
			}
			escritorArchivo = new PrintWriter(archivo);
			escritorArchivo.println(contenido);
			escritorArchivo.close();
			// cuando se habre un archivo despues de abrirlo ahi que cerrarlo
		} catch (IOException e) {
			// Si llegue hasta aqui es por que el aechivo no tiene permisos, la URL esta mal
			// o el acrchivo no existe
			System.out.println("Error al escribir el archivo de texto.(creacion del archivo).");
			e.printStackTrace();
		}
	}

	public static String leerArchivoTexto(String nombreArchivo) {
		try {
			archivo = new File(RUTA_CARPETA + "/" + nombreArchivo);
			if (!archivo.exists()) {
				archivo.createNewFile();
			}
			lectorArchivo = new Scanner(archivo);
			String contenido = "";
			while (lectorArchivo.hasNext()) {
				contenido += lectorArchivo.nextLine() + "\n";
			}
			lectorArchivo.close();
			return contenido;
		} catch (IOException e) {
			System.out.println("Error al leer el archivo de texto.(creacion del archivo).");
			e.printStackTrace();
		}
		return null;
	}

	// Serializado

	public static void escribirArchivoSerializado(String nombreArchivo, Object contenido) {
		try {
			archivo = new File(RUTA_CARPETA + "/" + nombreArchivo);
			if (!archivo.exists()) {
				archivo.createNewFile();
			}
			fos = new FileOutputStream(archivo);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(contenido);
			oos.close();
			fos.close();
		} catch (IOException e) {
			System.out.println("Problemas al abrir el archivo serealizado (escritura)");
			e.printStackTrace();
		}

	}

	public static Object leerArchivoSerialziado(String nombreArchivo) {

		Object contenido = null;
		try {
			archivo = new File(RUTA_CARPETA + "/" + nombreArchivo);
			if (!archivo.exists()) {
				archivo.createNewFile();
			}
			fis = new FileInputStream(archivo);
			ois = new ObjectInputStream(fis);
			contenido = ois.readObject();
			ois.close();
			fis.close();
		} catch (IOException e) {
			System.out.println("Error al leer el archivo serializado.");
			e.printStackTrace();

		} catch (ClassNotFoundException e) {
			System.out.println("Error en los datos del archivo serializado.");
			e.printStackTrace();
		}
		return contenido;
	}
}
