package co.edu.unbosque.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
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

import co.edu.unbosque.model.Carrito;
import co.edu.unbosque.model.Producto;

public class PanelHistorial extends JPanel {
	private JLabel fondo;
	private JButton btnVolver, btnLimpiar;
	
	/** Scroll que es usado para navegar en los productos del almacen. */
    private JScrollPane scrollPane;
    /** Panel en el que se guardan todos los productos del almacen. */
    private JPanel panelContenido;
    /** Botón para anadir un producto al carrito. */
    private ArrayList<JButton> botonesAnadir;
    /** Botón para eliminar un producto del almacen. */
    private ArrayList<JButton> botonesFav;
	private Properties prop;
	
    public PanelHistorial(Properties prop) throws IOException {
    	this.prop = prop;
        setBounds(0, 0, 1290, 750);
        botonesAnadir = new ArrayList<>();
        botonesFav = new ArrayList<>();
        setLayout(new BorderLayout());

        panelContenido = new JPanel();
        panelContenido.setLayout(new GridLayout(0, 1, 10, 10));

        fondo = new JLabel();
        BufferedImage fd = ImageIO.read(new File(prop.getProperty("archivospropiedad.fondo.fondovolver")));
        ImageIcon imagenFondo = new ImageIcon(fd.getScaledInstance(1290, 750, Image.SCALE_SMOOTH));
        fondo.setIcon(imagenFondo);
        fondo.setBounds(0, 0, 1290, 750);


        btnLimpiar = new JButton();
        btnLimpiar.setBounds(1050, 600, 200, 100);
        btnLimpiar.setText(prop.getProperty("archivospropiedad.boton.limpiar"));
        btnLimpiar.setFocusable(false);
		btnLimpiar.setBackground(Color.WHITE);
		btnLimpiar.setForeground(Color.black);
		btnLimpiar.setBackground(new Color(235, 219, 79));
		btnLimpiar.setFont(new Font("Baloo", Font.BOLD, 15));
        
        btnVolver = new JButton();
        btnVolver.setBounds(1120, 70, 120, 70);
        btnVolver.setFocusable(false);
        btnVolver.setBackground(new Color(0, 0, 0));
		btnVolver.setBorderPainted(false);
        btnVolver.setContentAreaFilled(false);
        btnVolver.setOpaque(false);

       
        JScrollPane scrollPrincipal = new JScrollPane(panelContenido);
        scrollPrincipal.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPrincipal.setBounds(50, 230, 1000, 480);

        add(btnVolver);
        add(btnLimpiar);
        add(scrollPrincipal);
        add(fondo);
    }
    
    public void actualizarComp() throws IOException {
        BufferedImage fd = ImageIO.read(new File(prop.getProperty("archivospropiedad.fondo.fondovolver")));
        ImageIcon imagenFondo = new ImageIcon(fd.getScaledInstance(1290, 750, Image.SCALE_SMOOTH));
        fondo.setIcon(imagenFondo);
        btnLimpiar.setText(prop.getProperty("archivospropiedad.boton.limpiar"));
    }
    
    public void agregarProducto(int cantidad, ArrayList<Carrito> listaDatos) {
        if (cantidad == -1) {
            return;
        }

        for (int i = 0; i < cantidad; i++) {
        	JLabel nProducto = new JLabel(" " + (i+1));
        	
            JPanel panelCarrito = new JPanel();
            panelCarrito.setLayout(new BorderLayout());
            panelCarrito.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
            panelCarrito.setBackground(new Color(198, 195, 195));
            
            panelCarrito.add(nProducto, BorderLayout.NORTH);
            
            JPanel panelProductos = new JPanel();
            panelProductos.setLayout(new GridLayout(0, 1, 5, 5));

            for (Producto producto : listaDatos.get(i).getListaCarrito()) {
                JPanel panelProducto = new JPanel(new BorderLayout());
                panelProducto.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                panelProducto.setBackground(new Color(230, 230, 230));

                JLabel lblImagen = new JLabel(asignarImagen(producto));
                lblImagen.setHorizontalAlignment(SwingConstants.CENTER);
                panelProducto.add(lblImagen, BorderLayout.EAST);

                JTextArea txtAreaInfo = new JTextArea(producto.toString());
                txtAreaInfo.setEditable(false);
                txtAreaInfo.setFont(new Font("Baloo", Font.BOLD, 18));
                txtAreaInfo.setBackground(new Color(230, 230, 230));
                panelProducto.add(txtAreaInfo, BorderLayout.CENTER);

                panelProductos.add(panelProducto);
            }

            JScrollPane scrollProductos = new JScrollPane(panelProductos);
            scrollProductos.setPreferredSize(new Dimension(950, 450));
            scrollProductos.setBorder(BorderFactory.createEmptyBorder());

            panelCarrito.add(scrollProductos, BorderLayout.CENTER);
            panelContenido.add(panelCarrito);
        }
    }

    private ImageIcon asignarImagen(Producto obj) {
        try {
            String ruta = obj.getImagen();
            
            ruta = ruta.replace("\\", "/");
         
    		BufferedImage fd = ImageIO.read(new File(ruta));

    		ImageIcon imagen = new ImageIcon(fd);
    		
    		Image fdRedim = fd.getScaledInstance(500, 325, Image.SCALE_SMOOTH);
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
    public void actualizarInfo(ArrayList<Carrito> listaDatos) {
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

	public JButton getBtnLimpiar() {
		return btnLimpiar;
	}

	public void setBtnLimpiar(JButton btnLimpiar) {
		this.btnLimpiar = btnLimpiar;
	}

	public Properties getProp() {
		return prop;
	}

	public void setProp(Properties prop) {
		this.prop = prop;
	}
    
}
