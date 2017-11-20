package keyEvents;

import cliente.Cliente;

/**
 * The Class Controlador.
 */
public class Controlador extends ChainOfResponsability {

    /**
     * The menu inventario.
     */
    private static TeclaI menuInventario;

    /**
     * The menu asignar.
     */
    private static TeclaA menuAsignar;

    /**
     * The menu stats.
     */
    private static TeclaS menuStats;

    /**
     * The menu escape.
     */
    private static TeclaEsc menuEscape;

    /**
     * The vent contac.
     */
    private static TeclaC ventContac;

    /*
     * (non-Javadoc)
     *
     * @see keyEvents.ChainOfResponsability#ejecutarAccion(int, cliente.Cliente)
     */
    @Override
    public void ejecutarAccion(final int evento, final Cliente cliente) {

        menuInventario = new TeclaI();
        this.setNext(menuInventario);

        menuAsignar = new TeclaA();
        menuInventario.setNext(menuAsignar);

        menuStats = new TeclaS();
        menuAsignar.setNext(menuStats);

        menuEscape = new TeclaEsc();
        menuStats.setNext(menuEscape);

        ventContac = new TeclaC();
        menuEscape.setNext(ventContac);

        next.ejecutarAccion(evento, cliente);

    }

}
