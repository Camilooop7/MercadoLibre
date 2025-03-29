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
	private JButton btnVolver;
	
	/** Scroll que es usado para navegar en los productos del almacen. */
    private JScrollPane scrollPane;
    /** Panel en el que se guardan todos los productos del almacen. */
    private JPanel panelContenido;
    /** Botón para anadir un producto al carrito. */
    private ArrayList<JButton> botonesAnadir;
    /** Botón para eliminar un producto del almacen. */
    private ArrayList<JButton> botonesFav;
	
	public PanelHistorial() throws IOException{
    	setBounds(0, 0, 1290, 750);
        botonesAnadir = new ArrayList<>();
        botonesFav = new ArrayList<>();
        setLayout(new BorderLayout());
        
        panelContenido = new JPanel();
        panelContenido.setLayout(new GridLayout(0, 1, 10, 10));
        
		fondo = new JLabel();
		BufferedImage fd = ImageIO.read(new File("src/co/edu/unbosque/view/Fondoa.png"));
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
		btnVolver.setVisible(true);

        agregarProductos(-1, new ArrayList<>());
        

        scrollPane = new JScrollPane(panelContenido);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBackground(Color.green);
        scrollPane.setBounds(150, 230, 1000, 480);
        
        JPanel pP = new JPanel();
        pP.setBounds(150, 230, 1000, 500);
        pP.setBackground(Color.GREEN);
        
        
        add(btnVolver);
        //add(pP);
        add(scrollPane);
        add(fondo);
    }

    /**
     * Agrega productos con sus botones correspondientes.
     * 
     * @param cantidad   Cantidad de productos a agregar.
     * @param listaDatos Lista con la información de cada producto.
     */
    public void agregarProductos(int cantidad, ArrayList<Carrito> listaDatos) {
        if (cantidad == -1) {
            return;
        }
        
        for (int i = 0; i < cantidad; i++) {
            JPanel panelCarrito = new JPanel();
            panelCarrito.setLayout(new BorderLayout());
            panelCarrito.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            panelCarrito.setBackground(new Color(198,195,195));
            
            for (int j = 0; j < listaDatos.get(i).getListaCarrito().size(); j++) {
                JPanel panelProducto = new JPanel();
                panelProducto.setLayout(new BorderLayout());
                panelProducto.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                panelProducto.setBackground(new Color(198,195,195));
                
                JLabel lblImagen = new JLabel(asignarImagen(listaDatos.get(i).getListaCarrito().get(j)));
                lblImagen.setHorizontalAlignment(SwingConstants.CENTER);
                panelProducto.add(lblImagen, BorderLayout.EAST);

                JTextArea txtAreaInfo = new JTextArea(listaDatos.get(i).getListaCarrito().get(j).toString());
                txtAreaInfo.setEditable(false);
                txtAreaInfo.setFont(new Font("Baloo", Font.BOLD, 25));
                txtAreaInfo.setBackground(new Color(198,195,195));
                panelProducto.add(txtAreaInfo, BorderLayout.WEST);

                panelCarrito.add(panelProducto);
            }
            
            panelContenido.add(panelCarrito);
        }
    }

    private ImageIcon asignarImagen(Producto obj) {
        try {
            String ruta = obj.getImagen();
            
            // Convertir rutas Windows a formato válido
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
        agregarProductos(listaDatos.size(), listaDatos);
        revalidate();
        repaint();
    }

}
