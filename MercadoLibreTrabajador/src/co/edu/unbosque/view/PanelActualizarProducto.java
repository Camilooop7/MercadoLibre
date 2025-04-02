package co.edu.unbosque.view;

/**
 * Importanción de las librerias para el uso de imagenes, texto, botones, colores, paneles.
 */
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

/**
 * Clase la cual es llamada como Ventana y extiende JPanel 
 * lo que permite agregar botones y o componentes de interfaz grafica.
 * y creación de las variables con su nombre privadas.
 */
public class PanelActualizarProducto extends JPanel {

	private JLabel fondo;
	private JButton btnVolver;
	private JButton btnHogar;
	private JButton btnOficina;
	private JButton btnOcio;
	private PanelAgregarH pah;
	private PanelAgregarOficina paof;
	private PanelAgregarOcio paoc;
	private PanelActualizarCocina pac;
	private PanelActualizarBano pab;
	private PanelActualizarElectro pae;
	private PanelActualizarPapel papap;
	private PanelActualizarVJ pavj;
	private PanelActualizarDeporte padep;
	private PanelAgregarCocina paco;
	private PanelAgregarBano paba;
	private PanelAgregarElectro paelec;
	private PanelAgregarPapeleria papape;
	private PanelAgregarVideoJuego pagvj;
	private PanelAgregarDeporte padepor;
	private Properties prop;

	
	/**
	 * Constructor del panel donde se ejecuta la logica en general de cada parametro
	 * que se encuentra en la ventana. además se declara la excepción de
	 * IOexception.
	 */
	public PanelActualizarProducto(Properties prop) throws IOException {

		/**
		 * Uso del setBounds para fijar la posción del panel setLayaout permite
		 * modificar manualmente los elementos.
		 */
		setBounds(0, 0, 1290, 750);
		setLayout(null);

		this.prop = prop;
		/**
		 * Inicialización del JLabel BufferedImage con el objetivo de establecer la
		 * ubicación del archivo de la imagen dentro de los archivos. Image Redim
		 * redimenzionar las medidas establecidas de la imagen.
		 */
		fondo = new JLabel();
		BufferedImage fd = ImageIO.read(new File("src/co/edu/unbosque/view/FondoTBack.png"));
		ImageIcon imagenFondo = new ImageIcon(fd);
		Image fdRedim = fd.getScaledInstance(1290, 750, Image.SCALE_SMOOTH);
		fondo.setIcon(new ImageIcon(fdRedim));
		fondo.setBounds(0, 0, 1290, 750);

		/**
		 * En este caso se inicializa el Jbutton para su uso 
		 * .setbounds para definir el tamaño y posicion dentro del panel
		 * .setbackground se establece el color.
		 * .contentareafilled para que el area de boton sea transparente
		 * .borderpainted quitar el borde establecido preterminado del boton.
		 * .add añadir el boton.
		 */
		btnVolver = new JButton();
		btnVolver.setBounds(1092, 71, 130, 97);
		btnVolver.setFocusable(false);
		btnVolver.setBackground(new Color(0, 0, 0));
		btnVolver.setContentAreaFilled(false);
		btnVolver.setOpaque(false);
		btnVolver.setBorderPainted(false);
		btnVolver.setVisible(true);
		add(btnVolver);

		/**
		 * En este caso se inicializa el Jbutton para su uso 
		 * .setbounds para definir el tamaño y posicion dentro del panel
		 * .setbackground se establece el color.
		 * .settext para establecer el texto dentro del boton
		 * .setfont establecer el tipo y tamaño de letra
		 * .add añadir el boton.
		 */
		btnHogar = new JButton();
		btnHogar.setBounds(100, 290, 252, 70);
		btnHogar.setText(prop.getProperty("archivosdepropiedades.panel.agregar.producto.hogar"));
		btnHogar.setFocusable(false);
		btnHogar.setForeground(Color.black);
		btnHogar.setBackground(new Color(235, 219, 79));
		btnHogar.setFont(new Font("Baloo", Font.BOLD, 35));
		add(btnHogar);

		/**
		 * En este caso se inicializa el Jbutton para su uso 
		 * .setbounds para definir el tamaño y posicion dentro del panel
		 * .setbackground se establece el color.
		 * .settext para establecer el texto dentro del boton
		 * .setfont establecer el tipo y tamaño de letra
		 * .add añadir el boton.
		 */
		btnOficina = new JButton();
		btnOficina.setBounds(100, 410, 252, 70);
		btnOficina.setText(prop.getProperty("archivosdepropiedades.panel.agregar.producto.oficina"));
		btnOficina.setFocusable(false);
		btnOficina.setForeground(Color.black);
		btnOficina.setBackground(new Color(235, 219, 79));
		btnOficina.setFont(new Font("Baloo", Font.BOLD, 35));
		add(btnOficina);

		/**
		 * En este caso se inicializa el Jbutton para su uso 
		 * .setbounds para definir el tamaño y posicion dentro del panel
		 * .setbackground se establece el color.
		 * .settext para establecer el texto dentro del boton
		 * .setfont establecer el tipo y tamaño de letra
		 * .add añadir el boton.
		 */
		btnOcio = new JButton();
		btnOcio.setBounds(100, 530, 252, 70);
		btnOcio.setText(prop.getProperty("archivosdepropiedades.panel.agregar.producto.ocio"));
		btnOcio.setFocusable(false);
		btnOcio.setForeground(Color.black);
		btnOcio.setBackground(new Color(235, 219, 79));
		btnOcio.setFont(new Font("Baloo", Font.BOLD, 35));
		add(btnOcio);
/**
 * creación e inicialización de los diferentes paneles(productos)
 */
		pah = new PanelAgregarH(prop);
		paof = new PanelAgregarOficina(prop);
		pac = new PanelActualizarCocina();
		pab = new PanelActualizarBano();
		pae = new PanelActualizarElectro();
		papap = new PanelActualizarPapel();
		pavj = new PanelActualizarVJ();
		padep = new PanelActualizarDeporte();
		paco = new PanelAgregarCocina(prop);
		paba = new PanelAgregarBano(prop);
		paelec = new PanelAgregarElectro(prop);
		papape = new PanelAgregarPapeleria(prop);
		pagvj = new PanelAgregarVideoJuego(prop);
		padepor = new PanelAgregarDeporte(prop);
		paoc = new PanelAgregarOcio(prop);
		
		/**
		 * añadir los paneles al panel general estableciendolos como false para su no 
		 * vizualisación.
		 */
		add(pah).setVisible(false);
		add(paof).setVisible(false);
		add(paoc).setVisible(false);
		add(pac).setVisible(false);
		add(pab).setVisible(false);
		add(pae).setVisible(false);
		add(papap).setVisible(false);
		add(pavj).setVisible(false);
		add(padep).setVisible(false);
		add(paco).setVisible(false);
		add(paba).setVisible(false);
		add(paelec).setVisible(false);
		add(papape).setVisible(false);
		add(pagvj).setVisible(false);
		add(padepor).setVisible(false);

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

	/**
	 * GETTERS & SETTERS
	 */
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

	public PanelActualizarCocina getPac() {
		return pac;
	}

	public void setPac(PanelActualizarCocina pac) {
		this.pac = pac;
	}

	public PanelActualizarBano getPab() {
		return pab;
	}

	public void setPab(PanelActualizarBano pab) {
		this.pab = pab;
	}

	public PanelActualizarElectro getPae() {
		return pae;
	}

	public void setPae(PanelActualizarElectro pae) {
		this.pae = pae;
	}

	public PanelActualizarPapel getPapap() {
		return papap;
	}

	public void setPapap(PanelActualizarPapel papap) {
		this.papap = papap;
	}

	public PanelActualizarVJ getPavj() {
		return pavj;
	}

	public void setPavj(PanelActualizarVJ pavj) {
		this.pavj = pavj;
	}

	public PanelActualizarDeporte getPadep() {
		return padep;
	}

	public void setPadep(PanelActualizarDeporte padep) {
		this.padep = padep;
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

	public PanelAgregarElectro getPaelec() {
		return paelec;
	}

	public void setPaelec(PanelAgregarElectro paelec) {
		this.paelec = paelec;
	}

	public PanelAgregarPapeleria getPapape() {
		return papape;
	}

	public void setPapape(PanelAgregarPapeleria papape) {
		this.papape = papape;
	}

	public PanelAgregarVideoJuego getPagvj() {
		return pagvj;
	}

	public void setPagvj(PanelAgregarVideoJuego pagvj) {
		this.pagvj = pagvj;
	}

	public PanelAgregarDeporte getPadepor() {
		return padepor;
	}

	public void setPadepor(PanelAgregarDeporte padepor) {
		this.padepor = padepor;
	}

	public Properties getProp() {
		return prop;
	}

	public void setProp(Properties prop) {
		this.prop = prop;
	}
	

	

}
