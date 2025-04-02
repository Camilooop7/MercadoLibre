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
/**
 * Clase que actúa como fachada para manejar los DAOs y la lógica del modelo.
 */
public class ModelFacade { 
	/**
	 * DAO para gestionar productos de baño.
	 */
	private BanoDAO banoDAO; 
	/**
	 * DAO para gestionar el carrito de compras
	 */
	private CarritoDAO carritoDAO; 
	/**
	 * DAO para gestionar clientes.
	 */
	private ClienteDAO clienteDAO; 
	/**
	 * DAO para gestionar productos de cocina.
	 */
	private CocinaDAO cocinaDAO; 
	/**
	 * DAO para gestionar productos deportivos.
	 */
	private DeporteDAO deporteDAO; 
	/**
	 * DAO para gestionar electrodomésticos.
	 */
	private ElectrodomesticoDAO electrodomesticoDAO; // DAO para gestionar electrodomésticos
	/**
	 * DAO para gestionar productos de papelería.
	 */
	private PapeleriaDAO papeleriaDAO; 
	/**
	 * DAO para gestionar trabajadores.
	 */
	private TrabajadorDAO trabajadorDAO; 
	/**
	 * DAO para gestionar videojuegos.
	 */
	private VideoJuegoDAO videoJuegoDAO; 
	/**
	 * Lista para almacenar productos
	 */
	private ArrayList<Producto> listaProducto; 
	/**
	 * Constructor de la clase. Inicializa los DAOs y las listas.
	 */
	public ModelFacade() {

		banoDAO = new BanoDAO(); 
		carritoDAO = new CarritoDAO(); 
		clienteDAO = new ClienteDAO();
		cocinaDAO = new CocinaDAO(); 
		deporteDAO = new DeporteDAO(); 
		electrodomesticoDAO = new ElectrodomesticoDAO(); 
		papeleriaDAO = new PapeleriaDAO(); 
		trabajadorDAO = new TrabajadorDAO();
		videoJuegoDAO = new VideoJuegoDAO();
		listaProducto = new ArrayList<>();
	}
	/**
	 * Convierte un texto en formato HTML.
	 * 
	 * @param texto Texto a convertir.
	 * @return Texto en formato HTML.
	 */
	public String convertirAHtml(String texto) {
		String cadena = texto.replace("\n", "<br>");
		return "<html><p>" + cadena + "</p></html>";

	}
	/**
	 * Obtiene el DAO de productos de baño.
	 * 
	 * @return DAO de productos de baño.
	 */

	public BanoDAO getBanoDAO() {
		return banoDAO;
	}
	/**
	 * Establece el DAO de productos de baño.
	 * 
	 * @param banoDAO DAO de productos de baño.
	 */

	public void setBanoDAO(BanoDAO banoDAO) {
		this.banoDAO = banoDAO;
	}
	
	/**
	 * Obtiene el DAO de carrito.
	 * 
	 * @return DAO de carrito.
	 */

	public CarritoDAO getCarritoDAO() {
		return carritoDAO;
	}

	public void setCarritoDAO(CarritoDAO carritoDAO) {
		this.carritoDAO = carritoDAO;
	}

	/**
	 * Obtiene el DAO de carrito.
	 * 
	 * @return DAO de carrito.
	 */
	public ClienteDAO getClienteDAO() {
		return clienteDAO;
	}

	/**
	 * Establece el DAO de clientes.
	 * 
	 * @param clienteDAO DAO de clientes.
	 */
	public void setClienteDAO(ClienteDAO clienteDAO) {
		this.clienteDAO = clienteDAO;
	}
	/**
	 * Obtiene el DAO de productos de cocina.
	 * 
	 * @return DAO de productos de cocina.
	 */

	public CocinaDAO getCocinaDAO() {
		return cocinaDAO;
	}
	/**
	 * Establece el DAO de productos de cocina.
	 * 
	 * @param cocinaDAO DAO de productos de cocina.
	 */

	public void setCocinaDAO(CocinaDAO cocinaDAO) {
		this.cocinaDAO = cocinaDAO;
	}
	/**
	 * Obtiene el DAO de productos deportivos.
	 * 
	 * @return DAO de productos deportivos.
	 */

	public DeporteDAO getDeporteDAO() {
		return deporteDAO;
	}
	/**
	 * Establece el DAO de productos deportivos.
	 * 
	 * @param deporteDAO DAO de productos deportivos.
	 */

	public void setDeporteDAO(DeporteDAO deporteDAO) {
		this.deporteDAO = deporteDAO;
	}
	/**
	 * Obtiene el DAO de electrodomésticos.
	 * 
	 * @return DAO de electrodomésticos.
	 */

	public ElectrodomesticoDAO getElectrodomesticoDAO() {
		return electrodomesticoDAO;
	}
	/**
	 * Establece el DAO de electrodomésticos.
	 * 
	 * @param electrodomesticoDAO DAO de electrodomésticos.
	 */

	public void setElectrodomesticoDAO(ElectrodomesticoDAO electrodomesticoDAO) {
		this.electrodomesticoDAO = electrodomesticoDAO;
	}
	/**
	 * Obtiene el DAO de productos de papelería.
	 * 
	 * @return DAO de productos de papelería.
	 */

	public PapeleriaDAO getPapeleriaDAO() {
		return papeleriaDAO;
	}
	/**
	 * Establece el DAO de productos de papelería.
	 * 
	 * @param papeleriaDAO DAO de productos de papelería.
	 */

	public void setPapeleriaDAO(PapeleriaDAO papeleriaDAO) {
		this.papeleriaDAO = papeleriaDAO;
	}
	/**
	 * Obtiene el DAO de trabajadores.
	 * 
	 * @return DAO de trabajadores.
	 */
	public TrabajadorDAO getTrabajadorDAO() {
		return trabajadorDAO;
	}
	/**
	 * Establece el DAO de trabajadores.
	 * 
	 * @param trabajadorDAO DAO de trabajadores.
	 */

	public void setTrabajadorDAO(TrabajadorDAO trabajadorDAO) {
		this.trabajadorDAO = trabajadorDAO;
	}
	/**
	 * Obtiene el DAO de videojuegos.
	 * 
	 * @return DAO de videojuegos.
	 */

	public VideoJuegoDAO getVideoJuegoDAO() {
		return videoJuegoDAO;
	}
	/**
	 * Establece el DAO de videojuegos.
	 * 
	 * @param videoJuegoDAO DAO de videojuegos.
	 */

	public void setVideoJuegoDAO(VideoJuegoDAO videoJuegoDAO) {
		this.videoJuegoDAO = videoJuegoDAO;
	}

	/**
	 * Obtiene la lista de productos .
	 * 
	 * @return Lista de productos .
	 */
	public ArrayList<Producto> getListaProducto() {
		return listaProducto;
	}
	/**
	 * Establece la lista de productos.
	 * 
	 * @param productos Lista de productos .
	 */
	public void setListaProducto(ArrayList<Producto> listaProducto) {
		this.listaProducto = listaProducto;
	}

}
