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

public class PanelAgregarOcio extends JPanel {
	
	private JLabel fondo;
	private JButton btnVideoJuego;
	private JButton btnDeporte;
	
	public PanelAgregarOcio()throws IOException {

		setBounds(412, 250, 780, 433);
		setLayout(null);

		fondo = new JLabel();
		BufferedImage fd = ImageIO.read(new File("src/co/edu/unbosque/view/FondoOcio.png"));
		ImageIcon imagenFondo = new ImageIcon(fd);
		Image fdRedim = fd.getScaledInstance(780, 433, Image.SCALE_SMOOTH);
		fondo.setIcon(new ImageIcon(fdRedim));
		fondo.setBounds(0, 0, 780, 433);

		btnVideoJuego = new JButton();
		btnVideoJuego.setBounds(133, 128, 182, 180);
		btnVideoJuego.setFocusable(false);
		btnVideoJuego.setBackground(new Color(0, 0, 0));
		btnVideoJuego.setContentAreaFilled(false);
		btnVideoJuego.setOpaque(false);
		btnVideoJuego.setBorderPainted(false);
		btnVideoJuego.setVisible(true);
		add(btnVideoJuego);

		btnDeporte = new JButton();
		btnDeporte.setBounds(460, 128, 182, 180);
		btnDeporte.setFocusable(false);
		btnDeporte.setBackground(new Color(0, 0, 0));
		btnDeporte.setContentAreaFilled(false);
		btnDeporte.setOpaque(false);
		btnDeporte.setBorderPainted(false);
		btnDeporte.setVisible(true);
		add(btnDeporte);

		add(fondo);

	}

}
