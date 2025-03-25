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

public class PanelModificarU extends JPanel {

	private JLabel fondo;
	private JButton btnTrabajador;
	private JButton btnCliente;

	public PanelModificarU() throws IOException {
		setBounds(166, 245, 950, 433);
		setLayout(null);

		fondo = new JLabel();
		BufferedImage fd = ImageIO.read(new File("src/co/edu/unbosque/view/FondoUs.png"));
		ImageIcon imagenFondo = new ImageIcon(fd);
		Image fdRedim = fd.getScaledInstance(950, 433, Image.SCALE_SMOOTH);
		fondo.setIcon(new ImageIcon(fdRedim));
		fondo.setBounds(0, 0, 950, 433);

		btnTrabajador = new JButton();
		btnTrabajador.setBounds(150, 140, 200, 150);
		btnTrabajador.setFocusable(false);
		btnTrabajador.setBackground(new Color(0, 0, 0));
		btnTrabajador.setContentAreaFilled(false);
		btnTrabajador.setOpaque(false);
		btnTrabajador.setBorderPainted(false);
		btnTrabajador.setVisible(true);
		add(btnTrabajador);

		btnCliente = new JButton();
		btnCliente.setBounds(545, 140, 260, 155);
		btnCliente.setFocusable(false);
		btnCliente.setBackground(new Color(0, 0, 0));
		btnCliente.setContentAreaFilled(false);
		btnCliente.setOpaque(false);
		btnCliente.setBorderPainted(false);
		btnCliente.setVisible(true);
		add(btnCliente);

		add(fondo);

	}

}
