package comandos;

import cliente.Cliente;
import mensajeria.Comando;

/**
 * The Class ComandosCliente.
 */
public abstract class ComandosCliente extends Comando {

    /**
     * The cliente.
     */
    protected Cliente cliente;

    /**
     * Sets the cliente.
     *
     * @param clienteParam
     *            the new cliente
     */
    public void setCliente(final Cliente clienteParam) {
        this.cliente = clienteParam;
    }

}
