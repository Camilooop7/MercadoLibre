package co.edu.unbosque.model;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;

import co.edu.unbosque.model.persistence.BanoDAO;
import co.edu.unbosque.model.persistence.CarritoDAO;
import co.edu.unbosque.model.persistence.ClienteDAO;
import co.edu.unbosque.model.persistence.CocinaDAO;
import co.edu.unbosque.model.persistence.DeporteDAO;
import co.edu.unbosque.model.persistence.ElectrodomesticoDAO;
import co.edu.unbosque.model.persistence.PapeleriaDAO;
import co.edu.unbosque.model.persistence.TrabajadorDAO;
import co.edu.unbosque.model.persistence.VideoJuegoDAO;

public class ModelFacade { // Clase que actúa como fachada para manejar los DAOs

	private BanoDAO banoDAO; // DAO para gestionar productos de baño
	private ClienteDAO clienteDAO; // DAO para gestionar clientes
	private CocinaDAO cocinaDAO; // DAO para gestionar productos de cocina
	private DeporteDAO deporteDAO; // DAO para gestionar productos deportivos
	private ElectrodomesticoDAO electrodomesticoDAO; // DAO para gestionar electrodomésticos
	private PapeleriaDAO papeleriaDAO; // DAO para gestionar productos de papelería
	private TrabajadorDAO trabajadorDAO; // DAO para gestionar trabajadores
	private VideoJuegoDAO videoJuegoDAO; // DAO para gestionar videojuegos
	
	private Cliente clienteActual;
	private ArrayList<Producto> productosRecomendados;
	

	public ModelFacade() { // Constructor de la clase

		banoDAO = new BanoDAO(); // Inicializa el DAO de baño
		clienteDAO = new ClienteDAO(); // Inicializa el DAO de cliente
		cocinaDAO = new CocinaDAO(); // Inicializa el DAO de cocina
		deporteDAO = new DeporteDAO(); // Inicializa el DAO de deporte
		electrodomesticoDAO = new ElectrodomesticoDAO(); // Inicializa el DAO de electrodoméstico
		papeleriaDAO = new PapeleriaDAO(); // Inicializa el DAO de papelería
		trabajadorDAO = new TrabajadorDAO(); // Inicializa el DAO de trabajador
		videoJuegoDAO = new VideoJuegoDAO(); // Inicializa el DAO de videojuegos
		productosRecomendados = new ArrayList<>(); // Inicializa la lista de producto
	}
			
	public ArrayList<Ocio> generarProductosOcio(){
		ArrayList<Ocio> pOcio = new ArrayList<>();
		pOcio.addAll(videoJuegoDAO.getListaVideoJuegos());
		pOcio.addAll(deporteDAO.getListaDeportes());
		return pOcio;
	}
	
	public ArrayList<Hogar> generarProductosHogar(){
		ArrayList<Hogar> pHogar = new ArrayList<>();
		pHogar.addAll(cocinaDAO.getListaCocinas());
		pHogar.addAll(banoDAO.getListaBanos());
		return pHogar;
	}
	
	public ArrayList<Oficina> generarProductosOficina(){
		ArrayList<Oficina> pOficina = new ArrayList<>();
		pOficina.addAll(papeleriaDAO.getListaPapeleria());
		pOficina.addAll(electrodomesticoDAO.getListaElectrodomesticos());
		return pOficina;
	}
	
	public ArrayList<Producto> anadirTodoProducto() {
		ArrayList<Producto> listaProducto = new ArrayList<>(); // Inicializa la lista de productos
		listaProducto.addAll(banoDAO.getListaBanos());
		listaProducto.addAll(cocinaDAO.getListaCocinas());
		listaProducto.addAll(deporteDAO.getListaDeportes());
		listaProducto.addAll(electrodomesticoDAO.getListaElectrodomesticos());
		listaProducto.addAll(papeleriaDAO.getListaPapeleria());
		listaProducto.addAll(videoJuegoDAO.getListaVideoJuegos());
		return listaProducto;
	}
	
	public ArrayList<Producto> tresAleatorios(ArrayList<Producto> productos) {
	    ArrayList<Producto> aleatorios = new ArrayList<>();
	    
	    if (productos.size() <= 3) {
	        this.productosRecomendados = new ArrayList<>(productos);
	        return new ArrayList<>(productos);
	    }
	    
	    ArrayList<Producto> copia = new ArrayList<>(productos);
	    Collections.shuffle(copia);
	    
	    for (int i = 0; i < 3; i++) {
	        aleatorios.add(copia.get(i));
	    }
	    
	    this.productosRecomendados = new ArrayList<>(aleatorios);
	    return aleatorios;
	}
	
	public String convertirAHtml(String texto) {
		String cadena = texto.replace("\n", "<br>");
		return "<html><p>" + cadena + "</p></html>";

	}

	public BanoDAO getBanoDAO() {
		return banoDAO;
	}

	public void setBanoDAO(BanoDAO banoDAO) {
		this.banoDAO = banoDAO;
	}
	public ClienteDAO getClienteDAO() {
		return clienteDAO;
	}

	public void setClienteDAO(ClienteDAO clienteDAO) {
		this.clienteDAO = clienteDAO;
	}

	public CocinaDAO getCocinaDAO() {
		return cocinaDAO;
	}

	public void setCocinaDAO(CocinaDAO cocinaDAO) {
		this.cocinaDAO = cocinaDAO;
	}

	public DeporteDAO getDeporteDAO() {
		return deporteDAO;
	}

	public void setDeporteDAO(DeporteDAO deporteDAO) {
		this.deporteDAO = deporteDAO;
	}

	public ElectrodomesticoDAO getElectrodomesticoDAO() {
		return electrodomesticoDAO;
	}

	public void setElectrodomesticoDAO(ElectrodomesticoDAO electrodomesticoDAO) {
		this.electrodomesticoDAO = electrodomesticoDAO;
	}

	public PapeleriaDAO getPapeleriaDAO() {
		return papeleriaDAO;
	}

	public void setPapeleriaDAO(PapeleriaDAO papeleriaDAO) {
		this.papeleriaDAO = papeleriaDAO;
	}

	public TrabajadorDAO getTrabajadorDAO() {
		return trabajadorDAO;
	}

	public void setTrabajadorDAO(TrabajadorDAO trabajadorDAO) {
		this.trabajadorDAO = trabajadorDAO;
	}

	public VideoJuegoDAO getVideoJuegoDAO() {
		return videoJuegoDAO;
	}

	public void setVideoJuegoDAO(VideoJuegoDAO videoJuegoDAO) {
		this.videoJuegoDAO = videoJuegoDAO;
	}

	public Cliente getClienteActual() {
		return clienteActual;
	}

	public void setClienteActual(Cliente clienteActual) {
		this.clienteActual = clienteActual;
	}

	public ArrayList<Producto> getProductosRecomendados() {
		return productosRecomendados;
	}

	public void setProductosRecomendados(ArrayList<Producto> productosRecomendados) {
		this.productosRecomendados = productosRecomendados;
	}
	
}
