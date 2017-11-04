package comandos;

import estados.Estado;
import mensajeria.PaqueteEnemigo;

/**
 * The Class DesaparecerEnemigo.
 */
public class DesaparecerEnemigo extends ComandosEscucha {

    /* (non-Javadoc)
     * @see mensajeria.Comando#ejecutar()
     */
    @Override
    public void ejecutar() {
        PaqueteEnemigo paqueteEnemigo = (PaqueteEnemigo) getGson()
                .fromJson(getCadenaLeida(), PaqueteEnemigo.class);
        juego.getEnemigos().get(paqueteEnemigo.getId())
                .setEstado(Estado.ESTADOBATALLANPC);
    }

}
