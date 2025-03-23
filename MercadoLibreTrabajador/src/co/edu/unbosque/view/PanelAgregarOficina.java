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

public class PanelAgregarOficina extends JPanel {

	private JLabel fondo;
	private JButton btnElectrodomestico;
	private JButton btnPapeleria;

	public PanelAgregarOficina() throws IOException {

		setBounds(412, 250, 780, 433);
		setLayout(null);

		fondo = new JLabel();
		BufferedImage fd = ImageIO.read(new File("src/co/edu/unbosque/view/FondoOficina.png"));
		ImageIcon imagenFondo = new ImageIcon(fd);
		Image fdRedim = fd.getScaledInstance(780, 433, Image.SCALE_SMOOTH);
		fondo.setIcon(new ImageIcon(fdRedim));
		fondo.setBounds(0, 0, 780, 433);

		btnElectrodomestico = new JButton();
		btnElectrodomestico.setBounds(120, 128, 182, 180);
		btnElectrodomestico.setFocusable(false);
		btnElectrodomestico.setBackground(new Color(0, 0, 0));
		btnElectrodomestico.setContentAreaFilled(false);
		btnElectrodomestico.setOpaque(false);
		btnElectrodomestico.setBorderPainted(false);
		btnElectrodomestico.setVisible(true);
		add(btnElectrodomestico);

		btnPapeleria = new JButton();
		btnPapeleria.setBounds(460, 128, 182, 180);
		btnPapeleria.setFocusable(false);
		btnPapeleria.setBackground(new Color(0, 0, 0));
		btnPapeleria.setContentAreaFilled(false);
		btnPapeleria.setOpaque(false);
		btnPapeleria.setBorderPainted(false);
		btnPapeleria.setVisible(true);
		add(btnPapeleria);

		add(fondo);

	}

	public JLabel getFondo() {
		return fondo;
	}

	public void setFondo(JLabel fondo) {
		this.fondo = fondo;
	}

	public JButton getBtnElectrodomestico() {
		return btnElectrodomestico;
	}

	public void setBtnElectrodomestico(JButton btnElectrodomestico) {
		this.btnElectrodomestico = btnElectrodomestico;
	}

	public JButton getBtnPapeleria() {
		return btnPapeleria;
	}

	public void setBtnPapeleria(JButton btnPapeleria) {
		this.btnPapeleria = btnPapeleria;
	}

}
