package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;

import co.edu.unbosque.model.Carrito;
import co.edu.unbosque.model.Cliente;
import co.edu.unbosque.model.ModelFacade;
import co.edu.unbosque.model.Producto;
import co.edu.unbosque.model.Trabajador;
import co.edu.unbosque.model.persistence.FileManager;
import co.edu.unbosque.util.exception.CapitalException;
import co.edu.unbosque.util.exception.CharacterException;
import co.edu.unbosque.util.exception.EqualPasswordException;
import co.edu.unbosque.util.exception.NumberException;
import co.edu.unbosque.util.exception.UsernameException;
import co.edu.unbosque.util.exception.SimbolException;
import co.edu.unbosque.util.exception.SmallException;
import co.edu.unbosque.util.exception.SymbolException;
import co.edu.unbosque.view.ViewFacade;

public class Controller implements ActionListener {
	private ModelFacade mf;
	private ViewFacade vf;

	public Controller() throws IOException {
		FileManager.crearCarpeta();
		mf = new ModelFacade();
		vf = new ViewFacade();
		asignarLectores();
	}

	public void run() {
		vf.getVpc().setVisible(true);

	}

	public void asignarLectores() {

		vf.getVpc().getPpc().getBtnIniciarS().addActionListener(this);
		vf.getVpc().getPpc().getBtnIniciarS().setActionCommand("btnIniciarS");
		vf.getVpc().getPpc().getBtnCrearU().addActionListener(this);
		vf.getVpc().getPpc().getBtnCrearU().setActionCommand("btnCrearU");
		vf.getVpc().getPpc().getBtnSalir().addActionListener(this);
		vf.getVpc().getPpc().getBtnSalir().setActionCommand("btnSalir");
		
		vf.getVpc().getPis().getBtnIngresar().addActionListener(this);
		vf.getVpc().getPis().getBtnIngresar().setActionCommand("btnIngresarI");
		vf.getVpc().getPis().getMostrarContrasena().addActionListener(this);
		vf.getVpc().getPis().getMostrarContrasena().setActionCommand("checkMostrarIni");
		vf.getVpc().getPis().getBtnVolver().addActionListener(this);
		vf.getVpc().getPis().getBtnVolver().setActionCommand("btnVolverI");
		
		vf.getVpc().getPcu().getBtnIngresar().addActionListener(this);
		vf.getVpc().getPcu().getBtnIngresar().setActionCommand("btnIngresarC");
		vf.getVpc().getPcu().getBtnVolver().addActionListener(this);
		vf.getVpc().getPcu().getBtnVolver().setActionCommand("btnVolverC");
		
		vf.getVpc().getPcu().getMostrarContrasena().addActionListener(this);
		vf.getVpc().getPcu().getMostrarContrasena().setActionCommand("checkMostrar");
		vf.getVpc().getPcu().getMostrarContrasena2().addActionListener(this);
		vf.getVpc().getPcu().getMostrarContrasena2().setActionCommand("checkMostrar2");
		
		vf.getVpc().getPcm().getBtnCarrito().addActionListener(this);
		vf.getVpc().getPcm().getBtnCarrito().setActionCommand("btnCarrito");
		vf.getVpc().getPc().getBtnVolver().addActionListener(this);
		vf.getVpc().getPc().getBtnVolver().setActionCommand("btnCarritoVolver");
		
		vf.getVpc().getPcm().getBtnHistorial().addActionListener(this);
		vf.getVpc().getPcm().getBtnHistorial().setActionCommand("btnHistorial");
		
		vf.getVpc().getPcm().getBtnTienda().addActionListener(this);
		vf.getVpc().getPcm().getBtnTienda().setActionCommand("btnTienda");
		
		vf.getVpc().getPcm().getBtnVolver().addActionListener(this);
		vf.getVpc().getPcm().getBtnVolver().setActionCommand("btnVolverCL");
		
		vf.getVpc().getPt().getBtnOcio().addActionListener(this);
		vf.getVpc().getPt().getBtnOcio().setActionCommand("btnOcio");
		vf.getVpc().getPt().getBtnOficina().addActionListener(this);
		vf.getVpc().getPt().getBtnOficina().setActionCommand("btnOficina");
		vf.getVpc().getPt().getBtnHogar().addActionListener(this);
		vf.getVpc().getPt().getBtnHogar().setActionCommand("btnHogar");
		vf.getVpc().getPt().getBtnVolver().addActionListener(this);
		vf.getVpc().getPt().getBtnVolver().setActionCommand("btnTiendaVolver");
		
		vf.getVpc().getPcm().getBtnFavoritos().addActionListener(this);
		vf.getVpc().getPcm().getBtnFavoritos().setActionCommand("btnFavorito");
		vf.getVpc().getPf().getBtnVolver().addActionListener(this);
		vf.getVpc().getPf().getBtnVolver().setActionCommand("btnVolverF");
		
	}

	public void actionPerformed(ActionEvent e) {

		switch (e.getActionCommand()) {

		case "btnIniciarS": {
			vf.getVpc().getPpc().setVisible(false);
			vf.getVpc().getPis().setVisible(true);

			break;
		}
		case "btnCrearU": {
			vf.getVpc().getPpc().setVisible(false);
			vf.getVpc().getPcu().setVisible(true);

			break;
		}
		case "btnSalir": {
			vf.getVpc().setVisible(false);

			break;
		}
		case "btnIngresarI": {

			String usuario = vf.getVpc().getPis().getNombreUsuario().getText();
			String contrasena = vf.getVpc().getPis().getContrasena();
			if (mf.getClienteDAO().encontrarUsuario(usuario, contrasena) != null) {

				vf.getVpc().getPis().setVisible(false);
				vf.getVpc().getPcm().setVisible(true);
				mf.setClienteActual(mf.getClienteDAO().encontrarUsuario(usuario, contrasena));

			} else {
				vf.getVemer().mostrar("Problema en el usuario o contraseña.");
			}

			break;
		}
		case "checkMostrar": {
			if (vf.getVpc().getPcu().getMostrarContrasena().isSelected()) {
				vf.getVpc().getPcu().getContrasena1F().setEchoChar((char) 0);
			} else {
				vf.getVpc().getPcu().getContrasena1F().setEchoChar('*');
			}

			break;
		}
		case "checkMostrar2": {
			if (vf.getVpc().getPcu().getMostrarContrasena2().isSelected()) {
				vf.getVpc().getPcu().getContrasena2F().setEchoChar((char) 0);
			} else {
				vf.getVpc().getPcu().getContrasena2F().setEchoChar('*');
			}

			break;
		}

		case "btnVolverI": {
			vf.getVpc().getPis().setVisible(false);
			vf.getVpc().getPpc().setVisible(true);
			break;
		}
		case "btnIngresarC": {
			String usuario = (String) vf.getVpc().getPcu().getNombreUsuario();
			String contrasena1 = (String) vf.getVpc().getPcu().getContrasena1();
			String contrasena2 = (String) vf.getVpc().getPcu().getContrasena2();

			try {
				ExceptionCheker.checkerCharacter(usuario);
				ExceptionCheker.checkerEqualPassword(contrasena1, contrasena2);
				ExceptionCheker.checkerPasword(contrasena1);

				for (Cliente c : mf.getClienteDAO().getListaClientes()) {
					if (c.getNombre().equals(usuario)) {
						throw new UsernameException();
					}
				}

				mf.getClienteDAO().crear(new Cliente(usuario, contrasena1));
				vf.getVemer().mostrar("Usuario creado con exito, Regrese al menu para iniciar sesión.");

			} catch (CharacterException e1) {
				vf.getVemer().mostrar("No cumple los requisitos de caracteres.");
			} catch (EqualPasswordException e1) {
				vf.getVemer().mostrar("Las contraseñas no son iguales.");
			} catch (CapitalException e1) {
				vf.getVemer().mostrar("Debe contener al menos una mayuscula.");
			} catch (SmallException e1) {
				vf.getVemer().mostrar("Debe contener al menos una minuscula.");
			} catch (NumberException e1) {
				vf.getVemer().mostrar("Debe contener al menos un número.");
			} catch (SymbolException e1) {
				vf.getVemer().mostrar("Debe contener al menos un simbolo.");
			} catch (UsernameException e1) {
				vf.getVemer().mostrar("Ya existe otro usuario con ese nombre.");
			}

			break;
		}
		case "checkMostrarIni": {
			if (vf.getVpc().getPis().getMostrarContrasena().isSelected()) {
				vf.getVpc().getPis().getContrasenaF().setEchoChar((char) 0);
			} else {
				vf.getVpc().getPis().getContrasenaF().setEchoChar('*');
			}

			break; 
		}
		case "btnVolverC": {
			vf.getVpc().getPcu().setVisible(false);
			vf.getVpc().getPpc().setVisible(true);
			break;
		}
		case "btnVolverCL": {
			vf.getVpc().getPcm().setVisible(false);
			vf.getVpc().getPpc().setVisible(true);
			break;
		}
		case "btnTienda":{
			vf.getVpc().getPcm().setVisible(false);
			vf.getVpc().getPt().setVisible(true);
			break;
		}
		case "btnOcio":{
			vf.getVpc().getPt().getPanelOcio().setVisible(true);
			vf.getVpc().getPt().getPanelOficina().setVisible(false);
			vf.getVpc().getPt().getPanelHogar().setVisible(false);
			vf.getVpc().getPt().getPanelOcio().actualizarInfo(mf.generarProductosOcio());
			asignarFuncionesComponentesProducto("Ocio");
			break;
		}
		case "btnOficina":{
			vf.getVpc().getPt().getPanelOcio().setVisible(false);
			vf.getVpc().getPt().getPanelOficina().setVisible(true);
			vf.getVpc().getPt().getPanelHogar().setVisible(false);
			vf.getVpc().getPt().getPanelOficina().actualizarInfo(mf.generarProductosOficina());
			asignarFuncionesComponentesProducto("Oficina");
			break;
		}
		case "btnHogar":{
			vf.getVpc().getPt().getPanelHogar().actualizarInfo(mf.generarProductosHogar());
			vf.getVpc().getPt().getPanelHogar().setVisible(true);
			vf.getVpc().getPt().getPanelOcio().setVisible(false);
			vf.getVpc().getPt().getPanelOficina().setVisible(false);
			asignarFuncionesComponentesProducto("Hogar");
			break;
		}
		case "btnTiendaVolver":{
			vf.getVpc().getPcm().setVisible(true);
			vf.getVpc().getPt().setVisible(false);
			break;
		}
		case "btnFavorito":{
			vf.getVpc().getPf().actualizarInfo(mf.getClienteActual().getListaProductoFavorito());
			vf.getVpc().getPcm().setVisible(false);
			vf.getVpc().getPf().setVisible(true);
			asignarFuncionesComponentesProducto("Favoritos");
			break;
		}
		case "btnVolverF":{
			vf.getVpc().getPcm().setVisible(true);
			vf.getVpc().getPf().setVisible(false);
			break;
		} 
		case"btnCarrito":{
			vf.getVpc().getPc().actualizarInfo(mf.getClienteActual().getCarrito().getListaCarrito());
			vf.getVpc().getPcm().setVisible(false);
			vf.getVpc().getPc().setVisible(true);
			asignarFuncionesComponentesProducto("Carrito");
			break;
		}
		case"btnCarritoVolver":{
			vf.getVpc().getPcm().setVisible(true);
			vf.getVpc().getPc().setVisible(false);
			break;
		}
		}
	}
	
	public void asignarFuncionesComponentesProducto(String producto) {
		switch (producto) {
		case "Ocio": {
			for (JButton btn : vf.getVpc().getPt().getPanelOcio().getBotonesAnadir()) {
				btn.setActionCommand(String.valueOf(vf.getVpc().getPt().getPanelOcio().getBotonesAnadir().indexOf(btn)));
				btn.addActionListener(e -> {
					int indice = Integer.parseInt(e.getActionCommand());

					if(mf.getClienteActual().getCarrito() == null) {
						mf.getClienteActual().setCarrito(new Carrito());
						mf.getClienteActual().getCarrito().getListaCarrito().add(mf.generarProductosOcio().get(indice));
						mf.getClienteDAO().escribirSerializado();
					}else {
						mf.getClienteActual().getCarrito().getListaCarrito().add(mf.generarProductosOcio().get(indice));
						mf.getClienteDAO().escribirSerializado();
					}
					actualizarInfo("Ocio");
					asignarFuncionesComponentesProducto("Ocio");
				});
			}
			
			for (JButton btn : vf.getVpc().getPt().getPanelOcio().getBotonesFav()) {
				btn.setActionCommand(String.valueOf (vf.getVpc().getPt().getPanelOcio().getBotonesFav().indexOf(btn)));
				btn.addActionListener(e -> {
					int indice = Integer.parseInt(e.getActionCommand());
					mf.getClienteActual().getListaProductoFavorito().add(mf.generarProductosOcio().get(indice));
					mf.getClienteDAO().escribirSerializado();
					actualizarInfo("Ocio");
					asignarFuncionesComponentesProducto("Ocio");
				});
			}
			break;
		}
		
		case "Hogar": {
			for (JButton btn : vf.getVpc().getPt().getPanelHogar().getBotonesAnadir()) {
				btn.setActionCommand(String.valueOf(vf.getVpc().getPt().getPanelHogar().getBotonesAnadir().indexOf(btn)));
				btn.addActionListener(e -> {
					int indice = Integer.parseInt(e.getActionCommand());

					if(mf.getClienteActual().getCarrito() == null) {
						mf.getClienteActual().setCarrito(new Carrito());
						mf.getClienteActual().getCarrito().getListaCarrito().add(mf.generarProductosHogar().get(indice));
						mf.getClienteDAO().escribirSerializado();
					}else {
						mf.getClienteActual().getCarrito().getListaCarrito().add(mf.generarProductosHogar().get(indice));
						mf.getClienteDAO().escribirSerializado();
					}
					actualizarInfo("Hogar");
					asignarFuncionesComponentesProducto("Hogar");
				});
			}
			
			for (JButton btn : vf.getVpc().getPt().getPanelHogar().getBotonesFav()) {
				btn.setActionCommand(String.valueOf (vf.getVpc().getPt().getPanelHogar().getBotonesFav().indexOf(btn)));
				btn.addActionListener(e -> {
					int indice = Integer.parseInt(e.getActionCommand());
					mf.getClienteActual().getListaProductoFavorito().add(mf.generarProductosHogar().get(indice));
					actualizarInfo("Hogar");
					asignarFuncionesComponentesProducto("Hogar");
					mf.getClienteDAO().escribirSerializado();
				});
			}
			break;
		}
		
		case "Oficina": {
			for (JButton btn : vf.getVpc().getPt().getPanelOficina().getBotonesAnadir()) {
				btn.setActionCommand(String.valueOf(vf.getVpc().getPt().getPanelOficina().getBotonesAnadir().indexOf(btn)));
				btn.addActionListener(e -> {
					int indice = Integer.parseInt(e.getActionCommand());

					if(mf.getClienteActual().getCarrito() == null) {
						mf.getClienteActual().setCarrito(new Carrito());
						mf.getClienteActual().getCarrito().getListaCarrito().add(mf.generarProductosOficina().get(indice));
						mf.getClienteDAO().escribirSerializado();
					}else {
						mf.getClienteActual().getCarrito().getListaCarrito().add(mf.generarProductosOficina().get(indice));
						mf.getClienteDAO().escribirSerializado();
					}
					actualizarInfo("Oficina");
					asignarFuncionesComponentesProducto("Oficina");
				});
			}
			
			for (JButton btn : vf.getVpc().getPt().getPanelOficina().getBotonesFav()) {
				btn.setActionCommand(String.valueOf (vf.getVpc().getPt().getPanelOficina().getBotonesFav().indexOf(btn)));
				btn.addActionListener(e -> {
					int indice = Integer.parseInt(e.getActionCommand());
					mf.getClienteActual().getListaProductoFavorito().add(mf.generarProductosOficina().get(indice));
					mf.getClienteDAO().escribirSerializado();
					actualizarInfo("Oficina");
					asignarFuncionesComponentesProducto("Oficina");
				});
			}
			break;
		}
		case "Favoritos": {
			for (JButton btn : vf.getVpc().getPf().getBotonesAnadir()) {
				btn.setActionCommand(String.valueOf(vf.getVpc().getPf().getBotonesAnadir().indexOf(btn)));
				btn.addActionListener(e -> {
					int indice = Integer.parseInt(e.getActionCommand());
					System.out.println(indice);
					if(mf.getClienteActual().getCarrito() == null) {
						mf.getClienteActual().setCarrito(new Carrito());
						mf.getClienteActual().getCarrito().getListaCarrito().add(mf.getClienteActual().getListaProductoFavorito().get(indice));
						mf.getClienteDAO().escribirSerializado();
					}else {
						mf.getClienteActual().getCarrito().getListaCarrito().add(mf.getClienteActual().getListaProductoFavorito().get(indice));
						mf.getClienteDAO().escribirSerializado();
					}
					actualizarInfo("Favoritos");
					asignarFuncionesComponentesProducto("Favoritos");
				});
			}
			
			for (JButton btn : vf.getVpc().getPf().getBotonesFav()) {
				btn.setActionCommand(String.valueOf (vf.getVpc().getPf().getBotonesFav().indexOf(btn)));
				btn.addActionListener(e -> {
					int indice = Integer.parseInt(e.getActionCommand());
					System.out.println(indice);
					mf.getClienteActual().getListaProductoFavorito().remove(indice);
					mf.getClienteDAO().escribirSerializado();
					actualizarInfo("Favoritos");
					asignarFuncionesComponentesProducto("Favoritos");
				});
			}
			break;
		}
		case "Carrito": {
			for (JButton btn : vf.getVpc().getPc().getBotonesAnadir()) {
				btn.setActionCommand(String.valueOf(vf.getVpc().getPc().getBotonesAnadir().indexOf(btn)));
				btn.addActionListener(e -> {
					int indice = Integer.parseInt(e.getActionCommand());
					System.out.println(indice);
					mf.getClienteActual().getCarrito().getListaCarrito().add(mf.getClienteActual().getListaProductoFavorito().remove(indice));
					mf.getClienteDAO().escribirSerializado();
					actualizarInfo("Carrito");
					asignarFuncionesComponentesProducto("Carrito");
				});
			}
		}
		default:
			break;
		}
	}
	
	public void actualizarInfo(String producto) {
		switch (producto) {
		case "Ocio": {
			vf.getVpc().getPt().getPanelOcio().actualizarInfo(mf.generarProductosOcio());
			break;
		}
		case "Hogar": {
			vf.getVpc().getPt().getPanelHogar().actualizarInfo(mf.generarProductosHogar());
			break;
		}
		case "Oficina": {
			vf.getVpc().getPt().getPanelOficina().actualizarInfo(mf.generarProductosOficina());
			break;
		}
		case "Favoritos": {
			vf.getVpc().getPf().actualizarInfo(mf.getClienteActual().getListaProductoFavorito());
			break;
		}
		case "Carrito": {
			vf.getVpc().getPf().actualizarInfo(mf.getClienteActual().getCarrito().getListaCarrito());
			break;
		}
		default:
			break;
		}
	}
}
