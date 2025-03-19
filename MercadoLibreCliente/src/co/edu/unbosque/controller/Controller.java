package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import co.edu.unbosque.model.Cliente;
import co.edu.unbosque.model.ModelFacade;
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

	private Cliente clienteActual;

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
		vf.getVpc().getPis().getBtnVolver().addActionListener(this);
		vf.getVpc().getPis().getBtnVolver().setActionCommand("btnVolverI");
		vf.getVpc().getPcu().getBtnIngresar().addActionListener(this);
		vf.getVpc().getPcu().getBtnIngresar().setActionCommand("btnIngresarC");
		vf.getVpc().getPcu().getBtnVolver().addActionListener(this);
		vf.getVpc().getPcu().getBtnVolver().setActionCommand("btnVolverC");
        vf.getVpc().getPcm().getBtnVolver().addActionListener(this);
        vf.getVpc().getPcm().getBtnVolver().setActionCommand("btnVolverCL");
        vf.getVpc().getPcm().getBtnCarrito().addActionListener(this);
        vf.getVpc().getPcm().getBtnCarrito().setActionCommand("btnCarritoCL");
        vf.getVpc().getPcm().getBtnHistorial().addActionListener(this);
        vf.getVpc().getPcm().getBtnHistorial().setActionCommand("btnHistorialCL");
        vf.getVpc().getPcm().getBtnTienda().addActionListener(this);
        vf.getVpc().getPcm().getBtnTienda().setActionCommand("btnTiendaCL");
        vf.getVpc().getPcm().getBtnFavoritos().addActionListener(this);
        vf.getVpc().getPcm().getBtnFavoritos().setActionCommand("btnFavoritoCL");
       
        
        
        
        
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
				clienteActual = mf.getClienteDAO().encontrarUsuario(usuario, contrasena);

			}else {
				vf.getVemer().mostrar("Problema en el usuario o contraseña.");
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
		case "btnVolverC": {
			vf.getVpc().getPcu().setVisible(false);
			vf.getVpc().getPpc().setVisible(true);
			break;
		}
		case "btnVolverCL" :{
			vf.getVpc().getPcm().setVisible(false);
			vf.getVpc().getPpc().setVisible(true);
			break;
		}
		case "btnCarritoCL" : {
			vf.getVpc().getPcm().setVisible(false);
			vf.getVpc().getPc().setVisible(true);
			break;
		}
		case "btnHistorialCL":{
			vf.getVpc().getPcm().setVisible(false);
			vf.getVpc().getPh().setVisible(true);
			break;
		}
		case "btnTiendaCL" : {
			vf.getVpc().getPcm().setVisible(false);
			vf.getVpc().getPt().setVisible(true);
			break;
		}
		case "btnFavoritoCL" : { 
			vf.getVpc().getPcm().setVisible(false);
			vf.getVpc().getPf().setVisible(true);
			break;
			
			
		}

		}

	}
}
