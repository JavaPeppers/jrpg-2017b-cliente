package comandos;

import mensajeria.PaquetePersonaje;

/**
 * The Class ActualizarPersonajeLvl.
 */
public class ActualizarPersonajeLvl extends ComandosEscucha {

    /*
     * (non-Javadoc)
     *
     * @see mensajeria.Comando#ejecutar()
     */
    @Override
    public void ejecutar() {
        PaquetePersonaje paquetePersonaje = (PaquetePersonaje) getGson()
                .fromJson(getCadenaLeida(), PaquetePersonaje.class);
        juego.getPersonajesConectados().remove(paquetePersonaje.getId());
        juego.getPersonajesConectados().put(paquetePersonaje.getId(),
                paquetePersonaje);
        if (juego.getPersonaje().getId() == paquetePersonaje.getId()) {
            juego.actualizarPersonaje();
            juego.getEstadoJuego().actualizarPersonaje();
            juego.getCliente().actualizarPersonaje(juego
                    .getPersonajesConectados().get(paquetePersonaje.getId()));
        }
    }

}
