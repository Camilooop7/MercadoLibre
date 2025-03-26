package co.edu.unbosque.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

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

public class PanelOcio extends JPanel{
	/** Scroll que es usado para navegar en los productos del almacen. */
    private JScrollPane scrollPane;
    /** Panel en el que se guardan todos los productos del almacen. */
    private JPanel panelContenido;
    /** Botón para anadir un producto al carrito. */
    private ArrayList<JButton> botonesAnadir;
    /** Botón para eliminar un producto del almacen. */
    private ArrayList<JButton> botonesFav;

    /**
     * Constructor que configura el panel con desplazamiento vertical.
     */
    public PanelOcio() {
    	setBounds(380, 240, 880, 470);
        botonesAnadir = new ArrayList<>();
        botonesFav = new ArrayList<>();
        setLayout(new BorderLayout());
        panelContenido = new JPanel();
        panelContenido.setLayout(new GridLayout(0, 1, 10, 10));

        scrollPane = new JScrollPane(panelContenido);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        agregarProductos(-1, new ArrayList<>());

        add(scrollPane, BorderLayout.CENTER);
    }

    /**
     * Agrega productos con sus botones correspondientes.
     * 
     * @param cantidad   Cantidad de productos a agregar.
     * @param listaDatos Lista con la información de cada producto.
     */
    public void agregarProductos(int cantidad, ArrayList<Ocio> listaDatos) {
        if (cantidad == -1) {
            return;
        }
        
        for (int i = 0; i < cantidad; i++) {
            JPanel panelProducto = new JPanel();
            panelProducto.setLayout(new BorderLayout());
            panelProducto.setBorder(BorderFactory.createLineBorder(Color.BLACK));

            JLabel lblImagen = new JLabel(asignarImagen(listaDatos.get(i)));
            lblImagen.setHorizontalAlignment(SwingConstants.CENTER);
            panelProducto.add(lblImagen, BorderLayout.EAST);

            JTextArea txtAreaInfo = new JTextArea(listaDatos.get(i).toString() + 
            		"\n                                                                                                       ");
            txtAreaInfo.setEditable(false);
            panelProducto.add(txtAreaInfo, BorderLayout.WEST);

            JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER));
            JButton btnAgregar = new JButton("Añadir al Carrito");
            JButton btnFavoritos = new JButton("Favoritos");
            
            botonesAnadir.add(btnAgregar);
            botonesFav.add(btnFavoritos);
            
            panelBotones.add(btnAgregar);
            panelBotones.add(btnFavoritos);
            panelBotones.setBackground(Color.yellow);

            panelProducto.add(panelBotones, BorderLayout.SOUTH);
            panelContenido.add(panelProducto);
        }
    }

    private ImageIcon asignarImagen(Ocio obj) {
        try {
            String ruta = obj.getImagen();
            
            // Convertir rutas Windows a formato válido
            ruta = ruta.replace("\\", "/");
         
    		BufferedImage fd = ImageIO.read(new File(ruta));

    		ImageIcon imagen = new ImageIcon(fd);
    		Image fdRedim = fd.getScaledInstance(575, 325, Image.SCALE_SMOOTH);
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
    public void actualizarInfo(ArrayList<Ocio> listaDatos) {
        botonesAnadir.clear();
        botonesFav.clear();
        panelContenido.removeAll();
        agregarProductos(listaDatos.size(), listaDatos);
        revalidate();
        repaint();
    }
}
