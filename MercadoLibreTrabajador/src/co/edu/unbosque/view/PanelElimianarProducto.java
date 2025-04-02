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

public class PanelElimianarProducto extends JPanel {

	private JLabel fondo;
	private JButton btnVolver;
	private JButton btnHogar;
	private JButton btnOficina;
	private JButton btnOcio;
	private PanelAgregarH pah;
	private PanelAgregarOficina paof;
	private PanelAgregarOcio paoc;
	private PanelEliminarCocina pec;
	private PanelEliminarBano peb;
	private PanelEliminarElectro pee;
	private PanelEliminarPapel pepap;
	private PanelEliminarVJ pevj;
	private PanelEliminarDeporte pedep;
	private Properties prop;

	public PanelElimianarProducto(Properties prop) throws IOException {

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
		pec = new PanelEliminarCocina();
		peb = new PanelEliminarBano(prop);
		pee = new PanelEliminarElectro();
		pepap = new PanelEliminarPapel();
		pevj = new PanelEliminarVJ();
		pedep = new PanelEliminarDeporte();
		paoc = new PanelAgregarOcio(prop);

		add(pah).setVisible(false);
		add(paof).setVisible(false);
		add(paoc).setVisible(false);
		add(pec).setVisible(false);
		add(peb).setVisible(false);
		add(pee).setVisible(false);
		add(pepap).setVisible(false);
		add(pevj).setVisible(false);
		add(pedep).setVisible(false);

		add(fondo);

	}
	
	public void refrescarUI(Properties prop) throws IOException {
	    // Aplicar revalidate() y repaint() a todos los paneles
		 	
		    
		    paoc.setProp(prop);
		    paoc.actualizarComps();
		    paoc.revalidate();
		    paoc.repaint();
		    
		  
		    
		    
		    pah.setProp(prop);
		    pah.actualizarComps();
		    pah.revalidate();
		    pah.repaint();
		    
		   
		    paof.setProp(prop);
		    paof.actualizarComps();
		    paof.revalidate();
		    paof.repaint();
		    
		    
		    
		  
	    
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

	public PanelEliminarCocina getPec() {
		return pec;
	}

	public void setPec(PanelEliminarCocina pec) {
		this.pec = pec;
	}

	public PanelEliminarBano getPeb() {
		return peb;
	}

	public void setPeb(PanelEliminarBano peb) {
		this.peb = peb;
	}

	public PanelEliminarElectro getPee() {
		return pee;
	}

	public void setPee(PanelEliminarElectro pee) {
		this.pee = pee;
	}

	public PanelEliminarPapel getPepap() {
		return pepap;
	}

	public void setPepap(PanelEliminarPapel pepap) {
		this.pepap = pepap;
	}

	public PanelEliminarVJ getPevj() {
		return pevj;
	}

	public void setPevj(PanelEliminarVJ pevj) {
		this.pevj = pevj;
	}

	public PanelEliminarDeporte getPedep() {
		return pedep;
	}

	public void setPedep(PanelEliminarDeporte pedep) {
		this.pedep = pedep;
	}

	public Properties getProp() {
		return prop;
	}

	public void setProp(Properties prop) {
		this.prop = prop;
	}
	
	
	

}
