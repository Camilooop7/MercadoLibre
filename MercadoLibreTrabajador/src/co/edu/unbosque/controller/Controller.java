package co.edu.unbosque.controller;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.InputMismatchException;

import javax.imageio.ImageIO;

import co.edu.unbosque.model.Bano;
import co.edu.unbosque.model.Cliente;
import co.edu.unbosque.model.Cocina;
import co.edu.unbosque.model.Deporte;
import co.edu.unbosque.model.Electrodomestico;
import co.edu.unbosque.model.ModelFacade;
import co.edu.unbosque.model.Papeleria;
import co.edu.unbosque.model.Trabajador;
import co.edu.unbosque.model.VideoJuego;
import co.edu.unbosque.model.persistence.FileManager;
import co.edu.unbosque.util.exception.CapitalException;
import co.edu.unbosque.util.exception.CharacterException;
import co.edu.unbosque.util.exception.EqualPasswordException;
import co.edu.unbosque.util.exception.ImageException;
import co.edu.unbosque.util.exception.IsBlackException;
import co.edu.unbosque.util.exception.NegativeNumberException;
import co.edu.unbosque.util.exception.NumberException;
import co.edu.unbosque.util.exception.SymbolException;
import co.edu.unbosque.util.exception.TextException;
import co.edu.unbosque.util.exception.UsernameException;
import co.edu.unbosque.util.exception.SmallException;
import co.edu.unbosque.view.ViewFacade;

public class Controller implements ActionListener {
	private ModelFacade mf;
	private ViewFacade vf;
	private Trabajador trabajadorActual;

	public Controller() throws IOException {
		FileManager.crearCarpeta();
		mf = new ModelFacade();
		vf = new ViewFacade();
		asignarLectores();
	}

	public void run() {
		vf.getVpt().setVisible(true);

	}

	public void asignarLectores() {

		vf.getVpt().getPpt().getBtnIniciarS().addActionListener(this);
		vf.getVpt().getPpt().getBtnIniciarS().setActionCommand("btnIniciarS");
		vf.getVpt().getPpt().getBtnCrearU().addActionListener(this);
		vf.getVpt().getPpt().getBtnCrearU().setActionCommand("btnCrearU");
		vf.getVpt().getPpt().getBtnCrearU().addActionListener(this);
		vf.getVpt().getPpt().getBtnCrearU().setActionCommand("btnCrearU");
		vf.getVpt().getPpt().getBtnSalir().addActionListener(this);
		vf.getVpt().getPpt().getBtnSalir().setActionCommand("btnSalir");

		vf.getVpt().getPis().getBtnIngresar().addActionListener(this);
		vf.getVpt().getPis().getBtnIngresar().setActionCommand("btnIngresarI");
		vf.getVpt().getPis().getBtnVolver().addActionListener(this);
		vf.getVpt().getPis().getBtnVolver().setActionCommand("btnVolverI");
		vf.getVpt().getPis().getMostrarContrasena().addActionListener(this);
		vf.getVpt().getPis().getMostrarContrasena().setActionCommand("checkMostrarIni");

		vf.getVpt().getPcu().getBtnIngresar().addActionListener(this);
		vf.getVpt().getPcu().getBtnIngresar().setActionCommand("btnIngresarC");
		vf.getVpt().getPcu().getMostrarContrasena().addActionListener(this);
		vf.getVpt().getPcu().getMostrarContrasena().setActionCommand("checkMostrar");
		vf.getVpt().getPcu().getMostrarContrasena2().addActionListener(this);
		vf.getVpt().getPcu().getMostrarContrasena2().setActionCommand("checkMostrar2");
		vf.getVpt().getPcu().getBtnVolver().addActionListener(this);
		vf.getVpt().getPcu().getBtnVolver().setActionCommand("btnVolverC");

		vf.getVpt().getPt().getBtnAnadir().addActionListener(this);
		vf.getVpt().getPt().getBtnAnadir().setActionCommand("btnAnadir");
		vf.getVpt().getPt().getBtnModificarProducto().addActionListener(this);
		vf.getVpt().getPt().getBtnModificarProducto().setActionCommand("btnModificarP");
		vf.getVpt().getPt().getBtnEliminarProducto().addActionListener(this);
		vf.getVpt().getPt().getBtnEliminarProducto().setActionCommand("btnEliminarP");
		vf.getVpt().getPt().getBtnModificarUsuario().addActionListener(this);
		vf.getVpt().getPt().getBtnModificarUsuario().setActionCommand("btnModificarU");
		vf.getVpt().getPt().getBtnSalir().addActionListener(this);
		vf.getVpt().getPt().getBtnSalir().setActionCommand("btnSalirT");

		vf.getVpt().getPap().getBtnVolver().addActionListener(this);
		vf.getVpt().getPap().getBtnVolver().setActionCommand("btnVolverAna");
		vf.getVpt().getPap().getBtnHogar().addActionListener(this);
		vf.getVpt().getPap().getBtnHogar().setActionCommand("btnAnadirHogar");
		vf.getVpt().getPap().getBtnOficina().addActionListener(this);
		vf.getVpt().getPap().getBtnOficina().setActionCommand("btnAnadirOficina");
		vf.getVpt().getPap().getBtnOcio().addActionListener(this);
		vf.getVpt().getPap().getBtnOcio().setActionCommand("btnAnadirOcio");

		vf.getVpt().getPmu().getBtnVolver().addActionListener(this);
		vf.getVpt().getPmu().getBtnVolver().setActionCommand("btnVolverMU");
		vf.getVpt().getPmu().getBtnModificar().addActionListener(this);
		vf.getVpt().getPmu().getBtnModificar().setActionCommand("btnModificarMU");
		vf.getVpt().getPmu().getBtnEliminar().addActionListener(this);
		vf.getVpt().getPmu().getBtnEliminar().setActionCommand("btnEliminarMU");
		vf.getVpt().getPmu().getBtnCliente().addActionListener(this);
		vf.getVpt().getPmu().getBtnCliente().setActionCommand("btnClientesMU");
		vf.getVpt().getPmu().getBtnTrabajador().addActionListener(this);
		vf.getVpt().getPmu().getBtnTrabajador().setActionCommand("btnTrabajadoresMU");

		vf.getVpt().getPap().getPah().getBtnCocina().addActionListener(this);
		vf.getVpt().getPap().getPah().getBtnCocina().setActionCommand("btnAgregarCocina");
		vf.getVpt().getPap().getPah().getBtnBano().addActionListener(this);
		vf.getVpt().getPap().getPah().getBtnBano().setActionCommand("btnAgregarBano");

		vf.getVpt().getPap().getPaof().getBtnElectrodomestico().addActionListener(this);
		vf.getVpt().getPap().getPaof().getBtnElectrodomestico().setActionCommand("btnAgregarElectro");
		vf.getVpt().getPap().getPaof().getBtnPapeleria().addActionListener(this);
		vf.getVpt().getPap().getPaof().getBtnPapeleria().setActionCommand("btnAgregarPapel");

		vf.getVpt().getPap().getPaoc().getBtnVideoJuego().addActionListener(this);
		vf.getVpt().getPap().getPaoc().getBtnVideoJuego().setActionCommand("btnAgregarVJ");
		vf.getVpt().getPap().getPaoc().getBtnDeporte().addActionListener(this);
		vf.getVpt().getPap().getPaoc().getBtnDeporte().setActionCommand("btnAgregarDepor");
		// cocina
		vf.getVpt().getPap().getPaco().getBtnAgregar().addActionListener(this);
		vf.getVpt().getPap().getPaco().getBtnAgregar().setActionCommand("btnAgregaProCocina");
		
		// bano
		vf.getVpt().getPap().getPaba().getBtnAgregar().addActionListener(this);
		vf.getVpt().getPap().getPaba().getBtnAgregar().setActionCommand("btnAgregaProBano");
		
		
		//electrodomestico
		vf.getVpt().getPap().getPae().getBtnAgregar().addActionListener(this);
		vf.getVpt().getPap().getPae().getBtnAgregar().setActionCommand("btnAgregaProElectro");
		
		//papeleria
		vf.getVpt().getPap().getPapape().getBtnAgregar().addActionListener(this);
		vf.getVpt().getPap().getPapape().getBtnAgregar().setActionCommand("btnAgregaProPapeleria");
		
		//videojuego
		vf.getVpt().getPap().getPavj().getBtnAgregar().addActionListener(this);
		vf.getVpt().getPap().getPavj().getBtnAgregar().setActionCommand("btnAgregaProVideoJuego");
		
		//deporte
		vf.getVpt().getPap().getPadepor().getBtnAgregar().addActionListener(this);
		vf.getVpt().getPap().getPadepor().getBtnAgregar().setActionCommand("btnAgregaProDeporte");
		
		
		
		

		// TODO botones
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

				if (mf.getTrabajadorDAO().encontrarUsuario(usuario, contrasena) != null) {

					vf.getVpt().getPis().setVisible(false);
					vf.getVpt().getPt().setVisible(true);
					trabajadorActual = mf.getTrabajadorDAO().encontrarUsuario(usuario, contrasena);

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
		case "checkMostrar": {
			if (vf.getVpt().getPcu().getMostrarContrasena().isSelected()) {
				vf.getVpt().getPcu().getContrasena1F().setEchoChar((char) 0);
			} else {
				vf.getVpt().getPcu().getContrasena1F().setEchoChar('*');
			}

			break;
		}
		case "checkMostrar2": {
			if (vf.getVpt().getPcu().getMostrarContrasena2().isSelected()) {
				vf.getVpt().getPcu().getContrasena2F().setEchoChar((char) 0);
			} else {
				vf.getVpt().getPcu().getContrasena2F().setEchoChar('*');
			}

			break;
		}
		case "checkMostrarIni": {
			if (vf.getVpt().getPis().getMostrarContrasena().isSelected()) {
				vf.getVpt().getPis().getContrasenaF().setEchoChar((char) 0);
			} else {
				vf.getVpt().getPis().getContrasenaF().setEchoChar('*');
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
			boolean verificar = mf.getTrabajadorDAO().encontrarNombre(usuario);

			try {
				ExceptionCheker.checkerCharacter(usuario);
				ExceptionCheker.checkerEqualPassword(contrasena1, contrasena2);
				ExceptionCheker.checkerPasword(contrasena1);
				ExceptionCheker.checkerUsername(verificar);

				mf.getTrabajadorDAO().crear(new Trabajador(usuario, contrasena1));
				vf.getVemer().mostrar("Usuario creado con exito, Regrese al menu para iniciar sesión.");

			} catch (CharacterException e1) {
				vf.getVemer().mostrar("No cumple los requisitos de caracteres.");
				e1.printStackTrace();
			} catch (EqualPasswordException e1) {
				vf.getVemer().mostrar("Las contraseñas no son iguales.");
				e1.printStackTrace();
			} catch (CapitalException e1) {
				vf.getVemer().mostrar("Debe contener al menos una mayuscula.");
				e1.printStackTrace();
			} catch (SmallException e1) {
				vf.getVemer().mostrar("Debe contener al menos una minuscula.");
				e1.printStackTrace();
			} catch (NumberException e1) {
				vf.getVemer().mostrar("Debe contener al menos un número.");
				e1.printStackTrace();
			} catch (SymbolException e1) {
				vf.getVemer().mostrar("Debe contener al menos un simbolo.");
				e1.printStackTrace();
			} catch (UsernameException e1) {
				vf.getVemer().mostrar("Nombre de usuario ya registrado, intente nuevamente.");
				e1.printStackTrace();
			}

			break;
		}
		case "btnVolverC": {
			vf.getVpt().getPcu().setVisible(false);
			vf.getVpt().getPpt().setVisible(true);
			break;
		}
		case "btnAnadir": {
			vf.getVpt().getPt().setVisible(false);
			vf.getVpt().getPap().setVisible(true);

			break;
		}
		case "btnAnadirHogar": {
			vf.getVpt().getPap().getPaof().setVisible(false);
			vf.getVpt().getPap().getPae().setVisible(false);
			vf.getVpt().getPap().getPapape().setVisible(false);

			vf.getVpt().getPap().getPaoc().setVisible(false);
			vf.getVpt().getPap().getPavj().setVisible(false);
			vf.getVpt().getPap().getPadepor().setVisible(false);

			vf.getVpt().getPap().getPaco().setVisible(false);
			vf.getVpt().getPap().getPaba().setVisible(false);
			vf.getVpt().getPap().getPah().setVisible(true);

			break;
		}
		case "btnAnadirOficina": {
			vf.getVpt().getPap().getPah().setVisible(false);
			vf.getVpt().getPap().getPaco().setVisible(false);
			vf.getVpt().getPap().getPaba().setVisible(false);

			vf.getVpt().getPap().getPaoc().setVisible(false);
			vf.getVpt().getPap().getPavj().setVisible(false);
			vf.getVpt().getPap().getPadepor().setVisible(false);

			vf.getVpt().getPap().getPae().setVisible(false);
			vf.getVpt().getPap().getPapape().setVisible(false);
			vf.getVpt().getPap().getPaof().setVisible(true);

			break;
		}
		case "btnAnadirOcio": {
			vf.getVpt().getPap().getPah().setVisible(false);
			vf.getVpt().getPap().getPaco().setVisible(false);
			vf.getVpt().getPap().getPaba().setVisible(false);

			vf.getVpt().getPap().getPaof().setVisible(false);
			vf.getVpt().getPap().getPae().setVisible(false);
			vf.getVpt().getPap().getPapape().setVisible(false);

			vf.getVpt().getPap().getPavj().setVisible(false);
			vf.getVpt().getPap().getPadepor().setVisible(false);
			vf.getVpt().getPap().getPaoc().setVisible(true);

			break;
		}
		case "btnAgregarCocina": {
			vf.getVpt().getPap().getPah().setVisible(false);
			vf.getVpt().getPap().getPaba().setVisible(false);
			vf.getVpt().getPap().getPaco().setVisible(true);

			break;

		}
		case "btnAgregarBano": {
			vf.getVpt().getPap().getPah().setVisible(false);
			vf.getVpt().getPap().getPaco().setVisible(false);
			vf.getVpt().getPap().getPaba().setVisible(true);
			break;

		}
		case "btnAgregarElectro": {
			vf.getVpt().getPap().getPaof().setVisible(false);
			vf.getVpt().getPap().getPapape().setVisible(false);
			vf.getVpt().getPap().getPae().setVisible(true);

			break;

		}
		case "btnAgregarPapel": {
			vf.getVpt().getPap().getPaof().setVisible(false);
			vf.getVpt().getPap().getPae().setVisible(false);
			vf.getVpt().getPap().getPapape().setVisible(true);
			break;

		}
		case "btnAgregarVJ": {
			vf.getVpt().getPap().getPaoc().setVisible(false);
			vf.getVpt().getPap().getPadepor().setVisible(false);
			vf.getVpt().getPap().getPavj().setVisible(true);

			break;

		}
		case "btnAgregarDepor": {
			vf.getVpt().getPap().getPaoc().setVisible(false);
			vf.getVpt().getPap().getPavj().setVisible(false);
			vf.getVpt().getPap().getPadepor().setVisible(true);

			break;

		}

		case "btnModificarP": {
			// TODO
			break;
		}
		case "btnEliminarP": {
			// TODO
			break;
		}
		case "btnModificarU": {
			vf.getVpt().getPt().setVisible(false);
			vf.getVpt().getPmu().setVisible(true);

			break;
		}
		case "btnSalirT": {

			vf.getVpt().getPt().setVisible(false);
			vf.getVpt().getPpt().setVisible(true);
			break;

		}
		case "btnVolverMU": {

			vf.getVpt().getPmu().setVisible(false);
			vf.getVpt().getPt().setVisible(true);
			break;

		}
		case "btnModificarMU": {
			String tipo = vf.getVemer().leerTexto("¿Que tipo de usuario desea modificar?").toLowerCase();
			try {
				ExceptionCheker.checkerText(tipo);

				if (tipo.contains("cliente")) {
					int a = vf.getVemer().leerInt("¿Cual desea actualizar?");
					ExceptionCheker.checkerNegativeNumber(a - 1);
					a = a - 1;
					if (mf.getClienteDAO().encontrar(a)) {

						String nombre = vf.getVemer().leerTexto("Nombre nuevo:");
						boolean verificar = mf.getTrabajadorDAO().encontrarNombre(nombre);
						ExceptionCheker.checkerCharacter(nombre);
						ExceptionCheker.checkerUsername(verificar);
						String contra = vf.getVemer().leerTexto("Contraseña nueva:");
						ExceptionCheker.checkerPasword(contra);

						mf.getClienteDAO().actulizar(a, new Cliente(nombre, contra));
						vf.getVpt().getPmu().setTexto(mf.getClienteDAO().mostrarTodo());
						vf.getVpt().getPmu().revalidate();
						vf.getVpt().getPmu().repaint();
					} else {
						vf.getVemer().mostrar("la posicion que desea actualizar no esta en la lista");
					}

				}
			} catch (TextException e1) {
				vf.getVemer().mostrar("Solo se permiten letras.");
				e1.printStackTrace();
			} catch (NegativeNumberException e1) {
				vf.getVemer().mostrar("Numero no valido.");
				e1.printStackTrace();
			} catch (CharacterException e1) {
				vf.getVemer().mostrar("No cumple los requisitos de caracteres.");
				e1.printStackTrace();
			} catch (UsernameException e1) {
				vf.getVemer().mostrar("Nombre de usuario ya registrado, intente nuevamente.");
				e1.printStackTrace();
			} catch (CapitalException e1) {
				vf.getVemer().mostrar("Debe contener al menos una mayuscula.");
				e1.printStackTrace();
			} catch (SmallException e1) {
				vf.getVemer().mostrar("Debe contener al menos una minuscula.");
				e1.printStackTrace();
			} catch (NumberException e1) {
				vf.getVemer().mostrar("Debe contener al menos un número.");
				e1.printStackTrace();
			} catch (SymbolException e1) {
				vf.getVemer().mostrar("Debe contener al menos un simbolo.");
				e1.printStackTrace();
			}

			try {
				ExceptionCheker.checkerText(tipo);

				if (tipo.contains("trabajador")) {
					int a = vf.getVemer().leerInt("¿Cual desea actualizar?");
					ExceptionCheker.checkerNegativeNumber(a - 1);
					a = a - 1;
					if (mf.getTrabajadorDAO().encontrar(a)) {

						String nombre = vf.getVemer().leerTexto("Nombre nuevo:");
						boolean verificar = mf.getTrabajadorDAO().encontrarNombre(nombre);
						ExceptionCheker.checkerCharacter(nombre);
						ExceptionCheker.checkerUsername(verificar);
						String contra = vf.getVemer().leerTexto("Contraseña nueva:");
						ExceptionCheker.checkerPasword(contra);
						mf.getTrabajadorDAO().actulizar(a, new Trabajador(nombre, contra));
						vf.getVpt().getPmu().setTexto(mf.getTrabajadorDAO().mostrarTodo());
						vf.getVpt().getPmu().revalidate();
						vf.getVpt().getPmu().repaint();
					} else {
						vf.getVemer().mostrar("la posicion que desea actualizar no esta en la lista");
					}
				}
			} catch (TextException e1) {
				e1.printStackTrace();
			} catch (NegativeNumberException e1) {
				vf.getVemer().mostrar("Numero no valido.");
				e1.printStackTrace();
			} catch (CharacterException e1) {
				vf.getVemer().mostrar("No cumple los requisitos de caracteres.");
				e1.printStackTrace();
			} catch (UsernameException e1) {
				vf.getVemer().mostrar("Nombre de usuario ya registrado, intente nuevamente.");
				e1.printStackTrace();
			} catch (CapitalException e1) {
				vf.getVemer().mostrar("Debe contener al menos una mayuscula.");
				e1.printStackTrace();
			} catch (SmallException e1) {
				vf.getVemer().mostrar("Debe contener al menos una minuscula.");
				e1.printStackTrace();
			} catch (NumberException e1) {
				vf.getVemer().mostrar("Debe contener al menos un número.");
				e1.printStackTrace();
			} catch (SymbolException e1) {
				vf.getVemer().mostrar("Debe contener al menos un simbolo.");
				e1.printStackTrace();
			}
			break;

		}
		case "btnEliminarMU": {
			String tipo = vf.getVemer().leerTexto("¿Que tipo de usuario desea eliminar?").toLowerCase();

			try {
				ExceptionCheker.checkerText(tipo);
				if (tipo.contains("cliente")) {
					int a = vf.getVemer().leerInt("¿Cual desea eliminar?");
					a = a - 1;
					ExceptionCheker.checkerNegativeNumber(a - 1);
					if (mf.getClienteDAO().encontrar(a)) {

						mf.getClienteDAO().eliminar(a);
						vf.getVpt().getPmu().setTexto(mf.getClienteDAO().mostrarTodo());
						vf.getVpt().getPmu().revalidate();
						vf.getVpt().getPmu().repaint();

					} else {
						vf.getVemer().mostrar("la posicion a eliminar no esta en la lista");

					}

				}
			} catch (TextException e1) {
				vf.getVemer().mostrar("Solo se permiten letras.");
				e1.printStackTrace();
			} catch (NegativeNumberException e1) {
				vf.getVemer().mostrar("Numero no valido.");
				e1.printStackTrace();
			}

			try {
				ExceptionCheker.checkerText(tipo);
				if (tipo.contains("trabajador")) {
					int a = vf.getVemer().leerInt("¿Cual desea eliminar?");
					ExceptionCheker.checkerNegativeNumber(a - 1);
					a = a - 1;
					if (mf.getTrabajadorDAO().encontrar(a)) {

						mf.getTrabajadorDAO().eliminar(a);
						vf.getVpt().getPmu().setTexto(mf.getTrabajadorDAO().mostrarTodo());
						vf.getVpt().getPmu().revalidate();
						vf.getVpt().getPmu().repaint();

					} else {
						vf.getVemer().mostrar("la posicion a eliminar no esta en la lista");
					}
				}

			} catch (TextException e1) {
				e1.printStackTrace();
			} catch (NegativeNumberException e1) {
				vf.getVemer().mostrar("Numero no valido.");
				e1.printStackTrace();
			}
			break;

		}
		case "btnClientesMU": {
			vf.getVpt().getPmu().setTexto(mf.getClienteDAO().mostrarTodo());
			vf.getVpt().getPmu().revalidate();
			vf.getVpt().getPmu().repaint();

			break;

		}
		case "btnTrabajadoresMU": {
			vf.getVpt().getPmu().setTexto(mf.getTrabajadorDAO().mostrarTodo());
			vf.getVpt().getPmu().revalidate();
			vf.getVpt().getPmu().repaint();
			break;

		}
		case "btnVolverAna": {

			vf.getVpt().getPap().setVisible(false);
			vf.getVpt().getPt().setVisible(true);
			break;

		}

		case "btnAgregaProCocina": {
			String nombre = (String) vf.getVpt().getPap().getPaco().getNombre();
			int precio = (int) vf.getVpt().getPap().getPaco().getPrecio();
			int id = new Cocina().codigoAleatorio();
			LocalDate fecha = LocalDate.now();
			boolean esDecoracion = false;
			boolean resisteAltaTemperatuta = false;
			boolean esPeligroso = false;
			String imagen = "../archivos/imagenes/cocina/";

			try {
				ExceptionCheker.checkerNegativeNumber(precio);
				
				ExceptionCheker.checkerIsBlank(nombre);
				

				if (vf.getVpt().getPap().getPaco().getSiD().isSelected()) {
					esDecoracion = true;
				} else if (vf.getVpt().getPap().getPaco().getNoD().isSelected()) {
					esDecoracion = false;
				}

				if (vf.getVpt().getPap().getPaco().getSiP().isSelected()) {
					resisteAltaTemperatuta = true;
				} else if (vf.getVpt().getPap().getPaco().getNoP().isSelected()) {
					resisteAltaTemperatuta = false;
				}

				if (vf.getVpt().getPap().getPaco().getSiR().isSelected()) {
					esPeligroso = true;
				} else if (vf.getVpt().getPap().getPaco().getNoR().isSelected()) {
					esPeligroso = false;
				}

				if (!vf.getVpt().getPap().getPaco().getSiD().isSelected()
						&& !vf.getVpt().getPap().getPaco().getNoD().isSelected()) {
					ExceptionCheker.checkerIsEmpty();
				}
				if (!vf.getVpt().getPap().getPaco().getSiP().isSelected()
						&& !vf.getVpt().getPap().getPaco().getNoP().isSelected()) {
					ExceptionCheker.checkerIsEmpty();
				}
				if (!vf.getVpt().getPap().getPaco().getSiR().isSelected()
						&& !vf.getVpt().getPap().getPaco().getNoR().isSelected()) {
					ExceptionCheker.checkerIsEmpty();
				}

				File selectedFile = vf.getVemer().seleccionarArchivo();
				if (selectedFile != null) {
					String fileName = selectedFile.getName().toLowerCase();
		            if (!fileName.endsWith(".jpg") && !fileName.endsWith(".jpeg") && !fileName.endsWith(".png") && !fileName.endsWith(".gif")) {
		                vf.getVemer().mostrarError("El archivo seleccionado no es una imagen válida. Por favor, seleccione un archivo con extensión .jpg, .jpeg, .png o .gif.");
		                break;
		            }
					try {
						// Cargar la imagen seleccionada
						Image image = ImageIO.read(selectedFile);

						// Copiar el archivo seleccionado al directorio 'resources/images'
						File destino = new File("../archivos/imagenes/cocina/" + selectedFile.getName());
						FileManager.guardarImagen(selectedFile, destino);

						// Guardar la URL de la imagen
						imagen = destino.getPath();

					} catch (IOException ex) {
						vf.getVemer().mostrarError("No se pudo cargar la imagen.");
					} catch (IllegalArgumentException ex) {
						vf.getVemer().mostrarError("El archivo seleccionado no es una imagen válida.");
					}
				} else {
					ExceptionCheker.checkerImage();
				}

				// Crear el objeto Cocina con la URL de la imagen
				mf.getCocinaDAO().crear(new Cocina(nombre, precio, id, fecha, imagen, esDecoracion,
						resisteAltaTemperatuta, esPeligroso));

				System.out.println(mf.getCocinaDAO().mostrarTodo());

			} catch (NegativeNumberException e2) {
				vf.getVemer().mostrar("Número no válido.");
				e2.printStackTrace();
			} catch (IsBlackException e2) {
				vf.getVemer().mostrar("Completar toda la información.");
				e2.printStackTrace();
			} catch (ImageException e2) {
				vf.getVemer().mostrar("No seleciono una imagen");
			} 
			break;
		}
		
		case "btnAgregaProBano": {
			String nombre = (String) vf.getVpt().getPap().getPaba().getNombre();
			int precio = (int) vf.getVpt().getPap().getPaba().getPrecio();
			int id = new Bano().codigoAleatorio();
			LocalDate fecha = LocalDate.now();
			boolean esDecoracion = false;
			boolean esLimpieza = false;
			String imagen = "../archivos/imagenes/bano/";
			
			try {
				ExceptionCheker.checkerNegativeNumber(precio);
				
				ExceptionCheker.checkerIsBlank(nombre);
				
				if (vf.getVpt().getPap().getPaba().getSiD().isSelected()) {
					esDecoracion = true;
				} else if (vf.getVpt().getPap().getPaba().getNoD().isSelected()) {
					esDecoracion = false;
				}

				if (vf.getVpt().getPap().getPaba().getSiL().isSelected()){
					esLimpieza = true;
				} else if (vf.getVpt().getPap().getPaba().getNoL().isSelected()) {
					esLimpieza = false;
				}



				if (!vf.getVpt().getPap().getPaba().getSiD().isSelected()
						&& !vf.getVpt().getPap().getPaba().getNoD().isSelected()) {
					ExceptionCheker.checkerIsEmpty();
				}
				if (!vf.getVpt().getPap().getPaba().getSiL().isSelected()
						&& !vf.getVpt().getPap().getPaba().getNoL().isSelected()) {
					ExceptionCheker.checkerIsEmpty();
				}
				
				File selectedFile = vf.getVemer().seleccionarArchivo();
				if (selectedFile != null) {
					String fileName = selectedFile.getName().toLowerCase();
		            if (!fileName.endsWith(".jpg") && !fileName.endsWith(".jpeg") && !fileName.endsWith(".png") && !fileName.endsWith(".gif")) {
		                vf.getVemer().mostrarError("El archivo seleccionado no es una imagen válida. Por favor, seleccione un archivo con extensión .jpg, .jpeg, .png o .gif.");
		                break;
		            }
					try {
						// Cargar la imagen seleccionada
						Image image = ImageIO.read(selectedFile);

						// Copiar el archivo seleccionado al directorio 'resources/images'
						File destino = new File("../archivos/imagenes/bano/" + selectedFile.getName());
						FileManager.guardarImagen(selectedFile, destino);

						// Guardar la URL de la imagen
						imagen = destino.getPath();

					} catch (IOException ex) {
						vf.getVemer().mostrarError("No se pudo cargar la imagen.");
					} catch (IllegalArgumentException ex) {
						vf.getVemer().mostrarError("El archivo seleccionado no es una imagen válida.");
					}
				} else {
					ExceptionCheker.checkerImage();
				}

				// Crear el objeto Cocina con la URL de la imagen
				mf.getBanoDAO().crear(new Bano(nombre, precio, id, fecha, imagen, esDecoracion, esLimpieza));

				System.out.println(mf.getBanoDAO().mostrarTodo());
				
				
			} catch (NegativeNumberException e2) {
				vf.getVemer().mostrar("Número no válido.");
				e2.printStackTrace();
			} catch (IsBlackException e2) {
				vf.getVemer().mostrar("Completar toda la información.");
				e2.printStackTrace();
			} catch (ImageException e2) {
				vf.getVemer().mostrar("No seleciono una imagen");
			} 
			break;
		}
		
		case "btnAgregaProElectro": {
			String nombre = (String) vf.getVpt().getPap().getPae().getNombre();
			int precio = (int) vf.getVpt().getPap().getPae().getPrecio();
			int id = new Electrodomestico().codigoAleatorio();
			LocalDate fecha = LocalDate.now();
			boolean esPortatil = false;
			String fuenteEnergia = (String) vf.getVpt().getPap().getPae().getFuenteEnergia();
			String imagen = "../archivos/imagenes/electro/";
			
			try {
				ExceptionCheker.checkerNegativeNumber(precio);
				
				ExceptionCheker.checkerIsBlank(nombre);
				
				if (vf.getVpt().getPap().getPae().getSiD().isSelected()) {
					esPortatil = true;
				} else if (vf.getVpt().getPap().getPae().getNoD().isSelected()) {
					esPortatil = false;
				}



				if (!vf.getVpt().getPap().getPae().getSiD().isSelected()
						&& !vf.getVpt().getPap().getPae().getNoD().isSelected()) {
					ExceptionCheker.checkerIsEmpty();
				}
				
				
				File selectedFile = vf.getVemer().seleccionarArchivo();
				if (selectedFile != null) {
					String fileName = selectedFile.getName().toLowerCase();
		            if (!fileName.endsWith(".jpg") && !fileName.endsWith(".jpeg") && !fileName.endsWith(".png") && !fileName.endsWith(".gif")) {
		                vf.getVemer().mostrarError("El archivo seleccionado no es una imagen válida. Por favor, seleccione un archivo con extensión .jpg, .jpeg, .png o .gif.");
		                break;
		            }
					try {
						// Cargar la imagen seleccionada
						Image image = ImageIO.read(selectedFile);

						// Copiar el archivo seleccionado al directorio 'resources/images'
						File destino = new File("../archivos/imagenes/electro/" + selectedFile.getName());
						FileManager.guardarImagen(selectedFile, destino);

						// Guardar la URL de la imagen
						imagen = destino.getPath();

					} catch (IOException ex) {
						vf.getVemer().mostrarError("No se pudo cargar la imagen.");
					} catch (IllegalArgumentException ex) {
						vf.getVemer().mostrarError("El archivo seleccionado no es una imagen válida.");
					}
				} else {
					ExceptionCheker.checkerImage();
				}

				// Crear el objeto Cocina con la URL de la imagen
				mf.getElectrodomesticoDAO().crear(new Electrodomestico(nombre, precio, id, fecha, imagen, esPortatil, fuenteEnergia));

				System.out.println(mf.getElectrodomesticoDAO().mostrarTodo());
				
				
			} catch (NegativeNumberException e2) {
				vf.getVemer().mostrar("Número no válido.");
				e2.printStackTrace();
			} catch (IsBlackException e2) {
				vf.getVemer().mostrar("Completar toda la información.");
				e2.printStackTrace();
			} catch (ImageException e2) {
				vf.getVemer().mostrar("No seleciono una imagen");
			} 
			break;
		} 
		case "btnAgregaProPapeleria": {
			String nombre = (String) vf.getVpt().getPap().getPapape().getNombre();
			int precio = (int) vf.getVpt().getPap().getPapape().getPrecio();
			int id = new Papeleria().codigoAleatorio();
			LocalDate fecha = LocalDate.now();
			boolean esPortatil = false;
			int cantidadPaquete = (int) vf.getVpt().getPap().getPapape().getCantidadPorPaquete();
			String imagen = "../archivos/imagenes/papeleria/";
			
			try {
				ExceptionCheker.checkerNegativeNumber(precio);
				ExceptionCheker.checkerNegativeNumber(cantidadPaquete);
				
				ExceptionCheker.checkerIsBlank(nombre);
				
				if (vf.getVpt().getPap().getPapape().getSiD().isSelected()) {
					esPortatil = true;
				} else if (vf.getVpt().getPap().getPapape().getNoD().isSelected()) {
					esPortatil = false;
				}



				if (!vf.getVpt().getPap().getPapape().getSiD().isSelected()
						&& !vf.getVpt().getPap().getPapape().getNoD().isSelected()) {
					ExceptionCheker.checkerIsEmpty();
				}
				
				
				File selectedFile = vf.getVemer().seleccionarArchivo();
				if (selectedFile != null) {
					String fileName = selectedFile.getName().toLowerCase();
		            if (!fileName.endsWith(".jpg") && !fileName.endsWith(".jpeg") && !fileName.endsWith(".png") && !fileName.endsWith(".gif")) {
		                vf.getVemer().mostrarError("El archivo seleccionado no es una imagen válida. Por favor, seleccione un archivo con extensión .jpg, .jpeg, .png o .gif.");
		                break;
		            }
					try {
						// Cargar la imagen seleccionada
						Image image = ImageIO.read(selectedFile);

						// Copiar el archivo seleccionado al directorio 'resources/images'
						File destino = new File("../archivos/imagenes/papeleria/" + selectedFile.getName());
						FileManager.guardarImagen(selectedFile, destino);

						// Guardar la URL de la imagen
						imagen = destino.getPath();

					} catch (IOException ex) {
						vf.getVemer().mostrarError("No se pudo cargar la imagen.");
					} catch (IllegalArgumentException ex) {
						vf.getVemer().mostrarError("El archivo seleccionado no es una imagen válida.");
					}
				} else {
					ExceptionCheker.checkerImage();
				}

				// Crear el objeto Cocina con la URL de la imagen
				mf.getPapeleriaDAO().crear(new Papeleria(nombre, precio, id, fecha, imagen, esPortatil, cantidadPaquete));

				System.out.println(mf.getPapeleriaDAO().mostrarTodo());
				
				
			} catch (NegativeNumberException e2) {
				vf.getVemer().mostrar("Número no válido.");
				e2.printStackTrace();
			} catch (IsBlackException e2) {
				vf.getVemer().mostrar("Completar toda la información.");
				e2.printStackTrace();
			} catch (ImageException e2) {
				vf.getVemer().mostrar("No seleciono una imagen");
			} 
			break;
		} 
		
		
		
		case "btnAgregaProVideoJuego": {
			String nombre = (String) vf.getVpt().getPap().getPavj().getNombre();
			int precio = (int) vf.getVpt().getPap().getPavj().getPrecio();
			int id = new VideoJuego().codigoAleatorio();
			LocalDate fecha = LocalDate.now();
			boolean esAccesorio = false;
			String referenciaConsola = (String) vf.getVpt().getPap().getPavj().getReferenciaConsola();
			String imagen = "../archivos/imagenes/videojuego/";
			
			try {
				ExceptionCheker.checkerNegativeNumber(precio);
				
				ExceptionCheker.checkerIsBlank(referenciaConsola);
				ExceptionCheker.checkerIsBlank(nombre);
				
				if (vf.getVpt().getPap().getPavj().getSiA().isSelected()) {
					esAccesorio = true;
				} else if (vf.getVpt().getPap().getPavj().getNoA().isSelected()) {
					esAccesorio = false;
				}



				if (!vf.getVpt().getPap().getPavj().getSiA().isSelected()
						&& !vf.getVpt().getPap().getPavj().getNoA().isSelected()) {
					ExceptionCheker.checkerIsEmpty();
				}
				
				
				File selectedFile = vf.getVemer().seleccionarArchivo();
				if (selectedFile != null) {
					String fileName = selectedFile.getName().toLowerCase();
		            if (!fileName.endsWith(".jpg") && !fileName.endsWith(".jpeg") && !fileName.endsWith(".png") && !fileName.endsWith(".gif")) {
		                vf.getVemer().mostrarError("El archivo seleccionado no es una imagen válida. Por favor, seleccione un archivo con extensión .jpg, .jpeg, .png o .gif.");
		                break;
		            }
					try {
						// Cargar la imagen seleccionada
						Image image = ImageIO.read(selectedFile);

						// Copiar el archivo seleccionado al directorio 'resources/images'
						File destino = new File("../archivos/imagenes/videojuego/" + selectedFile.getName());
						FileManager.guardarImagen(selectedFile, destino);

						// Guardar la URL de la imagen
						imagen = destino.getPath();

					} catch (IOException ex) {
						vf.getVemer().mostrarError("No se pudo cargar la imagen.");
					} catch (IllegalArgumentException ex) {
						vf.getVemer().mostrarError("El archivo seleccionado no es una imagen válida.");
					}
				} else {
					ExceptionCheker.checkerImage();
				}

				// Crear el objeto Cocina con la URL de la imagen
				mf.getVideoJuegoDAO().crear(new VideoJuego(nombre, precio, id, fecha, imagen, esAccesorio, referenciaConsola));

				System.out.println(mf.getVideoJuegoDAO().mostrarTodo());
				
				
			} catch (NegativeNumberException e2) {
				vf.getVemer().mostrar("Número no válido.");
				e2.printStackTrace();
			} catch (IsBlackException e2) {
				vf.getVemer().mostrar("Completar toda la información.");
				e2.printStackTrace();
			} catch (ImageException e2) {
				vf.getVemer().mostrar("No seleciono una imagen");
			} 
			break;
		} 
		
		case "btnAgregaProDeporte": {
			
			String nombre1 = (String)vf.getVpt().getPap().getPadepor().getNombre();
		    int precio = (int) vf.getVpt().getPap().getPadepor().getPrecio();
		    int id = new Deporte().codigoAleatorio();
		    LocalDate fecha = LocalDate.now();
		    boolean esAccesorio = false;
		    String deporte = (String) vf.getVpt().getPap().getPadepor().getDeporte();
		    System.out.println(nombre1);
		    System.out.println(deporte);
		    String imagen = "../archivos/imagenes/deporte/";

		    try {
		        ExceptionCheker.checkerNegativeNumber(precio);
		        ExceptionCheker.checkerIsBlank(nombre1);
		        ExceptionCheker.checkerIsBlank(deporte); // Validación adicional

		        if (vf.getVpt().getPap().getPadepor().getSiA().isSelected()) {
		            esAccesorio = true;
		        } else if (vf.getVpt().getPap().getPadepor().getNoA().isSelected()) {
		            esAccesorio = false;
		        }

		        if (!vf.getVpt().getPap().getPadepor().getSiA().isSelected()
		                && !vf.getVpt().getPap().getPadepor().getNoA().isSelected()) {
		            ExceptionCheker.checkerIsEmpty();
		        }

		        File selectedFile = vf.getVemer().seleccionarArchivo();
		        if (selectedFile != null) {
		            String fileName = selectedFile.getName().toLowerCase();
		            if (!fileName.endsWith(".jpg") && !fileName.endsWith(".jpeg") && !fileName.endsWith(".png") && !fileName.endsWith(".gif")) {
		                vf.getVemer().mostrarError("El archivo seleccionado no es una imagen válida. Por favor, seleccione un archivo con extensión .jpg, .jpeg, .png o .gif.");
		                break;
		            }
		            try {
		                // Cargar la imagen seleccionada
		                Image image = ImageIO.read(selectedFile);

		                // Copiar el archivo seleccionado al directorio 'resources/images'
		                File destino = new File("../archivos/imagenes/deporte/" + selectedFile.getName());
		                FileManager.guardarImagen(selectedFile, destino);

		                // Guardar la URL de la imagen
		                imagen = destino.getPath();

		            } catch (IOException ex) {
		                vf.getVemer().mostrarError("No se pudo cargar la imagen.");
		            } catch (IllegalArgumentException ex) {
		                vf.getVemer().mostrarError("El archivo seleccionado no es una imagen válida.");
		            }
		        } else {
		            ExceptionCheker.checkerImage();
		        }

		        // Crear el objeto Deporte con la URL de la imagen
		        mf.getDeporteDAO().crear(new Deporte(nombre1, precio, id, fecha, imagen, esAccesorio, deporte));

		        System.out.println(mf.getDeporteDAO().mostrarTodo());

		    } catch (NegativeNumberException e2) {
		        vf.getVemer().mostrar("Número no válido.");
		        e2.printStackTrace();
		    } catch (IsBlackException e2) {
		        vf.getVemer().mostrar("Completar toda la información.");
		        e2.printStackTrace();
		    } catch (ImageException e2) {
		        vf.getVemer().mostrar("No seleccionó una imagen.");
		    }
		    break;
		}

		
		
		
		 
		
		
		

		}

	}

}
