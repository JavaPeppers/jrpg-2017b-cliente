package keyEvents;

import com.sun.glass.events.KeyEvent;

import cliente.Cliente;
import estados.Estado;
import frames.MenuEscape;

/**
 * The Class TeclaEsc.
 */
public class TeclaEsc extends ChainOfResponsability {

    /**
     * The menu escp.
     */
    private static MenuEscape menuEscp;

    /*
     * (non-Javadoc)
     *
     * @see keyEvents.ChainOfResponsability#ejecutarAccion(int, cliente.Cliente)
     */
    @Override
    public void ejecutarAccion(final int evento, final Cliente cliente) {
        if (evento == KeyEvent.VK_ESCAPE) {
            if (Estado.getEstado().esEstadoDeJuego()) {
                if (menuEscp == null) {
                    menuEscp = new MenuEscape(cliente);
                    menuEscp.setVisible(true);
                }
            }
        } else {
            next.ejecutarAccion(evento, cliente);
        }

    }

    /**
     * Gets the menu escp.
     *
     * @return the menu escp
     */
    public static MenuEscape getMenuEscp() {
        return menuEscp;
    }

    /**
     * Sets the menu escp.
     *
     * @param menuEscpParam
     *            the new menu escp
     */
    public static void setMenuEscp(final MenuEscape menuEscpParam) {
        TeclaEsc.menuEscp = menuEscpParam;
    }

}
