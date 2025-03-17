package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class PanelIniciarSesion extends JPanel {

	private JLabel fondo;
	private JTextField nombreUsuario;
	private JPasswordField contrasena;
	private JButton btnVolver;
	private JButton btnIngresar;
	private JLabel textNombre;
	private JLabel textContra;
	private JLabel textEstandar;

	public PanelIniciarSesion() throws IOException {
		setBounds(0, 0, 1290, 750);
		setLayout(null);

		fondo = new JLabel();
		BufferedImage fd = ImageIO.read(new File("src/co/edu/unbosque/view/FondoT.png"));
		ImageIcon imagenFondo = new ImageIcon(fd);
		Image fdRedim = fd.getScaledInstance(1290, 750, Image.SCALE_SMOOTH);
		fondo.setIcon(new ImageIcon(fdRedim));
		fondo.setBounds(0, 0, 1290, 750);

		btnVolver = new JButton();
		btnVolver.setBounds(800, 530, 170, 50);
		btnVolver.setText("Volver");
		btnVolver.setFocusable(false);
		btnVolver.setForeground(Color.black);
		btnVolver.setBackground(new Color(246, 86, 86));
		btnVolver.setFont(new Font("Baloo", Font.BOLD, 26));
		add(btnVolver);

		btnIngresar = new JButton();
		btnIngresar.setBounds(480, 530, 320, 50);
		btnIngresar.setText("Ingresar");
		btnIngresar.setFocusable(false);
		btnIngresar.setForeground(Color.black);
		btnIngresar.setBackground(new Color(235, 219, 79));
		btnIngresar.setFont(new Font("Baloo", Font.BOLD, 26));
		add(btnIngresar);

		nombreUsuario = new JTextField();
		nombreUsuario.setBounds(480, 300, 490, 60);
		nombreUsuario.setFont(new Font("Baloo", Font.BOLD, 26));
		add(nombreUsuario);

		contrasena = new JPasswordField();
		contrasena.setBounds(480, 400, 490, 60);
		contrasena.setFont(new Font("Baloo", Font.BOLD, 26));
		add(contrasena);

		textNombre = new JLabel();
		textNombre.setBounds(230, 300, 400, 60);
		textNombre.setText("Nombre de usuario:");
		textNombre.setFont(new Font("Baloo", Font.BOLD, 26));
		add(textNombre);

		textContra = new JLabel();
		textContra.setBounds(324, 400, 400, 60);
		textContra.setText("Contraseña: ");
		textContra.setFont(new Font("Baloo", Font.BOLD, 26));
		add(textContra);

		textEstandar = new JLabel();
		textEstandar.setBounds(480, 441, 800, 60);
		textEstandar.setText(
				"Debe contener 8 caracteres, una mayuscula, una minuscula, un simbolo y al menos un número.  ");
		textEstandar.setFont(new Font("Baloo", Font.BOLD, 10));
		add(textEstandar);

		add(fondo);

	}

	public JLabel getFondo() {
		return fondo;
	}

	public void setFondo(JLabel fondo) {
		this.fondo = fondo;
	}

	public JTextField getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(JTextField nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public JPasswordField getContrasena() {
		return contrasena;
	}

	public void setContrasena(JPasswordField contrasena) {
		this.contrasena = contrasena;
	}

	public JButton getBtnVolver() {
		return btnVolver;
	}

	public void setBtnVolver(JButton btnVolver) {
		this.btnVolver = btnVolver;
	}

	public JButton getBtnIngresar() {
		return btnIngresar;
	}

	public void setBtnIngresar(JButton btnIngresar) {
		this.btnIngresar = btnIngresar;
	}

	public JLabel getTextNombre() {
		return textNombre;
	}

	public void setTextNombre(JLabel textNombre) {
		this.textNombre = textNombre;
	}

	public JLabel getTextContra() {
		return textContra;
	}

	public void setTextContra(JLabel textContra) {
		this.textContra = textContra;
	}

	public JLabel getTextEstandar() {
		return textEstandar;
	}

	public void setTextEstandar(JLabel textEstandar) {
		this.textEstandar = textEstandar;
	}

}
