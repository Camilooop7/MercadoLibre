package co.edu.unbosque.model;

import java.util.ArrayList;

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
	private CarritoDAO carritoDAO; // DAO para gestionar el carrito de compras
	private ClienteDAO clienteDAO; // DAO para gestionar clientes
	private CocinaDAO cocinaDAO; // DAO para gestionar productos de cocina
	private DeporteDAO deporteDAO; // DAO para gestionar productos deportivos
	private ElectrodomesticoDAO electrodomesticoDAO; // DAO para gestionar electrodomésticos
	private PapeleriaDAO papeleriaDAO; // DAO para gestionar productos de papelería
	private TrabajadorDAO trabajadorDAO; // DAO para gestionar trabajadores
	private VideoJuegoDAO videoJuegoDAO; // DAO para gestionar videojuegos
	private ArrayList<Producto> listaProducto; // Lista para almacenar productos

	public ModelFacade() { // Constructor de la clase

		banoDAO = new BanoDAO(); // Inicializa el DAO de baño
		carritoDAO = new CarritoDAO(); // Inicializa el DAO del carrito
		clienteDAO = new ClienteDAO(); // Inicializa el DAO de cliente
		cocinaDAO = new CocinaDAO(); // Inicializa el DAO de cocina
		deporteDAO = new DeporteDAO(); // Inicializa el DAO de deporte
		electrodomesticoDAO = new ElectrodomesticoDAO(); // Inicializa el DAO de electrodoméstico
		papeleriaDAO = new PapeleriaDAO(); // Inicializa el DAO de papelería
		trabajadorDAO = new TrabajadorDAO(); // Inicializa el DAO de trabajador
		videoJuegoDAO = new VideoJuegoDAO(); // Inicializa el DAO de videojuegos
		listaProducto = new ArrayList<>(); // Inicializa la lista de productos
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

	public CarritoDAO getCarritoDAO() {
		return carritoDAO;
	}

	public void setCarritoDAO(CarritoDAO carritoDAO) {
		this.carritoDAO = carritoDAO;
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

	public ArrayList<Producto> getListaProducto() {
		return listaProducto;
	}

	public void setListaProducto(ArrayList<Producto> listaProducto) {
		this.listaProducto = listaProducto;
	}

}
