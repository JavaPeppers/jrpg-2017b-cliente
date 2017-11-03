package comandos;

import mensajeria.PaqueteDeEnemigos;

/**
 * The Class SetEnemigos.
 */
public class SetEnemigos extends ComandosEscucha {

    /* (non-Javadoc)
     * @see mensajeria.Comando#ejecutar()
     */
    @Override
    public void ejecutar() {
        // Primero seteo en el juego los enemigos
        PaqueteDeEnemigos paqueteEnemigos = (PaqueteDeEnemigos) getGson()
                .fromJson(getCadenaLeida(), PaqueteDeEnemigos.class);
        juego.setEnemigos(paqueteEnemigos.getEnemigos());
    }
}
