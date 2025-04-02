package co.edu.unbosque.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import co.edu.unbosque.model.Ocio;
import co.edu.unbosque.model.Producto;

public class PanelClienteMenu extends JPanel {

	private JLabel fondo;

	private JButton btnVolver, btnCarrito, btnHistorial, btnTienda, btnFavoritos;

	/** Scroll que es usado para navegar en los productos del almacen. */
    private JScrollPane scrollPane;
    /** Panel en el que se guardan todos los productos del almacen. */
    private JPanel panelContenido;
    /** Botón para anadir un producto al carrito. */
    private ArrayList<JButton> botonesAnadir;
    /** Botón para eliminar un producto del almacen. */
    private ArrayList<JButton> botonesFav;
	private Properties prop;
	
	public PanelClienteMenu(Properties prop) throws IOException {
    	this.prop = prop;
		
		setBounds(0, 0, 1290, 750);
		setLayout(null);

		fondo = new JLabel();
		BufferedImage fd = ImageIO.read(new File(prop.getProperty("archivospropiedad.fondo.fondomenu")));
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
		btnVolver.setBorderPainted(false);
		btnVolver.setVisible(true);
		add(btnVolver);
		
		btnCarrito = new JButton();
		btnCarrito.setBounds(165, 550, 150, 150);
		btnCarrito.setFocusable(false);
		btnCarrito.setBackground(new Color(0, 0, 0));
		btnCarrito.setContentAreaFilled(false);
		btnCarrito.setOpaque(false);
		btnCarrito.setBorderPainted(false);
		btnCarrito.setVisible(true);
		add(btnCarrito);

		btnHistorial = new JButton();
		btnHistorial.setBounds(415, 550, 150, 150);
		btnHistorial.setFocusable(false);
		btnHistorial.setBackground(new Color(0, 0, 0));
		btnHistorial.setContentAreaFilled(false);
		btnHistorial.setOpaque(false);
		btnHistorial.setBorderPainted(false);
		btnHistorial.setVisible(true);
		add(btnHistorial);
		
		btnTienda = new JButton();
		btnTienda.setBounds(690, 550, 175, 150);
		btnTienda.setFocusable(false);
		btnTienda.setBackground(new Color(0, 0, 0));
		btnTienda.setContentAreaFilled(false);
		btnTienda.setOpaque(false);
		btnTienda.setVisible(true);
		btnTienda.setBorderPainted(false);
		add(btnTienda);
		
		btnFavoritos = new JButton();
		btnFavoritos.setBounds(985, 550, 150, 150);
		btnFavoritos.setFocusable(false);
		btnFavoritos.setBackground(new Color(0, 0, 0));
		btnFavoritos.setContentAreaFilled(false);
		btnFavoritos.setOpaque(false);
		btnFavoritos.setVisible(true);
		btnFavoritos.setBorderPainted(false);
		add(btnFavoritos);
		

        botonesAnadir = new ArrayList<>();
        botonesFav = new ArrayList<>();
        setLayout(new BorderLayout());
        panelContenido = new JPanel();
        panelContenido.setLayout(new GridLayout(1, 0, 10, 10));

        scrollPane = new JScrollPane(panelContenido);
        scrollPane.setBounds(0, 210, 1280, 300);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        agregarProducto(-1, new ArrayList<>());

        add(scrollPane, BorderLayout.CENTER);
		add(fondo); 
	}
	
	public void actualizarComp() throws IOException {
		BufferedImage fd = ImageIO.read(new File(prop.getProperty("archivospropiedad.fondo.fondomenu")));
		ImageIcon imagenFondo = new ImageIcon(fd);
		Image fdRedim = fd.getScaledInstance(1290, 750, Image.SCALE_SMOOTH);
		fondo.setIcon(new ImageIcon(fdRedim));
	}
	
	public void agregarProducto(int cantidad, ArrayList<Producto> listaDatos) {
        if (cantidad == -1) {
            return;
        }
        
        for (int i = 0; i < cantidad; i++) {
            JPanel panelProducto = new JPanel();
            panelProducto.setLayout(new BorderLayout());
            panelProducto.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            panelProducto.setBackground(new Color(198,195,195));
            
            JLabel lblImagen = new JLabel(asignarImagen(listaDatos.get(i)));
            lblImagen.setHorizontalAlignment(SwingConstants.CENTER);
            panelProducto.add(lblImagen, BorderLayout.EAST);

            JTextArea txtAreaInfo = new JTextArea(listaDatos.get(i).toString() + " ");
            txtAreaInfo.setEditable(false);
            txtAreaInfo.setFont(new Font("Baloo", Font.BOLD, 10));
            txtAreaInfo.setBackground(new Color(198,195,195));
            panelProducto.add(txtAreaInfo, BorderLayout.WEST);

            JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER));
            JButton btnAgregar = new JButton(prop.getProperty("archivospropiedad.boton.carritomas"));
            btnAgregar.setBackground(new Color(235, 219, 79));
            btnAgregar.setFont(new Font("Baloo", Font.BOLD, 15));
            JButton btnFavoritos = new JButton(prop.getProperty("archivospropiedad.boton.favoritomas"));
            btnFavoritos.setBackground(new Color(235, 219, 79));
            btnFavoritos.setFont(new Font("Baloo", Font.BOLD, 15));
            
            botonesAnadir.add(btnAgregar);
            botonesFav.add(btnFavoritos);
            
            panelBotones.add(btnAgregar);
            panelBotones.add(btnFavoritos);
            panelBotones.setBackground(new Color(198,195,195));

            panelProducto.add(panelBotones, BorderLayout.SOUTH);
            panelContenido.add(panelProducto);
        }
    }

    private ImageIcon asignarImagen(Producto obj) {
        try {
            String ruta = obj.getImagen();
            
            // Convertir rutas Windows a formato válido
            ruta = ruta.replace("\\", "/");
         
    		BufferedImage fd = ImageIO.read(new File(ruta));

    		ImageIcon imagen = new ImageIcon(fd);
    		
    		Image fdRedim = fd.getScaledInstance(250, 180, Image.SCALE_SMOOTH);
            return new ImageIcon(fdRedim);
            
        } catch (Exception e) {
            System.err.println("Error cargando imagen: " + e.getMessage());
            return null;
        }
    }
    
    /**
     * Actualiza la información mostrada en el panel.
     * 
     * @param listaDatos Lista con la nueva información de los productos.
     */
    public void actualizarInfo(ArrayList<Producto> listaDatos) {
        botonesAnadir.clear();
        botonesFav.clear();
        panelContenido.removeAll();
        agregarProducto(listaDatos.size(), listaDatos);
        revalidate();
        repaint();
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

	public JScrollPane getScrollPane() {
		return scrollPane;
	}

	public void setScrollPane(JScrollPane scrollPane) {
		this.scrollPane = scrollPane;
	}

	public JPanel getPanelContenido() {
		return panelContenido;
	}

	public void setPanelContenido(JPanel panelContenido) {
		this.panelContenido = panelContenido;
	}

	public ArrayList<JButton> getBotonesAnadir() {
		return botonesAnadir;
	}

	public void setBotonesAnadir(ArrayList<JButton> botonesAnadir) {
		this.botonesAnadir = botonesAnadir;
	}

	public ArrayList<JButton> getBotonesFav() {
		return botonesFav;
	}

	public void setBotonesFav(ArrayList<JButton> botonesFav) {
		this.botonesFav = botonesFav;
	}

	public Properties getProp() {
		return prop;
	}

	public void setProp(Properties prop) {
		this.prop = prop;
	}

	
	
}