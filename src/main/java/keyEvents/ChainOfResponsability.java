package keyEvents;

import cliente.Cliente;

/**
 * The Class ChainOfResponsability.
 */
public abstract class ChainOfResponsability {

    /**
     * The next.
     */
    protected ChainOfResponsability next;

    /**
     * Ejecutar accion.
     *
     * @param evento
     *            the evento
     * @param cliente
     *            the cliente
     */
    public abstract void ejecutarAccion(int evento, Cliente cliente);

    /**
     * Gets the next.
     *
     * @return the next
     */
    public ChainOfResponsability getNext() {
        return next;
    }

    /**
     * Sets the next.
     *
     * @param nextParam
     *            the new next
     */
    public void setNext(final ChainOfResponsability nextParam) {
        this.next = nextParam;
    }

}
