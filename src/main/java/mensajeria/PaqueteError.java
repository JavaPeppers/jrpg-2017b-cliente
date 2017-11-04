package mensajeria;

import java.io.Serializable;

/**
 * The Class PaqueteError.
 */
public class PaqueteError extends Paquete implements Serializable, Cloneable {

    /**
     * Instantiates a new paquete error.
     */
    public PaqueteError() {
        setComando(Comando.COMANDOERROR);
    }
}
