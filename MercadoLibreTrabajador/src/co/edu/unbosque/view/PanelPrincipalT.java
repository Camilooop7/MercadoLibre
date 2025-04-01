package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Properties;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelPrincipalT extends JPanel {
	
	
	private JLabel fondo;
	private JButton btnIniciarS;
	private JButton btnCrearU;
	private JButton btnSalir;
	private Properties prop;

	public PanelPrincipalT(Properties prop) throws IOException {
		
		setBounds(0, 0, 1290, 750);
		setLayout(null);
		
		this.prop = prop;
		
		fondo = new JLabel();
		BufferedImage fd = ImageIO.read(new File("src/co/edu/unbosque/view/FondoT.png"));
		ImageIcon imagenFondo = new ImageIcon(fd);
		Image fdRedim = fd.getScaledInstance(1290, 750, Image.SCALE_SMOOTH);
		fondo.setIcon(new ImageIcon(fdRedim));
		fondo.setBounds(0, 0, 1290, 750);

		btnIniciarS = new JButton();
		btnIniciarS.setBounds(140, 360, 290, 150);
		btnIniciarS.setText(prop.getProperty("archivosdepropiedades.panel.principal.sesioni"));
		btnIniciarS.setFocusable(false);
		btnIniciarS.setBackground(Color.WHITE);
		btnIniciarS.setForeground(Color.black);
		btnIniciarS.setBackground(new Color(235, 219, 79));
		btnIniciarS.setFont(new Font("Baloo", Font.BOLD, 35));
		add(btnIniciarS);

		btnCrearU = new JButton();
		btnCrearU.setBounds(500, 360, 290, 150);
		btnCrearU.setText(prop.getProperty("archivosdepropiedades.panel.principal.crearc"));
		btnCrearU.setFocusable(false);
		btnCrearU.setBackground(Color.WHITE);
		btnCrearU.setForeground(Color.black);
		btnCrearU.setBackground(new Color(235, 219, 79));
		btnCrearU.setFont(new Font("Baloo", Font.BOLD, 35));
		add(btnCrearU);

		btnSalir = new JButton();
		btnSalir.setBounds(860, 360, 290, 150);
		btnSalir.setText(prop.getProperty("archivosdepropiedades.panel.principal.exit"));
		btnSalir.setFocusable(false);
		btnSalir.setBackground(Color.WHITE);
		btnSalir.setForeground(Color.black);
		btnSalir.setBackground(new Color(246, 86, 86));
		btnSalir.setFont(new Font("Baloo", Font.BOLD, 35));
		add(btnSalir);

		add(fondo); 
	}
	
	public void actualizarComps() throws IOException {
		BufferedImage fd = ImageIO.read(new File(prop.getProperty("archivospropiedad.fondo.fondoidioma")));
		ImageIcon imagenFondo = new ImageIcon(fd);
		Image fdRedim = fd.getScaledInstance(1290, 750, Image.SCALE_SMOOTH);
		fondo.setIcon(new ImageIcon(fdRedim));
		
		btnIniciarS.setText(prop.getProperty("archivosdepropiedades.panel.principal.sesioni"));
		btnCrearU.setText(prop.getProperty("archivosdepropiedades.panel.principal.crearc"));
		btnSalir.setText(prop.getProperty("archivosdepropiedades.panel.principal.exit"));
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

	public Properties getProp() {
		return prop;
	}

	public void setProp(Properties prop) {
		this.prop = prop;
	}
	
	

}
