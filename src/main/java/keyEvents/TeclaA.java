package keyEvents;

import com.sun.glass.events.KeyEvent;

import cliente.Cliente;
import estados.Estado;
import frames.MenuAsignarSkills;

/**
 * The Class TeclaA.
 */
public class TeclaA extends ChainOfResponsability {

    /**
     * The menu asignar.
     */
    private static MenuAsignarSkills menuAsignar;

    /*
     * (non-Javadoc)
     *
     * @see keyEvents.ChainOfResponsability#ejecutarAccion(int, cliente.Cliente)
     */
    @Override
    public void ejecutarAccion(final int evento, final Cliente cliente) {
        if (evento == KeyEvent.VK_A) {
            if (Estado.getEstado().esEstadoDeJuego()) {
                if (menuAsignar == null) {
                    menuAsignar = new MenuAsignarSkills(cliente);
                    menuAsignar.setVisible(true);
                }
            }
        } else {
            next.ejecutarAccion(evento, cliente);
        }

    }

    /**
     * Gets the menu asignar.
     *
     * @return the menu asignar
     */
    public static MenuAsignarSkills getMenuAsignar() {
        return menuAsignar;
    }

    /**
     * Sets the menu asignar.
     *
     * @param menuAsignarParam
     *            the new menu asignar
     */
    public static void setMenuAsignar(
            final MenuAsignarSkills menuAsignarParam) {
        TeclaA.menuAsignar = menuAsignarParam;
    }

}
