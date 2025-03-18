package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import co.edu.unbosque.model.ModelFacade;
import co.edu.unbosque.model.Trabajador;
import co.edu.unbosque.model.persistence.FileManager;
import co.edu.unbosque.util.exception.CapitalException;
import co.edu.unbosque.util.exception.CharacterException;
import co.edu.unbosque.util.exception.EqualPasswordException;
import co.edu.unbosque.util.exception.NumberException;
import co.edu.unbosque.util.exception.SymbolException;
import co.edu.unbosque.util.exception.SmallException;
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
		vf.getVpt().setVisible(true);
		vf.getVemer().leerBoleano("aaa");

	}

	public void asignarLectores() {

		vf.getVpt().getPpt().getBtnIniciarS().addActionListener(this);
		vf.getVpt().getPpt().getBtnIniciarS().setActionCommand("btnIniciarS");
		vf.getVpt().getPpt().getBtnCrearU().addActionListener(this);
		vf.getVpt().getPpt().getBtnCrearU().setActionCommand("btnCrearU");
		vf.getVpt().getPpt().getBtnSalir().addActionListener(this);
		vf.getVpt().getPpt().getBtnSalir().setActionCommand("btnSalir");
		vf.getVpt().getPis().getBtnIngresar().addActionListener(this);
		vf.getVpt().getPis().getBtnIngresar().setActionCommand("btnIngresarI");
		vf.getVpt().getPis().getBtnVolver().addActionListener(this);
		vf.getVpt().getPis().getBtnVolver().setActionCommand("btnVolverI");
		vf.getVpt().getPcu().getBtnIngresar().addActionListener(this);
		vf.getVpt().getPcu().getBtnIngresar().setActionCommand("btnIngresarC");
		vf.getVpt().getPcu().getBtnVolver().addActionListener(this);
		vf.getVpt().getPcu().getBtnVolver().setActionCommand("btnVolverC");

	}

	public void actionPerformed(ActionEvent e) {

		switch (e.getActionCommand()) {

		case "btnIniciarS": {
			vf.getVpt().getPpt().setVisible(false);
			vf.getVpt().getPis().setVisible(true);

			break;
		}
		case "btnCrearU": {
			vf.getVpt().getPpt().setVisible(false);
			vf.getVpt().getPcu().setVisible(true);

			break;
		}
		case "btnSalir": {
			vf.getVpt().setVisible(false);

			break;
		}
		case "btnIngresarI": {

			String usuario = (String) vf.getVpt().getPis().getNombreUsuario();
			String contrasena = (String) vf.getVpt().getPis().getContrasena();
			try {
				ExceptionCheker.checkerCharacter(usuario);
				ExceptionCheker.checkerPasword(contrasena);
				
				if (usuario.equals(mf.getTrabajadorDAO())&&contrasena.equals(mf.getTrabajadorDAO())) {
					vf.getVpt().getPis().setVisible(false);
					vf.getVpt().getPt().setVisible(true);
					
					
				}

				
			} catch (CharacterException e1) {
				vf.getVemer().mostrar("No cumple los requisitos de caracteres.");
			} catch (CapitalException e1) {
				vf.getVemer().mostrar("Debe contener al menos una mayuscula.");
			} catch (SmallException e1) {
				vf.getVemer().mostrar("Debe contener al menos una minuscula.");
			} catch (NumberException e1) {
				vf.getVemer().mostrar("Debe contener al menos un número.");
			} catch (SymbolException e1) {
				vf.getVemer().mostrar("Debe contener al menos un simbolo.");
			}

			break;
		}
		case "btnVolverI": {
			vf.getVpt().getPis().setVisible(false);
			vf.getVpt().getPpt().setVisible(true);
			break;
		}
		case "btnIngresarC": {
			String usuario = (String) vf.getVpt().getPcu().getNombreUsuario();
			String contrasena1 = (String) vf.getVpt().getPcu().getContrasena1();
			String contrasena2 = (String) vf.getVpt().getPcu().getContrasena2();

			try {
				ExceptionCheker.checkerCharacter(usuario);
				ExceptionCheker.checkerEqualPassword(contrasena1, contrasena2);
				ExceptionCheker.checkerPasword(contrasena1);

				mf.getTrabajadorDAO().crear(new Trabajador(usuario, contrasena1));
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
			}

			break;
		}
		case "btnVolverC": {
			vf.getVpt().getPcu().setVisible(false);
			vf.getVpt().getPpt().setVisible(true);
			break;
		}

		}

	}
}
