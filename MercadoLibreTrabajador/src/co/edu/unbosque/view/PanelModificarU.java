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
import javax.swing.JTextArea;

public class PanelModificarU extends JPanel {

	private JLabel fondo;
	private JButton btnVolver;
	private JButton btnTrabajador;
	private JButton btnCliente;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JTextArea espacioLista;
	private String texto;

	public PanelModificarU() throws IOException {
		setBounds(0, 0, 1290, 750);
		setLayout(null);

		fondo = new JLabel();
		BufferedImage fd = ImageIO.read(new File("src/co/edu/unbosque/view/FondoTBack.png"));
		ImageIcon imagenFondo = new ImageIcon(fd);
		Image fdRedim = fd.getScaledInstance(1290, 750, Image.SCALE_SMOOTH);
		fondo.setIcon(new ImageIcon(fdRedim));
		fondo.setBounds(0, 0, 1290, 750);

		btnVolver = new JButton();
		btnVolver.setBounds(1092, 71, 130, 97);
		btnVolver.setFocusable(false);
		btnVolver.setBackground(new Color(0, 0, 0));
		btnVolver.setContentAreaFilled(false);
		btnVolver.setOpaque(false);
		btnVolver.setBorderPainted(false);
		btnVolver.setVisible(true);
		add(btnVolver);

		btnTrabajador = new JButton();
		btnTrabajador.setBounds(100, 250, 252, 70);
		btnTrabajador.setText("Trabajadores");
		btnTrabajador.setFocusable(false);
		btnTrabajador.setForeground(Color.black);
		btnTrabajador.setBackground(new Color(235, 219, 79));
		btnTrabajador.setFont(new Font("Baloo", Font.BOLD, 35));
		add(btnTrabajador);

		btnCliente = new JButton();
		btnCliente.setBounds(100, 370, 252, 70);
		btnCliente.setText("Clientes");
		btnCliente.setFocusable(false);
		btnCliente.setForeground(Color.black);
		btnCliente.setBackground(new Color(235, 219, 79));
		btnCliente.setFont(new Font("Baloo", Font.BOLD, 35));
		add(btnCliente);

		btnModificar = new JButton();
		btnModificar.setBounds(100, 490, 252, 70);
		btnModificar.setText("Modificar");
		btnModificar.setFocusable(false);
		btnModificar.setForeground(Color.black);
		btnModificar.setBackground(new Color(235, 219, 79));
		btnModificar.setFont(new Font("Baloo", Font.BOLD, 35));
		add(btnModificar);

		btnEliminar = new JButton();
		btnEliminar.setBounds(100, 610, 252, 70);
		btnEliminar.setText("Eliminar");
		btnEliminar.setFocusable(false);
		btnEliminar.setBackground(Color.WHITE);
		btnEliminar.setForeground(Color.black);
		btnEliminar.setBackground(new Color(246, 86, 86));
		btnEliminar.setFont(new Font("Baloo", Font.BOLD, 35));
		add(btnEliminar);

		espacioLista = new JTextArea();
		espacioLista.setBounds(412, 250, 780, 433);
		espacioLista.setFocusable(false);
		espacioLista.setText(texto);
		espacioLista.setBackground(Color.WHITE);
		espacioLista.setFont(new Font("Baloo", Font.BOLD, 20));
		espacioLista.setLineWrap(true);
		espacioLista.setWrapStyleWord(true);
		espacioLista.setEditable(false);
		add(espacioLista);

		add(fondo);
	}

	public JLabel getFondo() {
		return fondo;
	}

	public void setFondo(JLabel fondo) {
		this.fondo = fondo;
	}

	public JButton getBtnVolver() {
		return btnVolver;
	}

	public void setBtnVolver(JButton btnVolver) {
		this.btnVolver = btnVolver;
	}

	public JButton getBtnModificar() {
		return btnModificar;
	}

	public void setBtnModificar(JButton btnModificar) {
		this.btnModificar = btnModificar;
	}

	public JButton getBtnEliminar() {
		return btnEliminar;
	}

	public void setBtnEliminar(JButton btnEliminar) {
		this.btnEliminar = btnEliminar;
	}

	public JButton getBtnTrabajador() {
		return btnTrabajador;
	}

	public void setBtnTrabajador(JButton btnTrabajador) {
		this.btnTrabajador = btnTrabajador;
	}

	public JButton getBtnCliente() {
		return btnCliente;
	}

	public void setBtnCliente(JButton btnCliente) {
		this.btnCliente = btnCliente;
	}

	public JTextArea getEspacioLista() {
		return espacioLista;
	}

	public void setEspacioLista(JTextArea espacioLista) {
		this.espacioLista = espacioLista;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
		espacioLista.setText(texto);
	}

}
