package keyEvents;

import com.sun.glass.events.KeyEvent;

import cliente.Cliente;
import estados.Estado;
import frames.MenuStats;

/**
 * The Class TeclaS.
 */
public class TeclaS extends ChainOfResponsability {

    /**
     * The menu stats.
     */
    private static MenuStats menuStats;

    /*
     * (non-Javadoc)
     *
     * @see keyEvents.ChainOfResponsability#ejecutarAccion(int, cliente.Cliente)
     */
    @Override
    public void ejecutarAccion(final int evento, final Cliente cliente) {
        if (evento == KeyEvent.VK_S) {
            if (Estado.getEstado().esEstadoDeJuego()) {
                if (menuStats == null) {
                    menuStats = new MenuStats(cliente);
                    menuStats.setVisible(true);
                }
            }
        } else {
            next.ejecutarAccion(evento, cliente);
        }

    }

    /**
     * Gets the menu stats.
     *
     * @return the menu stats
     */
    public static MenuStats getMenuStats() {
        return menuStats;
    }

    /**
     * Sets the menu stats.
     *
     * @param menuStatsParam
     *            the new menu stats
     */
    public static void setMenuStats(final MenuStats menuStatsParam) {
        TeclaS.menuStats = menuStatsParam;
    }

}
