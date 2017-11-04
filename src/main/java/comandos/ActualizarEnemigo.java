package comandos;

import mensajeria.PaqueteEnemigo;

/**
 * The Class ActualizarEnemigo.
 */
public class ActualizarEnemigo extends ComandosEscucha {

    /* (non-Javadoc)
     * @see mensajeria.Comando#ejecutar()
     */
    @Override
    public void ejecutar() {
        PaqueteEnemigo paqueteEnemigo = (PaqueteEnemigo) getGson()
                .fromJson(getCadenaLeida(), PaqueteEnemigo.class);

        juego.getEnemigos().get(paqueteEnemigo.getId())
                .setX(paqueteEnemigo.getX());
        juego.getEnemigos().get(paqueteEnemigo.getId())
                .setY(paqueteEnemigo.getY());
        juego.getEnemigos().get(paqueteEnemigo.getId())
                .setEstado(paqueteEnemigo.getEstado());
    }

}
