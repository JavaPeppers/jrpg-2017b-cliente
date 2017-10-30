package comandos;

import mensajeria.PaqueteAtacar;

/**
 * The Class Atacar.
 */
public class Atacar extends ComandosEscucha {

    /*
     * (non-Javadoc)
     *
     * @see mensajeria.Comando#ejecutar()
     */
    @Override
    public void ejecutar() {
        PaqueteAtacar paqueteAtacar = (PaqueteAtacar) getGson()
                .fromJson(getCadenaLeida(),
                PaqueteAtacar.class);
        juego.getEstadoBatalla().getEnemigo()
                .actualizarAtributos(paqueteAtacar.getMapPersonaje());
        juego.getEstadoBatalla().getPersonaje()
                .actualizarAtributos(paqueteAtacar.getMapEnemigo());
        juego.getEstadoBatalla().setMiTurno(true);

    }

}
