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
        PaqueteAtacar paqueteAtacar = (PaqueteAtacar) gson.fromJson(cadenaLeida,
                PaqueteAtacar.class);
        juego.getEstadoBatalla().getEnemigo()
                .actualizarAtributos(paqueteAtacar.getMapPersonaje());
        juego.getEstadoBatalla().getPersonaje()
                .actualizarAtributos(paqueteAtacar.getMapEnemigo());
        juego.getEstadoBatalla().setMiTurno(true);

    }

}
