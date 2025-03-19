package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelClienteMenu extends JPanel {

	private JLabel fondo;

	private JButton btnVolver, btnCarrito, btnHistorial, btnTienda, btnFavoritos;
	
	public PanelClienteMenu() throws IOException {
		
		setBounds(0, 0, 1290, 750);
		setLayout(null);

		fondo = new JLabel();
		BufferedImage fd = ImageIO.read(new File("src/co/edu/unbosque/view/FondoCMenu.png"));
		ImageIcon imagenFondo = new ImageIcon(fd);
		Image fdRedim = fd.getScaledInstance(1290, 750, Image.SCALE_SMOOTH);
		fondo.setIcon(new ImageIcon(fdRedim));
		fondo.setBounds(0, 0, 1290, 750);
		
		btnVolver = new JButton();
		btnVolver.setBounds(1120, 70, 120, 70);
		btnVolver.setFocusable(false);
		btnVolver.setBackground(new Color(0, 0, 0));
		btnVolver.setContentAreaFilled(false);
		btnVolver.setOpaque(false);
		//btnVolver.setBorderPainted(false);
		btnVolver.setVisible(true);
		add(btnVolver);
		
		btnCarrito = new JButton();
		btnCarrito.setBounds(165, 550, 150, 150);
		btnCarrito.setFocusable(false);
		btnCarrito.setBackground(new Color(0, 0, 0));
		btnCarrito.setContentAreaFilled(false);
		btnCarrito.setOpaque(false);
		btnCarrito.setVisible(true);
		add(btnCarrito);

		btnHistorial = new JButton();
		btnHistorial.setBounds(415, 550, 150, 150);
		btnHistorial.setFocusable(false);
		btnHistorial.setBackground(new Color(0, 0, 0));
		btnHistorial.setContentAreaFilled(false);
		btnHistorial.setOpaque(false);
		btnHistorial.setVisible(true);
		add(btnHistorial);
		
		btnTienda = new JButton();
		btnTienda.setBounds(690, 550, 175, 150);
		btnTienda.setFocusable(false);
		btnTienda.setBackground(new Color(0, 0, 0));
		btnTienda.setContentAreaFilled(false);
		btnTienda.setOpaque(false);
		btnTienda.setVisible(true);
		add(btnTienda);
		
		btnFavoritos = new JButton();
		btnFavoritos.setBounds(985, 550, 150, 150);
		btnFavoritos.setFocusable(false);
		btnFavoritos.setBackground(new Color(0, 0, 0));
		btnFavoritos.setContentAreaFilled(false);
		btnFavoritos.setOpaque(false);
		btnFavoritos.setVisible(true);
		add(btnFavoritos);
		
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

	public JButton getBtnCarrito() {
		return btnCarrito;
	}

	public void setBtnCarrito(JButton btnCarrito) {
		this.btnCarrito = btnCarrito;
	}

	public JButton getBtnHistorial() {
		return btnHistorial;
	}

	public void setBtnHistorial(JButton btnHistorial) {
		this.btnHistorial = btnHistorial;
	}

	public JButton getBtnTienda() {
		return btnTienda;
	}

	public void setBtnTienda(JButton btnTienda) {
		this.btnTienda = btnTienda;
	}

	public JButton getBtnFavoritos() {
		return btnFavoritos;
	}

	public void setBtnFavoritos(JButton btnFavoritos) {
		this.btnFavoritos = btnFavoritos;
	}

	
	
}