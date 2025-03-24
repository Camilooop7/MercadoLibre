package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextField;

import co.edu.unbosque.controller.Controller;

public class PanelAgregarDeporte extends JPanel {

	private JLabel fondo;
	private JButton btnAgregar;
	private JLabel textNombre;
	private JTextField nombre;
	private JLabel textPrecio;
	private JSpinner precio;
	private JLabel textAccesorio;
	private JRadioButton siA;
	private JRadioButton noA;
	private JLabel textDeporte;
	private JTextField deporte;

	public PanelAgregarDeporte() throws IOException {

		setBounds(412, 250, 780, 433);
		setLayout(null);

		fondo = new JLabel();
		BufferedImage fd = ImageIO.read(new File("src/co/edu/unbosque/view/PanelAgregar.png"));
		ImageIcon imagenFondo = new ImageIcon(fd);
		Image fdRedim = fd.getScaledInstance(780, 433, Image.SCALE_SMOOTH);
		fondo.setIcon(new ImageIcon(fdRedim));
		fondo.setBounds(0, 0, 780, 433);

		btnAgregar = new JButton();
		btnAgregar.setBounds(625, 298, 112, 112);
		btnAgregar.setFocusable(false);
		btnAgregar.setBackground(new Color(0, 0, 0));
		btnAgregar.setContentAreaFilled(false);
		btnAgregar.setOpaque(false);
		btnAgregar.setBorderPainted(false);
		btnAgregar.setVisible(true);
		add(btnAgregar);
		
		textNombre = new JLabel();
		textNombre.setBounds(44, 40, 150, 60);
		textNombre.setText("Nombre: ");
		textNombre.setFont(new Font("Baloo", Font.BOLD, 24));
		add(textNombre);

		nombre = new JTextField();
		nombre.setBounds(140, 40, 490, 50);
		nombre.setFont(new Font("Baloo", Font.BOLD, 24));
		add(nombre);

		textPrecio = new JLabel();
		textPrecio.setBounds(50, 130, 150, 60);
		textPrecio.setText("Precio: ");
		textPrecio.setFont(new Font("Baloo", Font.BOLD, 24));
		add(textPrecio);

		precio = new JSpinner();
		precio.setBounds(140, 130, 490, 50);
		precio.setFont(new Font("Baloo", Font.BOLD, 24));
		add(precio);

		textAccesorio = new JLabel();
		textAccesorio.setBounds(50, 190, 400, 60);
		textAccesorio.setText("¿Es accesorio? ");
		textAccesorio.setFont(new Font("Baloo", Font.BOLD, 26));
		add(textAccesorio);

		siA = new JRadioButton("SI");
		siA.setBounds(257, 210, 80, 30); // Ajustar el tamaño para que el texto sea visible
		siA.setFont(new Font("Baloo", Font.BOLD, 15));
		siA.setOpaque(false);
		siA.setContentAreaFilled(false);
		siA.setBorderPainted(false);
		siA.setFocusPainted(false);
		add(siA);

		noA = new JRadioButton("NO");
		noA.setBounds(340, 210, 80, 30); // Ajustar el tamaño para que el texto sea visible
		noA.setFont(new Font("Baloo", Font.BOLD, 15));
		noA.setOpaque(false);
		noA.setContentAreaFilled(false);
		noA.setBorderPainted(false);
		noA.setFocusPainted(false);
		add(noA);
		// Agrupar los JRadioButton
		ButtonGroup grupo = new ButtonGroup();
		grupo.add(siA);
		grupo.add(noA);

		textDeporte = new JLabel();
		textDeporte.setBounds(40, 270, 150, 60);
		textDeporte.setText("Deporte:");
		textDeporte.setFont(new Font("Baloo", Font.BOLD, 24));
		add(textDeporte);

		deporte = new JTextField();
		deporte.setBounds(140, 270, 470, 50);
		deporte.setFont(new Font("Baloo", Font.BOLD, 24));
		add(deporte);

		add(fondo);
	}

	public JLabel getFondo() {
		return fondo;
	}

	public void setFondo(JLabel fondo) {
		this.fondo = fondo;
	}

	public JButton getBtnAgregar() {
		return btnAgregar;
	}

	public void setBtnAgregar(JButton btnAgregar) {
		this.btnAgregar = btnAgregar;
	}

	public JLabel getTextNombre() {
		return textNombre;
	}

	public void setTextNombre(JLabel textNombre) {
		this.textNombre = textNombre;
	}

	public String getNombre() {
		return (String) nombre.getText();
	}

	public void setNombre(JTextField nombre) {
		this.nombre = nombre;
	}

	public JLabel getTextPrecio() {
		return textPrecio;
	}

	public void setTextPrecio(JLabel textPrecio) {
		this.textPrecio = textPrecio;
	}

	public int getPrecio() {
		return (int) precio.getValue();
	}

	public void setPrecio(JSpinner precio) {
		this.precio = precio;
	}

	public JLabel getTextAccesorio() {
		return textAccesorio;
	}

	public void setTextAccesorio(JLabel textAccesorio) {
		this.textAccesorio = textAccesorio;
	}

	public JRadioButton getSiA() {
		return siA;
	}

	public void setSiA(JRadioButton siA) {
		this.siA = siA;
	}

	public JRadioButton getNoA() {
		return noA;
	}

	public void setNoA(JRadioButton noA) {
		this.noA = noA;
	}

	public JLabel getTextDeporte() {
		return textDeporte;
	}

	public void setTextDeporte(JLabel textDeporte) {
		this.textDeporte = textDeporte;
	}

	public String getDeporte() {
		return (String) deporte.getText();
	}

	public void setDeporte(JTextField deporte) {
		this.deporte = deporte;
	}

}