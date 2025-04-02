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
import javax.swing.JTextArea;

public class PanelAnadirProducto extends JPanel {

	private JLabel fondo;
	private JButton btnVolver;
	private JButton btnHogar;
	private JButton btnOficina;
	private JButton btnOcio;
	private PanelAgregarH pah;
	private PanelAgregarOficina paof;
	private PanelAgregarOcio paoc;
	private PanelAgregarCocina paco;
	private PanelAgregarBano paba;
	private PanelAgregarElectro pae;
	private PanelAgregarPapeleria papape;
	private PanelAgregarVideoJuego pavj;
	private PanelAgregarDeporte pade;
	private Properties prop;

	public PanelAnadirProducto(Properties prop) throws IOException {

		setBounds(0, 0, 1290, 750);
		setLayout(null);
		
		this.prop = prop;

		fondo = new JLabel();
		BufferedImage fd = ImageIO.read(new File(prop.getProperty("archivospropiedad.fondo.tback")));
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

		btnHogar = new JButton();
		btnHogar.setBounds(100, 290, 252, 70);
		btnHogar.setText(prop.getProperty("archivosdepropiedades.panel.agregar.producto.hogar"));
		btnHogar.setFocusable(false);
		btnHogar.setForeground(Color.black);
		btnHogar.setBackground(new Color(235, 219, 79));
		btnHogar.setFont(new Font("Baloo", Font.BOLD, 35));
		add(btnHogar);

		btnOficina = new JButton();
		btnOficina.setBounds(100, 410, 252, 70);
		btnOficina.setText(prop.getProperty("archivosdepropiedades.panel.agregar.producto.oficina"));
		btnOficina.setFocusable(false);
		btnOficina.setForeground(Color.black);
		btnOficina.setBackground(new Color(235, 219, 79));
		btnOficina.setFont(new Font("Baloo", Font.BOLD, 35));
		add(btnOficina);

		btnOcio = new JButton();
		btnOcio.setBounds(100, 530, 252, 70);
		btnOcio.setText(prop.getProperty("archivosdepropiedades.panel.agregar.producto.ocio"));
		btnOcio.setFocusable(false);
		btnOcio.setForeground(Color.black);
		btnOcio.setBackground(new Color(235, 219, 79));
		btnOcio.setFont(new Font("Baloo", Font.BOLD, 35));
		add(btnOcio);

		pah = new PanelAgregarH(prop);
		paof = new PanelAgregarOficina(prop);
		paco = new PanelAgregarCocina(prop);
		paba = new PanelAgregarBano(prop);
		pae = new PanelAgregarElectro(prop);
		papape = new PanelAgregarPapeleria(prop);
		pavj = new PanelAgregarVideoJuego(prop);
		pade = new PanelAgregarDeporte(prop);
		paoc = new PanelAgregarOcio(prop);

		add(pae).setVisible(false);
		add(papape).setVisible(false);
		add(pavj).setVisible(false);
		add(pade).setVisible(false);
		add(paco).setVisible(false);
		add(paba).setVisible(false);
		add(pah).setVisible(false);
		add(paof).setVisible(false);
		add(paoc).setVisible(false);
		add(fondo);
	}
	
	public void refrescarUI(Properties prop) throws IOException {
	    // Aplicar revalidate() y repaint() a todos los paneles
		
			
		
		
		 	paba.setProp(prop);
		    paba.actualizarComps();
		    paba.revalidate();
		    paba.repaint();
		    
		    paoc.setProp(prop);
		    paoc.actualizarComps();
		    paoc.revalidate();
		    paoc.repaint();
		    
		    paco.setProp(prop);
		    paco.actualizarComps();
		    paco.revalidate();
		    paco.repaint();
		    
		    pade.setProp(prop);
		    pade.actualizarComps();
		    pade.revalidate();
		    pade.repaint();
		    
		    
		    pae.setProp(prop);
		    pae.actualizarComps();
		    pae.revalidate();
		    pae.repaint();
		    
		    pah.setProp(prop);
		    pah.actualizarComps();
		    pah.revalidate();
		    pah.repaint();
		    
		   
		    
		    paof.setProp(prop);
		    paof.actualizarComps();
		    paof.revalidate();
		    paof.repaint();
		    
		    papape.setProp(prop);
		    papape.actualizarComps();
		    papape.revalidate();
		    papape.repaint();
		    
		    
		    pavj.setProp(prop);
		    pavj.actualizarComps();
		    pavj.revalidate();
		    pavj.repaint();
		    
		    
	   
	    
	    // También actualizar la ventana principal
	    this.revalidate();
	    this.repaint();
	}
	
	public void actualizarCompss() throws IOException {
		BufferedImage fd = ImageIO.read(new File(prop.getProperty("archivospropiedad.fondo.tback")));
		ImageIcon imagenFondo = new ImageIcon(fd);
		Image fdRedim = fd.getScaledInstance(1290, 750, Image.SCALE_SMOOTH);
		fondo.setIcon(new ImageIcon(fdRedim));
	}
	
	
	public void actualizarComps() {
		btnHogar.setText(prop.getProperty("archivosdepropiedades.panel.agregar.producto.hogar"));
		btnOficina.setText(prop.getProperty("archivosdepropiedades.panel.agregar.producto.oficina"));
		btnOcio.setText(prop.getProperty("archivosdepropiedades.panel.agregar.producto.ocio"));
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

	public JButton getBtnHogar() {
		return btnHogar;
	}

	public void setBtnHogar(JButton btnHogar) {
		this.btnHogar = btnHogar;
	}

	public JButton getBtnOficina() {
		return btnOficina;
	}

	public void setBtnOficina(JButton btnOficina) {
		this.btnOficina = btnOficina;
	}

	public JButton getBtnOcio() {
		return btnOcio;
	}

	public void setBtnOcio(JButton btnOcio) {
		this.btnOcio = btnOcio;
	}

	public PanelAgregarH getPah() {
		return pah;
	}

	public void setPah(PanelAgregarH pah) {
		this.pah = pah;
	}

	public PanelAgregarOficina getPaof() {
		return paof;
	}

	public void setPaof(PanelAgregarOficina paof) {
		this.paof = paof;
	}

	public PanelAgregarOcio getPaoc() {
		return paoc;
	}

	public void setPaoc(PanelAgregarOcio paoc) {
		this.paoc = paoc;
	}

	public PanelAgregarCocina getPaco() {
		return paco;
	}

	public void setPaco(PanelAgregarCocina paco) {
		this.paco = paco;
	}

	public PanelAgregarBano getPaba() {
		return paba;
	}

	public void setPaba(PanelAgregarBano paba) {
		this.paba = paba;
	}

	public PanelAgregarElectro getPae() {
		return pae;
	}

	public void setPae(PanelAgregarElectro pae) {
		this.pae = pae;
	}

	public PanelAgregarPapeleria getPapape() {
		return papape;
	}

	public void setPapape(PanelAgregarPapeleria papape) {
		this.papape = papape;
	}

	public PanelAgregarVideoJuego getPavj() {
		return pavj;
	}

	public void setPavj(PanelAgregarVideoJuego pavj) {
		this.pavj = pavj;
	}

	public PanelAgregarDeporte getPade() {
		return pade;
	}

	public void setPade(PanelAgregarDeporte pade) {
		this.pade = pade;
	}

	public Properties getProp() {
		return prop;
	}

	public void setProp(Properties prop) {
		this.prop = prop;
	}
	
	

}
