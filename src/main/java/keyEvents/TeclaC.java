package keyEvents;

import com.sun.glass.events.KeyEvent;

import chat.VentanaContactos;
import cliente.Cliente;
import estados.Estado;

/**
 * The Class TeclaC.
 */
public class TeclaC extends ChainOfResponsability {

    /**
     * The vent contac.
     */
    private static VentanaContactos ventContac;

    /*
     * (non-Javadoc)
     *
     * @see keyEvents.ChainOfResponsability#ejecutarAccion(int, cliente.Cliente)
     */
    @Override
    public void ejecutarAccion(final int evento, final Cliente cliente) {
        if (evento == KeyEvent.VK_C) {
            if (Estado.getEstado().esEstadoDeJuego()) {
                if (ventContac == null) {
                    ventContac = new VentanaContactos(cliente.getJuego());
                    ventContac.setVisible(true);
                }

            }
        }
    }

    /**
     * Gets the vent contac.
     *
     * @return the vent contac
     */
    public static VentanaContactos getVentContac() {
        return ventContac;
    }

    /**
     * Sets the vent contac.
     *
     * @param ventContacParam
     *            the new vent contac
     */
    public static void setVentContac(final VentanaContactos ventContacParam) {
        TeclaC.ventContac = ventContacParam;
    }

}
