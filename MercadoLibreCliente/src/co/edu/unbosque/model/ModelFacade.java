package co.edu.unbosque.model;

import java.util.ArrayList;
import java.util.Collections;

import co.edu.unbosque.model.persistence.*;

/**
 * Clase que actúa como fachada para manejar los DAOs y la lógica del modelo.
 */
public class ModelFacade {

	/**
	 * DAO para gestionar productos de baño.
	 */
	private BanoDAO banoDAO;

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
	private ElectrodomesticoDAO electrodomesticoDAO;

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
	 * Cliente actualmente en sesión.
	 */
	private Cliente clienteActual;

	/**
	 * Lista de productos recomendados.
	 */
	private ArrayList<Producto> productosRecomendados;

	/**
	 * Constructor de la clase. Inicializa los DAOs y las listas.
	 */
	public ModelFacade() {
		banoDAO = new BanoDAO();
		clienteDAO = new ClienteDAO();
		cocinaDAO = new CocinaDAO();
		deporteDAO = new DeporteDAO();
		electrodomesticoDAO = new ElectrodomesticoDAO();
		papeleriaDAO = new PapeleriaDAO();
		trabajadorDAO = new TrabajadorDAO();
		videoJuegoDAO = new VideoJuegoDAO();
		productosRecomendados = new ArrayList<>();
	}

	/**
	 * Genera una lista de productos de ocio combinando videojuegos y deportes.
	 * 
	 * @return Lista de productos de ocio.
	 */
	public ArrayList<Ocio> generarProductosOcio() {
		ArrayList<Ocio> pOcio = new ArrayList<>();
		pOcio.addAll(videoJuegoDAO.getListaVideoJuegos());
		pOcio.addAll(deporteDAO.getListaDeportes());
		return pOcio;
	}

	/**
	 * Genera una lista de productos del hogar combinando cocina y baño.
	 * 
	 * @return Lista de productos del hogar.
	 */
	public ArrayList<Hogar> generarProductosHogar() {
		ArrayList<Hogar> pHogar = new ArrayList<>();
		pHogar.addAll(cocinaDAO.getListaCocinas());
		pHogar.addAll(banoDAO.getListaBanos());
		return pHogar;
	}

	/**
	 * Genera una lista de productos de oficina combinando papelería y electrodomésticos.
	 * 
	 * @return Lista de productos de oficina.
	 */
	public ArrayList<Oficina> generarProductosOficina() {
		ArrayList<Oficina> pOficina = new ArrayList<>();
		pOficina.addAll(papeleriaDAO.getListaPapeleria());
		pOficina.addAll(electrodomesticoDAO.getListaElectrodomesticos());
		return pOficina;
	}

	/**
	 * Combina todos los productos en una sola lista.
	 * 
	 * @return Lista de todos los productos.
	 */
	public ArrayList<Producto> anadirTodoProducto() {
		ArrayList<Producto> listaProducto = new ArrayList<>();
		listaProducto.addAll(banoDAO.getListaBanos());
		listaProducto.addAll(cocinaDAO.getListaCocinas());
		listaProducto.addAll(deporteDAO.getListaDeportes());
		listaProducto.addAll(electrodomesticoDAO.getListaElectrodomesticos());
		listaProducto.addAll(papeleriaDAO.getListaPapeleria());
		listaProducto.addAll(videoJuegoDAO.getListaVideoJuegos());
		return listaProducto;
	}

	/**
	 * Selecciona tres productos aleatorios de una lista dada.
	 * 
	 * @param productos Lista de productos de la cual seleccionar.
	 * @return Lista con tres productos aleatorios.
	 */
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
	 * Obtiene el DAO de clientes.
	 * 
	 * @return DAO de clientes.
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
	 * Obtiene el cliente actualmente en sesión.
	 * 
	 * @return Cliente actualmente en sesión.
	 */
	public Cliente getClienteActual() {
		return clienteActual;
	}

	/**
	 * Establece el cliente actualmente en sesión.
	 * 
	 * @param clienteActual Cliente actualmente en sesión.
	 */
	public void setClienteActual(Cliente clienteActual) {
		this.clienteActual = clienteActual;
	}

	/**
	 * Obtiene la lista de productos recomendados.
	 * 
	 * @return Lista de productos recomendados.
	 */
	public ArrayList<Producto> getProductosRecomendados() {
		return productosRecomendados;
	}

	/**
	 * Establece la lista de productos recomendados.
	 * 
	 * @param productosRecomendados Lista de productos recomendados.
	 */
	public void setProductosRecomendados(ArrayList<Producto> productosRecomendados) {
		this.productosRecomendados = productosRecomendados;
	}
}
