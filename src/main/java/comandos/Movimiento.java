package comandos;

import mensajeria.PaqueteDeMovimientos;

/**
 * The Class Movimiento.
 */
public class Movimiento extends ComandosEscucha {

    /*
     * (non-Javadoc)
     *
     * @see mensajeria.Comando#ejecutar()
     */
    @Override
    public void ejecutar() {
        PaqueteDeMovimientos pdm = (PaqueteDeMovimientos) getGson()
                .fromJson(getCadenaLeida(), PaqueteDeMovimientos.class);
        juego.setUbicacionPersonajes(pdm.getPersonajes());
    }

}
