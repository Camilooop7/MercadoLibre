package co.edu.unbosque.view;

import java.io.IOException;
import java.util.Properties;

/**
 * Clase que actúa como fachada para gestionar las vistas de la aplicación.
 */
public class ViewFacade {
    /** Ventana emergente para mostrar mensajes. */
    private VentanaEmergente vemer;
    /** Ventana principal de la aplicación. */
    private VentanaPrincipalC vpc;

    /**
     * Constructor que inicializa las vistas principales.
     * 
     * @param prop Propiedades para configurar las vistas.
     * @throws IOException Si ocurre un error al cargar las vistas.
     */
    public ViewFacade(Properties prop) throws IOException {
        vemer = new VentanaEmergente();
        vpc = new VentanaPrincipalC(prop);
    }

    /**
     * Obtiene la ventana emergente.
     * 
     * @return Ventana emergente.
     */
    public VentanaEmergente getVemer() {
        return vemer;
    }

    /**
     * Establece la ventana emergente.
     * 
     * @param vemer Ventana emergente.
     */
    public void setVemer(VentanaEmergente vemer) {
        this.vemer = vemer;
    }

    /**
     * Obtiene la ventana principal.
     * 
     * @return Ventana principal.
     */
    public VentanaPrincipalC getVpc() {
        return vpc;
    }

    /**
     * Establece la ventana principal.
     * 
     * @param vpc Ventana principal.
     */
    public void setVpc(VentanaPrincipalC vpc) {
        this.vpc = vpc;
    }
}
