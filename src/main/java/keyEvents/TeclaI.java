package keyEvents;

import com.sun.glass.events.KeyEvent;

import cliente.Cliente;
import estados.Estado;
import frames.MenuInventario;

/**
 * The Class TeclaI.
 */
public class TeclaI extends ChainOfResponsability {

    /**
     * The menu inventario.
     */
    private static MenuInventario menuInventario;

    /*
     * (non-Javadoc)
     *
     * @see keyEvents.ChainOfResponsability#ejecutarAccion(int, cliente.Cliente)
     */
    @Override
    public void ejecutarAccion(final int evento, final Cliente cliente) {
        if (evento == KeyEvent.VK_I) {
            if (Estado.getEstado().esEstadoDeJuego()) {
                if (menuInventario == null) {
                    menuInventario = new MenuInventario(cliente);
                    menuInventario.setVisible(true);
                }
            }

        } else {
            next.ejecutarAccion(evento, cliente);
        }

    }

    /**
     * Gets the menu inventario.
     *
     * @return the menu inventario
     */
    public static MenuInventario getMenuInventario() {
        return menuInventario;
    }

    /**
     * Sets the menu inventario.
     *
     * @param menuInventarioParam
     *            the new menu inventario
     */
    public static void setMenuInventario(
            final MenuInventario menuInventarioParam) {
        TeclaI.menuInventario = menuInventarioParam;
    }

}
