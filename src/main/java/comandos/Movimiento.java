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
        PaqueteDeMovimientos pdm = (PaqueteDeMovimientos) gson
                .fromJson(cadenaLeida, PaqueteDeMovimientos.class);
        juego.setUbicacionPersonajes(pdm.getPersonajes());
    }

}
