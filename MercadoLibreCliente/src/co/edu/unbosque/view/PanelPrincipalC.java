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

public class PanelPrincipalC extends JPanel {
	
	
	private JLabel fondo;
	private JButton btnIniciarS;
	private JButton btnCrearU;
	private JButton btnSalir;

	public PanelPrincipalC() throws IOException {
		
		setBounds(0, 0, 1290, 750);
		setLayout(null);
		
		fondo = new JLabel();
		BufferedImage fd = ImageIO.read(new File("src/co/edu/unbosque/view/FondoC.png"));
		ImageIcon imagenFondo = new ImageIcon(fd);
		Image fdRedim = fd.getScaledInstance(1290, 750, Image.SCALE_SMOOTH);
		fondo.setIcon(new ImageIcon(fdRedim));
		fondo.setBounds(0, 0, 1290, 750);

		btnIniciarS = new JButton();
		btnIniciarS.setBounds(140, 360, 290, 150);
		btnIniciarS.setText("Iniciar Sesion");
		btnIniciarS.setFocusable(false);
		btnIniciarS.setBackground(Color.WHITE);
		btnIniciarS.setForeground(Color.black);
		btnIniciarS.setBackground(new Color(235, 219, 79));
		btnIniciarS.setFont(new Font("Baloo", Font.BOLD, 35));
		add(btnIniciarS);

		btnCrearU = new JButton();
		btnCrearU.setBounds(500, 360, 290, 150);
		btnCrearU.setText("Crear Cuenta");
		btnCrearU.setFocusable(false);
		btnCrearU.setBackground(Color.WHITE);
		btnCrearU.setForeground(Color.black);
		btnCrearU.setBackground(new Color(235, 219, 79));
		btnCrearU.setFont(new Font("Baloo", Font.BOLD, 35));
		add(btnCrearU);

		btnSalir = new JButton();
		btnSalir.setBounds(860, 360, 290, 150);
		btnSalir.setText("Salir");
		btnSalir.setFocusable(false);
		btnSalir.setBackground(Color.WHITE);
		btnSalir.setForeground(Color.black);
		btnSalir.setBackground(new Color(246, 86, 86));
		btnSalir.setFont(new Font("Baloo", Font.BOLD, 35));
		add(btnSalir);

		add(fondo); // TODO Auto-generated constructor stub
	}

	public JLabel getFondo() {
		return fondo;
	}

	public void setFondo(JLabel fondo) {
		this.fondo = fondo;
	}

	public JButton getBtnIniciarS() {
		return btnIniciarS;
	}

	public void setBtnIniciarS(JButton btnIniciarS) {
		this.btnIniciarS = btnIniciarS;
	}

	public JButton getBtnCrearU() {
		return btnCrearU;
	}

	public void setBtnCrearU(JButton btnCrearU) {
		this.btnCrearU = btnCrearU;
	}

	public JButton getBtnSalir() {
		return btnSalir;
	}

	public void setBtnSalir(JButton btnSalir) {
		this.btnSalir = btnSalir;
	}

}
