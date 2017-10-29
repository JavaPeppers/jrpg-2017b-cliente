package comandos;

import mensajeria.Comando;

/**
 * The Class RegistroSet.
 */
public class RegistroSet extends ComandosCliente {

    /*
     * (non-Javadoc)
     *
     * @see mensajeria.Comando#ejecutar()
     */
    @Override
    public void ejecutar() {
        cliente.getPaqueteUsuario().setComando(Comando.REGISTRO);

    }

}
