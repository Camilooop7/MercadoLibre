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

public class ModelFacade {

	private BanoDAO banoDAO;
	private CarritoDAO carritoDAO;
	private ClienteDAO clienteDAO;
	private CocinaDAO cocinaDAO;
	private DeporteDAO deporteDAO;
	private ElectrodomesticoDAO electrodomesticoDAO;
	private PapeleriaDAO papeleriaDAO;
	private TrabajadorDAO trabajadorDAO;
	private VideoJuegoDAO videoJuegoDAO;
	private ArrayList<Producto> listaProducto;

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
